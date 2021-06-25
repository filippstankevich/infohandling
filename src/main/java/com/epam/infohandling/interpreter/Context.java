package com.epam.infohandling.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {
    private Deque<Integer> contestValues = new ArrayDeque<>();

    public Integer popValue(){
        return contestValues.pop();
    }
    public void pushValue(Integer value){
        this.contestValues.push(value);
    }

}