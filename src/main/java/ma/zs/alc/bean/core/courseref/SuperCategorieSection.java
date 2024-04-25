package ma.zs.alc.bean.core.courseref;

import java.util.Objects;
import java.util.List;





import ma.zs.alc.bean.core.courseref.CategorieSection;
import ma.zs.alc.bean.core.course.Section;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "super_categorie_section")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class SuperCategorieSection   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;


    private List<CategorieSection> categorieSections ;

    public SuperCategorieSection(){
        super();
    }

    public SuperCategorieSection(Long id){
        this.id = id;
    }

    public SuperCategorieSection(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public SuperCategorieSection(String libelle){
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
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @OneToMany(mappedBy = "superCategorieSection")

    public List<CategorieSection> getCategorieSections(){
        return this.categorieSections;
    }
    public void setCategorieSections(List<CategorieSection> categorieSections){
        this.categorieSections = categorieSections;
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
        SuperCategorieSection superCategorieSection = (SuperCategorieSection) o;
        return id != null && id.equals(superCategorieSection.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

