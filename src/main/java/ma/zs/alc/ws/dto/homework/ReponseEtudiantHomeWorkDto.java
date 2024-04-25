package  ma.zs.alc.ws.dto.homework;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;




@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReponseEtudiantHomeWorkDto  extends AuditBaseDto {

    private String answer  ;
    private String profNote  ;
    private BigDecimal note  ;

    private HoweWorkQSTReponseDto howeWorkQSTReponse ;
    private HomeWorkEtudiantDto homeWorkEtudiant ;
    private HomeWorkQuestionDto homeWorkQuestion ;



    public ReponseEtudiantHomeWorkDto(){
        super();
    }



    @Log
    public String getAnswer(){
        return this.answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }

    @Log
    public String getProfNote(){
        return this.profNote;
    }
    public void setProfNote(String profNote){
        this.profNote = profNote;
    }

    @Log
    public BigDecimal getNote(){
        return this.note;
    }
    public void setNote(BigDecimal note){
        this.note = note;
    }


    public HoweWorkQSTReponseDto getHoweWorkQSTReponse(){
        return this.howeWorkQSTReponse;
    }

    public void setHoweWorkQSTReponse(HoweWorkQSTReponseDto howeWorkQSTReponse){
        this.howeWorkQSTReponse = howeWorkQSTReponse;
    }
    public HomeWorkEtudiantDto getHomeWorkEtudiant(){
        return this.homeWorkEtudiant;
    }

    public void setHomeWorkEtudiant(HomeWorkEtudiantDto homeWorkEtudiant){
        this.homeWorkEtudiant = homeWorkEtudiant;
    }
    public HomeWorkQuestionDto getHomeWorkQuestion(){
        return this.homeWorkQuestion;
    }

    public void setHomeWorkQuestion(HomeWorkQuestionDto homeWorkQuestion){
        this.homeWorkQuestion = homeWorkQuestion;
    }






}
