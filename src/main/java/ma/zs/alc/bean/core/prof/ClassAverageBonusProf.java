package ma.zs.alc.bean.core.prof;

import java.util.Objects;





import ma.zs.alc.bean.core.salary.Salary;
import ma.zs.alc.bean.core.prof.Prof;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "class_average_bonus_prof")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ClassAverageBonusProf   extends AuditBusinessObject     {

    private Long id;

    private Integer mois = 0;
    private Integer annee = 0;

    private Prof prof ;
    private Salary salary ;


    public ClassAverageBonusProf(){
        super();
    }

    public ClassAverageBonusProf(Long id){
        this.id = id;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof")
    public Prof getProf(){
        return this.prof;
    }
    public void setProf(Prof prof){
        this.prof = prof;
    }
    public Integer getMois(){
        return this.mois;
    }
    public void setMois(Integer mois){
        this.mois = mois;
    }
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary")
    public Salary getSalary(){
        return this.salary;
    }
    public void setSalary(Salary salary){
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassAverageBonusProf classAverageBonusProf = (ClassAverageBonusProf) o;
        return id != null && id.equals(classAverageBonusProf.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

