package org.igorr.quickstarts.helloworld.tests.hamcrests;

public class ClassForMatcherTests {

    public ClassForMatcherTests(){

    }

    public int inc(int i){
        return ++i;
    }

    public Integer inc(boolean flag){
        return flag ? 1 : null;
    }


    public void getFlag(){
        if(isFlag()){
            throw new RuntimeException("boom");
        }
    }

    private boolean isFlag(){
        return false;
    }
}
