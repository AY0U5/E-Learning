package  ma.zs.alc.ws.converter.recomrecla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.recomrecla.TypeReclamationProfConverter;
import ma.zs.alc.ws.converter.alc.AdminConverter;
import ma.zs.alc.ws.converter.prof.ProfConverter;

import ma.zs.alc.bean.core.prof.Prof;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.recomrecla.ReclamationProf;
import ma.zs.alc.ws.dto.recomrecla.ReclamationProfDto;

@Component
public class ReclamationProfConverter extends AbstractConverter<ReclamationProf, ReclamationProfDto> {

    @Autowired
    private TypeReclamationProfConverter typeReclamationProfConverter ;
    @Autowired
    private AdminConverter adminConverter ;
    @Autowired
    private ProfConverter profConverter ;
    private boolean admin;
    private boolean prof;
    private boolean typeReclamationProf;

    public  ReclamationProfConverter() {
        super(ReclamationProf.class, ReclamationProfDto.class);
        init(true);
    }

    @Override
    public ReclamationProf toItem(ReclamationProfDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReclamationProf item = new ReclamationProf();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateReclamation()))
                item.setDateReclamation(DateUtil.stringEnToDate(dto.getDateReclamation()));
            if(StringUtil.isNotEmpty(dto.getMessage()))
                item.setMessage(dto.getMessage());
            if(dto.getTraite() != null)
                item.setTraite(dto.getTraite());
            if(StringUtil.isNotEmpty(dto.getDateTraitement()))
                item.setDateTraitement(DateUtil.stringEnToDate(dto.getDateTraitement()));
            if(StringUtil.isNotEmpty(dto.getDateReponse()))
                item.setDateReponse(DateUtil.stringEnToDate(dto.getDateReponse()));
            if(dto.getPostView() != null)
                item.setPostView(dto.getPostView());
            if(StringUtil.isNotEmpty(dto.getCommentaireTraiteur()))
                item.setCommentaireTraiteur(dto.getCommentaireTraiteur());
            if(StringUtil.isNotEmpty(dto.getObjetReclamationProf()))
                item.setObjetReclamationProf(dto.getObjetReclamationProf());
            if(this.admin && dto.getAdmin()!=null)
                item.setAdmin(adminConverter.toItem(dto.getAdmin())) ;

            if(dto.getProf() != null && dto.getProf().getId() != null){
                item.setProf(new Prof());
                item.getProf().setId(dto.getProf().getId());
                item.getProf().setRef(dto.getProf().getRef());
            }

            if(this.typeReclamationProf && dto.getTypeReclamationProf()!=null)
                item.setTypeReclamationProf(typeReclamationProfConverter.toItem(dto.getTypeReclamationProf())) ;




        return item;
        }
    }

    @Override
    public ReclamationProfDto toDto(ReclamationProf item) {
        if (item == null) {
            return null;
        } else {
            ReclamationProfDto dto = new ReclamationProfDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateReclamation()!=null)
                dto.setDateReclamation(DateUtil.dateTimeToString(item.getDateReclamation()));
            if(StringUtil.isNotEmpty(item.getMessage()))
                dto.setMessage(item.getMessage());
                dto.setTraite(item.getTraite());
            if(item.getDateTraitement()!=null)
                dto.setDateTraitement(DateUtil.dateTimeToString(item.getDateTraitement()));
            if(item.getDateReponse()!=null)
                dto.setDateReponse(DateUtil.dateTimeToString(item.getDateReponse()));
                dto.setPostView(item.getPostView());
            if(StringUtil.isNotEmpty(item.getCommentaireTraiteur()))
                dto.setCommentaireTraiteur(item.getCommentaireTraiteur());
            if(StringUtil.isNotEmpty(item.getObjetReclamationProf()))
                dto.setObjetReclamationProf(item.getObjetReclamationProf());
            if(this.admin && item.getAdmin()!=null) {
                dto.setAdmin(adminConverter.toDto(item.getAdmin())) ;

            }
            if(this.prof && item.getProf()!=null) {
                dto.setProf(profConverter.toDto(item.getProf())) ;

            }
            if(this.typeReclamationProf && item.getTypeReclamationProf()!=null) {
                dto.setTypeReclamationProf(typeReclamationProfConverter.toDto(item.getTypeReclamationProf())) ;

            }


        return dto;
        }
    }

    public void copy(ReclamationProfDto dto, ReclamationProf t) {
    super.copy(dto, t);
    if (dto.getAdmin() != null)
        adminConverter.copy(dto.getAdmin(), t.getAdmin());
    if (dto.getProf() != null)
        profConverter.copy(dto.getProf(), t.getProf());
    if (dto.getTypeReclamationProf() != null)
        typeReclamationProfConverter.copy(dto.getTypeReclamationProf(), t.getTypeReclamationProf());
    }



    public void initObject(boolean value) {
        this.admin = value;
        this.prof = value;
        this.typeReclamationProf = value;
    }


    public TypeReclamationProfConverter getTypeReclamationProfConverter(){
        return this.typeReclamationProfConverter;
    }
    public void setTypeReclamationProfConverter(TypeReclamationProfConverter typeReclamationProfConverter ){
        this.typeReclamationProfConverter = typeReclamationProfConverter;
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
    public boolean  isAdmin(){
        return this.admin;
    }
    public void  setAdmin(boolean admin){
        this.admin = admin;
    }
    public boolean  isProf(){
        return this.prof;
    }
    public void  setProf(boolean prof){
        this.prof = prof;
    }
    public boolean  isTypeReclamationProf(){
        return this.typeReclamationProf;
    }
    public void  setTypeReclamationProf(boolean typeReclamationProf){
        this.typeReclamationProf = typeReclamationProf;
    }
}
