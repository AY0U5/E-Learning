package  ma.zs.alc.dao.criteria.core.common;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ContactCriteria extends  BaseCriteria  {

    private String name;
    private String nameLike;
    private String email;
    private String emailLike;
    private String phone;
    private String phoneLike;
    private String setFrom;
    private String setFromLike;
    private LocalDateTime dateContact;
    private LocalDateTime dateContactFrom;
    private LocalDateTime dateContactTo;
    private Boolean replied;
    private String message;
    private String messageLike;



    public ContactCriteria(){}

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getNameLike(){
        return this.nameLike;
    }
    public void setNameLike(String nameLike){
        this.nameLike = nameLike;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }

    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhoneLike(){
        return this.phoneLike;
    }
    public void setPhoneLike(String phoneLike){
        this.phoneLike = phoneLike;
    }

    public String getSetFrom(){
        return this.setFrom;
    }
    public void setSetFrom(String setFrom){
        this.setFrom = setFrom;
    }
    public String getSetFromLike(){
        return this.setFromLike;
    }
    public void setSetFromLike(String setFromLike){
        this.setFromLike = setFromLike;
    }

    public LocalDateTime getDateContact(){
        return this.dateContact;
    }
    public void setDateContact(LocalDateTime dateContact){
        this.dateContact = dateContact;
    }
    public LocalDateTime getDateContactFrom(){
        return this.dateContactFrom;
    }
    public void setDateContactFrom(LocalDateTime dateContactFrom){
        this.dateContactFrom = dateContactFrom;
    }
    public LocalDateTime getDateContactTo(){
        return this.dateContactTo;
    }
    public void setDateContactTo(LocalDateTime dateContactTo){
        this.dateContactTo = dateContactTo;
    }
    public Boolean getReplied(){
        return this.replied;
    }
    public void setReplied(Boolean replied){
        this.replied = replied;
    }
    public String getMessage(){
        return this.message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessageLike(){
        return this.messageLike;
    }
    public void setMessageLike(String messageLike){
        this.messageLike = messageLike;
    }


}
