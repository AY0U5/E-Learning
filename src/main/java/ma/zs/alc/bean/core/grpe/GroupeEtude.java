package ma.zs.alc.bean.core.grpe;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "groupe_etude")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class GroupeEtude   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String description;
    private Long nombreEtudiant ;



    public GroupeEtude(){
        super();
    }

    public GroupeEtude(Long id){
        this.id = id;
    }

    public GroupeEtude(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public GroupeEtude(String libelle){
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
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Long getNombreEtudiant(){
        return this.nombreEtudiant;
    }
    public void setNombreEtudiant(Long nombreEtudiant){
        this.nombreEtudiant = nombreEtudiant;
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
        GroupeEtude groupeEtude = (GroupeEtude) o;
        return id != null && id.equals(groupeEtude.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

