package  ma.zs.alc.ws.converter.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.course.SectionConverter;

import ma.zs.alc.bean.core.course.Section;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.course.SectionItem;
import ma.zs.alc.ws.dto.course.SectionItemDto;

@Component
public class SectionItemConverter extends AbstractConverter<SectionItem, SectionItemDto> {

    @Autowired
    private SectionConverter sectionConverter ;
    private boolean section;

    public  SectionItemConverter() {
        super(SectionItem.class, SectionItemDto.class);
        init(true);
    }

    @Override
    public SectionItem toItem(SectionItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        SectionItem item = new SectionItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getImageUrl()))
                item.setImageUrl(dto.getImageUrl());
            if(StringUtil.isNotEmpty(dto.getResponse()))
                item.setResponse(dto.getResponse());
            if(StringUtil.isNotEmpty(dto.getTranscription()))
                item.setTranscription(dto.getTranscription());
            if(StringUtil.isNotEmpty(dto.getTranslation()))
                item.setTranslation(dto.getTranslation());
            if(StringUtil.isNotEmpty(dto.getExplanation()))
                item.setExplanation(dto.getExplanation());
            if(StringUtil.isNotEmpty(dto.getExample()))
                item.setExample(dto.getExample());
            if(StringUtil.isNotEmpty(dto.getSynonyms()))
                item.setSynonyms(dto.getSynonyms());
            if(dto.getSection() != null && dto.getSection().getId() != null){
                item.setSection(new Section());
                item.getSection().setId(dto.getSection().getId());
                item.getSection().setCode(dto.getSection().getCode());
            }




        return item;
        }
    }

    @Override
    public SectionItemDto toDto(SectionItem item) {
        if (item == null) {
            return null;
        } else {
            SectionItemDto dto = new SectionItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getImageUrl()))
                dto.setImageUrl(item.getImageUrl());
            if(StringUtil.isNotEmpty(item.getResponse()))
                dto.setResponse(item.getResponse());
            if(StringUtil.isNotEmpty(item.getTranscription()))
                dto.setTranscription(item.getTranscription());
            if(StringUtil.isNotEmpty(item.getTranslation()))
                dto.setTranslation(item.getTranslation());
            if(StringUtil.isNotEmpty(item.getExplanation()))
                dto.setExplanation(item.getExplanation());
            if(StringUtil.isNotEmpty(item.getExample()))
                dto.setExample(item.getExample());
            if(StringUtil.isNotEmpty(item.getSynonyms()))
                dto.setSynonyms(item.getSynonyms());
            if(this.section && item.getSection()!=null) {
                dto.setSection(sectionConverter.toDto(item.getSection())) ;

            }


        return dto;
        }
    }

    public void copy(SectionItemDto dto, SectionItem t) {
    super.copy(dto, t);
    if (dto.getSection() != null)
        sectionConverter.copy(dto.getSection(), t.getSection());
    }



    public void initObject(boolean value) {
        this.section = value;
    }


    public SectionConverter getSectionConverter(){
        return this.sectionConverter;
    }
    public void setSectionConverter(SectionConverter sectionConverter ){
        this.sectionConverter = sectionConverter;
    }
    public boolean  isSection(){
        return this.section;
    }
    public void  setSection(boolean section){
        this.section = section;
    }
}
