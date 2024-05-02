package  ma.zs.alc.ws.converter.courseref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.courseref.EtatParcours;
import ma.zs.alc.ws.dto.courseref.EtatParcoursDto;

@Component
public class EtatParcoursConverter extends AbstractConverter<EtatParcours, EtatParcoursDto> {


    public  EtatParcoursConverter() {
        super(EtatParcours.class, EtatParcoursDto.class);
    }

    @Override
    public EtatParcours toItem(EtatParcoursDto dto) {
        if (dto == null) {
            return null;
        } else {
            EtatParcours item = new EtatParcours();
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
    public EtatParcoursDto toDto(EtatParcours item) {
        if (item == null) {
            return null;
        } else {
            EtatParcoursDto dto = new EtatParcoursDto();
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
