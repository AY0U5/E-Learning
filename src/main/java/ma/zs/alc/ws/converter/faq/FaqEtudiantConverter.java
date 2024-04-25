package  ma.zs.alc.ws.converter.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.faq.FaqTypeConverter;
import ma.zs.alc.ws.converter.inscription.EtudiantConverter;
import ma.zs.alc.ws.converter.alc.AdminConverter;

import ma.zs.alc.bean.core.inscription.Etudiant;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.faq.FaqEtudiant;
import ma.zs.alc.ws.dto.faq.FaqEtudiantDto;

@Component
public class FaqEtudiantConverter extends AbstractConverter<FaqEtudiant, FaqEtudiantDto> {

    @Autowired
    private FaqTypeConverter faqTypeConverter ;
    @Autowired
    private EtudiantConverter etudiantConverter ;
    @Autowired
    private AdminConverter adminConverter ;
    private boolean etudiant;
    private boolean admin;
    private boolean faqType;

    public  FaqEtudiantConverter() {
        super(FaqEtudiant.class, FaqEtudiantDto.class);
        init(true);
    }

    @Override
    public FaqEtudiant toItem(FaqEtudiantDto dto) {
        if (dto == null) {
            return null;
        } else {
        FaqEtudiant item = new FaqEtudiant();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(dto.getEtudiant() != null && dto.getEtudiant().getId() != null){
                item.setEtudiant(new Etudiant());
                item.getEtudiant().setId(dto.getEtudiant().getId());
                item.getEtudiant().setRef(dto.getEtudiant().getRef());
            }

            if(this.admin && dto.getAdmin()!=null)
                item.setAdmin(adminConverter.toItem(dto.getAdmin())) ;

            if(this.faqType && dto.getFaqType()!=null)
                item.setFaqType(faqTypeConverter.toItem(dto.getFaqType())) ;




        return item;
        }
    }

    @Override
    public FaqEtudiantDto toDto(FaqEtudiant item) {
        if (item == null) {
            return null;
        } else {
            FaqEtudiantDto dto = new FaqEtudiantDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(this.etudiant && item.getEtudiant()!=null) {
                dto.setEtudiant(etudiantConverter.toDto(item.getEtudiant())) ;

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

    public void copy(FaqEtudiantDto dto, FaqEtudiant t) {
    super.copy(dto, t);
    if (dto.getEtudiant() != null)
        etudiantConverter.copy(dto.getEtudiant(), t.getEtudiant());
    if (dto.getAdmin() != null)
        adminConverter.copy(dto.getAdmin(), t.getAdmin());
    if (dto.getFaqType() != null)
        faqTypeConverter.copy(dto.getFaqType(), t.getFaqType());
    }



    public void initObject(boolean value) {
        this.etudiant = value;
        this.admin = value;
        this.faqType = value;
    }


    public FaqTypeConverter getFaqTypeConverter(){
        return this.faqTypeConverter;
    }
    public void setFaqTypeConverter(FaqTypeConverter faqTypeConverter ){
        this.faqTypeConverter = faqTypeConverter;
    }
    public EtudiantConverter getEtudiantConverter(){
        return this.etudiantConverter;
    }
    public void setEtudiantConverter(EtudiantConverter etudiantConverter ){
        this.etudiantConverter = etudiantConverter;
    }
    public AdminConverter getAdminConverter(){
        return this.adminConverter;
    }
    public void setAdminConverter(AdminConverter adminConverter ){
        this.adminConverter = adminConverter;
    }
    public boolean  isEtudiant(){
        return this.etudiant;
    }
    public void  setEtudiant(boolean etudiant){
        this.etudiant = etudiant;
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
