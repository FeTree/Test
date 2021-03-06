package MultipleChoiceTest;

/*
Author: David Eisenbaum
This app designed to be a multiple choice exam.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.net.*;

public class MultipleChoice extends JApplet
{
    // GUI components
    JPanel  upper, middle;
    JTextArea outputArea, questionArea;
    JTextArea answerFields[];
    JButton answerButtons[];
    JButton nextButton;
    JComboBox index;
    JFrame frame;
    final int NUM_BUTTONS = 5;
    String buttonStrings[] = {"A", "B", "C", "D", "E"};

    // Question file index variables
    Vector fileDescriptions;     // These are vectors of strings.  I should be smarter about this and have a unified vector
    Vector fileNames;            // but I'm too lazy to make another class.

    // Multiple choice test variables
    int currentQuestionNum;
    int numQuestions;
    int score;
    int maxScore;
    boolean questionAnswered;
    ShuffleVector questionList;

    // Parser variables
    Question q;
    Answer a;
    int value;
    boolean shuffleAnswers;
    int mode;
    final int GLOBAL_MODE = 0;
    final int QUESTION_MODE = 1;
    final int ANSWER_MODE = 2;

    //String indexLoc = "C:/Users/dvdei/Desktop/Tests/index.txt";
    File indexLocation = new File("C:/Users/dvdei/Desktop/Tests/index.txt");
    File bellowsLogoLoc = new File("C:/Users/dvdei/Desktop/Tests/PNGs/bellowsLogo.jpg");
    Font font = new Font ("Arial", Font.PLAIN, 25);



    ////////////////////// Constructors ///////////////////////
    public void init()
    {
        int i;

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(upper = new JPanel(), BorderLayout.NORTH);
        getContentPane().add(middle =new JPanel(), BorderLayout.CENTER);
        upper.setLayout(new GridBagLayout());
        middle.setLayout(new GridBagLayout());



// upper third of applet

        getFiles();
        addComponent(upper,new JLabel( "Select category: "), 0 , 0);
        addComponent(upper,index = new JComboBox(fileDescriptions), 0, 1);
        addComponent(upper, nextButton = new JButton("Next Question >>"), 0, 2);
        addComponent(upper, questionArea = new JTextArea(4,50),1,0,3,3);
        questionArea.setLineWrap(true);
        questionArea.setWrapStyleWord(true);
        questionArea.setEditable(false);
        questionArea.setFont(font);

//middle third of applet


        answerButtons = new JButton[NUM_BUTTONS];
        answerFields = new JTextArea[NUM_BUTTONS];

        for (i = 0; i < NUM_BUTTONS; i++)
        {
            addComponent(middle, answerButtons[i] = new JButton(buttonStrings[i]), i, 0);
            addComponent(middle, answerFields[i] = new JTextArea(2,50), i, 1, 2, 1);

            answerFields[i].setLineWrap(true);
            answerFields[i].setWrapStyleWord(true);
            answerFields[i].setEditable(false);
            answerFields[i].setFont(font);
            if (i % 2 == 1) answerFields[i].setBackground(Color.lightGray);
        }


// lower third of applet

        getContentPane().add(outputArea = new JTextArea(8,40), BorderLayout.SOUTH);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(font);

// get data

        getQuestions("");
        displayQuestion();


// set Listeners

        for (i = 0; i < NUM_BUTTONS; i++)			// Answer button listeners
        {
            answerButtons[i].addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    int a = 0;

                    for (int j = 0; j < NUM_BUTTONS; j++)
                        if (e.getSource() == answerButtons[j])
                            a = j;

                    Question currentQuestion = getCurrentQuestion();
                    int c = currentQuestion.getCorrectAnswer();
                    Answer ans = currentQuestion.getAnswer(a);

                    if (ans.isEmpty()) return;

                    output("Answer " + answerButtons[a].getText() + " is " + ans.getVerdict() + ".");
                    if (ans.hasComment())
                        output(ans.getComment());

                    if (currentQuestion.hasComment() && ans.getValue() == Answer.CORRECT)
                        output(currentQuestion.getComment());

                    if (questionAnswered) return;
                    questionAnswered = true;

//	 if (ans.getValue() != Answer.CORRECT)
//		 output("The correct answer was " + answerButtons[c].getText() + ".");

                    int currentScore = currentQuestion.getScore(ans);
                    score += currentScore;
                    maxScore += currentQuestion.getMaxScore();

                    output("You added " + currentQuestion.getScore(ans) + " to your score, which is now " + score + " (out of " + maxScore + ").");
                }
            });
        }

        nextButton.addActionListener(new ActionListener()		// The next Button listener
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!questionAnswered)
                {
                    maxScore += getCurrentQuestion().getMaxScore();
                    questionAnswered = true;  // empty answer is an answer; usually will get cleared when question number is advanced
                }

                if (currentQuestionNum >= getNumQuestions() - 1)
                {
                    clearOutput();
                    output("No more questions.  Please select a new list of questions.");
                    output("Your final score was " + score + " (out of " + maxScore + ").");
                    if (score == maxScore) output("Congratulations, you had a perfect score!");
                    return;
                }
                currentQuestionNum++;
                questionAnswered = false;
                displayQuestion();
                clearOutput();
            }
        });


        index.addActionListener(new ActionListener()                  // The category selection listener
        {
            public void actionPerformed(ActionEvent e)
            {
                int j = index.getSelectedIndex();
                String urlString = (String) fileNames.elementAt(j);
                if (urlString.length() == 0 && j > 0) return;
                getQuestions(urlString);
                displayQuestion();
            }
        });

        //changes icon in upper left corner
//        Toolkit kit = Toolkit.getDefaultToolkit();
//        Image bellowsLogoPNG = kit.createImage("C:/Users/dvdei/Desktop/Tests/PNGs/bellowsLogo.jpg");
//
//        frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JLabel bt = new JLabel(new ImageIcon("C:/Users/dvdei/Desktop/Tests/PNGs/bellowsLogo.jpg"));
//        frame.setBounds(50, 50, 200, 200);
//        frame.setVisible(true);
//        frame.setIconImage(bellowsLogoPNG);


    }

    private void addComponent(  JPanel p , Component c, int row, int column, int width, int height)
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx= column;
        gbc.gridy= row;
        gbc.gridheight = height;
        gbc.gridwidth = width;
        p.add( c,gbc);
    }

    private void addComponent(  JPanel p , Component c, int row, int column)
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx= column;
        gbc.gridy= row;
        p.add( c,gbc);
    }


////////////////////// Data entry ///////////////////////

    void getQuestions(String urlString)
    {
        questionList = new ShuffleVector();

        initTest();

        if (urlString.length() == 0) return;

        clearOutput();
// initalize parse variables
        q = new Question();
        a = new Answer();
        value = Question.DEFAULT_VALUE;
        shuffleAnswers = false;
        mode = GLOBAL_MODE;

        try
        {
            //URL url = new URL(urlString);
            //URLConnection conn = url.openConnection();
            //BufferedReader data = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            File file = new File(urlString);
            //FileReader fr = new FileReader("C:/Users/dvdei/Desktop/Tests/index.txt");
            BufferedReader data = new BufferedReader(new FileReader(file));
            String line;
            while ((line = data.readLine()) != null)
                parse(line.trim());
            data.close();
        }
        catch (MalformedURLException e) {
            output("Unable to create URL: " + urlString);
        }
        catch (IOException e) {
            output("IO Error while loading questions: " + e.getMessage());
        }

    }

    void initTest()
    {
// initialize multiple choice test variables
        currentQuestionNum = -1;   // empty question
        questionAnswered = false;
        score = 0;
        maxScore = 0;
    }

////////////////////// Parser ///////////////////////

    public void parse(String line)   // A simple, interpreted parser for question text data.
    {
        if (line.length() == 0) return;   // ignore whitespace

        if (line.startsWith("Question.")
                || line.startsWith("Q."))  // A new question!
        {
            q = new Question(content(line), shuffleAnswers, value);
            questionList.add(q);
            mode = QUESTION_MODE;
            return;
        }

        if (line.startsWith("Comment.") || line.startsWith("Remark"))  // A comment!
        {
            switch (mode)
            {
                case GLOBAL_MODE:  // global comment
                    output(content(line));
                    return;
                case QUESTION_MODE: // comment to the current question
                    q.appendComment(content(line));
                    return;
                case ANSWER_MODE: // comment to the current answer
                    a.appendComment(content(line));
                    return;
            }
            return;
        }

        if (line.startsWith("//"))  // ignore remarks
            return;

        if (line.startsWith("Answer.")
                || line.startsWith("Incorrect Answer.")
                || line.startsWith("A."))  // An incorrect answer!
        {
            a = new Answer(content(line));
            q.addAnswer(a);
            mode = ANSWER_MODE;
            return;
        }

        if (line.startsWith("Correct Answer."))  // A correct answer!
        {
            a = new Answer(content(line), Answer.CORRECT);
            q.addAnswer(a);
            mode = ANSWER_MODE;
            return;
        }

        if (line.startsWith("Shuffle Answers.") || line.startsWith("Do Shuffle Answers."))
        {
            shuffleAnswers = true;
            q.shuffleAnswers();
            return;
        }

        if (line.startsWith("Don't Shuffle Answers."))
        {
            shuffleAnswers = false;
            q.unshuffleAnswers();
            return;
        }

        if (line.startsWith("Shuffle These Answers.") || line.startsWith("Do Shuffle These Answers."))
        // this command and the next are transient - they don't persist to the next question.
        {
            q.shuffleAnswers();
            return;
        }

        if (line.startsWith("Don't Shuffle These Answers."))
        {
            q.unshuffleAnswers();
            return;
        }

        if (line.startsWith("Shuffle Questions.") || line.startsWith("Do Shuffle Questions."))
        {
            questionList.shuffle();
            return;
        }

        if (line.startsWith("Don't Shuffle Questions."))
        {
            questionList.unshuffle();
            return;
        }


        if (line.startsWith("Value."))  // Set points value for a question
        {
            try
            {
                value = Integer.valueOf(content(line)).intValue();
            }
            catch (NumberFormatException e)
            {
                output("Ignored: bad points value: " + content(line));
            }
            q.setValue(value);
            return;
        }

        if (line.startsWith("Correctness."))  // Set correctness value of an answer (out of 10)
        {
            try
            {
                int type = Integer.valueOf(content(line)).intValue();
                a.setType(type);
            }
            catch (NumberFormatException e)
            {
                output("Ignored: bad correctness value: " + content(line));
            }
            return;
        }

        output("Ignored1: " + line);
    }

    String content(String line) // returns the portion of line after .
    {
        int i = line.indexOf('.');
        return line.substring(i+1).trim();
    }

////////////////////// Queries ///////////////////////

    Question getCurrentQuestion()
    {
        if (currentQuestionNum >= questionList.size() || currentQuestionNum < 0)
            return new Question();
        else
            return (Question) questionList.getShuffled(currentQuestionNum);
    }

    int getNumQuestions()
    {
        return questionList.size();
    }

    void getFiles()
    {
        fileDescriptions = new Vector();
        fileNames = new Vector();

        fileDescriptions.add("(None)");
        fileNames.add("");

        try
        {
            FileReader file = new FileReader("C:/Users/dvdei/Desktop/Tests/index.txt");
            BufferedReader data = new BufferedReader(file);
            String line;
            while ((line = data.readLine()) != null)
            {
                if (line.indexOf('|') == -1)
                {
                    fileDescriptions.add(line.trim());
                    fileNames.add("");
                }
                else
                {
                    int i = line.indexOf('|');
                    fileDescriptions.add(line.substring(0,i).trim());
                    fileNames.add(line.substring(i+1).trim());
                }
            }
            data.close();
        }
        catch (MalformedURLException e) {
            output("Unable to create URL: " + getParameter("Index"));
        }
        catch (IOException e) {
            output("IO Error while reading index: " + e.getMessage());
        }
    }

////////////////////// Methods ///////////////////////

    void displayQuestion()
    {
        Question q = getCurrentQuestion();
        questionArea.setText("Question " + (currentQuestionNum+1) + " (of " + getNumQuestions() + "). [" + q.getMaxScore() + " points] " + q.getText());
        for (int i = 0; i < NUM_BUTTONS; i++)
            answerFields[i].setText(q.getAnswerText(i));
    }

    void clearOutput()
    {
        outputArea.setText("");
    }

    void output(String s)
    {
        outputArea.append(s + "\n");
    }

}
