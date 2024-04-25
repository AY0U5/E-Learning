package  ma.zs.alc.ws.converter.courseref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.courseref.EtatCours;
import ma.zs.alc.ws.dto.courseref.EtatCoursDto;

@Component
public class EtatCoursConverter extends AbstractConverter<EtatCours, EtatCoursDto> {


    public  EtatCoursConverter() {
        super(EtatCours.class, EtatCoursDto.class);
    }

    @Override
    public EtatCours toItem(EtatCoursDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatCours item = new EtatCours();
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
    public EtatCoursDto toDto(EtatCours item) {
        if (item == null) {
            return null;
        } else {
            EtatCoursDto dto = new EtatCoursDto();
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
