package  ma.zs.alc.ws.converter.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.alc.zynerator.util.ListUtil;

import ma.zs.alc.ws.converter.homework.HoweWorkQSTReponseConverter;
import ma.zs.alc.ws.converter.quizref.TypeDeQuestionConverter;
import ma.zs.alc.ws.converter.homework.HomeWorkEtudiantConverter;
import ma.zs.alc.ws.converter.inscription.EtudiantConverter;
import ma.zs.alc.ws.converter.homework.ReponseEtudiantHomeWorkConverter;
import ma.zs.alc.ws.converter.homework.HomeWorkQuestionConverter;
import ma.zs.alc.ws.converter.homework.TypeHomeWorkConverter;
import ma.zs.alc.ws.converter.course.CoursConverter;

import ma.zs.alc.bean.core.course.Cours;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.homework.HomeWork;
import ma.zs.alc.ws.dto.homework.HomeWorkDto;

@Component
public class HomeWorkConverter extends AbstractConverter<HomeWork, HomeWorkDto> {

    @Autowired
    private HoweWorkQSTReponseConverter howeWorkQSTReponseConverter ;
    @Autowired
    private TypeDeQuestionConverter typeDeQuestionConverter ;
    @Autowired
    private HomeWorkEtudiantConverter homeWorkEtudiantConverter ;
    @Autowired
    private EtudiantConverter etudiantConverter ;
    @Autowired
    private ReponseEtudiantHomeWorkConverter reponseEtudiantHomeWorkConverter ;
    @Autowired
    private HomeWorkQuestionConverter homeWorkQuestionConverter ;
    @Autowired
    private TypeHomeWorkConverter typeHomeWorkConverter ;
    @Autowired
    private CoursConverter coursConverter ;
    private boolean cours;
    private boolean typeHomeWork;
    private boolean homeWorkQuestions;
    private boolean homeWorkEtudiants;

    public  HomeWorkConverter() {
        super(HomeWork.class, HomeWorkDto.class);
        init(true);
    }

    @Override
    public HomeWork toItem(HomeWorkDto dto) {
        if (dto == null) {
            return null;
        } else {
        HomeWork item = new HomeWork();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getUrlImage()))
                item.setUrlImage(dto.getUrlImage());
            if(StringUtil.isNotEmpty(dto.getUrlVideo()))
                item.setUrlVideo(dto.getUrlVideo());
            if(dto.getCours() != null && dto.getCours().getId() != null){
                item.setCours(new Cours());
                item.getCours().setId(dto.getCours().getId());
                item.getCours().setLibelle(dto.getCours().getLibelle());
            }

            if(this.typeHomeWork && dto.getTypeHomeWork()!=null)
                item.setTypeHomeWork(typeHomeWorkConverter.toItem(dto.getTypeHomeWork())) ;


            if(this.homeWorkQuestions && ListUtil.isNotEmpty(dto.getHomeWorkQuestions()))
                item.setHomeWorkQuestions(homeWorkQuestionConverter.toItem(dto.getHomeWorkQuestions()));
            if(this.homeWorkEtudiants && ListUtil.isNotEmpty(dto.getHomeWorkEtudiants()))
                item.setHomeWorkEtudiants(homeWorkEtudiantConverter.toItem(dto.getHomeWorkEtudiants()));


        return item;
        }
    }

    @Override
    public HomeWorkDto toDto(HomeWork item) {
        if (item == null) {
            return null;
        } else {
            HomeWorkDto dto = new HomeWorkDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getUrlImage()))
                dto.setUrlImage(item.getUrlImage());
            if(StringUtil.isNotEmpty(item.getUrlVideo()))
                dto.setUrlVideo(item.getUrlVideo());
            if(this.cours && item.getCours()!=null) {
                dto.setCours(coursConverter.toDto(item.getCours())) ;

            }
            if(this.typeHomeWork && item.getTypeHomeWork()!=null) {
                dto.setTypeHomeWork(typeHomeWorkConverter.toDto(item.getTypeHomeWork())) ;

            }
        if(this.homeWorkQuestions && ListUtil.isNotEmpty(item.getHomeWorkQuestions())){
            homeWorkQuestionConverter.init(true);
            homeWorkQuestionConverter.setHomeWork(false);
            dto.setHomeWorkQuestions(homeWorkQuestionConverter.toDto(item.getHomeWorkQuestions()));
            homeWorkQuestionConverter.setHomeWork(true);

        }
        if(this.homeWorkEtudiants && ListUtil.isNotEmpty(item.getHomeWorkEtudiants())){
            homeWorkEtudiantConverter.init(true);
            homeWorkEtudiantConverter.setHomeWork(false);
            dto.setHomeWorkEtudiants(homeWorkEtudiantConverter.toDto(item.getHomeWorkEtudiants()));
            homeWorkEtudiantConverter.setHomeWork(true);

        }


        return dto;
        }
    }

    public void copy(HomeWorkDto dto, HomeWork t) {
    super.copy(dto, t);
    if (dto.getHomeWorkQuestions() != null)
        t.setHomeWorkQuestions(homeWorkQuestionConverter.copy(dto.getHomeWorkQuestions()));
    if (dto.getHomeWorkEtudiants() != null)
        t.setHomeWorkEtudiants(homeWorkEtudiantConverter.copy(dto.getHomeWorkEtudiants()));
    if (dto.getCours() != null)
        coursConverter.copy(dto.getCours(), t.getCours());
    if (dto.getTypeHomeWork() != null)
        typeHomeWorkConverter.copy(dto.getTypeHomeWork(), t.getTypeHomeWork());
    }


    public void initList(boolean value) {
        this.homeWorkQuestions = value;
        this.homeWorkEtudiants = value;
    }

    public void initObject(boolean value) {
        this.cours = value;
        this.typeHomeWork = value;
    }


    public HoweWorkQSTReponseConverter getHoweWorkQSTReponseConverter(){
        return this.howeWorkQSTReponseConverter;
    }
    public void setHoweWorkQSTReponseConverter(HoweWorkQSTReponseConverter howeWorkQSTReponseConverter ){
        this.howeWorkQSTReponseConverter = howeWorkQSTReponseConverter;
    }
    public TypeDeQuestionConverter getTypeDeQuestionConverter(){
        return this.typeDeQuestionConverter;
    }
    public void setTypeDeQuestionConverter(TypeDeQuestionConverter typeDeQuestionConverter ){
        this.typeDeQuestionConverter = typeDeQuestionConverter;
    }
    public HomeWorkEtudiantConverter getHomeWorkEtudiantConverter(){
        return this.homeWorkEtudiantConverter;
    }
    public void setHomeWorkEtudiantConverter(HomeWorkEtudiantConverter homeWorkEtudiantConverter ){
        this.homeWorkEtudiantConverter = homeWorkEtudiantConverter;
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
    public TypeHomeWorkConverter getTypeHomeWorkConverter(){
        return this.typeHomeWorkConverter;
    }
    public void setTypeHomeWorkConverter(TypeHomeWorkConverter typeHomeWorkConverter ){
        this.typeHomeWorkConverter = typeHomeWorkConverter;
    }
    public CoursConverter getCoursConverter(){
        return this.coursConverter;
    }
    public void setCoursConverter(CoursConverter coursConverter ){
        this.coursConverter = coursConverter;
    }
    public boolean  isCours(){
        return this.cours;
    }
    public void  setCours(boolean cours){
        this.cours = cours;
    }
    public boolean  isTypeHomeWork(){
        return this.typeHomeWork;
    }
    public void  setTypeHomeWork(boolean typeHomeWork){
        this.typeHomeWork = typeHomeWork;
    }
    public boolean  isHomeWorkQuestions(){
        return this.homeWorkQuestions ;
    }
    public void  setHomeWorkQuestions(boolean homeWorkQuestions ){
        this.homeWorkQuestions  = homeWorkQuestions ;
    }
    public boolean  isHomeWorkEtudiants(){
        return this.homeWorkEtudiants ;
    }
    public void  setHomeWorkEtudiants(boolean homeWorkEtudiants ){
        this.homeWorkEtudiants  = homeWorkEtudiants ;
    }
}
