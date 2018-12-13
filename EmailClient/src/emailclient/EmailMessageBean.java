/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailclient;

import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hadin
 */
public class EmailMessageBean {
    private SimpleStringProperty sender;
    private SimpleStringProperty subject;
    private SimpleStringProperty size;
    public static Map<String, Integer> formattedValues = new HashMap<>(); //can be used for comperator in size column.
    
    public EmailMessageBean(String subject, String sender, int size){
        this.subject = new SimpleStringProperty(subject);
        this.sender = new SimpleStringProperty(sender);
        this.size = new SimpleStringProperty(formattedSize(size));
    }
    
    public String getSubject(){
        return subject.get();
    }
    public String getSender(){
        return sender.get();
    }
    public String getSize(){
        return size.get();
    }
    
    //format the size with bytes, Kbytes ot Megabytes:
    private String formattedSize(int size){
        String formattedSizeString;
        if(size <= 0)
            formattedSizeString = "0";
        else if(size < 1024)
            formattedSizeString = size + " B";
        else if (size < 1048576)
            formattedSizeString = size/1024 + " KB";
        else
            formattedSizeString = size/1048576 + " MB";
        
        formattedValues.put(formattedSizeString, size);
        return formattedSizeString;
    }
}
