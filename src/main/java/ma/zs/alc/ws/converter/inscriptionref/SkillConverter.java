package  ma.zs.alc.ws.converter.inscriptionref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.inscriptionref.Skill;
import ma.zs.alc.ws.dto.inscriptionref.SkillDto;

@Component
public class SkillConverter extends AbstractConverter<Skill, SkillDto> {


    public  SkillConverter() {
        super(Skill.class, SkillDto.class);
    }

    @Override
    public Skill toItem(SkillDto dto) {
        if (dto == null) {
            return null;
        } else {
        Skill item = new Skill();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public SkillDto toDto(Skill item) {
        if (item == null) {
            return null;
        } else {
            SkillDto dto = new SkillDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
