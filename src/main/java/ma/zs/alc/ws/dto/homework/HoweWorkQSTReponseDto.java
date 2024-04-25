package  ma.zs.alc.ws.dto.homework;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class HoweWorkQSTReponseDto  extends AuditBaseDto {

    private String ref  ;
    private String lib  ;
    private String etatReponse  ;
    private Integer numero  = 0 ;

    private HomeWorkQuestionDto homeWorkQuestion ;



    public HoweWorkQSTReponseDto(){
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
    public String getLib(){
        return this.lib;
    }
    public void setLib(String lib){
        this.lib = lib;
    }

    @Log
    public String getEtatReponse(){
        return this.etatReponse;
    }
    public void setEtatReponse(String etatReponse){
        this.etatReponse = etatReponse;
    }

    @Log
    public Integer getNumero(){
        return this.numero;
    }
    public void setNumero(Integer numero){
        this.numero = numero;
    }


    public HomeWorkQuestionDto getHomeWorkQuestion(){
        return this.homeWorkQuestion;
    }

    public void setHomeWorkQuestion(HomeWorkQuestionDto homeWorkQuestion){
        this.homeWorkQuestion = homeWorkQuestion;
    }






}
