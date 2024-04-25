package  ma.zs.alc.ws.dto.review;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.ws.dto.inscription.EtudiantDto;
import ma.zs.alc.ws.dto.course.CoursDto;
import ma.zs.alc.ws.dto.prof.ProfDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfReviewDto  extends AuditBaseDto {

    private Integer review  = 0 ;
    private String comment  ;
    private String dateReview ;

    private EtudiantDto etudiant ;
    private ProfDto prof ;
    private CoursDto cours ;



    public ProfReviewDto(){
        super();
    }



    @Log
    public Integer getReview(){
        return this.review;
    }
    public void setReview(Integer review){
        this.review = review;
    }

    @Log
    public String getComment(){
        return this.comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateReview(){
        return this.dateReview;
    }
    public void setDateReview(String dateReview){
        this.dateReview = dateReview;
    }


    public EtudiantDto getEtudiant(){
        return this.etudiant;
    }

    public void setEtudiant(EtudiantDto etudiant){
        this.etudiant = etudiant;
    }
    public ProfDto getProf(){
        return this.prof;
    }

    public void setProf(ProfDto prof){
        this.prof = prof;
    }
    public CoursDto getCours(){
        return this.cours;
    }

    public void setCours(CoursDto cours){
        this.cours = cours;
    }






}
