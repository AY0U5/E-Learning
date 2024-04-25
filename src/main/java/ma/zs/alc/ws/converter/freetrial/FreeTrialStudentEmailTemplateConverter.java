package  ma.zs.alc.ws.converter.freetrial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.freetrial.FreeTrialStudentEmailTemplate;
import ma.zs.alc.ws.dto.freetrial.FreeTrialStudentEmailTemplateDto;

@Component
public class FreeTrialStudentEmailTemplateConverter extends AbstractConverter<FreeTrialStudentEmailTemplate, FreeTrialStudentEmailTemplateDto> {


    public  FreeTrialStudentEmailTemplateConverter() {
        super(FreeTrialStudentEmailTemplate.class, FreeTrialStudentEmailTemplateDto.class);
    }

    @Override
    public FreeTrialStudentEmailTemplate toItem(FreeTrialStudentEmailTemplateDto dto) {
        if (dto == null) {
            return null;
        } else {
        FreeTrialStudentEmailTemplate item = new FreeTrialStudentEmailTemplate();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getObject()))
                item.setObject(dto.getObject());
            if(StringUtil.isNotEmpty(dto.getCorps()))
                item.setCorps(dto.getCorps());
            if(StringUtil.isNotEmpty(dto.getSource()))
                item.setSource(dto.getSource());



        return item;
        }
    }

    @Override
    public FreeTrialStudentEmailTemplateDto toDto(FreeTrialStudentEmailTemplate item) {
        if (item == null) {
            return null;
        } else {
            FreeTrialStudentEmailTemplateDto dto = new FreeTrialStudentEmailTemplateDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getObject()))
                dto.setObject(item.getObject());
            if(StringUtil.isNotEmpty(item.getCorps()))
                dto.setCorps(item.getCorps());
            if(StringUtil.isNotEmpty(item.getSource()))
                dto.setSource(item.getSource());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
