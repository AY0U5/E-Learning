package  ma.zs.alc.ws.converter.recomrecla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.recomrecla.TypeReclamationProf;
import ma.zs.alc.ws.dto.recomrecla.TypeReclamationProfDto;

@Component
public class TypeReclamationProfConverter extends AbstractConverter<TypeReclamationProf, TypeReclamationProfDto> {


    public  TypeReclamationProfConverter() {
        super(TypeReclamationProf.class, TypeReclamationProfDto.class);
    }

    @Override
    public TypeReclamationProf toItem(TypeReclamationProfDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeReclamationProf item = new TypeReclamationProf();
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
    public TypeReclamationProfDto toDto(TypeReclamationProf item) {
        if (item == null) {
            return null;
        } else {
            TypeReclamationProfDto dto = new TypeReclamationProfDto();
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
