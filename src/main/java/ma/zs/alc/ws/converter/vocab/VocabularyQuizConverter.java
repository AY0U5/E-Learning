package  ma.zs.alc.ws.converter.vocab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.alc.zynerator.util.ListUtil;

import ma.zs.alc.ws.converter.vocab.VocabularyConverter;
import ma.zs.alc.ws.converter.course.SectionConverter;

import ma.zs.alc.bean.core.course.Section;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.vocab.VocabularyQuiz;
import ma.zs.alc.ws.dto.vocab.VocabularyQuizDto;

@Component
public class VocabularyQuizConverter extends AbstractConverter<VocabularyQuiz, VocabularyQuizDto> {

    @Autowired
    private VocabularyConverter vocabularyConverter ;
    @Autowired
    private SectionConverter sectionConverter ;
    private boolean section;
    private boolean vocabularys;

    public  VocabularyQuizConverter() {
        super(VocabularyQuiz.class, VocabularyQuizDto.class);
        init(true);
    }

    @Override
    public VocabularyQuiz toItem(VocabularyQuizDto dto) {
        if (dto == null) {
            return null;
        } else {
        VocabularyQuiz item = new VocabularyQuiz();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDateDebut()))
                item.setDateDebut(DateUtil.stringEnToDate(dto.getDateDebut()));
            if(StringUtil.isNotEmpty(dto.getDateFin()))
                item.setDateFin(DateUtil.stringEnToDate(dto.getDateFin()));
            if(dto.getSection() != null && dto.getSection().getId() != null){
                item.setSection(new Section());
                item.getSection().setId(dto.getSection().getId());
                item.getSection().setCode(dto.getSection().getCode());
            }


            if(this.vocabularys && ListUtil.isNotEmpty(dto.getVocabularys()))
                item.setVocabularys(vocabularyConverter.toItem(dto.getVocabularys()));


        return item;
        }
    }

    @Override
    public VocabularyQuizDto toDto(VocabularyQuiz item) {
        if (item == null) {
            return null;
        } else {
            VocabularyQuizDto dto = new VocabularyQuizDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(item.getDateDebut()!=null)
                dto.setDateDebut(DateUtil.dateTimeToString(item.getDateDebut()));
            if(item.getDateFin()!=null)
                dto.setDateFin(DateUtil.dateTimeToString(item.getDateFin()));
            if(this.section && item.getSection()!=null) {
                dto.setSection(sectionConverter.toDto(item.getSection())) ;

            }
        if(this.vocabularys && ListUtil.isNotEmpty(item.getVocabularys())){
            vocabularyConverter.init(true);
            vocabularyConverter.setVocabularyQuiz(false);
            dto.setVocabularys(vocabularyConverter.toDto(item.getVocabularys()));
            vocabularyConverter.setVocabularyQuiz(true);

        }


        return dto;
        }
    }

    public void copy(VocabularyQuizDto dto, VocabularyQuiz t) {
    super.copy(dto, t);
    if (dto.getVocabularys() != null)
        t.setVocabularys(vocabularyConverter.copy(dto.getVocabularys()));
    if (dto.getSection() != null)
        sectionConverter.copy(dto.getSection(), t.getSection());
    }


    public void initList(boolean value) {
        this.vocabularys = value;
    }

    public void initObject(boolean value) {
        this.section = value;
    }


    public VocabularyConverter getVocabularyConverter(){
        return this.vocabularyConverter;
    }
    public void setVocabularyConverter(VocabularyConverter vocabularyConverter ){
        this.vocabularyConverter = vocabularyConverter;
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
    public boolean  isVocabularys(){
        return this.vocabularys ;
    }
    public void  setVocabularys(boolean vocabularys ){
        this.vocabularys  = vocabularys ;
    }
}
