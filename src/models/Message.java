package models;

import java.util.Date;

public class Message {
    private String content;
    private String from;
    private String to;
    private Date date;

    public Message(String content, String from, String to, Date date) {
        this.content = content;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Отправитель " + this.getFrom()+"\n"+
                "Получатель " + this.getTo()+"\n"+
                "Контент " + this.getContent()+"\n"+
                "Дата "+this.getDate();
    }
}
