package ma.zs.alc.bean.core.courseref;

import java.util.Objects;
import java.util.List;





import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.course.Cours;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "centre")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Centre   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String description;
    @Column(length = 500)
    private String log;
    @Column(length = 500)
    private String password;


    private List<Parcours> parcourss ;

    public Centre(){
        super();
    }

    public Centre(Long id){
        this.id = id;
    }

    public Centre(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public Centre(String ref){
        this.ref = ref ;
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
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getLog(){
        return this.log;
    }
    public void setLog(String log){
        this.log = log;
    }
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    @OneToMany(mappedBy = "centre")

    public List<Parcours> getParcourss(){
        return this.parcourss;
    }
    public void setParcourss(List<Parcours> parcourss){
        this.parcourss = parcourss;
    }

    @Transient
    public String getLabel() {
        label = ref;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Centre centre = (Centre) o;
        return id != null && id.equals(centre.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

