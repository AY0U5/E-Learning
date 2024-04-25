package  ma.zs.alc.ws.dto.faq;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.alc.ws.dto.inscription.EtudiantDto;
import ma.zs.alc.ws.dto.alc.AdminDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class FaqEtudiantDto  extends AuditBaseDto {

    private String description  ;
    private String libelle  ;

    private EtudiantDto etudiant ;
    private AdminDto admin ;
    private FaqTypeDto faqType ;



    public FaqEtudiantDto(){
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


    public EtudiantDto getEtudiant(){
        return this.etudiant;
    }

    public void setEtudiant(EtudiantDto etudiant){
        this.etudiant = etudiant;
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
