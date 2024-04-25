package  ma.zs.alc.ws.converter.profetudiantcours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.inscription.EtudiantConverter;
import ma.zs.alc.ws.converter.course.CoursConverter;
import ma.zs.alc.ws.converter.prof.ProfConverter;

import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.prof.Prof;
import ma.zs.alc.bean.core.course.Cours;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.profetudiantcours.EtudiantCours;
import ma.zs.alc.ws.dto.profetudiantcours.EtudiantCoursDto;

@Component
public class EtudiantCoursConverter extends AbstractConverter<EtudiantCours, EtudiantCoursDto> {

    @Autowired
    private EtudiantConverter etudiantConverter ;
    @Autowired
    private CoursConverter coursConverter ;
    @Autowired
    private ProfConverter profConverter ;
    private boolean etudiant;
    private boolean prof;
    private boolean cours;

    public  EtudiantCoursConverter() {
        super(EtudiantCours.class, EtudiantCoursDto.class);
        init(true);
    }

    @Override
    public EtudiantCours toItem(EtudiantCoursDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtudiantCours item = new EtudiantCours();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(dto.getPayer() != null)
                item.setPayer(dto.getPayer());
            if(StringUtil.isNotEmpty(dto.getDateFin()))
                item.setDateFin(DateUtil.stringEnToDate(dto.getDateFin()));
            if(dto.getEtudiant() != null && dto.getEtudiant().getId() != null){
                item.setEtudiant(new Etudiant());
                item.getEtudiant().setId(dto.getEtudiant().getId());
                item.getEtudiant().setRef(dto.getEtudiant().getRef());
            }

            if(dto.getProf() != null && dto.getProf().getId() != null){
                item.setProf(new Prof());
                item.getProf().setId(dto.getProf().getId());
                item.getProf().setRef(dto.getProf().getRef());
            }

            if(dto.getCours() != null && dto.getCours().getId() != null){
                item.setCours(new Cours());
                item.getCours().setId(dto.getCours().getId());
                item.getCours().setLibelle(dto.getCours().getLibelle());
            }




        return item;
        }
    }

    @Override
    public EtudiantCoursDto toDto(EtudiantCours item) {
        if (item == null) {
            return null;
        } else {
            EtudiantCoursDto dto = new EtudiantCoursDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
                dto.setPayer(item.getPayer());
            if(item.getDateFin()!=null)
                dto.setDateFin(DateUtil.dateTimeToString(item.getDateFin()));
            if(this.etudiant && item.getEtudiant()!=null) {
                dto.setEtudiant(etudiantConverter.toDto(item.getEtudiant())) ;

            }
            if(this.prof && item.getProf()!=null) {
                dto.setProf(profConverter.toDto(item.getProf())) ;

            }
            if(this.cours && item.getCours()!=null) {
                dto.setCours(coursConverter.toDto(item.getCours())) ;

            }


        return dto;
        }
    }

    public void copy(EtudiantCoursDto dto, EtudiantCours t) {
    super.copy(dto, t);
    if (dto.getEtudiant() != null)
        etudiantConverter.copy(dto.getEtudiant(), t.getEtudiant());
    if (dto.getProf() != null)
        profConverter.copy(dto.getProf(), t.getProf());
    if (dto.getCours() != null)
        coursConverter.copy(dto.getCours(), t.getCours());
    }



    public void initObject(boolean value) {
        this.etudiant = value;
        this.prof = value;
        this.cours = value;
    }


    public EtudiantConverter getEtudiantConverter(){
        return this.etudiantConverter;
    }
    public void setEtudiantConverter(EtudiantConverter etudiantConverter ){
        this.etudiantConverter = etudiantConverter;
    }
    public CoursConverter getCoursConverter(){
        return this.coursConverter;
    }
    public void setCoursConverter(CoursConverter coursConverter ){
        this.coursConverter = coursConverter;
    }
    public ProfConverter getProfConverter(){
        return this.profConverter;
    }
    public void setProfConverter(ProfConverter profConverter ){
        this.profConverter = profConverter;
    }
    public boolean  isEtudiant(){
        return this.etudiant;
    }
    public void  setEtudiant(boolean etudiant){
        this.etudiant = etudiant;
    }
    public boolean  isProf(){
        return this.prof;
    }
    public void  setProf(boolean prof){
        this.prof = prof;
    }
    public boolean  isCours(){
        return this.cours;
    }
    public void  setCours(boolean cours){
        this.cours = cours;
    }
}
