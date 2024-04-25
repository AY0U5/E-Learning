package ma.zs.alc.bean.core.freetrial;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;




import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "free_trial_configuration")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class FreeTrialConfiguration   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateApplicationDebut ;
    private LocalDateTime dateApplicationFin ;
    private Integer nombreStudentMax = 0;
    private Integer nombreStudentMin = 0;



    public FreeTrialConfiguration(){
        super();
    }

    public FreeTrialConfiguration(Long id){
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
    public LocalDateTime getDateApplicationDebut(){
        return this.dateApplicationDebut;
    }
    public void setDateApplicationDebut(LocalDateTime dateApplicationDebut){
        this.dateApplicationDebut = dateApplicationDebut;
    }
    public LocalDateTime getDateApplicationFin(){
        return this.dateApplicationFin;
    }
    public void setDateApplicationFin(LocalDateTime dateApplicationFin){
        this.dateApplicationFin = dateApplicationFin;
    }
    public Integer getNombreStudentMax(){
        return this.nombreStudentMax;
    }
    public void setNombreStudentMax(Integer nombreStudentMax){
        this.nombreStudentMax = nombreStudentMax;
    }
    public Integer getNombreStudentMin(){
        return this.nombreStudentMin;
    }
    public void setNombreStudentMin(Integer nombreStudentMin){
        this.nombreStudentMin = nombreStudentMin;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreeTrialConfiguration freeTrialConfiguration = (FreeTrialConfiguration) o;
        return id != null && id.equals(freeTrialConfiguration.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

