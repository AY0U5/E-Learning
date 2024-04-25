package ma.zs.alc.bean.core.quiz;

import java.util.Objects;





import ma.zs.alc.bean.core.quiz.Question;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "reponse")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Reponse   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String lib;
    @Column(length = 500)
    private String etatReponse;
    private Long numero ;

    private Question question ;


    public Reponse(){
        super();
    }

    public Reponse(Long id){
        this.id = id;
    }

    public Reponse(Long id,String lib){
        this.id = id;
        this.lib = lib ;
    }
    public Reponse(String lib){
        this.lib = lib ;
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
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getLib(){
        return this.lib;
    }
    public void setLib(String lib){
        this.lib = lib;
    }
    public String getEtatReponse(){
        return this.etatReponse;
    }
    public void setEtatReponse(String etatReponse){
        this.etatReponse = etatReponse;
    }
    public Long getNumero(){
        return this.numero;
    }
    public void setNumero(Long numero){
        this.numero = numero;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question")
    public Question getQuestion(){
        return this.question;
    }
    public void setQuestion(Question question){
        this.question = question;
    }

    @Transient
    public String getLabel() {
        label = lib;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reponse reponse = (Reponse) o;
        return id != null && id.equals(reponse.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

