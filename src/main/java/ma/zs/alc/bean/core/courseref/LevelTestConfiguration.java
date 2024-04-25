package ma.zs.alc.bean.core.courseref;

import java.util.Objects;





import ma.zs.alc.bean.core.course.Parcours;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "level_test_configuration")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class LevelTestConfiguration   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal noteMin = BigDecimal.ZERO;
    private BigDecimal noteMax = BigDecimal.ZERO;

    private Parcours parcours ;


    public LevelTestConfiguration(){
        super();
    }

    public LevelTestConfiguration(Long id){
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
    public BigDecimal getNoteMin(){
        return this.noteMin;
    }
    public void setNoteMin(BigDecimal noteMin){
        this.noteMin = noteMin;
    }
    public BigDecimal getNoteMax(){
        return this.noteMax;
    }
    public void setNoteMax(BigDecimal noteMax){
        this.noteMax = noteMax;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parcours")
    public Parcours getParcours(){
        return this.parcours;
    }
    public void setParcours(Parcours parcours){
        this.parcours = parcours;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LevelTestConfiguration levelTestConfiguration = (LevelTestConfiguration) o;
        return id != null && id.equals(levelTestConfiguration.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

