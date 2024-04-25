package ma.zs.alc.bean.core.quizref;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "type_de_question")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TypeDeQuestion   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String lib;



    public TypeDeQuestion(){
        super();
    }

    public TypeDeQuestion(Long id){
        this.id = id;
    }

    public TypeDeQuestion(Long id,String lib){
        this.id = id;
        this.lib = lib ;
    }
    public TypeDeQuestion(String lib){
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

    @Transient
    public String getLabel() {
        label = lib;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeDeQuestion typeDeQuestion = (TypeDeQuestion) o;
        return id != null && id.equals(typeDeQuestion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

