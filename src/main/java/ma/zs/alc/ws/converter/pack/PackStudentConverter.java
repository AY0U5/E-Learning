package  ma.zs.alc.ws.converter.pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.course.ParcoursConverter;
import ma.zs.alc.ws.converter.price.PriceConverter;

import ma.zs.alc.bean.core.course.Parcours;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.pack.PackStudent;
import ma.zs.alc.ws.dto.pack.PackStudentDto;

@Component
public class PackStudentConverter extends AbstractConverter<PackStudent, PackStudentDto> {

    @Autowired
    private ParcoursConverter parcoursConverter ;
    @Autowired
    private PriceConverter priceConverter ;
    private boolean parcours;
    private boolean price;

    public  PackStudentConverter() {
        super(PackStudent.class, PackStudentDto.class);
        init(true);
    }

    @Override
    public PackStudent toItem(PackStudentDto dto) {
        if (dto == null) {
            return null;
        } else {
        PackStudent item = new PackStudent();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNombreCours()))
                item.setNombreCours(dto.getNombreCours());
            if(dto.getForGroupe() != null)
                item.setForGroupe(dto.getForGroupe());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getPreRequisites()))
                item.setPreRequisites(dto.getPreRequisites());
            if(StringUtil.isNotEmpty(dto.getWhyTakeThisCourse()))
                item.setWhyTakeThisCourse(dto.getWhyTakeThisCourse());
            if(StringUtil.isNotEmpty(dto.getExpectations()))
                item.setExpectations(dto.getExpectations());
            if(StringUtil.isNotEmpty(dto.getImgUrl()))
                item.setImgUrl(dto.getImgUrl());
            if(StringUtil.isNotEmpty(dto.getTotalStudents()))
                item.setTotalStudents(dto.getTotalStudents());
            if(StringUtil.isNotEmpty(dto.getRating()))
                item.setRating(dto.getRating());
            if(StringUtil.isNotEmpty(dto.getOldPrice()))
                item.setOldPrice(dto.getOldPrice());
            if(dto.getParcours() != null && dto.getParcours().getId() != null){
                item.setParcours(new Parcours());
                item.getParcours().setId(dto.getParcours().getId());
                item.getParcours().setLibelle(dto.getParcours().getLibelle());
            }

            if(this.price && dto.getPrice()!=null)
                item.setPrice(priceConverter.toItem(dto.getPrice())) ;




        return item;
        }
    }

    @Override
    public PackStudentDto toDto(PackStudent item) {
        if (item == null) {
            return null;
        } else {
            PackStudentDto dto = new PackStudentDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNombreCours()))
                dto.setNombreCours(item.getNombreCours());
                dto.setForGroupe(item.getForGroupe());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getPreRequisites()))
                dto.setPreRequisites(item.getPreRequisites());
            if(StringUtil.isNotEmpty(item.getWhyTakeThisCourse()))
                dto.setWhyTakeThisCourse(item.getWhyTakeThisCourse());
            if(StringUtil.isNotEmpty(item.getExpectations()))
                dto.setExpectations(item.getExpectations());
            if(StringUtil.isNotEmpty(item.getImgUrl()))
                dto.setImgUrl(item.getImgUrl());
            if(StringUtil.isNotEmpty(item.getTotalStudents()))
                dto.setTotalStudents(item.getTotalStudents());
            if(StringUtil.isNotEmpty(item.getRating()))
                dto.setRating(item.getRating());
            if(StringUtil.isNotEmpty(item.getOldPrice()))
                dto.setOldPrice(item.getOldPrice());
            if(this.parcours && item.getParcours()!=null) {
                dto.setParcours(parcoursConverter.toDto(item.getParcours())) ;

            }
            if(this.price && item.getPrice()!=null) {
                dto.setPrice(priceConverter.toDto(item.getPrice())) ;

            }


        return dto;
        }
    }

    public void copy(PackStudentDto dto, PackStudent t) {
    super.copy(dto, t);
    if (dto.getParcours() != null)
        parcoursConverter.copy(dto.getParcours(), t.getParcours());
    if (dto.getPrice() != null)
        priceConverter.copy(dto.getPrice(), t.getPrice());
    }



    public void initObject(boolean value) {
        this.parcours = value;
        this.price = value;
    }


    public ParcoursConverter getParcoursConverter(){
        return this.parcoursConverter;
    }
    public void setParcoursConverter(ParcoursConverter parcoursConverter ){
        this.parcoursConverter = parcoursConverter;
    }
    public PriceConverter getPriceConverter(){
        return this.priceConverter;
    }
    public void setPriceConverter(PriceConverter priceConverter ){
        this.priceConverter = priceConverter;
    }
    public boolean  isParcours(){
        return this.parcours;
    }
    public void  setParcours(boolean parcours){
        this.parcours = parcours;
    }
    public boolean  isPrice(){
        return this.price;
    }
    public void  setPrice(boolean price){
        this.price = price;
    }
}
