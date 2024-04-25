package  ma.zs.alc.ws.converter.homework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.homework.TypeHomeWork;
import ma.zs.alc.ws.dto.homework.TypeHomeWorkDto;

@Component
public class TypeHomeWorkConverter extends AbstractConverter<TypeHomeWork, TypeHomeWorkDto> {


    public  TypeHomeWorkConverter() {
        super(TypeHomeWork.class, TypeHomeWorkDto.class);
    }

    @Override
    public TypeHomeWork toItem(TypeHomeWorkDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeHomeWork item = new TypeHomeWork();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLib()))
                item.setLib(dto.getLib());



        return item;
        }
    }

    @Override
    public TypeHomeWorkDto toDto(TypeHomeWork item) {
        if (item == null) {
            return null;
        } else {
            TypeHomeWorkDto dto = new TypeHomeWorkDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLib()))
                dto.setLib(item.getLib());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
