package  ma.zs.alc.ws.converter.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.faq.FaqType;
import ma.zs.alc.ws.dto.faq.FaqTypeDto;

@Component
public class FaqTypeConverter extends AbstractConverter<FaqType, FaqTypeDto> {


    public  FaqTypeConverter() {
        super(FaqType.class, FaqTypeDto.class);
    }

    @Override
    public FaqType toItem(FaqTypeDto dto) {
        if (dto == null) {
            return null;
        } else {
        FaqType item = new FaqType();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDestinataire()))
                item.setDestinataire(dto.getDestinataire());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());



        return item;
        }
    }

    @Override
    public FaqTypeDto toDto(FaqType item) {
        if (item == null) {
            return null;
        } else {
            FaqTypeDto dto = new FaqTypeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getDestinataire()))
                dto.setDestinataire(item.getDestinataire());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
