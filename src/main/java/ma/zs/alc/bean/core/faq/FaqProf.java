package ma.zs.alc.bean.core.faq;

import java.util.Objects;





import ma.zs.alc.bean.core.faq.FaqType;
import ma.zs.alc.bean.core.alc.Admin;
import ma.zs.alc.bean.core.prof.Prof;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "faq_prof")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class FaqProf   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String description;
    @Column(length = 500)
    private String libelle;

    private Prof prof ;
    private Admin admin ;
    private FaqType faqType ;


    public FaqProf(){
        super();
    }

    public FaqProf(Long id){
        this.id = id;
    }

    public FaqProf(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public FaqProf(String libelle){
        this.libelle = libelle ;
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
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof")
    public Prof getProf(){
        return this.prof;
    }
    public void setProf(Prof prof){
        this.prof = prof;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin")
    public Admin getAdmin(){
        return this.admin;
    }
    public void setAdmin(Admin admin){
        this.admin = admin;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faq_type")
    public FaqType getFaqType(){
        return this.faqType;
    }
    public void setFaqType(FaqType faqType){
        this.faqType = faqType;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FaqProf faqProf = (FaqProf) o;
        return id != null && id.equals(faqProf.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

