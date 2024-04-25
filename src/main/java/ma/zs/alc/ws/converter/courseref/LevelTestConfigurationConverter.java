package  ma.zs.alc.ws.converter.courseref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.course.ParcoursConverter;

import ma.zs.alc.bean.core.course.Parcours;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.courseref.LevelTestConfiguration;
import ma.zs.alc.ws.dto.courseref.LevelTestConfigurationDto;

@Component
public class LevelTestConfigurationConverter extends AbstractConverter<LevelTestConfiguration, LevelTestConfigurationDto> {

    @Autowired
    private ParcoursConverter parcoursConverter ;
    private boolean parcours;

    public  LevelTestConfigurationConverter() {
        super(LevelTestConfiguration.class, LevelTestConfigurationDto.class);
        init(true);
    }

    @Override
    public LevelTestConfiguration toItem(LevelTestConfigurationDto dto) {
        if (dto == null) {
            return null;
        } else {
        LevelTestConfiguration item = new LevelTestConfiguration();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNoteMin()))
                item.setNoteMin(dto.getNoteMin());
            if(StringUtil.isNotEmpty(dto.getNoteMax()))
                item.setNoteMax(dto.getNoteMax());
            if(dto.getParcours() != null && dto.getParcours().getId() != null){
                item.setParcours(new Parcours());
                item.getParcours().setId(dto.getParcours().getId());
                item.getParcours().setLibelle(dto.getParcours().getLibelle());
            }




        return item;
        }
    }

    @Override
    public LevelTestConfigurationDto toDto(LevelTestConfiguration item) {
        if (item == null) {
            return null;
        } else {
            LevelTestConfigurationDto dto = new LevelTestConfigurationDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNoteMin()))
                dto.setNoteMin(item.getNoteMin());
            if(StringUtil.isNotEmpty(item.getNoteMax()))
                dto.setNoteMax(item.getNoteMax());
            if(this.parcours && item.getParcours()!=null) {
                dto.setParcours(parcoursConverter.toDto(item.getParcours())) ;

            }


        return dto;
        }
    }

    public void copy(LevelTestConfigurationDto dto, LevelTestConfiguration t) {
    super.copy(dto, t);
    if (dto.getParcours() != null)
        parcoursConverter.copy(dto.getParcours(), t.getParcours());
    }



    public void initObject(boolean value) {
        this.parcours = value;
    }


    public ParcoursConverter getParcoursConverter(){
        return this.parcoursConverter;
    }
    public void setParcoursConverter(ParcoursConverter parcoursConverter ){
        this.parcoursConverter = parcoursConverter;
    }
    public boolean  isParcours(){
        return this.parcours;
    }
    public void  setParcours(boolean parcours){
        this.parcours = parcours;
    }
}
