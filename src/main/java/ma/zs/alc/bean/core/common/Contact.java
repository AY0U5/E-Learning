package ma.zs.alc.bean.core.common;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;




import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "contact")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Contact   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String name;
    @Column(length = 500)
    private String email;
    @Column(length = 500)
    private String phone;
    @Column(length = 500)
    private String setFrom;
    private LocalDateTime dateContact ;
    @Column(columnDefinition = "boolean default false")
    private Boolean replied = false;
    @Column(length = 500)
    private String message;



    public Contact(){
        super();
    }

    public Contact(Long id){
        this.id = id;
    }





    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getSetFrom(){
        return this.setFrom;
    }
    public void setSetFrom(String setFrom){
        this.setFrom = setFrom;
    }
    public LocalDateTime getDateContact(){
        return this.dateContact;
    }
    public void setDateContact(LocalDateTime dateContact){
        this.dateContact = dateContact;
    }
    public Boolean  getReplied(){
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id != null && id.equals(contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

