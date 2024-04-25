package  ma.zs.alc.ws.converter.grpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.alc.zynerator.util.ListUtil;

import ma.zs.alc.ws.converter.course.ParcoursConverter;
import ma.zs.alc.ws.converter.grpe.GroupeEtatConverter;
import ma.zs.alc.ws.converter.grpe.GroupeEtudiantDetailConverter;
import ma.zs.alc.ws.converter.inscription.EtudiantConverter;
import ma.zs.alc.ws.converter.grpe.GroupeTypeConverter;
import ma.zs.alc.ws.converter.grpe.GroupeEtudeConverter;
import ma.zs.alc.ws.converter.prof.ProfConverter;

import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.bean.core.prof.Prof;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.grpe.GroupeEtudiant;
import ma.zs.alc.ws.dto.grpe.GroupeEtudiantDto;

@Component
public class GroupeEtudiantConverter extends AbstractConverter<GroupeEtudiant, GroupeEtudiantDto> {

    @Autowired
    private ParcoursConverter parcoursConverter ;
    @Autowired
    private GroupeEtatConverter groupeEtatConverter ;
    @Autowired
    private GroupeEtudiantDetailConverter groupeEtudiantDetailConverter ;
    @Autowired
    private EtudiantConverter etudiantConverter ;
    @Autowired
    private GroupeTypeConverter groupeTypeConverter ;
    @Autowired
    private GroupeEtudeConverter groupeEtudeConverter ;
    @Autowired
    private ProfConverter profConverter ;
    private boolean groupeEtude;
    private boolean groupeType;
    private boolean groupeEtat;
    private boolean parcours;
    private boolean prof;
    private boolean groupeEtudiantDetails;

    public  GroupeEtudiantConverter() {
        super(GroupeEtudiant.class, GroupeEtudiantDto.class);
        init(true);
    }

    @Override
    public GroupeEtudiant toItem(GroupeEtudiantDto dto) {
        if (dto == null) {
            return null;
        } else {
        GroupeEtudiant item = new GroupeEtudiant();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDateDebut()))
                item.setDateDebut(DateUtil.stringEnToDate(dto.getDateDebut()));
            if(StringUtil.isNotEmpty(dto.getDateFin()))
                item.setDateFin(DateUtil.stringEnToDate(dto.getDateFin()));
            if(StringUtil.isNotEmpty(dto.getNombrePlace()))
                item.setNombrePlace(dto.getNombrePlace());
            if(StringUtil.isNotEmpty(dto.getNombrePlacevide()))
                item.setNombrePlacevide(dto.getNombrePlacevide());
            if(StringUtil.isNotEmpty(dto.getNombrePlaceNonVide()))
                item.setNombrePlaceNonVide(dto.getNombrePlaceNonVide());
            if(this.groupeEtude && dto.getGroupeEtude()!=null)
                item.setGroupeEtude(groupeEtudeConverter.toItem(dto.getGroupeEtude())) ;

            if(this.groupeType && dto.getGroupeType()!=null)
                item.setGroupeType(groupeTypeConverter.toItem(dto.getGroupeType())) ;

            if(this.groupeEtat && dto.getGroupeEtat()!=null)
                item.setGroupeEtat(groupeEtatConverter.toItem(dto.getGroupeEtat())) ;

            if(dto.getParcours() != null && dto.getParcours().getId() != null){
                item.setParcours(new Parcours());
                item.getParcours().setId(dto.getParcours().getId());
                item.getParcours().setLibelle(dto.getParcours().getLibelle());
            }

            if(dto.getProf() != null && dto.getProf().getId() != null){
                item.setProf(new Prof());
                item.getProf().setId(dto.getProf().getId());
                item.getProf().setRef(dto.getProf().getRef());
            }


            if(this.groupeEtudiantDetails && ListUtil.isNotEmpty(dto.getGroupeEtudiantDetails()))
                item.setGroupeEtudiantDetails(groupeEtudiantDetailConverter.toItem(dto.getGroupeEtudiantDetails()));


        return item;
        }
    }

    @Override
    public GroupeEtudiantDto toDto(GroupeEtudiant item) {
        if (item == null) {
            return null;
        } else {
            GroupeEtudiantDto dto = new GroupeEtudiantDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(item.getDateDebut()!=null)
                dto.setDateDebut(DateUtil.dateTimeToString(item.getDateDebut()));
            if(item.getDateFin()!=null)
                dto.setDateFin(DateUtil.dateTimeToString(item.getDateFin()));
            if(StringUtil.isNotEmpty(item.getNombrePlace()))
                dto.setNombrePlace(item.getNombrePlace());
            if(StringUtil.isNotEmpty(item.getNombrePlacevide()))
                dto.setNombrePlacevide(item.getNombrePlacevide());
            if(StringUtil.isNotEmpty(item.getNombrePlaceNonVide()))
                dto.setNombrePlaceNonVide(item.getNombrePlaceNonVide());
            if(this.groupeEtude && item.getGroupeEtude()!=null) {
                dto.setGroupeEtude(groupeEtudeConverter.toDto(item.getGroupeEtude())) ;

            }
            if(this.groupeType && item.getGroupeType()!=null) {
                dto.setGroupeType(groupeTypeConverter.toDto(item.getGroupeType())) ;

            }
            if(this.groupeEtat && item.getGroupeEtat()!=null) {
                dto.setGroupeEtat(groupeEtatConverter.toDto(item.getGroupeEtat())) ;

            }
            if(this.parcours && item.getParcours()!=null) {
                dto.setParcours(parcoursConverter.toDto(item.getParcours())) ;

            }
            if(this.prof && item.getProf()!=null) {
                dto.setProf(profConverter.toDto(item.getProf())) ;

            }
        if(this.groupeEtudiantDetails && ListUtil.isNotEmpty(item.getGroupeEtudiantDetails())){
            groupeEtudiantDetailConverter.init(true);
            groupeEtudiantDetailConverter.setGroupeEtudiant(false);
            dto.setGroupeEtudiantDetails(groupeEtudiantDetailConverter.toDto(item.getGroupeEtudiantDetails()));
            groupeEtudiantDetailConverter.setGroupeEtudiant(true);

        }


        return dto;
        }
    }

    public void copy(GroupeEtudiantDto dto, GroupeEtudiant t) {
    super.copy(dto, t);
    if (dto.getGroupeEtudiantDetails() != null)
        t.setGroupeEtudiantDetails(groupeEtudiantDetailConverter.copy(dto.getGroupeEtudiantDetails()));
    if (dto.getGroupeEtude() != null)
        groupeEtudeConverter.copy(dto.getGroupeEtude(), t.getGroupeEtude());
    if (dto.getGroupeType() != null)
        groupeTypeConverter.copy(dto.getGroupeType(), t.getGroupeType());
    if (dto.getGroupeEtat() != null)
        groupeEtatConverter.copy(dto.getGroupeEtat(), t.getGroupeEtat());
    if (dto.getParcours() != null)
        parcoursConverter.copy(dto.getParcours(), t.getParcours());
    if (dto.getProf() != null)
        profConverter.copy(dto.getProf(), t.getProf());
    }


    public void initList(boolean value) {
        this.groupeEtudiantDetails = value;
    }

    public void initObject(boolean value) {
        this.groupeEtude = value;
        this.groupeType = value;
        this.groupeEtat = value;
        this.parcours = value;
        this.prof = value;
    }


    public ParcoursConverter getParcoursConverter(){
        return this.parcoursConverter;
    }
    public void setParcoursConverter(ParcoursConverter parcoursConverter ){
        this.parcoursConverter = parcoursConverter;
    }
    public GroupeEtatConverter getGroupeEtatConverter(){
        return this.groupeEtatConverter;
    }
    public void setGroupeEtatConverter(GroupeEtatConverter groupeEtatConverter ){
        this.groupeEtatConverter = groupeEtatConverter;
    }
    public GroupeEtudiantDetailConverter getGroupeEtudiantDetailConverter(){
        return this.groupeEtudiantDetailConverter;
    }
    public void setGroupeEtudiantDetailConverter(GroupeEtudiantDetailConverter groupeEtudiantDetailConverter ){
        this.groupeEtudiantDetailConverter = groupeEtudiantDetailConverter;
    }
    public EtudiantConverter getEtudiantConverter(){
        return this.etudiantConverter;
    }
    public void setEtudiantConverter(EtudiantConverter etudiantConverter ){
        this.etudiantConverter = etudiantConverter;
    }
    public GroupeTypeConverter getGroupeTypeConverter(){
        return this.groupeTypeConverter;
    }
    public void setGroupeTypeConverter(GroupeTypeConverter groupeTypeConverter ){
        this.groupeTypeConverter = groupeTypeConverter;
    }
    public GroupeEtudeConverter getGroupeEtudeConverter(){
        return this.groupeEtudeConverter;
    }
    public void setGroupeEtudeConverter(GroupeEtudeConverter groupeEtudeConverter ){
        this.groupeEtudeConverter = groupeEtudeConverter;
    }
    public ProfConverter getProfConverter(){
        return this.profConverter;
    }
    public void setProfConverter(ProfConverter profConverter ){
        this.profConverter = profConverter;
    }
    public boolean  isGroupeEtude(){
        return this.groupeEtude;
    }
    public void  setGroupeEtude(boolean groupeEtude){
        this.groupeEtude = groupeEtude;
    }
    public boolean  isGroupeType(){
        return this.groupeType;
    }
    public void  setGroupeType(boolean groupeType){
        this.groupeType = groupeType;
    }
    public boolean  isGroupeEtat(){
        return this.groupeEtat;
    }
    public void  setGroupeEtat(boolean groupeEtat){
        this.groupeEtat = groupeEtat;
    }
    public boolean  isParcours(){
        return this.parcours;
    }
    public void  setParcours(boolean parcours){
        this.parcours = parcours;
    }
    public boolean  isProf(){
        return this.prof;
    }
    public void  setProf(boolean prof){
        this.prof = prof;
    }
    public boolean  isGroupeEtudiantDetails(){
        return this.groupeEtudiantDetails ;
    }
    public void  setGroupeEtudiantDetails(boolean groupeEtudiantDetails ){
        this.groupeEtudiantDetails  = groupeEtudiantDetails ;
    }
}
