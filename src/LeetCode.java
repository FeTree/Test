import java.util.*;

class LeetCode {

    // https://leetcode.com/problems/multiply-strings/
    // Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
    // Input: num1 = "2", num2 = "3"
    // Output: "6"
    public String multiply(String num1, String num2) {
        Integer value1 = Integer.parseInt(num1);
        Integer value2 = Integer.parseInt(num2);

        return Integer.toString(value1 * value2);
    }

    public double twentyFour(double n, double a){
        if(n == 1){
            return Math.pow(2, Math.pow(2, n));
        }
        else{
            return twentyFour(n-1, a ) * twentyFour(n-1, a);
        }
    }

    void printNumber(int num)
    {
        if (num != 0)
        {
            printNumber(num / 10);
            System.out.printf("%d", num % 10);
        }
    }

    public boolean isHappy(int n) {

        HashSet<Integer> seenNumbers = new HashSet<Integer>();

        while(seenNumbers.add(n)){
            int sum = 0;
            while(n > 0) {
                sum += Math.pow(n % 10 , 2);
                n /= 10;
                System.out.println("sum= " + sum + " n=" + n);
            }
            n = sum;
            if(n == 1)
                return true;
            //System.out.println(n);
        }
        return false;
    }
    public int maxSubArray(int[] nums) {

        int answer = 0;
        int temp;

        for (int i = 0; i < nums.length; i++)
        {
            temp = 0;
            for (int j = 1; j < nums.length; j++)
            {
                temp += nums[j];
                answer += temp;
            }
        }

        return answer;
    }

    public boolean backspaceCompare(String S, String T) {
        char[] sArr = S.toCharArray();
        char[] tArr = T.toCharArray();

        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for(char c: sArr){
            if(c != '#') {
                sStack.push(c);
            }
            else if (c == '#') {
                sStack.pop();
            }
        }

        for(char c: tArr){
            if(c != '#') {
                tStack.push(c);
            }
            else if (c == '#' && !tStack.isEmpty()) {
                tStack.pop();
            }
        }

        String newS = "";
        String newT = "";
        for (int i = 0; i < sStack.size(); i++) {
            newS += sStack.pop();
        }
        for (int i = 0; i < tStack.size(); i++) {
            newT += tStack.pop();
        }
        System.out.println(newS);
        System.out.println(newT);
        return newS.equals(newT);
    }

    public int countElements(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for(int i : arr){
            set.add(i);
        }

        for (int i = 0; i <arr.length ; i++) {
            if(set.contains(arr[i] + 1)) {
                count++;
            }
        }

        return count;
    }


    public int lastStoneWeight(int[] stones) {
        int weight = 0;

        //sort array
        Arrays.sort(stones);

        //create list
        Stack<Integer> stoneStack = new Stack<>();

        //copy values into list
        for(int i: stones){
            stoneStack.push(i);
        }
        System.out.println(stoneStack.toString());

        /*
        If x == y, both stones are totally destroyed;
        If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
         */
        int x;
        int y;

        while(stoneStack.size() > 1) {
            y = stoneStack.pop();
            x = stoneStack.pop();

            if(x == y) {
                x = 0;
                y = 0;
            }

            if(x != y){
                y = y - x;
                stoneStack.push(y); //push y back since has not been destroyed

                //copy to array to resort
                ArrayList<Integer> recopy = new ArrayList<>();
                for(Integer i : stoneStack){
                    recopy.add(i);
                }
                Collections.sort(recopy);
                stoneStack.clear();
                for(Integer i : recopy){
                    stoneStack.push(i);
                }
            }

        }
        //System.out.println(stoneStack.toString());

        if(stoneStack.isEmpty()){
            return 0;
        }
        weight = stoneStack.peek();
        return weight;
    }
    static final int MAX = 100;

    // Returns maximum amount of gold that
    // can be collected when journey started
    // from first column and moves allowed
    // are right, right-up and right-down
    static int getMaxGold(int gold[][],
                          int m, int n)
    {

        // Create a table for storing
        // intermediate results and initialize
        // all cells to 0. The first row of
        // goldMineTable gives the maximum
        // gold that the miner can collect
        // when starts that row
        int goldTable[][] = new int[m][n];

        for(int[] rows:goldTable)
            Arrays.fill(rows, 0);

        for (int col = n-1; col >= 0; col--)
        {
            for (int row = 0; row < m; row++)
            {

                // Gold collected on going to
                // the cell on the right(->)
                int right = (col == n-1) ? 0
                        : goldTable[row][col+1];

                // Gold collected on going to
                // the cell to right up (/)
                int right_up = (row == 0 ||
                        col == n-1) ? 0 :
                        goldTable[row-1][col+1];

                // Gold collected on going to
                // the cell to right down (\)
                int right_down = (row == m-1
                        || col == n-1) ? 0 :
                        goldTable[row+1][col+1];

                // Max gold collected from taking
                // either of the above 3 paths
                goldTable[row][col] = gold[row][col]
                        + Math.max(right, Math.max(right_up,
                        right_down));
                ;
            }
        }

        // The max amount of gold collected will be
        // the max value in first column of all rows
        int res = goldTable[0][0];

        for (int i = 1; i < m; i++)
            res = Math.max(res, goldTable[i][0]);

        return res;
    }

    public static void main(String[] args) {
        LeetCode lc = new LeetCode();

        int gold[][]= { {5,6,8,1,7,5},
                        {2,2,1,2,6,1},
                        {3,7,3,1,4,2},
                        {7,3,5,2,2,3},
                        {9,4,1,7,3,9},
                        {1,5,2,8,1,2},
                        {4,1,9,9,4,1}};

        //System.out.println(lc.backspaceCompare("ab##", "c#d#"));
        System.out.println(getMaxGold(gold, 7, 6));

    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class MinStack {
    Node top;
    Node min;

    /** initialize your data structure here. */
    public MinStack() {
        top = null;
        min = null;;
    }

    public void push(int x) {
        Node prevTop = top;
        Node newNode = new Node();
        newNode.value = x;
        newNode.next = prevTop;
        top = newNode;

        //first time called
        boolean flag = true;
        if(flag){
            min = newNode;
            flag = false;
        }
        else if (newNode.value < min.value){
            min = newNode;
        }

    }

    public void pop() {
        if (isEmpty()){
            System.out.println("empty stack");
        }
        Node popped = top;
        top = top.next;
        System.out.println("popped: " + popped.value);
        //return popped.value;
    }

    public int top() {
        if (isEmpty()){
            System.out.println("Empty, top is null");
            return -1;
        }
        return top.value;
    }

    public int getMin() {
        if (isEmpty()){
            System.out.println("Empty, min is null");
            return -1;
        }

        Node minCheck = top;
        int minValue = Integer.MAX_VALUE;

        while (minCheck != null){
            if(minValue > minCheck.value){
                minValue = minCheck.value;
            }
            minCheck = minCheck.next;
        }
        return minValue;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class Node {
    int value;
    Node next;
}
