package com.example.task04;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class RotationFileHandler implements MessageHandler{
    private ChronoUnit rotation;
    private LocalDateTime previousRotation;
    private FileHandler fileHandler;
    public RotationFileHandler(ChronoUnit rotation) {
        this.previousRotation = LocalDateTime.now();
        this.rotation = rotation;
    }
    @Override
    public void Handle(String message) {
        if(LocalDateTime.now().isAfter(previousRotation.plus(3,rotation)) ) {
            fileHandler = new FileHandler( new SimpleDateFormat("HH-mm-ss").format(new Date()));
            fileHandler.Handle(message);
            previousRotation = LocalDateTime.now();
        }
    }
}
