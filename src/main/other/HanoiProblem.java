package main.other;

import java.util.Stack;

public class HanoiProblem {

    public static enum Action {
        No, LToM, MToL, MToR, RToM
    }

    public static int hanoiProblem2(int N){
        if(N<1) return 0;
        Stack<Integer> fStack=new Stack<Integer>();
        Stack<Integer> mStack=new Stack<Integer>();
        Stack<Integer> tStack=new Stack<Integer>();
        fStack.push(Integer.MAX_VALUE);
        mStack.push(Integer.MAX_VALUE);
        tStack.push(Integer.MAX_VALUE);

        for(int i=N;i>=1;i--){
            fStack.push(i);
        }

        // record主要是记录上一次的操作
        Action[] record={Action.No};
        int step=0;
        while(tStack.size()!=N+1){
            step+=process2(record,Action.MToL,Action.LToM,fStack,mStack);
            step+=process2(record,Action.LToM,Action.MToL,mStack,fStack);
            step+=process2(record,Action.RToM,Action.MToR,mStack,tStack);
            step+=process2(record,Action.MToR,Action.RToM,tStack,mStack);
        }

        return step;
    }

    public static int process2(Action[] record, Action preNoAct, Action curAct, Stack<Integer> fStack,
                               Stack<Integer> tStack){
        // 当上一次的操作 为当前上次不允许的操作时，返回
        // 当大压小时，不符合操作规则，返回
        if(record[0]==preNoAct || fStack.peek()>=tStack.peek()){
            return 0;
        }

        // 本次操作允许，记录
        tStack.push(fStack.pop());
        record[0]=curAct;
        return 1;
    }


    public static void main(String[] args) {
        System.out.println(HanoiProblem.hanoiProblem2(2));
    }


}
