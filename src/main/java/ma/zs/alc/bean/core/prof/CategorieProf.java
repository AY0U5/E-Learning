package ma.zs.alc.bean.core.prof;

import java.util.Objects;
import java.util.List;





import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.bean.core.prof.TypeTeacher;
import ma.zs.alc.bean.core.recomrecla.RecommendTeacher;
import ma.zs.alc.bean.core.prof.Prof;
import ma.zs.alc.bean.core.prof.TrancheHoraireProf;
import ma.zs.alc.bean.core.classroom.ClassRoom;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "categorie_prof")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CategorieProf   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String level;
    private BigDecimal lessonRate = BigDecimal.ZERO;


    private List<Prof> profs ;

    public CategorieProf(){
        super();
    }

    public CategorieProf(Long id){
        this.id = id;
    }

    public CategorieProf(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public CategorieProf(String code){
        this.code = code ;
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
    public String getLevel(){
        return this.level;
    }
    public void setLevel(String level){
        this.level = level;
    }
    public BigDecimal getLessonRate(){
        return this.lessonRate;
    }
    public void setLessonRate(BigDecimal lessonRate){
        this.lessonRate = lessonRate;
    }
    @OneToMany(mappedBy = "categorieProf")

    public List<Prof> getProfs(){
        return this.profs;
    }
    public void setProfs(List<Prof> profs){
        this.profs = profs;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieProf categorieProf = (CategorieProf) o;
        return id != null && id.equals(categorieProf.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

