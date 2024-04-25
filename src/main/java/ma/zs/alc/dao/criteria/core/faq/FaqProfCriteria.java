package  ma.zs.alc.dao.criteria.core.faq;


import ma.zs.alc.dao.criteria.core.alc.AdminCriteria;
import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class FaqProfCriteria extends  BaseCriteria  {

    private String description;
    private String descriptionLike;
    private String libelle;
    private String libelleLike;

    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;
    private AdminCriteria admin ;
    private List<AdminCriteria> admins ;
    private FaqTypeCriteria faqType ;
    private List<FaqTypeCriteria> faqTypes ;


    public FaqProfCriteria(){}

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }


    public ProfCriteria getProf(){
        return this.prof;
    }

    public void setProf(ProfCriteria prof){
        this.prof = prof;
    }
    public List<ProfCriteria> getProfs(){
        return this.profs;
    }

    public void setProfs(List<ProfCriteria> profs){
        this.profs = profs;
    }
    public AdminCriteria getAdmin(){
        return this.admin;
    }

    public void setAdmin(AdminCriteria admin){
        this.admin = admin;
    }
    public List<AdminCriteria> getAdmins(){
        return this.admins;
    }

    public void setAdmins(List<AdminCriteria> admins){
        this.admins = admins;
    }
    public FaqTypeCriteria getFaqType(){
        return this.faqType;
    }

    public void setFaqType(FaqTypeCriteria faqType){
        this.faqType = faqType;
    }
    public List<FaqTypeCriteria> getFaqTypes(){
        return this.faqTypes;
    }

    public void setFaqTypes(List<FaqTypeCriteria> faqTypes){
        this.faqTypes = faqTypes;
    }
}
