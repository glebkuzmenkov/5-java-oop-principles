package com.example.task04;

import java.util.ArrayList;

public class MemoryHandler implements MessageHandler{
    private ArrayList<String> memory = new ArrayList<>();
    private int limit = 50;
    private ConsoleHandler handler = new ConsoleHandler();
    @Override
    public void Handle(String message) {
        if (memory.size() < limit){
            memory.add(message);
        }else {
            for (String element : memory){
                handler.Handle(element);
            }
            memory.clear();
        }
    }
}
