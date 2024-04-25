package  ma.zs.alc.ws.converter.freetrial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.freetrial.Services;
import ma.zs.alc.ws.dto.freetrial.ServicesDto;

@Component
public class ServicesConverter extends AbstractConverter<Services, ServicesDto> {


    public  ServicesConverter() {
        super(Services.class, ServicesDto.class);
    }

    @Override
    public Services toItem(ServicesDto dto) {
        if (dto == null) {
            return null;
        } else {
        Services item = new Services();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());



        return item;
        }
    }

    @Override
    public ServicesDto toDto(Services item) {
        if (item == null) {
            return null;
        } else {
            ServicesDto dto = new ServicesDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
