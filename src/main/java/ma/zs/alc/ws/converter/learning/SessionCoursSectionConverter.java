package  ma.zs.alc.ws.converter.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.learning.SessionCoursConverter;
import ma.zs.alc.ws.converter.course.SectionConverter;

import ma.zs.alc.bean.core.learning.SessionCours;
import ma.zs.alc.bean.core.course.Section;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.learning.SessionCoursSection;
import ma.zs.alc.ws.dto.learning.SessionCoursSectionDto;

@Component
public class SessionCoursSectionConverter extends AbstractConverter<SessionCoursSection, SessionCoursSectionDto> {

    @Autowired
    private SessionCoursConverter sessionCoursConverter ;
    @Autowired
    private SectionConverter sectionConverter ;
    private boolean sessionCours;
    private boolean section;

    public  SessionCoursSectionConverter() {
        super(SessionCoursSection.class, SessionCoursSectionDto.class);
        init(true);
    }

    @Override
    public SessionCoursSection toItem(SessionCoursSectionDto dto) {
        if (dto == null) {
            return null;
        } else {
        SessionCoursSection item = new SessionCoursSection();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(dto.getSessionCours() != null && dto.getSessionCours().getId() != null){
                item.setSessionCours(new SessionCours());
                item.getSessionCours().setId(dto.getSessionCours().getId());
                item.getSessionCours().setReference(dto.getSessionCours().getReference());
            }

            if(dto.getSection() != null && dto.getSection().getId() != null){
                item.setSection(new Section());
                item.getSection().setId(dto.getSection().getId());
                item.getSection().setCode(dto.getSection().getCode());
            }




        return item;
        }
    }

    @Override
    public SessionCoursSectionDto toDto(SessionCoursSection item) {
        if (item == null) {
            return null;
        } else {
            SessionCoursSectionDto dto = new SessionCoursSectionDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(this.sessionCours && item.getSessionCours()!=null) {
                dto.setSessionCours(sessionCoursConverter.toDto(item.getSessionCours())) ;

            }
            if(this.section && item.getSection()!=null) {
                dto.setSection(sectionConverter.toDto(item.getSection())) ;

            }


        return dto;
        }
    }

    public void copy(SessionCoursSectionDto dto, SessionCoursSection t) {
    super.copy(dto, t);
    if (dto.getSessionCours() != null)
        sessionCoursConverter.copy(dto.getSessionCours(), t.getSessionCours());
    if (dto.getSection() != null)
        sectionConverter.copy(dto.getSection(), t.getSection());
    }



    public void initObject(boolean value) {
        this.sessionCours = value;
        this.section = value;
    }


    public SessionCoursConverter getSessionCoursConverter(){
        return this.sessionCoursConverter;
    }
    public void setSessionCoursConverter(SessionCoursConverter sessionCoursConverter ){
        this.sessionCoursConverter = sessionCoursConverter;
    }
    public SectionConverter getSectionConverter(){
        return this.sectionConverter;
    }
    public void setSectionConverter(SectionConverter sectionConverter ){
        this.sectionConverter = sectionConverter;
    }
    public boolean  isSessionCours(){
        return this.sessionCours;
    }
    public void  setSessionCours(boolean sessionCours){
        this.sessionCours = sessionCours;
    }
    public boolean  isSection(){
        return this.section;
    }
    public void  setSection(boolean section){
        this.section = section;
    }
}
