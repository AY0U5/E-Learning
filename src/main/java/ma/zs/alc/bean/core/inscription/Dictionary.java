package ma.zs.alc.bean.core.inscription;

import java.util.Objects;





import ma.zs.alc.bean.core.inscription.Etudiant;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "dictionary")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Dictionary   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String word;
    @Column(length = 500)
    private String definition;

    private Etudiant etudiant ;


    public Dictionary(){
        super();
    }

    public Dictionary(Long id){
        this.id = id;
    }

    public Dictionary(Long id,String word){
        this.id = id;
        this.word = word ;
    }
    public Dictionary(String word){
        this.word = word ;
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
    public String getWord(){
        return this.word;
    }
    public void setWord(String word){
        this.word = word;
    }
    public String getDefinition(){
        return this.definition;
    }
    public void setDefinition(String definition){
        this.definition = definition;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant")
    public Etudiant getEtudiant(){
        return this.etudiant;
    }
    public void setEtudiant(Etudiant etudiant){
        this.etudiant = etudiant;
    }

    @Transient
    public String getLabel() {
        label = word;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dictionary dictionary = (Dictionary) o;
        return id != null && id.equals(dictionary.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

