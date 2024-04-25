package  ma.zs.alc.ws.dto.prof;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.math.BigDecimal;


import ma.zs.alc.ws.dto.course.ParcoursDto;
import ma.zs.alc.ws.dto.recomrecla.RecommendTeacherDto;
import ma.zs.alc.ws.dto.classroom.ClassRoomDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategorieProfDto  extends AuditBaseDto {

    private String code  ;
    private String level  ;
    private BigDecimal lessonRate  ;


    private List<ProfDto> profs ;


    public CategorieProfDto(){
        super();
    }



    @Log
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }

    @Log
    public String getLevel(){
        return this.level;
    }
    public void setLevel(String level){
        this.level = level;
    }

    @Log
    public BigDecimal getLessonRate(){
        return this.lessonRate;
    }
    public void setLessonRate(BigDecimal lessonRate){
        this.lessonRate = lessonRate;
    }





    public List<ProfDto> getProfs(){
        return this.profs;
    }

    public void setProfs(List<ProfDto> profs){
        this.profs = profs;
    }



}
