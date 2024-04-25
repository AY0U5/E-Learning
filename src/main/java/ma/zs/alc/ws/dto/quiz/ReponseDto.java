package  ma.zs.alc.ws.dto.quiz;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReponseDto  extends AuditBaseDto {

    private String ref  ;
    private String lib  ;
    private String etatReponse  ;
    private Long numero  ;

    private QuestionDto question ;



    public ReponseDto(){
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
    public Long getNumero(){
        return this.numero;
    }
    public void setNumero(Long numero){
        this.numero = numero;
    }


    public QuestionDto getQuestion(){
        return this.question;
    }

    public void setQuestion(QuestionDto question){
        this.question = question;
    }






}
