package  ma.zs.alc.dao.criteria.core.grpe;


import ma.zs.alc.dao.criteria.core.course.ParcoursCriteria;
import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class GroupeEtudiantCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private LocalDateTime dateDebut;
    private LocalDateTime dateDebutFrom;
    private LocalDateTime dateDebutTo;
    private LocalDateTime dateFin;
    private LocalDateTime dateFinFrom;
    private LocalDateTime dateFinTo;
    private String nombrePlace;
    private String nombrePlaceMin;
    private String nombrePlaceMax;
    private String nombrePlacevide;
    private String nombrePlacevideMin;
    private String nombrePlacevideMax;
    private String nombrePlaceNonVide;
    private String nombrePlaceNonVideMin;
    private String nombrePlaceNonVideMax;

    private GroupeEtudeCriteria groupeEtude ;
    private List<GroupeEtudeCriteria> groupeEtudes ;
    private GroupeTypeCriteria groupeType ;
    private List<GroupeTypeCriteria> groupeTypes ;
    private GroupeEtatCriteria groupeEtat ;
    private List<GroupeEtatCriteria> groupeEtats ;
    private ParcoursCriteria parcours ;
    private List<ParcoursCriteria> parcourss ;
    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;


    public GroupeEtudiantCriteria(){}

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

    public LocalDateTime getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(LocalDateTime dateDebut){
        this.dateDebut = dateDebut;
    }
    public LocalDateTime getDateDebutFrom(){
        return this.dateDebutFrom;
    }
    public void setDateDebutFrom(LocalDateTime dateDebutFrom){
        this.dateDebutFrom = dateDebutFrom;
    }
    public LocalDateTime getDateDebutTo(){
        return this.dateDebutTo;
    }
    public void setDateDebutTo(LocalDateTime dateDebutTo){
        this.dateDebutTo = dateDebutTo;
    }
    public LocalDateTime getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(LocalDateTime dateFin){
        this.dateFin = dateFin;
    }
    public LocalDateTime getDateFinFrom(){
        return this.dateFinFrom;
    }
    public void setDateFinFrom(LocalDateTime dateFinFrom){
        this.dateFinFrom = dateFinFrom;
    }
    public LocalDateTime getDateFinTo(){
        return this.dateFinTo;
    }
    public void setDateFinTo(LocalDateTime dateFinTo){
        this.dateFinTo = dateFinTo;
    }
    public String getNombrePlace(){
        return this.nombrePlace;
    }
    public void setNombrePlace(String nombrePlace){
        this.nombrePlace = nombrePlace;
    }   
    public String getNombrePlaceMin(){
        return this.nombrePlaceMin;
    }
    public void setNombrePlaceMin(String nombrePlaceMin){
        this.nombrePlaceMin = nombrePlaceMin;
    }
    public String getNombrePlaceMax(){
        return this.nombrePlaceMax;
    }
    public void setNombrePlaceMax(String nombrePlaceMax){
        this.nombrePlaceMax = nombrePlaceMax;
    }
      
    public String getNombrePlacevide(){
        return this.nombrePlacevide;
    }
    public void setNombrePlacevide(String nombrePlacevide){
        this.nombrePlacevide = nombrePlacevide;
    }   
    public String getNombrePlacevideMin(){
        return this.nombrePlacevideMin;
    }
    public void setNombrePlacevideMin(String nombrePlacevideMin){
        this.nombrePlacevideMin = nombrePlacevideMin;
    }
    public String getNombrePlacevideMax(){
        return this.nombrePlacevideMax;
    }
    public void setNombrePlacevideMax(String nombrePlacevideMax){
        this.nombrePlacevideMax = nombrePlacevideMax;
    }
      
    public String getNombrePlaceNonVide(){
        return this.nombrePlaceNonVide;
    }
    public void setNombrePlaceNonVide(String nombrePlaceNonVide){
        this.nombrePlaceNonVide = nombrePlaceNonVide;
    }   
    public String getNombrePlaceNonVideMin(){
        return this.nombrePlaceNonVideMin;
    }
    public void setNombrePlaceNonVideMin(String nombrePlaceNonVideMin){
        this.nombrePlaceNonVideMin = nombrePlaceNonVideMin;
    }
    public String getNombrePlaceNonVideMax(){
        return this.nombrePlaceNonVideMax;
    }
    public void setNombrePlaceNonVideMax(String nombrePlaceNonVideMax){
        this.nombrePlaceNonVideMax = nombrePlaceNonVideMax;
    }
      

    public GroupeEtudeCriteria getGroupeEtude(){
        return this.groupeEtude;
    }

    public void setGroupeEtude(GroupeEtudeCriteria groupeEtude){
        this.groupeEtude = groupeEtude;
    }
    public List<GroupeEtudeCriteria> getGroupeEtudes(){
        return this.groupeEtudes;
    }

    public void setGroupeEtudes(List<GroupeEtudeCriteria> groupeEtudes){
        this.groupeEtudes = groupeEtudes;
    }
    public GroupeTypeCriteria getGroupeType(){
        return this.groupeType;
    }

    public void setGroupeType(GroupeTypeCriteria groupeType){
        this.groupeType = groupeType;
    }
    public List<GroupeTypeCriteria> getGroupeTypes(){
        return this.groupeTypes;
    }

    public void setGroupeTypes(List<GroupeTypeCriteria> groupeTypes){
        this.groupeTypes = groupeTypes;
    }
    public GroupeEtatCriteria getGroupeEtat(){
        return this.groupeEtat;
    }

    public void setGroupeEtat(GroupeEtatCriteria groupeEtat){
        this.groupeEtat = groupeEtat;
    }
    public List<GroupeEtatCriteria> getGroupeEtats(){
        return this.groupeEtats;
    }

    public void setGroupeEtats(List<GroupeEtatCriteria> groupeEtats){
        this.groupeEtats = groupeEtats;
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
}
