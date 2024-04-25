package ma.zs.alc.bean.core.faq;

import java.util.Objects;





import ma.zs.alc.bean.core.faq.FaqType;
import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.alc.Admin;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "faq_etudiant")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class FaqEtudiant   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String description;
    @Column(length = 500)
    private String libelle;

    private Etudiant etudiant ;
    private Admin admin ;
    private FaqType faqType ;


    public FaqEtudiant(){
        super();
    }

    public FaqEtudiant(Long id){
        this.id = id;
    }

    public FaqEtudiant(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public FaqEtudiant(String libelle){
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
    @JoinColumn(name = "etudiant")
    public Etudiant getEtudiant(){
        return this.etudiant;
    }
    public void setEtudiant(Etudiant etudiant){
        this.etudiant = etudiant;
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
        FaqEtudiant faqEtudiant = (FaqEtudiant) o;
        return id != null && id.equals(faqEtudiant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

