package  ma.zs.alc.ws.dto.faq;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class FaqDto  extends AuditBaseDto {

    private String description  ;
    private String libelle  ;

    private FaqTypeDto faqType ;



    public FaqDto(){
        super();
    }



    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }


    public FaqTypeDto getFaqType(){
        return this.faqType;
    }

    public void setFaqType(FaqTypeDto faqType){
        this.faqType = faqType;
    }






}
