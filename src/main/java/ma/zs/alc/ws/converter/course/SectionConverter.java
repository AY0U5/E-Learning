package ma.zs.alc.ws.converter.course;

import ma.zs.alc.ws.converter.courseref.EtatSectionConverter;
import ma.zs.alc.ws.dto.course.CoursDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.alc.zynerator.util.ListUtil;

import ma.zs.alc.ws.converter.courseref.CategorieSectionConverter;
import ma.zs.alc.ws.converter.course.CoursConverter;
import ma.zs.alc.ws.converter.course.SectionItemConverter;

import ma.zs.alc.bean.core.courseref.CategorieSection;
import ma.zs.alc.bean.core.course.Cours;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.course.Section;
import ma.zs.alc.ws.dto.course.SectionDto;

@Component
public class SectionConverter extends AbstractConverter<Section, SectionDto> {
    @Autowired
    private EtatSectionConverter etatSectionConverter;

    @Autowired
    private CategorieSectionConverter categorieSectionConverter;
    @Autowired
    private CoursConverter coursConverter;
    @Autowired
    private SectionItemConverter sectionItemConverter;
    private boolean categorieSection;

    private boolean etatSection;
    private boolean cours;
    private boolean sectionItems;

    public SectionConverter() {
        super(Section.class, SectionDto.class);
        init(true);
    }

    @Override
    public Section toItem(SectionDto dto) {
        if (dto == null) {
            return null;
        } else {
            Section item = new Section();
            if (StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if (StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if (StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if (StringUtil.isNotEmpty(dto.getUrlImage()))
                item.setUrlImage(dto.getUrlImage());
            if (StringUtil.isNotEmpty(dto.getUrlImage2()))
                item.setUrlImage2(dto.getUrlImage2());
            if (StringUtil.isNotEmpty(dto.getUrlImage3()))
                item.setUrlImage3(dto.getUrlImage3());
            if (StringUtil.isNotEmpty(dto.getUrlVideo()))
                item.setUrlVideo(dto.getUrlVideo());
            if (StringUtil.isNotEmpty(dto.getContenu()))
                item.setContenu(dto.getContenu());
            if (StringUtil.isNotEmpty(dto.getQuestions()))
                item.setQuestions(dto.getQuestions());
            if (StringUtil.isNotEmpty(dto.getIndicationProf()))
                item.setIndicationProf(dto.getIndicationProf());
            if (StringUtil.isNotEmpty(dto.getNumeroOrder()))
                item.setNumeroOrder(dto.getNumeroOrder());
            if (StringUtil.isNotEmpty(dto.getUrl()))
                item.setUrl(dto.getUrl());
            if (StringUtil.isNotEmpty(dto.getContent()))
                item.setContent(dto.getContent());
            if (dto.getCategorieSection() != null && dto.getCategorieSection().getId() != null) {
                item.setCategorieSection(new CategorieSection());
                item.getCategorieSection().setId(dto.getCategorieSection().getId());
                item.getCategorieSection().setCode(dto.getCategorieSection().getCode());
            }
            if (this.etatSection && dto.getEtatSection() != null)
                item.setEtatSection(etatSectionConverter.toItem(dto.getEtatSection()));

            if (dto.getCours() != null && dto.getCours().getId() != null) {
                item.setCours(new Cours());
                item.getCours().setId(dto.getCours().getId());
                item.getCours().setLibelle(dto.getCours().getLibelle());
            }


            if (this.sectionItems && ListUtil.isNotEmpty(dto.getSectionItems()))
                item.setSectionItems(sectionItemConverter.toItem(dto.getSectionItems()));


            return item;
        }
    }

    @Override
    public SectionDto toDto(Section item) {
        if (item == null) {
            return null;
        } else {
            SectionDto dto = new SectionDto();
            if (StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if (StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if (StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if (StringUtil.isNotEmpty(item.getUrlImage()))
                dto.setUrlImage(item.getUrlImage());
            if (StringUtil.isNotEmpty(item.getUrlImage2()))
                dto.setUrlImage2(item.getUrlImage2());
            if (StringUtil.isNotEmpty(item.getUrlImage3()))
                dto.setUrlImage3(item.getUrlImage3());
            if (StringUtil.isNotEmpty(item.getUrlVideo()))
                dto.setUrlVideo(item.getUrlVideo());
            if (StringUtil.isNotEmpty(item.getContenu()))
                dto.setContenu(item.getContenu());
            if (StringUtil.isNotEmpty(item.getQuestions()))
                dto.setQuestions(item.getQuestions());
            if (StringUtil.isNotEmpty(item.getIndicationProf()))
                dto.setIndicationProf(item.getIndicationProf());
            if (StringUtil.isNotEmpty(item.getNumeroOrder()))
                dto.setNumeroOrder(item.getNumeroOrder());
            if (StringUtil.isNotEmpty(item.getUrl()))
                dto.setUrl(item.getUrl());
            if (StringUtil.isNotEmpty(item.getContent()))
                dto.setContent(item.getContent());
            if (this.categorieSection && item.getCategorieSection() != null) {
                dto.setCategorieSection(categorieSectionConverter.toDto(item.getCategorieSection()));

            }
            if (this.etatSection && item.getEtatSection() != null) {
                dto.setEtatSection(etatSectionConverter.toDto(item.getEtatSection()));

            }
            if (item.getCours() != null) {
                if (dto.getCours() == null) {
                    dto.setCours(new CoursDto());
                }
                dto.getCours().setLibelle(item.getLibelle());
                dto.getCours().setId(item.getId());
                dto.getCours().setCode(item.getCode());
//                dto.setCours(coursConverter.toDto(item.getCours()));
            }
            if (this.sectionItems && ListUtil.isNotEmpty(item.getSectionItems())) {
                sectionItemConverter.init(true);
                sectionItemConverter.setSection(false);
                dto.setSectionItems(sectionItemConverter.toDto(item.getSectionItems()));
                sectionItemConverter.setSection(true);

            }


            return dto;
        }
    }

    public void copy(SectionDto dto, Section t) {
        super.copy(dto, t);
        if (dto.getCategorieSection() != null)
            categorieSectionConverter.copy(dto.getCategorieSection(), t.getCategorieSection());

        if (dto.getEtatSection() != null)
            etatSectionConverter.copy(dto.getEtatSection(), t.getEtatSection());
        if (dto.getCours() != null)
            coursConverter.copy(dto.getCours(), t.getCours());
        if (dto.getSectionItems() != null)
            t.setSectionItems(sectionItemConverter.copy(dto.getSectionItems()));
    }


    public void initList(boolean value) {
        this.sectionItems = value;
    }

    public void initObject(boolean value) {
        this.categorieSection = value;
        this.etatSection = value;
        this.cours = value;
    }


    public CategorieSectionConverter getCategorieSectionConverter() {
        return this.categorieSectionConverter;
    }

    public void setCategorieSectionConverter(CategorieSectionConverter categorieSectionConverter) {
        this.categorieSectionConverter = categorieSectionConverter;
    }

    public EtatSectionConverter getEtatSectionConverter(){
        return this.etatSectionConverter;
    }
    public void setEtatSectionConverter(EtatSectionConverter etatSectionConverter ){
        this.etatSectionConverter = etatSectionConverter;
    }

    public CoursConverter getCoursConverter() {
        return this.coursConverter;
    }

    public void setCoursConverter(CoursConverter coursConverter) {
        this.coursConverter = coursConverter;
    }

    public SectionItemConverter getSectionItemConverter() {
        return this.sectionItemConverter;
    }

    public void setSectionItemConverter(SectionItemConverter sectionItemConverter) {
        this.sectionItemConverter = sectionItemConverter;
    }

    public boolean isCategorieSection() {
        return this.categorieSection;
    }

    public void setCategorieSection(boolean categorieSection) {
        this.categorieSection = categorieSection;
    }

    public boolean  isEtatSection(){
        return this.etatSection;
    }
    public void  setEtatSection(boolean etatSection){
        this.etatSection = etatSection;
    }

    public boolean isCours() {
        return this.cours;
    }

    public void setCours(boolean cours) {
        this.cours = cours;
    }

    public boolean isSectionItems() {
        return this.sectionItems;
    }

    public void setSectionItems(boolean sectionItems) {
        this.sectionItems = sectionItems;
    }
}
