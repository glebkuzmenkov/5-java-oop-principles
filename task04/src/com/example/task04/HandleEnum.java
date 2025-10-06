package com.example.task04;
import java.time.temporal.ChronoUnit;
public enum HandleEnum {
    ConsoleHandle(new ConsoleHandler()),
    FileHandle(new FileHandler()),
    RotationFileHandle(new RotationFileHandler(ChronoUnit.SECONDS)),
    MemoryHandle(new MemoryHandler());
    private final MessageHandler messageHandler;
    HandleEnum(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }
    public MessageHandler getHandle(){
        return  this.messageHandler;
    }
}
