package com.example.task04;
import javax.imageio.IIOException;
import java.io.*;
public class FileHandler implements MessageHandler{
    private String fileName;
    public FileHandler(){}
    public FileHandler(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void Handle(String message) {
        try {
            PrintWriter pw = new PrintWriter( new FileWriter(fileInit(fileName),true) );
            pw.println(message);
            pw.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private File fileInit(String fileName){
        File file = new File(String.format("task04/%s.txt",fileName));
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return file;
    }
}
