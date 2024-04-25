package  ma.zs.alc.ws.converter.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.alc.zynerator.util.ListUtil;

import ma.zs.alc.ws.converter.homework.HoweWorkQSTReponseConverter;
import ma.zs.alc.ws.converter.inscription.EtudiantConverter;
import ma.zs.alc.ws.converter.homework.ReponseEtudiantHomeWorkConverter;
import ma.zs.alc.ws.converter.homework.HomeWorkQuestionConverter;
import ma.zs.alc.ws.converter.homework.HomeWorkConverter;

import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.homework.HomeWork;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.homework.HomeWorkEtudiant;
import ma.zs.alc.ws.dto.homework.HomeWorkEtudiantDto;

@Component
public class HomeWorkEtudiantConverter extends AbstractConverter<HomeWorkEtudiant, HomeWorkEtudiantDto> {

    @Autowired
    private HoweWorkQSTReponseConverter howeWorkQSTReponseConverter ;
    @Autowired
    private EtudiantConverter etudiantConverter ;
    @Autowired
    private ReponseEtudiantHomeWorkConverter reponseEtudiantHomeWorkConverter ;
    @Autowired
    private HomeWorkQuestionConverter homeWorkQuestionConverter ;
    @Autowired
    private HomeWorkConverter homeWorkConverter ;
    private boolean etudiant;
    private boolean homeWork;
    private boolean reponseEtudiantHomeWorks;

    public  HomeWorkEtudiantConverter() {
        super(HomeWorkEtudiant.class, HomeWorkEtudiantDto.class);
        init(true);
    }

    @Override
    public HomeWorkEtudiant toItem(HomeWorkEtudiantDto dto) {
        if (dto == null) {
            return null;
        } else {
        HomeWorkEtudiant item = new HomeWorkEtudiant();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNote()))
                item.setNote(dto.getNote());
            if(StringUtil.isNotEmpty(dto.getResultat()))
                item.setResultat(dto.getResultat());
            if(StringUtil.isNotEmpty(dto.getDateHomeWork()))
                item.setDateHomeWork(DateUtil.stringEnToDate(dto.getDateHomeWork()));
            if(dto.getEtudiant() != null && dto.getEtudiant().getId() != null){
                item.setEtudiant(new Etudiant());
                item.getEtudiant().setId(dto.getEtudiant().getId());
                item.getEtudiant().setRef(dto.getEtudiant().getRef());
            }

            if(dto.getHomeWork() != null && dto.getHomeWork().getId() != null){
                item.setHomeWork(new HomeWork());
                item.getHomeWork().setId(dto.getHomeWork().getId());
                item.getHomeWork().setLibelle(dto.getHomeWork().getLibelle());
            }


            if(this.reponseEtudiantHomeWorks && ListUtil.isNotEmpty(dto.getReponseEtudiantHomeWorks()))
                item.setReponseEtudiantHomeWorks(reponseEtudiantHomeWorkConverter.toItem(dto.getReponseEtudiantHomeWorks()));


        return item;
        }
    }

    @Override
    public HomeWorkEtudiantDto toDto(HomeWorkEtudiant item) {
        if (item == null) {
            return null;
        } else {
            HomeWorkEtudiantDto dto = new HomeWorkEtudiantDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNote()))
                dto.setNote(item.getNote());
            if(StringUtil.isNotEmpty(item.getResultat()))
                dto.setResultat(item.getResultat());
            if(item.getDateHomeWork()!=null)
                dto.setDateHomeWork(DateUtil.dateTimeToString(item.getDateHomeWork()));
            if(this.etudiant && item.getEtudiant()!=null) {
                dto.setEtudiant(etudiantConverter.toDto(item.getEtudiant())) ;

            }
            if(this.homeWork && item.getHomeWork()!=null) {
                dto.setHomeWork(homeWorkConverter.toDto(item.getHomeWork())) ;

            }
        if(this.reponseEtudiantHomeWorks && ListUtil.isNotEmpty(item.getReponseEtudiantHomeWorks())){
            reponseEtudiantHomeWorkConverter.init(true);
            reponseEtudiantHomeWorkConverter.setHomeWorkEtudiant(false);
            dto.setReponseEtudiantHomeWorks(reponseEtudiantHomeWorkConverter.toDto(item.getReponseEtudiantHomeWorks()));
            reponseEtudiantHomeWorkConverter.setHomeWorkEtudiant(true);

        }


        return dto;
        }
    }

    public void copy(HomeWorkEtudiantDto dto, HomeWorkEtudiant t) {
    super.copy(dto, t);
    if (dto.getEtudiant() != null)
        etudiantConverter.copy(dto.getEtudiant(), t.getEtudiant());
    if (dto.getHomeWork() != null)
        homeWorkConverter.copy(dto.getHomeWork(), t.getHomeWork());
    if (dto.getReponseEtudiantHomeWorks() != null)
        t.setReponseEtudiantHomeWorks(reponseEtudiantHomeWorkConverter.copy(dto.getReponseEtudiantHomeWorks()));
    }


    public void initList(boolean value) {
        this.reponseEtudiantHomeWorks = value;
    }

    public void initObject(boolean value) {
        this.etudiant = value;
        this.homeWork = value;
    }


    public HoweWorkQSTReponseConverter getHoweWorkQSTReponseConverter(){
        return this.howeWorkQSTReponseConverter;
    }
    public void setHoweWorkQSTReponseConverter(HoweWorkQSTReponseConverter howeWorkQSTReponseConverter ){
        this.howeWorkQSTReponseConverter = howeWorkQSTReponseConverter;
    }
    public EtudiantConverter getEtudiantConverter(){
        return this.etudiantConverter;
    }
    public void setEtudiantConverter(EtudiantConverter etudiantConverter ){
        this.etudiantConverter = etudiantConverter;
    }
    public ReponseEtudiantHomeWorkConverter getReponseEtudiantHomeWorkConverter(){
        return this.reponseEtudiantHomeWorkConverter;
    }
    public void setReponseEtudiantHomeWorkConverter(ReponseEtudiantHomeWorkConverter reponseEtudiantHomeWorkConverter ){
        this.reponseEtudiantHomeWorkConverter = reponseEtudiantHomeWorkConverter;
    }
    public HomeWorkQuestionConverter getHomeWorkQuestionConverter(){
        return this.homeWorkQuestionConverter;
    }
    public void setHomeWorkQuestionConverter(HomeWorkQuestionConverter homeWorkQuestionConverter ){
        this.homeWorkQuestionConverter = homeWorkQuestionConverter;
    }
    public HomeWorkConverter getHomeWorkConverter(){
        return this.homeWorkConverter;
    }
    public void setHomeWorkConverter(HomeWorkConverter homeWorkConverter ){
        this.homeWorkConverter = homeWorkConverter;
    }
    public boolean  isEtudiant(){
        return this.etudiant;
    }
    public void  setEtudiant(boolean etudiant){
        this.etudiant = etudiant;
    }
    public boolean  isHomeWork(){
        return this.homeWork;
    }
    public void  setHomeWork(boolean homeWork){
        this.homeWork = homeWork;
    }
    public boolean  isReponseEtudiantHomeWorks(){
        return this.reponseEtudiantHomeWorks ;
    }
    public void  setReponseEtudiantHomeWorks(boolean reponseEtudiantHomeWorks ){
        this.reponseEtudiantHomeWorks  = reponseEtudiantHomeWorks ;
    }
}
