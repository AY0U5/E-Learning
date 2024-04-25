package ma.zs.alc.bean.core.freetrial;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "statut_free_trial")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class StatutFreeTrial   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String style;



    public StatutFreeTrial(){
        super();
    }

    public StatutFreeTrial(Long id){
        this.id = id;
    }

    public StatutFreeTrial(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public StatutFreeTrial(String libelle){
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
    public String getStyle(){
        return this.style;
    }
    public void setStyle(String style){
        this.style = style;
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
        StatutFreeTrial statutFreeTrial = (StatutFreeTrial) o;
        return id != null && id.equals(statutFreeTrial.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

