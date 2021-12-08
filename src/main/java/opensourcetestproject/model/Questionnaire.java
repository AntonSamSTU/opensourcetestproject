//package opensourcetestproject.model;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "questionnaires")
//public class Questionnaire {
//
//    @ManyToMany(fetch = FetchType.EAGER) //Строки в анкете
//    private Set<Row> rows;
//
//    @ManyToMany(fetch = FetchType.EAGER)    //Пользователи, которым отправили анкету
//    private Set<User> recipients;
//
//    @ManyToMany(fetch = FetchType.EAGER)//Пользователи, которые заполнили анкету
//    private Set<User> respondents;
//
//
//    @ManyToOne(fetch = FetchType.EAGER) //одному автору соответскует множество анкет
//    @JoinColumn(name = "author_id")
//    private User author;
//
//    private boolean multipart; //Мультивыборочная анкета или нет
//
//    public Questionnaire() {
//    }
//
//
//    public Set<Row> getRows() {
//        return rows;
//    }
//
//    public void setRows(Set<Row> rows) {
//        this.rows = rows;
//    }
//
//    public Set<User> getRecipients() {
//        return recipients;
//    }
//
//    public void setRecipients(Set<User> recipients) {
//        this.recipients = recipients;
//    }
//
//    public Set<User> getRespondents() {
//        return respondents;
//    }
//
//    public void setRespondents(Set<User> respondents) {
//        this.respondents = respondents;
//    }
//
//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }
//
//    public boolean isMultipart() {
//        return multipart;
//    }
//
//    public void setMultipart(boolean multipart) {
//        this.multipart = multipart;
//    }
//}
