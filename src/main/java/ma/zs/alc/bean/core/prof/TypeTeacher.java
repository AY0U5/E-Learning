package ma.zs.alc.bean.core.prof;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "type_teacher")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TypeTeacher   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;



    public TypeTeacher(){
        super();
    }

    public TypeTeacher(Long id){
        this.id = id;
    }

    public TypeTeacher(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public TypeTeacher(String libelle){
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
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
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
        TypeTeacher typeTeacher = (TypeTeacher) o;
        return id != null && id.equals(typeTeacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

