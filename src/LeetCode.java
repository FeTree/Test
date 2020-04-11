import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

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

        ArrayList<Character> sLst = new ArrayList<>();
        ArrayList<Character> tLst = new ArrayList<>();

        int tDeletes = 0;
        int sDeletes = 0;
        for (int i = 0; i < S.length() - 1; i++) {
            if(S.charAt(i) != '#') {
                sLst.add(S.charAt(i));
            }
            if(S.charAt(i) == '#') {
                sDeletes++;
            }
        }

        for (int i = 0; i < T.length() - 1; i++) {
            if(T.charAt(i) != '#') {
                tLst.add(T.charAt(i));
            }
            if(T.charAt(i) == '#') {
                tDeletes++;
            }

        }

        System.out.println(sLst.toString());
        System.out.println(tLst.toString());


        String sAns = "";
        String tAns = "";

        System.out.println(tAns);
        return sAns.equals(tAns);
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


    public static void main(String[] args) {
        LeetCode lc = new LeetCode();

        int[] nums = {1,3,2,3,5,0};
        //System.out.println(lc.backspaceCompare("ab##", "c#d#"));

        //System.out.println(lc.countElements(nums));

         MinStack obj = new MinStack();
         obj.push(5);
         obj.push(-3);
         obj.push(-2);
         obj.pop();
         int param_3 = obj.top();
         int param_4 = obj.getMin();
        System.out.println(param_4);
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
