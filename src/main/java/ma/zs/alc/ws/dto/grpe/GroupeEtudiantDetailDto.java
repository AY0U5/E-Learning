package  ma.zs.alc.ws.dto.grpe;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.alc.ws.dto.inscription.EtudiantDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupeEtudiantDetailDto  extends AuditBaseDto {


    private GroupeEtudiantDto groupeEtudiant ;
    private EtudiantDto etudiant ;



    public GroupeEtudiantDetailDto(){
        super();
    }




    public GroupeEtudiantDto getGroupeEtudiant(){
        return this.groupeEtudiant;
    }

    public void setGroupeEtudiant(GroupeEtudiantDto groupeEtudiant){
        this.groupeEtudiant = groupeEtudiant;
    }
    public EtudiantDto getEtudiant(){
        return this.etudiant;
    }

    public void setEtudiant(EtudiantDto etudiant){
        this.etudiant = etudiant;
    }






}
