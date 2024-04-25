package  ma.zs.alc.ws.converter.grpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.grpe.GroupeEtat;
import ma.zs.alc.ws.dto.grpe.GroupeEtatDto;

@Component
public class GroupeEtatConverter extends AbstractConverter<GroupeEtat, GroupeEtatDto> {


    public  GroupeEtatConverter() {
        super(GroupeEtat.class, GroupeEtatDto.class);
    }

    @Override
    public GroupeEtat toItem(GroupeEtatDto dto) {
        if (dto == null) {
            return null;
        } else {
        GroupeEtat item = new GroupeEtat();
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
    public GroupeEtatDto toDto(GroupeEtat item) {
        if (item == null) {
            return null;
        } else {
            GroupeEtatDto dto = new GroupeEtatDto();
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
