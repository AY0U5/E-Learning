package  ma.zs.alc.dao.criteria.core.grpe;


import ma.zs.alc.dao.criteria.core.inscription.EtudiantCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class GroupeEtudiantDetailCriteria extends  BaseCriteria  {


    private GroupeEtudiantCriteria groupeEtudiant ;
    private List<GroupeEtudiantCriteria> groupeEtudiants ;
    private EtudiantCriteria etudiant ;
    private List<EtudiantCriteria> etudiants ;


    public GroupeEtudiantDetailCriteria(){}


    public GroupeEtudiantCriteria getGroupeEtudiant(){
        return this.groupeEtudiant;
    }

    public void setGroupeEtudiant(GroupeEtudiantCriteria groupeEtudiant){
        this.groupeEtudiant = groupeEtudiant;
    }
    public List<GroupeEtudiantCriteria> getGroupeEtudiants(){
        return this.groupeEtudiants;
    }

    public void setGroupeEtudiants(List<GroupeEtudiantCriteria> groupeEtudiants){
        this.groupeEtudiants = groupeEtudiants;
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
}
