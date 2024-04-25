package  ma.zs.alc.ws.converter.prof;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.alc.zynerator.util.ListUtil;

import ma.zs.alc.ws.converter.course.ParcoursConverter;
import ma.zs.alc.ws.converter.prof.TypeTeacherConverter;
import ma.zs.alc.ws.converter.recomrecla.RecommendTeacherConverter;
import ma.zs.alc.ws.converter.prof.ProfConverter;
import ma.zs.alc.ws.converter.prof.TrancheHoraireProfConverter;
import ma.zs.alc.ws.converter.classroom.ClassRoomConverter;



import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.prof.CategorieProf;
import ma.zs.alc.ws.dto.prof.CategorieProfDto;

@Component
public class CategorieProfConverter extends AbstractConverter<CategorieProf, CategorieProfDto> {

    @Autowired
    private ParcoursConverter parcoursConverter ;
    @Autowired
    private TypeTeacherConverter typeTeacherConverter ;
    @Autowired
    private RecommendTeacherConverter recommendTeacherConverter ;
    @Autowired
    private ProfConverter profConverter ;
    @Autowired
    private TrancheHoraireProfConverter trancheHoraireProfConverter ;
    @Autowired
    private ClassRoomConverter classRoomConverter ;
    private boolean profs;

    public  CategorieProfConverter() {
        super(CategorieProf.class, CategorieProfDto.class);
        init(true);
    }

    @Override
    public CategorieProf toItem(CategorieProfDto dto) {
        if (dto == null) {
            return null;
        } else {
        CategorieProf item = new CategorieProf();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLevel()))
                item.setLevel(dto.getLevel());
            if(StringUtil.isNotEmpty(dto.getLessonRate()))
                item.setLessonRate(dto.getLessonRate());

            if(this.profs && ListUtil.isNotEmpty(dto.getProfs()))
                item.setProfs(profConverter.toItem(dto.getProfs()));


        return item;
        }
    }

    @Override
    public CategorieProfDto toDto(CategorieProf item) {
        if (item == null) {
            return null;
        } else {
            CategorieProfDto dto = new CategorieProfDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLevel()))
                dto.setLevel(item.getLevel());
            if(StringUtil.isNotEmpty(item.getLessonRate()))
                dto.setLessonRate(item.getLessonRate());
        if(this.profs && ListUtil.isNotEmpty(item.getProfs())){
            profConverter.init(true);
            profConverter.setCategorieProf(false);
            dto.setProfs(profConverter.toDto(item.getProfs()));
            profConverter.setCategorieProf(true);

        }


        return dto;
        }
    }

    public void copy(CategorieProfDto dto, CategorieProf t) {
    super.copy(dto, t);
    if (dto.getProfs() != null)
        t.setProfs(profConverter.copy(dto.getProfs()));
    }


    public void initList(boolean value) {
        this.profs = value;
    }

    public void initObject(boolean value) {
    }


    public ParcoursConverter getParcoursConverter(){
        return this.parcoursConverter;
    }
    public void setParcoursConverter(ParcoursConverter parcoursConverter ){
        this.parcoursConverter = parcoursConverter;
    }
    public TypeTeacherConverter getTypeTeacherConverter(){
        return this.typeTeacherConverter;
    }
    public void setTypeTeacherConverter(TypeTeacherConverter typeTeacherConverter ){
        this.typeTeacherConverter = typeTeacherConverter;
    }
    public RecommendTeacherConverter getRecommendTeacherConverter(){
        return this.recommendTeacherConverter;
    }
    public void setRecommendTeacherConverter(RecommendTeacherConverter recommendTeacherConverter ){
        this.recommendTeacherConverter = recommendTeacherConverter;
    }
    public ProfConverter getProfConverter(){
        return this.profConverter;
    }
    public void setProfConverter(ProfConverter profConverter ){
        this.profConverter = profConverter;
    }
    public TrancheHoraireProfConverter getTrancheHoraireProfConverter(){
        return this.trancheHoraireProfConverter;
    }
    public void setTrancheHoraireProfConverter(TrancheHoraireProfConverter trancheHoraireProfConverter ){
        this.trancheHoraireProfConverter = trancheHoraireProfConverter;
    }
    public ClassRoomConverter getClassRoomConverter(){
        return this.classRoomConverter;
    }
    public void setClassRoomConverter(ClassRoomConverter classRoomConverter ){
        this.classRoomConverter = classRoomConverter;
    }
    public boolean  isProfs(){
        return this.profs ;
    }
    public void  setProfs(boolean profs ){
        this.profs  = profs ;
    }
}
