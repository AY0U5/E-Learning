package  ma.zs.alc.ws.converter.courseref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.alc.zynerator.util.ListUtil;

import ma.zs.alc.ws.converter.course.ParcoursConverter;
import ma.zs.alc.ws.converter.inscription.EtudiantConverter;
import ma.zs.alc.ws.converter.course.CoursConverter;



import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.courseref.Centre;
import ma.zs.alc.ws.dto.courseref.CentreDto;

@Component
public class CentreConverter extends AbstractConverter<Centre, CentreDto> {

    @Autowired
    private ParcoursConverter parcoursConverter ;
    @Autowired
    private EtudiantConverter etudiantConverter ;
    @Autowired
    private CoursConverter coursConverter ;
    private boolean parcourss;

    public  CentreConverter() {
        super(Centre.class, CentreDto.class);
        init(true);
    }

    @Override
    public Centre toItem(CentreDto dto) {
        if (dto == null) {
            return null;
        } else {
        Centre item = new Centre();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getLog()))
                item.setLog(dto.getLog());
            if(StringUtil.isNotEmpty(dto.getPassword()))
                item.setPassword(dto.getPassword());

            if(this.parcourss && ListUtil.isNotEmpty(dto.getParcourss()))
                item.setParcourss(parcoursConverter.toItem(dto.getParcourss()));


        return item;
        }
    }

    @Override
    public CentreDto toDto(Centre item) {
        if (item == null) {
            return null;
        } else {
            CentreDto dto = new CentreDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getLog()))
                dto.setLog(item.getLog());
            if(StringUtil.isNotEmpty(item.getPassword()))
                dto.setPassword(item.getPassword());
        if(this.parcourss && ListUtil.isNotEmpty(item.getParcourss())){
            parcoursConverter.init(true);
            parcoursConverter.setCentre(false);
            dto.setParcourss(parcoursConverter.toDto(item.getParcourss()));
            parcoursConverter.setCentre(true);

        }


        return dto;
        }
    }

    public void copy(CentreDto dto, Centre t) {
    super.copy(dto, t);
    if (dto.getParcourss() != null)
        t.setParcourss(parcoursConverter.copy(dto.getParcourss()));
    }


    public void initList(boolean value) {
        this.parcourss = value;
    }

    public void initObject(boolean value) {
    }


    public ParcoursConverter getParcoursConverter(){
        return this.parcoursConverter;
    }
    public void setParcoursConverter(ParcoursConverter parcoursConverter ){
        this.parcoursConverter = parcoursConverter;
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
    public boolean  isParcourss(){
        return this.parcourss ;
    }
    public void  setParcourss(boolean parcourss ){
        this.parcourss  = parcourss ;
    }
}
