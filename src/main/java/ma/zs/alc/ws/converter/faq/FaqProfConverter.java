package  ma.zs.alc.ws.converter.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.faq.FaqTypeConverter;
import ma.zs.alc.ws.converter.alc.AdminConverter;
import ma.zs.alc.ws.converter.prof.ProfConverter;

import ma.zs.alc.bean.core.prof.Prof;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.faq.FaqProf;
import ma.zs.alc.ws.dto.faq.FaqProfDto;

@Component
public class FaqProfConverter extends AbstractConverter<FaqProf, FaqProfDto> {

    @Autowired
    private FaqTypeConverter faqTypeConverter ;
    @Autowired
    private AdminConverter adminConverter ;
    @Autowired
    private ProfConverter profConverter ;
    private boolean prof;
    private boolean admin;
    private boolean faqType;

    public  FaqProfConverter() {
        super(FaqProf.class, FaqProfDto.class);
        init(true);
    }

    @Override
    public FaqProf toItem(FaqProfDto dto) {
        if (dto == null) {
            return null;
        } else {
        FaqProf item = new FaqProf();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(dto.getProf() != null && dto.getProf().getId() != null){
                item.setProf(new Prof());
                item.getProf().setId(dto.getProf().getId());
                item.getProf().setRef(dto.getProf().getRef());
            }

            if(this.admin && dto.getAdmin()!=null)
                item.setAdmin(adminConverter.toItem(dto.getAdmin())) ;

            if(this.faqType && dto.getFaqType()!=null)
                item.setFaqType(faqTypeConverter.toItem(dto.getFaqType())) ;




        return item;
        }
    }

    @Override
    public FaqProfDto toDto(FaqProf item) {
        if (item == null) {
            return null;
        } else {
            FaqProfDto dto = new FaqProfDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(this.prof && item.getProf()!=null) {
                dto.setProf(profConverter.toDto(item.getProf())) ;

            }
            if(this.admin && item.getAdmin()!=null) {
                dto.setAdmin(adminConverter.toDto(item.getAdmin())) ;

            }
            if(this.faqType && item.getFaqType()!=null) {
                dto.setFaqType(faqTypeConverter.toDto(item.getFaqType())) ;

            }


        return dto;
        }
    }

    public void copy(FaqProfDto dto, FaqProf t) {
    super.copy(dto, t);
    if (dto.getProf() != null)
        profConverter.copy(dto.getProf(), t.getProf());
    if (dto.getAdmin() != null)
        adminConverter.copy(dto.getAdmin(), t.getAdmin());
    if (dto.getFaqType() != null)
        faqTypeConverter.copy(dto.getFaqType(), t.getFaqType());
    }



    public void initObject(boolean value) {
        this.prof = value;
        this.admin = value;
        this.faqType = value;
    }


    public FaqTypeConverter getFaqTypeConverter(){
        return this.faqTypeConverter;
    }
    public void setFaqTypeConverter(FaqTypeConverter faqTypeConverter ){
        this.faqTypeConverter = faqTypeConverter;
    }
    public AdminConverter getAdminConverter(){
        return this.adminConverter;
    }
    public void setAdminConverter(AdminConverter adminConverter ){
        this.adminConverter = adminConverter;
    }
    public ProfConverter getProfConverter(){
        return this.profConverter;
    }
    public void setProfConverter(ProfConverter profConverter ){
        this.profConverter = profConverter;
    }
    public boolean  isProf(){
        return this.prof;
    }
    public void  setProf(boolean prof){
        this.prof = prof;
    }
    public boolean  isAdmin(){
        return this.admin;
    }
    public void  setAdmin(boolean admin){
        this.admin = admin;
    }
    public boolean  isFaqType(){
        return this.faqType;
    }
    public void  setFaqType(boolean faqType){
        this.faqType = faqType;
    }
}
