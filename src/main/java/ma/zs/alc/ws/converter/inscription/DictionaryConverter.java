package  ma.zs.alc.ws.converter.inscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.inscription.EtudiantConverter;

import ma.zs.alc.bean.core.inscription.Etudiant;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.inscription.Dictionary;
import ma.zs.alc.ws.dto.inscription.DictionaryDto;

@Component
public class DictionaryConverter extends AbstractConverter<Dictionary, DictionaryDto> {

    @Autowired
    private EtudiantConverter etudiantConverter ;
    private boolean etudiant;

    public  DictionaryConverter() {
        super(Dictionary.class, DictionaryDto.class);
        init(true);
    }

    @Override
    public Dictionary toItem(DictionaryDto dto) {
        if (dto == null) {
            return null;
        } else {
        Dictionary item = new Dictionary();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getWord()))
                item.setWord(dto.getWord());
            if(StringUtil.isNotEmpty(dto.getDefinition()))
                item.setDefinition(dto.getDefinition());
            if(dto.getEtudiant() != null && dto.getEtudiant().getId() != null){
                item.setEtudiant(new Etudiant());
                item.getEtudiant().setId(dto.getEtudiant().getId());
                item.getEtudiant().setRef(dto.getEtudiant().getRef());
            }




        return item;
        }
    }

    @Override
    public DictionaryDto toDto(Dictionary item) {
        if (item == null) {
            return null;
        } else {
            DictionaryDto dto = new DictionaryDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getWord()))
                dto.setWord(item.getWord());
            if(StringUtil.isNotEmpty(item.getDefinition()))
                dto.setDefinition(item.getDefinition());
            if(this.etudiant && item.getEtudiant()!=null) {
                dto.setEtudiant(etudiantConverter.toDto(item.getEtudiant())) ;

            }


        return dto;
        }
    }

    public void copy(DictionaryDto dto, Dictionary t) {
    super.copy(dto, t);
    if (dto.getEtudiant() != null)
        etudiantConverter.copy(dto.getEtudiant(), t.getEtudiant());
    }



    public void initObject(boolean value) {
        this.etudiant = value;
    }


    public EtudiantConverter getEtudiantConverter(){
        return this.etudiantConverter;
    }
    public void setEtudiantConverter(EtudiantConverter etudiantConverter ){
        this.etudiantConverter = etudiantConverter;
    }
    public boolean  isEtudiant(){
        return this.etudiant;
    }
    public void  setEtudiant(boolean etudiant){
        this.etudiant = etudiant;
    }
}
