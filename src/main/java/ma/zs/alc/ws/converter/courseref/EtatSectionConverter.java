package  ma.zs.alc.ws.converter.courseref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.courseref.EtatSection;
import ma.zs.alc.ws.dto.courseref.EtatSectionDto;

@Component
public class EtatSectionConverter extends AbstractConverter<EtatSection, EtatSectionDto> {


    public  EtatSectionConverter() {
        super(EtatSection.class, EtatSectionDto.class);
    }

    @Override
    public EtatSection toItem(EtatSectionDto dto) {
        if (dto == null) {
            return null;
        } else {
            EtatSection item = new EtatSection();
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
    public EtatSectionDto toDto(EtatSection item) {
        if (item == null) {
            return null;
        } else {
            EtatSectionDto dto = new EtatSectionDto();
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
