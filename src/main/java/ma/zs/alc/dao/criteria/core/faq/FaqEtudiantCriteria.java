package  ma.zs.alc.dao.criteria.core.faq;


import ma.zs.alc.dao.criteria.core.inscription.EtudiantCriteria;
import ma.zs.alc.dao.criteria.core.alc.AdminCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class FaqEtudiantCriteria extends  BaseCriteria  {

    private String description;
    private String descriptionLike;
    private String libelle;
    private String libelleLike;

    private EtudiantCriteria etudiant ;
    private List<EtudiantCriteria> etudiants ;
    private AdminCriteria admin ;
    private List<AdminCriteria> admins ;
    private FaqTypeCriteria faqType ;
    private List<FaqTypeCriteria> faqTypes ;


    public FaqEtudiantCriteria(){}

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


    public EtudiantCriteria getEtudiant(){
        return this.etudiant;
    }

    public void setEtudiant(EtudiantCriteria etudiant){
        this.etudiant = etudiant;
    }
    public List<EtudiantCriteria> getEtudiants(){
        return this.etudiants;
    }

    public void setEtudiants(List<EtudiantCriteria> etudiants){
        this.etudiants = etudiants;
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
