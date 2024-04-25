package  ma.zs.alc.ws.converter.inscriptionref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial;
import ma.zs.alc.ws.dto.inscriptionref.StatutSocialDto;

@Component
public class StatutSocialConverter extends AbstractConverter<StatutSocial, StatutSocialDto> {


    public  StatutSocialConverter() {
        super(StatutSocial.class, StatutSocialDto.class);
    }

    @Override
    public StatutSocial toItem(StatutSocialDto dto) {
        if (dto == null) {
            return null;
        } else {
        StatutSocial item = new StatutSocial();
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
    public StatutSocialDto toDto(StatutSocial item) {
        if (item == null) {
            return null;
        } else {
            StatutSocialDto dto = new StatutSocialDto();
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
