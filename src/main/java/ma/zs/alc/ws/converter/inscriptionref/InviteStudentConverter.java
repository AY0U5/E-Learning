package  ma.zs.alc.ws.converter.inscriptionref;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.inscription.EtudiantConverter;

import ma.zs.alc.bean.core.inscription.Etudiant;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.inscriptionref.InviteStudent;
import ma.zs.alc.ws.dto.inscriptionref.InviteStudentDto;

@Component
public class InviteStudentConverter extends AbstractConverter<InviteStudent, InviteStudentDto> {

    @Autowired
    private EtudiantConverter etudiantConverter ;
    private boolean etudiant;

    public  InviteStudentConverter() {
        super(InviteStudent.class, InviteStudentDto.class);
        init(true);
    }

    @Override
    public InviteStudent toItem(InviteStudentDto dto) {
        if (dto == null) {
            return null;
        } else {
        InviteStudent item = new InviteStudent();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(dto.getIsAccepted() != null)
                item.setIsAccepted(dto.getIsAccepted());
            if(dto.getIsPaidPack() != null)
                item.setIsPaidPack(dto.getIsPaidPack());
            if(StringUtil.isNotEmpty(dto.getEmailInvited()))
                item.setEmailInvited(dto.getEmailInvited());
            if(StringUtil.isNotEmpty(dto.getDateSentInvitation()))
                item.setDateSentInvitation(DateUtil.stringEnToDate(dto.getDateSentInvitation()));
            if(StringUtil.isNotEmpty(dto.getDateAcceptInvitation()))
                item.setDateAcceptInvitation(DateUtil.stringEnToDate(dto.getDateAcceptInvitation()));
            if(StringUtil.isNotEmpty(dto.getDatePayPack()))
                item.setDatePayPack(DateUtil.stringEnToDate(dto.getDatePayPack()));
            if(dto.getEtudiant() != null && dto.getEtudiant().getId() != null){
                item.setEtudiant(new Etudiant());
                item.getEtudiant().setId(dto.getEtudiant().getId());
                item.getEtudiant().setRef(dto.getEtudiant().getRef());
            }




        return item;
        }
    }

    @Override
    public InviteStudentDto toDto(InviteStudent item) {
        if (item == null) {
            return null;
        } else {
            InviteStudentDto dto = new InviteStudentDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
                dto.setIsAccepted(item.getIsAccepted());
                dto.setIsPaidPack(item.getIsPaidPack());
            if(StringUtil.isNotEmpty(item.getEmailInvited()))
                dto.setEmailInvited(item.getEmailInvited());
            if(item.getDateSentInvitation()!=null)
                dto.setDateSentInvitation(DateUtil.dateTimeToString(item.getDateSentInvitation()));
            if(item.getDateAcceptInvitation()!=null)
                dto.setDateAcceptInvitation(DateUtil.dateTimeToString(item.getDateAcceptInvitation()));
            if(item.getDatePayPack()!=null)
                dto.setDatePayPack(DateUtil.dateTimeToString(item.getDatePayPack()));
            if(this.etudiant && item.getEtudiant()!=null) {
                dto.setEtudiant(etudiantConverter.toDto(item.getEtudiant())) ;

            }


        return dto;
        }
    }

    public void copy(InviteStudentDto dto, InviteStudent t) {
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
