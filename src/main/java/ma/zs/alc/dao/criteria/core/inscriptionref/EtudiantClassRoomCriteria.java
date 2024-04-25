package  ma.zs.alc.dao.criteria.core.inscriptionref;


import ma.zs.alc.dao.criteria.core.inscription.EtudiantCriteria;
import ma.zs.alc.dao.criteria.core.classroom.ClassRoomCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class EtudiantClassRoomCriteria extends  BaseCriteria  {


    private ClassRoomCriteria classRoom ;
    private List<ClassRoomCriteria> classRooms ;
    private EtudiantCriteria etudiant ;
    private List<EtudiantCriteria> etudiants ;


    public EtudiantClassRoomCriteria(){}


    public ClassRoomCriteria getClassRoom(){
        return this.classRoom;
    }

    public void setClassRoom(ClassRoomCriteria classRoom){
        this.classRoom = classRoom;
    }
    public List<ClassRoomCriteria> getClassRooms(){
        return this.classRooms;
    }

    public void setClassRooms(List<ClassRoomCriteria> classRooms){
        this.classRooms = classRooms;
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
