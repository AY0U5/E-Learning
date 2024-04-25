package  ma.zs.alc.ws.converter.grpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.grpe.GroupeType;
import ma.zs.alc.ws.dto.grpe.GroupeTypeDto;

@Component
public class GroupeTypeConverter extends AbstractConverter<GroupeType, GroupeTypeDto> {


    public  GroupeTypeConverter() {
        super(GroupeType.class, GroupeTypeDto.class);
    }

    @Override
    public GroupeType toItem(GroupeTypeDto dto) {
        if (dto == null) {
            return null;
        } else {
        GroupeType item = new GroupeType();
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
    public GroupeTypeDto toDto(GroupeType item) {
        if (item == null) {
            return null;
        } else {
            GroupeTypeDto dto = new GroupeTypeDto();
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
