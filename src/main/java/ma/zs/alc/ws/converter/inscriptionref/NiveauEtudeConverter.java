package  ma.zs.alc.ws.converter.inscriptionref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude;
import ma.zs.alc.ws.dto.inscriptionref.NiveauEtudeDto;

@Component
public class NiveauEtudeConverter extends AbstractConverter<NiveauEtude, NiveauEtudeDto> {


    public  NiveauEtudeConverter() {
        super(NiveauEtude.class, NiveauEtudeDto.class);
    }

    @Override
    public NiveauEtude toItem(NiveauEtudeDto dto) {
        if (dto == null) {
            return null;
        } else {
        NiveauEtude item = new NiveauEtude();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());



        return item;
        }
    }

    @Override
    public NiveauEtudeDto toDto(NiveauEtude item) {
        if (item == null) {
            return null;
        } else {
            NiveauEtudeDto dto = new NiveauEtudeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
