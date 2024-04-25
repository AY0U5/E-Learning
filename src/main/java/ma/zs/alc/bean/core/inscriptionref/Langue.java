package ma.zs.alc.bean.core.inscriptionref;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "langue")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Langue   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String libelle;



    public Langue(){
        super();
    }

    public Langue(Long id){
        this.id = id;
    }

    public Langue(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Langue(String libelle){
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
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
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
        Langue langue = (Langue) o;
        return id != null && id.equals(langue.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

