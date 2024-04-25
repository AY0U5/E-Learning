package  ma.zs.alc.ws.converter.inscriptionref;

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
import ma.zs.alc.bean.core.inscriptionref.EtudiantReview;
import ma.zs.alc.ws.dto.inscriptionref.EtudiantReviewDto;

@Component
public class EtudiantReviewConverter extends AbstractConverter<EtudiantReview, EtudiantReviewDto> {

    @Autowired
    private EtudiantConverter etudiantConverter ;
    @Autowired
    private CoursConverter coursConverter ;
    @Autowired
    private ProfConverter profConverter ;
    private boolean etudiant;
    private boolean prof;
    private boolean cours;

    public  EtudiantReviewConverter() {
        super(EtudiantReview.class, EtudiantReviewDto.class);
        init(true);
    }

    @Override
    public EtudiantReview toItem(EtudiantReviewDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtudiantReview item = new EtudiantReview();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReview()))
                item.setReview(dto.getReview());
            if(StringUtil.isNotEmpty(dto.getComment()))
                item.setComment(dto.getComment());
            if(StringUtil.isNotEmpty(dto.getDateReview()))
                item.setDateReview(DateUtil.stringEnToDate(dto.getDateReview()));
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
    public EtudiantReviewDto toDto(EtudiantReview item) {
        if (item == null) {
            return null;
        } else {
            EtudiantReviewDto dto = new EtudiantReviewDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReview()))
                dto.setReview(item.getReview());
            if(StringUtil.isNotEmpty(item.getComment()))
                dto.setComment(item.getComment());
            if(item.getDateReview()!=null)
                dto.setDateReview(DateUtil.dateTimeToString(item.getDateReview()));
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

    public void copy(EtudiantReviewDto dto, EtudiantReview t) {
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
