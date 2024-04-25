package  ma.zs.alc.dao.criteria.core.freetrial;


import ma.zs.alc.dao.criteria.core.grpe.InscriptionCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class FreeTrialformuleCriteria extends  BaseCriteria  {

    private String code;
    private String codeLike;
    private String dayspeerweek;
    private String dayspeerweekLike;
    private String timeperday;
    private String timeperdayLike;
    private String teacherGenderoption;
    private String teacherGenderoptionLike;
    private String teacherAgeRange;
    private String teacherAgeRangeLike;
    private String teacherPersonnality;
    private String teacherPersonnalityLike;
    private Boolean status;
    private LocalDateTime dateConfirmation;
    private LocalDateTime dateConfirmationFrom;
    private LocalDateTime dateConfirmationTo;

    private InscriptionCriteria inscription ;
    private List<InscriptionCriteria> inscriptions ;


    public FreeTrialformuleCriteria(){}

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }

    public String getDayspeerweek(){
        return this.dayspeerweek;
    }
    public void setDayspeerweek(String dayspeerweek){
        this.dayspeerweek = dayspeerweek;
    }
    public String getDayspeerweekLike(){
        return this.dayspeerweekLike;
    }
    public void setDayspeerweekLike(String dayspeerweekLike){
        this.dayspeerweekLike = dayspeerweekLike;
    }

    public String getTimeperday(){
        return this.timeperday;
    }
    public void setTimeperday(String timeperday){
        this.timeperday = timeperday;
    }
    public String getTimeperdayLike(){
        return this.timeperdayLike;
    }
    public void setTimeperdayLike(String timeperdayLike){
        this.timeperdayLike = timeperdayLike;
    }

    public String getTeacherGenderoption(){
        return this.teacherGenderoption;
    }
    public void setTeacherGenderoption(String teacherGenderoption){
        this.teacherGenderoption = teacherGenderoption;
    }
    public String getTeacherGenderoptionLike(){
        return this.teacherGenderoptionLike;
    }
    public void setTeacherGenderoptionLike(String teacherGenderoptionLike){
        this.teacherGenderoptionLike = teacherGenderoptionLike;
    }

    public String getTeacherAgeRange(){
        return this.teacherAgeRange;
    }
    public void setTeacherAgeRange(String teacherAgeRange){
        this.teacherAgeRange = teacherAgeRange;
    }
    public String getTeacherAgeRangeLike(){
        return this.teacherAgeRangeLike;
    }
    public void setTeacherAgeRangeLike(String teacherAgeRangeLike){
        this.teacherAgeRangeLike = teacherAgeRangeLike;
    }

    public String getTeacherPersonnality(){
        return this.teacherPersonnality;
    }
    public void setTeacherPersonnality(String teacherPersonnality){
        this.teacherPersonnality = teacherPersonnality;
    }
    public String getTeacherPersonnalityLike(){
        return this.teacherPersonnalityLike;
    }
    public void setTeacherPersonnalityLike(String teacherPersonnalityLike){
        this.teacherPersonnalityLike = teacherPersonnalityLike;
    }

    public Boolean getStatus(){
        return this.status;
    }
    public void setStatus(Boolean status){
        this.status = status;
    }
    public LocalDateTime getDateConfirmation(){
        return this.dateConfirmation;
    }
    public void setDateConfirmation(LocalDateTime dateConfirmation){
        this.dateConfirmation = dateConfirmation;
    }
    public LocalDateTime getDateConfirmationFrom(){
        return this.dateConfirmationFrom;
    }
    public void setDateConfirmationFrom(LocalDateTime dateConfirmationFrom){
        this.dateConfirmationFrom = dateConfirmationFrom;
    }
    public LocalDateTime getDateConfirmationTo(){
        return this.dateConfirmationTo;
    }
    public void setDateConfirmationTo(LocalDateTime dateConfirmationTo){
        this.dateConfirmationTo = dateConfirmationTo;
    }

    public InscriptionCriteria getInscription(){
        return this.inscription;
    }

    public void setInscription(InscriptionCriteria inscription){
        this.inscription = inscription;
    }
    public List<InscriptionCriteria> getInscriptions(){
        return this.inscriptions;
    }

    public void setInscriptions(List<InscriptionCriteria> inscriptions){
        this.inscriptions = inscriptions;
    }
}
