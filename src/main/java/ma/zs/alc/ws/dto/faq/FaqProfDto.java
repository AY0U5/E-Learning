package  ma.zs.alc.ws.dto.faq;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.alc.ws.dto.alc.AdminDto;
import ma.zs.alc.ws.dto.prof.ProfDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class FaqProfDto  extends AuditBaseDto {

    private String description  ;
    private String libelle  ;

    private ProfDto prof ;
    private AdminDto admin ;
    private FaqTypeDto faqType ;



    public FaqProfDto(){
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


    public ProfDto getProf(){
        return this.prof;
    }

    public void setProf(ProfDto prof){
        this.prof = prof;
    }
    public AdminDto getAdmin(){
        return this.admin;
    }

    public void setAdmin(AdminDto admin){
        this.admin = admin;
    }
    public FaqTypeDto getFaqType(){
        return this.faqType;
    }

    public void setFaqType(FaqTypeDto faqType){
        this.faqType = faqType;
    }






}
