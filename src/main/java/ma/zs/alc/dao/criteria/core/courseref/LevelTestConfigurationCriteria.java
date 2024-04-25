package  ma.zs.alc.dao.criteria.core.courseref;


import ma.zs.alc.dao.criteria.core.course.ParcoursCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class LevelTestConfigurationCriteria extends  BaseCriteria  {

    private String noteMin;
    private String noteMinMin;
    private String noteMinMax;
    private String noteMax;
    private String noteMaxMin;
    private String noteMaxMax;

    private ParcoursCriteria parcours ;
    private List<ParcoursCriteria> parcourss ;


    public LevelTestConfigurationCriteria(){}

    public String getNoteMin(){
        return this.noteMin;
    }
    public void setNoteMin(String noteMin){
        this.noteMin = noteMin;
    }   
    public String getNoteMinMin(){
        return this.noteMinMin;
    }
    public void setNoteMinMin(String noteMinMin){
        this.noteMinMin = noteMinMin;
    }
    public String getNoteMinMax(){
        return this.noteMinMax;
    }
    public void setNoteMinMax(String noteMinMax){
        this.noteMinMax = noteMinMax;
    }
      
    public String getNoteMax(){
        return this.noteMax;
    }
    public void setNoteMax(String noteMax){
        this.noteMax = noteMax;
    }   
    public String getNoteMaxMin(){
        return this.noteMaxMin;
    }
    public void setNoteMaxMin(String noteMaxMin){
        this.noteMaxMin = noteMaxMin;
    }
    public String getNoteMaxMax(){
        return this.noteMaxMax;
    }
    public void setNoteMaxMax(String noteMaxMax){
        this.noteMaxMax = noteMaxMax;
    }
      

    public ParcoursCriteria getParcours(){
        return this.parcours;
    }

    public void setParcours(ParcoursCriteria parcours){
        this.parcours = parcours;
    }
    public List<ParcoursCriteria> getParcourss(){
        return this.parcourss;
    }

    public void setParcourss(List<ParcoursCriteria> parcourss){
        this.parcourss = parcourss;
    }
}
