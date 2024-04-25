package  ma.zs.alc.ws.dto.prof;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.ws.dto.inscription.EtudiantDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CalendrierProfDto  extends AuditBaseDto {

    private String ref  ;
    private String startTime  ;
    private String endTime  ;
    private String startRecur ;
    private String endRecur ;

    private ProfDto prof ;
    private EtudiantDto etudiant ;



    public CalendrierProfDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    public String getStartTime(){
        return this.startTime;
    }
    public void setStartTime(String startTime){
        this.startTime = startTime;
    }

    @Log
    public String getEndTime(){
        return this.endTime;
    }
    public void setEndTime(String endTime){
        this.endTime = endTime;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getStartRecur(){
        return this.startRecur;
    }
    public void setStartRecur(String startRecur){
        this.startRecur = startRecur;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getEndRecur(){
        return this.endRecur;
    }
    public void setEndRecur(String endRecur){
        this.endRecur = endRecur;
    }


    public ProfDto getProf(){
        return this.prof;
    }

    public void setProf(ProfDto prof){
        this.prof = prof;
    }
    public EtudiantDto getEtudiant(){
        return this.etudiant;
    }

    public void setEtudiant(EtudiantDto etudiant){
        this.etudiant = etudiant;
    }






}
