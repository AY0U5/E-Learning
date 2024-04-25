package  ma.zs.alc.ws.converter.inscriptionref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.inscriptionref.TeacherLocality;
import ma.zs.alc.ws.dto.inscriptionref.TeacherLocalityDto;

@Component
public class TeacherLocalityConverter extends AbstractConverter<TeacherLocality, TeacherLocalityDto> {


    public  TeacherLocalityConverter() {
        super(TeacherLocality.class, TeacherLocalityDto.class);
    }

    @Override
    public TeacherLocality toItem(TeacherLocalityDto dto) {
        if (dto == null) {
            return null;
        } else {
        TeacherLocality item = new TeacherLocality();
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
    public TeacherLocalityDto toDto(TeacherLocality item) {
        if (item == null) {
            return null;
        } else {
            TeacherLocalityDto dto = new TeacherLocalityDto();
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
