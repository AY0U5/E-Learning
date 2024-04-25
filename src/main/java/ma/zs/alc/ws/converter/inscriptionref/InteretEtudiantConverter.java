package  ma.zs.alc.ws.converter.inscriptionref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant;
import ma.zs.alc.ws.dto.inscriptionref.InteretEtudiantDto;

@Component
public class InteretEtudiantConverter extends AbstractConverter<InteretEtudiant, InteretEtudiantDto> {


    public  InteretEtudiantConverter() {
        super(InteretEtudiant.class, InteretEtudiantDto.class);
    }

    @Override
    public InteretEtudiant toItem(InteretEtudiantDto dto) {
        if (dto == null) {
            return null;
        } else {
        InteretEtudiant item = new InteretEtudiant();
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
    public InteretEtudiantDto toDto(InteretEtudiant item) {
        if (item == null) {
            return null;
        } else {
            InteretEtudiantDto dto = new InteretEtudiantDto();
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
