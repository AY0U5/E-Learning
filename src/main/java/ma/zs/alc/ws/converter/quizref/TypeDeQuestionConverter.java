package  ma.zs.alc.ws.converter.quizref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.quizref.TypeDeQuestion;
import ma.zs.alc.ws.dto.quizref.TypeDeQuestionDto;

@Component
public class TypeDeQuestionConverter extends AbstractConverter<TypeDeQuestion, TypeDeQuestionDto> {


    public  TypeDeQuestionConverter() {
        super(TypeDeQuestion.class, TypeDeQuestionDto.class);
    }

    @Override
    public TypeDeQuestion toItem(TypeDeQuestionDto dto) {
        if (dto == null) {
            return null;
        } else {
        TypeDeQuestion item = new TypeDeQuestion();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getLib()))
                item.setLib(dto.getLib());



        return item;
        }
    }

    @Override
    public TypeDeQuestionDto toDto(TypeDeQuestion item) {
        if (item == null) {
            return null;
        } else {
            TypeDeQuestionDto dto = new TypeDeQuestionDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getLib()))
                dto.setLib(item.getLib());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
