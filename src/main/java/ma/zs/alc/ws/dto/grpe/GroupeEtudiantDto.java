package  ma.zs.alc.ws.dto.grpe;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.ws.dto.course.ParcoursDto;
import ma.zs.alc.ws.dto.inscription.EtudiantDto;
import ma.zs.alc.ws.dto.prof.ProfDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupeEtudiantDto  extends AuditBaseDto {

    private String libelle  ;
    private String dateDebut ;
    private String dateFin ;
    private Long nombrePlace  ;
    private Long nombrePlacevide  ;
    private Long nombrePlaceNonVide  ;

    private GroupeEtudeDto groupeEtude ;
    private GroupeTypeDto groupeType ;
    private GroupeEtatDto groupeEtat ;
    private ParcoursDto parcours ;
    private ProfDto prof ;

    private List<GroupeEtudiantDetailDto> groupeEtudiantDetails ;


    public GroupeEtudiantDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDebut(){
        return this.dateDebut;
    }
    public void setDateDebut(String dateDebut){
        this.dateDebut = dateDebut;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFin(){
        return this.dateFin;
    }
    public void setDateFin(String dateFin){
        this.dateFin = dateFin;
    }

    @Log
    public Long getNombrePlace(){
        return this.nombrePlace;
    }
    public void setNombrePlace(Long nombrePlace){
        this.nombrePlace = nombrePlace;
    }

    @Log
    public Long getNombrePlacevide(){
        return this.nombrePlacevide;
    }
    public void setNombrePlacevide(Long nombrePlacevide){
        this.nombrePlacevide = nombrePlacevide;
    }

    @Log
    public Long getNombrePlaceNonVide(){
        return this.nombrePlaceNonVide;
    }
    public void setNombrePlaceNonVide(Long nombrePlaceNonVide){
        this.nombrePlaceNonVide = nombrePlaceNonVide;
    }


    public GroupeEtudeDto getGroupeEtude(){
        return this.groupeEtude;
    }

    public void setGroupeEtude(GroupeEtudeDto groupeEtude){
        this.groupeEtude = groupeEtude;
    }
    public GroupeTypeDto getGroupeType(){
        return this.groupeType;
    }

    public void setGroupeType(GroupeTypeDto groupeType){
        this.groupeType = groupeType;
    }
    public GroupeEtatDto getGroupeEtat(){
        return this.groupeEtat;
    }

    public void setGroupeEtat(GroupeEtatDto groupeEtat){
        this.groupeEtat = groupeEtat;
    }
    public ParcoursDto getParcours(){
        return this.parcours;
    }

    public void setParcours(ParcoursDto parcours){
        this.parcours = parcours;
    }
    public ProfDto getProf(){
        return this.prof;
    }

    public void setProf(ProfDto prof){
        this.prof = prof;
    }



    public List<GroupeEtudiantDetailDto> getGroupeEtudiantDetails(){
        return this.groupeEtudiantDetails;
    }

    public void setGroupeEtudiantDetails(List<GroupeEtudiantDetailDto> groupeEtudiantDetails){
        this.groupeEtudiantDetails = groupeEtudiantDetails;
    }



}
