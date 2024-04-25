package  ma.zs.alc.ws.dto.quizref;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeDeQuestionDto  extends AuditBaseDto {

    private String ref  ;
    private String lib  ;




    public TypeDeQuestionDto(){
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








}
