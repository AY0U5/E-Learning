package  ma.zs.alc.ws.dto.inscriptionref;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class EtatEtudiantScheduleDto  extends AuditBaseDto {

    private String ref  ;
    private String libelle  ;
    private String couleur  ;




    public EtatEtudiantScheduleDto(){
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
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getCouleur(){
        return this.couleur;
    }
    public void setCouleur(String couleur){
        this.couleur = couleur;
    }








}
