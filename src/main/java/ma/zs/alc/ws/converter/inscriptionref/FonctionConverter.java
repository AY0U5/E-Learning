package  ma.zs.alc.ws.converter.inscriptionref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.inscriptionref.Fonction;
import ma.zs.alc.ws.dto.inscriptionref.FonctionDto;

@Component
public class FonctionConverter extends AbstractConverter<Fonction, FonctionDto> {


    public  FonctionConverter() {
        super(Fonction.class, FonctionDto.class);
    }

    @Override
    public Fonction toItem(FonctionDto dto) {
        if (dto == null) {
            return null;
        } else {
        Fonction item = new Fonction();
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
    public FonctionDto toDto(Fonction item) {
        if (item == null) {
            return null;
        } else {
            FonctionDto dto = new FonctionDto();
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
