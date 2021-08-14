package stackCode;

import java.util.Stack;

public class Solution_CQueue {
    private Stack<Integer> stack;
    private Stack<Integer> stack1;
//    public void CQueue(){
//        stack = new Stack<>();
//        stack1 = new Stack<>();
//    }
//    public void appendTail(int value){
//        stack1.push(value);
//    }
//    public int deleteHead(){
//        int de = -1;
//        if(!stack.isEmpty()){
//            de=stack.pop();
//        }else{
//            if(!stack1.isEmpty()){
//                while (!stack1.isEmpty()){
//                    stack.push(stack1.pop());
//                }
//                de=stack.pop();
//            }
//        }
//        return de;
//    }
//    public void CQueue(){
//        stack = new Stack<>();
//        stack1 = new Stack<>();
//    }
//    public void appendTail(int value){
//        if(stack.isEmpty()){
//            stack.push(value);
//        }else{
//
//            while(!stack.isEmpty()){
//                stack1.push(stack.pop());
//            }
//            stack1.push(value);
//            while(!stack1.isEmpty()){
//                stack.push(stack1.pop());
//            }
//        }
//    }
//    public int deleteHead(){
//        int de = -1;
//        if(!stack.isEmpty()){
//            de=stack.pop();
//        }
//        return de;
//    }

    public Solution_CQueue() {
        stack = new Stack<>();
        stack1 = new Stack<>();
    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty()){
            if (stack.isEmpty()) return -1;
            while (!stack.isEmpty()){
                stack1.push(stack.pop());
            }
        }
        return stack1.pop();
    }
}
class test{
    public static void main(String[] args) {

    }
}
