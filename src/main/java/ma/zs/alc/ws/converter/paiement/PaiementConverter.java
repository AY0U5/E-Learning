package  ma.zs.alc.ws.converter.paiement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.grpe.GroupeEtudiantConverter;
import ma.zs.alc.ws.converter.prof.ProfConverter;

import ma.zs.alc.bean.core.prof.Prof;
import ma.zs.alc.bean.core.grpe.GroupeEtudiant;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.paiement.Paiement;
import ma.zs.alc.ws.dto.paiement.PaiementDto;

@Component
public class PaiementConverter extends AbstractConverter<Paiement, PaiementDto> {

    @Autowired
    private GroupeEtudiantConverter groupeEtudiantConverter ;
    @Autowired
    private ProfConverter profConverter ;
    private boolean prof;
    private boolean groupeEtudiant;

    public  PaiementConverter() {
        super(Paiement.class, PaiementDto.class);
        init(true);
    }

    @Override
    public Paiement toItem(PaiementDto dto) {
        if (dto == null) {
            return null;
        } else {
        Paiement item = new Paiement();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getDatePaiement()))
                item.setDatePaiement(DateUtil.stringEnToDate(dto.getDatePaiement()));
            if(dto.getProf() != null && dto.getProf().getId() != null){
                item.setProf(new Prof());
                item.getProf().setId(dto.getProf().getId());
                item.getProf().setRef(dto.getProf().getRef());
            }

            if(dto.getGroupeEtudiant() != null && dto.getGroupeEtudiant().getId() != null){
                item.setGroupeEtudiant(new GroupeEtudiant());
                item.getGroupeEtudiant().setId(dto.getGroupeEtudiant().getId());
                item.getGroupeEtudiant().setId(dto.getGroupeEtudiant().getId());
            }




        return item;
        }
    }

    @Override
    public PaiementDto toDto(Paiement item) {
        if (item == null) {
            return null;
        } else {
            PaiementDto dto = new PaiementDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getDatePaiement()!=null)
                dto.setDatePaiement(DateUtil.dateTimeToString(item.getDatePaiement()));
            if(this.prof && item.getProf()!=null) {
                dto.setProf(profConverter.toDto(item.getProf())) ;

            }
            if(this.groupeEtudiant && item.getGroupeEtudiant()!=null) {
                dto.setGroupeEtudiant(groupeEtudiantConverter.toDto(item.getGroupeEtudiant())) ;

            }


        return dto;
        }
    }

    public void copy(PaiementDto dto, Paiement t) {
    super.copy(dto, t);
    if (dto.getProf() != null)
        profConverter.copy(dto.getProf(), t.getProf());
    if (dto.getGroupeEtudiant() != null)
        groupeEtudiantConverter.copy(dto.getGroupeEtudiant(), t.getGroupeEtudiant());
    }



    public void initObject(boolean value) {
        this.prof = value;
        this.groupeEtudiant = value;
    }


    public GroupeEtudiantConverter getGroupeEtudiantConverter(){
        return this.groupeEtudiantConverter;
    }
    public void setGroupeEtudiantConverter(GroupeEtudiantConverter groupeEtudiantConverter ){
        this.groupeEtudiantConverter = groupeEtudiantConverter;
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
    public boolean  isGroupeEtudiant(){
        return this.groupeEtudiant;
    }
    public void  setGroupeEtudiant(boolean groupeEtudiant){
        this.groupeEtudiant = groupeEtudiant;
    }
}
