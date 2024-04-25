package  ma.zs.alc.ws.dto.vocab;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.ws.dto.course.SectionDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class VocabularyQuizDto  extends AuditBaseDto {

    private String libelle  ;
    private String dateDebut ;
    private String dateFin ;

    private SectionDto section ;

    private List<VocabularyDto> vocabularys ;


    public VocabularyQuizDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(String dateFin){
        this.dateFin = dateFin;
    }


    public SectionDto getSection(){
        return this.section;
    }

    public void setSection(SectionDto section){
        this.section = section;
    }



    public List<VocabularyDto> getVocabularys(){
        return this.vocabularys;
    }

    public void setVocabularys(List<VocabularyDto> vocabularys){
        this.vocabularys = vocabularys;
    }



}
