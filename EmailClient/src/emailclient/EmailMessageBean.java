/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailclient;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author hadin
 */
public class EmailMessageBean {
    private SimpleStringProperty sender;
    private SimpleStringProperty subject;
    private SimpleIntegerProperty size;
    
    public EmailMessageBean(String subject, String sender, int size){
        this.subject = new SimpleStringProperty(subject);
        this.sender = new SimpleStringProperty(sender);
        this.size = new SimpleIntegerProperty(size);
    }
    
    public String getSubject(){
        return subject.get();
    }
    public String getSender(){
        return sender.get();
    }
    public int getSize(){
        return size.get();
    }
}
