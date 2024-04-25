package  ma.zs.alc.ws.converter.inscriptionref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule;
import ma.zs.alc.ws.dto.inscriptionref.EtatEtudiantScheduleDto;

@Component
public class EtatEtudiantScheduleConverter extends AbstractConverter<EtatEtudiantSchedule, EtatEtudiantScheduleDto> {


    public  EtatEtudiantScheduleConverter() {
        super(EtatEtudiantSchedule.class, EtatEtudiantScheduleDto.class);
    }

    @Override
    public EtatEtudiantSchedule toItem(EtatEtudiantScheduleDto dto) {
        if (dto == null) {
            return null;
        } else {
        EtatEtudiantSchedule item = new EtatEtudiantSchedule();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCouleur()))
                item.setCouleur(dto.getCouleur());



        return item;
        }
    }

    @Override
    public EtatEtudiantScheduleDto toDto(EtatEtudiantSchedule item) {
        if (item == null) {
            return null;
        } else {
            EtatEtudiantScheduleDto dto = new EtatEtudiantScheduleDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCouleur()))
                dto.setCouleur(item.getCouleur());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
