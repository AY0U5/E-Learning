package  ma.zs.alc.ws.converter.freetrial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.alc.zynerator.util.ListUtil;

import ma.zs.alc.ws.converter.freetrial.FreeTrialTeacherEmailTemplateConverter;
import ma.zs.alc.ws.converter.freetrial.FreeTrialTeacherWhatsTemplateConverter;
import ma.zs.alc.ws.converter.freetrial.StatutFreeTrialConverter;
import ma.zs.alc.ws.converter.freetrial.FreeTrialConfigurationConverter;
import ma.zs.alc.ws.converter.inscription.EtudiantConverter;
import ma.zs.alc.ws.converter.freetrial.FreeTrialStudentEmailTemplateConverter;
import ma.zs.alc.ws.converter.freetrial.FreeTrialDetailConverter;
import ma.zs.alc.ws.converter.prof.ProfConverter;
import ma.zs.alc.ws.converter.inscriptionref.NiveauEtudeConverter;
import ma.zs.alc.ws.converter.freetrial.FreeTrialStudentWhatsTemplateConverter;

import ma.zs.alc.bean.core.prof.Prof;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.freetrial.FreeTrial;
import ma.zs.alc.ws.dto.freetrial.FreeTrialDto;

@Component
public class FreeTrialConverter extends AbstractConverter<FreeTrial, FreeTrialDto> {

    @Autowired
    private FreeTrialTeacherEmailTemplateConverter freeTrialTeacherEmailTemplateConverter ;
    @Autowired
    private FreeTrialTeacherWhatsTemplateConverter freeTrialTeacherWhatsTemplateConverter ;
    @Autowired
    private StatutFreeTrialConverter statutFreeTrialConverter ;
    @Autowired
    private FreeTrialConfigurationConverter freeTrialConfigurationConverter ;
    @Autowired
    private EtudiantConverter etudiantConverter ;
    @Autowired
    private FreeTrialStudentEmailTemplateConverter freeTrialStudentEmailTemplateConverter ;
    @Autowired
    private FreeTrialDetailConverter freeTrialDetailConverter ;
    @Autowired
    private ProfConverter profConverter ;
    @Autowired
    private NiveauEtudeConverter niveauEtudeConverter ;
    @Autowired
    private FreeTrialStudentWhatsTemplateConverter freeTrialStudentWhatsTemplateConverter ;
    private boolean prof;
    private boolean niveauEtude;
    private boolean freeTrialStudentWhatsTemplate;
    private boolean freeTrialStudentEmailTemplate;
    private boolean freeTrialTeacherEmailTemplate;
    private boolean freeTrialTeacherWhatsTemplate;
    private boolean freeTrialConfiguration;
    private boolean statutFreeTrial;
    private boolean freeTrialDetails;

    public  FreeTrialConverter() {
        super(FreeTrial.class, FreeTrialDto.class);
        init(true);
    }

    @Override
    public FreeTrial toItem(FreeTrialDto dto) {
        if (dto == null) {
            return null;
        } else {
        FreeTrial item = new FreeTrial();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDateFreeTrial()))
                item.setDateFreeTrial(DateUtil.stringEnToDate(dto.getDateFreeTrial()));
            if(StringUtil.isNotEmpty(dto.getLink()))
                item.setLink(dto.getLink());
            if(dto.getEmailTeacherSent() != null)
                item.setEmailTeacherSent(dto.getEmailTeacherSent());
            if(StringUtil.isNotEmpty(dto.getEmailTeacherSendingDate()))
                item.setEmailTeacherSendingDate(DateUtil.stringEnToDate(dto.getEmailTeacherSendingDate()));
            if(dto.getWhatsTeacherSent() != null)
                item.setWhatsTeacherSent(dto.getWhatsTeacherSent());
            if(StringUtil.isNotEmpty(dto.getWhatsTeacherSendingDate()))
                item.setWhatsTeacherSendingDate(DateUtil.stringEnToDate(dto.getWhatsTeacherSendingDate()));
            if(StringUtil.isNotEmpty(dto.getDateFreeTrialPremierRappel()))
                item.setDateFreeTrialPremierRappel(DateUtil.stringEnToDate(dto.getDateFreeTrialPremierRappel()));
            if(StringUtil.isNotEmpty(dto.getDateFreeTrialPremierDeuxiemeRappel()))
                item.setDateFreeTrialPremierDeuxiemeRappel(DateUtil.stringEnToDate(dto.getDateFreeTrialPremierDeuxiemeRappel()));
            if(StringUtil.isNotEmpty(dto.getNombreStudentTotal()))
                item.setNombreStudentTotal(dto.getNombreStudentTotal());
            if(StringUtil.isNotEmpty(dto.getNombreStudentAbonne()))
                item.setNombreStudentAbonne(dto.getNombreStudentAbonne());
            if(StringUtil.isNotEmpty(dto.getNombreStudentPresent()))
                item.setNombreStudentPresent(dto.getNombreStudentPresent());
            if(dto.getProf() != null && dto.getProf().getId() != null){
                item.setProf(new Prof());
                item.getProf().setId(dto.getProf().getId());
                item.getProf().setRef(dto.getProf().getRef());
            }

            if(this.niveauEtude && dto.getNiveauEtude()!=null)
                item.setNiveauEtude(niveauEtudeConverter.toItem(dto.getNiveauEtude())) ;

            if(this.freeTrialStudentWhatsTemplate && dto.getFreeTrialStudentWhatsTemplate()!=null)
                item.setFreeTrialStudentWhatsTemplate(freeTrialStudentWhatsTemplateConverter.toItem(dto.getFreeTrialStudentWhatsTemplate())) ;

            if(this.freeTrialStudentEmailTemplate && dto.getFreeTrialStudentEmailTemplate()!=null)
                item.setFreeTrialStudentEmailTemplate(freeTrialStudentEmailTemplateConverter.toItem(dto.getFreeTrialStudentEmailTemplate())) ;

            if(this.freeTrialTeacherEmailTemplate && dto.getFreeTrialTeacherEmailTemplate()!=null)
                item.setFreeTrialTeacherEmailTemplate(freeTrialTeacherEmailTemplateConverter.toItem(dto.getFreeTrialTeacherEmailTemplate())) ;

            if(this.freeTrialTeacherWhatsTemplate && dto.getFreeTrialTeacherWhatsTemplate()!=null)
                item.setFreeTrialTeacherWhatsTemplate(freeTrialTeacherWhatsTemplateConverter.toItem(dto.getFreeTrialTeacherWhatsTemplate())) ;

            if(this.freeTrialConfiguration && dto.getFreeTrialConfiguration()!=null)
                item.setFreeTrialConfiguration(freeTrialConfigurationConverter.toItem(dto.getFreeTrialConfiguration())) ;

            if(this.statutFreeTrial && dto.getStatutFreeTrial()!=null)
                item.setStatutFreeTrial(statutFreeTrialConverter.toItem(dto.getStatutFreeTrial())) ;


            if(this.freeTrialDetails && ListUtil.isNotEmpty(dto.getFreeTrialDetails()))
                item.setFreeTrialDetails(freeTrialDetailConverter.toItem(dto.getFreeTrialDetails()));


        return item;
        }
    }

    @Override
    public FreeTrialDto toDto(FreeTrial item) {
        if (item == null) {
            return null;
        } else {
            FreeTrialDto dto = new FreeTrialDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDateFreeTrial()!=null)
                dto.setDateFreeTrial(DateUtil.dateTimeToString(item.getDateFreeTrial()));
            if(StringUtil.isNotEmpty(item.getLink()))
                dto.setLink(item.getLink());
                dto.setEmailTeacherSent(item.getEmailTeacherSent());
            if(item.getEmailTeacherSendingDate()!=null)
                dto.setEmailTeacherSendingDate(DateUtil.dateTimeToString(item.getEmailTeacherSendingDate()));
                dto.setWhatsTeacherSent(item.getWhatsTeacherSent());
            if(item.getWhatsTeacherSendingDate()!=null)
                dto.setWhatsTeacherSendingDate(DateUtil.dateTimeToString(item.getWhatsTeacherSendingDate()));
            if(item.getDateFreeTrialPremierRappel()!=null)
                dto.setDateFreeTrialPremierRappel(DateUtil.dateTimeToString(item.getDateFreeTrialPremierRappel()));
            if(item.getDateFreeTrialPremierDeuxiemeRappel()!=null)
                dto.setDateFreeTrialPremierDeuxiemeRappel(DateUtil.dateTimeToString(item.getDateFreeTrialPremierDeuxiemeRappel()));
            if(StringUtil.isNotEmpty(item.getNombreStudentTotal()))
                dto.setNombreStudentTotal(item.getNombreStudentTotal());
            if(StringUtil.isNotEmpty(item.getNombreStudentAbonne()))
                dto.setNombreStudentAbonne(item.getNombreStudentAbonne());
            if(StringUtil.isNotEmpty(item.getNombreStudentPresent()))
                dto.setNombreStudentPresent(item.getNombreStudentPresent());
            if(this.prof && item.getProf()!=null) {
                dto.setProf(profConverter.toDto(item.getProf())) ;

            }
            if(this.niveauEtude && item.getNiveauEtude()!=null) {
                dto.setNiveauEtude(niveauEtudeConverter.toDto(item.getNiveauEtude())) ;

            }
            if(this.freeTrialStudentWhatsTemplate && item.getFreeTrialStudentWhatsTemplate()!=null) {
                dto.setFreeTrialStudentWhatsTemplate(freeTrialStudentWhatsTemplateConverter.toDto(item.getFreeTrialStudentWhatsTemplate())) ;

            }
            if(this.freeTrialStudentEmailTemplate && item.getFreeTrialStudentEmailTemplate()!=null) {
                dto.setFreeTrialStudentEmailTemplate(freeTrialStudentEmailTemplateConverter.toDto(item.getFreeTrialStudentEmailTemplate())) ;

            }
            if(this.freeTrialTeacherEmailTemplate && item.getFreeTrialTeacherEmailTemplate()!=null) {
                dto.setFreeTrialTeacherEmailTemplate(freeTrialTeacherEmailTemplateConverter.toDto(item.getFreeTrialTeacherEmailTemplate())) ;

            }
            if(this.freeTrialTeacherWhatsTemplate && item.getFreeTrialTeacherWhatsTemplate()!=null) {
                dto.setFreeTrialTeacherWhatsTemplate(freeTrialTeacherWhatsTemplateConverter.toDto(item.getFreeTrialTeacherWhatsTemplate())) ;

            }
            if(this.freeTrialConfiguration && item.getFreeTrialConfiguration()!=null) {
                dto.setFreeTrialConfiguration(freeTrialConfigurationConverter.toDto(item.getFreeTrialConfiguration())) ;

            }
            if(this.statutFreeTrial && item.getStatutFreeTrial()!=null) {
                dto.setStatutFreeTrial(statutFreeTrialConverter.toDto(item.getStatutFreeTrial())) ;

            }
        if(this.freeTrialDetails && ListUtil.isNotEmpty(item.getFreeTrialDetails())){
            freeTrialDetailConverter.init(true);
            freeTrialDetailConverter.setFreeTrial(false);
            dto.setFreeTrialDetails(freeTrialDetailConverter.toDto(item.getFreeTrialDetails()));
            freeTrialDetailConverter.setFreeTrial(true);

        }


        return dto;
        }
    }

    public void copy(FreeTrialDto dto, FreeTrial t) {
    super.copy(dto, t);
    if (dto.getProf() != null)
        profConverter.copy(dto.getProf(), t.getProf());
    if (dto.getNiveauEtude() != null)
        niveauEtudeConverter.copy(dto.getNiveauEtude(), t.getNiveauEtude());
    if (dto.getFreeTrialStudentWhatsTemplate() != null)
        freeTrialStudentWhatsTemplateConverter.copy(dto.getFreeTrialStudentWhatsTemplate(), t.getFreeTrialStudentWhatsTemplate());
    if (dto.getFreeTrialStudentEmailTemplate() != null)
        freeTrialStudentEmailTemplateConverter.copy(dto.getFreeTrialStudentEmailTemplate(), t.getFreeTrialStudentEmailTemplate());
    if (dto.getFreeTrialTeacherEmailTemplate() != null)
        freeTrialTeacherEmailTemplateConverter.copy(dto.getFreeTrialTeacherEmailTemplate(), t.getFreeTrialTeacherEmailTemplate());
    if (dto.getFreeTrialTeacherWhatsTemplate() != null)
        freeTrialTeacherWhatsTemplateConverter.copy(dto.getFreeTrialTeacherWhatsTemplate(), t.getFreeTrialTeacherWhatsTemplate());
    if (dto.getFreeTrialConfiguration() != null)
        freeTrialConfigurationConverter.copy(dto.getFreeTrialConfiguration(), t.getFreeTrialConfiguration());
    if (dto.getStatutFreeTrial() != null)
        statutFreeTrialConverter.copy(dto.getStatutFreeTrial(), t.getStatutFreeTrial());
    if (dto.getFreeTrialDetails() != null)
        t.setFreeTrialDetails(freeTrialDetailConverter.copy(dto.getFreeTrialDetails()));
    }


    public void initList(boolean value) {
        this.freeTrialDetails = value;
    }

    public void initObject(boolean value) {
        this.prof = value;
        this.niveauEtude = value;
        this.freeTrialStudentWhatsTemplate = value;
        this.freeTrialStudentEmailTemplate = value;
        this.freeTrialTeacherEmailTemplate = value;
        this.freeTrialTeacherWhatsTemplate = value;
        this.freeTrialConfiguration = value;
        this.statutFreeTrial = value;
    }


    public FreeTrialTeacherEmailTemplateConverter getFreeTrialTeacherEmailTemplateConverter(){
        return this.freeTrialTeacherEmailTemplateConverter;
    }
    public void setFreeTrialTeacherEmailTemplateConverter(FreeTrialTeacherEmailTemplateConverter freeTrialTeacherEmailTemplateConverter ){
        this.freeTrialTeacherEmailTemplateConverter = freeTrialTeacherEmailTemplateConverter;
    }
    public FreeTrialTeacherWhatsTemplateConverter getFreeTrialTeacherWhatsTemplateConverter(){
        return this.freeTrialTeacherWhatsTemplateConverter;
    }
    public void setFreeTrialTeacherWhatsTemplateConverter(FreeTrialTeacherWhatsTemplateConverter freeTrialTeacherWhatsTemplateConverter ){
        this.freeTrialTeacherWhatsTemplateConverter = freeTrialTeacherWhatsTemplateConverter;
    }
    public StatutFreeTrialConverter getStatutFreeTrialConverter(){
        return this.statutFreeTrialConverter;
    }
    public void setStatutFreeTrialConverter(StatutFreeTrialConverter statutFreeTrialConverter ){
        this.statutFreeTrialConverter = statutFreeTrialConverter;
    }
    public FreeTrialConfigurationConverter getFreeTrialConfigurationConverter(){
        return this.freeTrialConfigurationConverter;
    }
    public void setFreeTrialConfigurationConverter(FreeTrialConfigurationConverter freeTrialConfigurationConverter ){
        this.freeTrialConfigurationConverter = freeTrialConfigurationConverter;
    }
    public EtudiantConverter getEtudiantConverter(){
        return this.etudiantConverter;
    }
    public void setEtudiantConverter(EtudiantConverter etudiantConverter ){
        this.etudiantConverter = etudiantConverter;
    }
    public FreeTrialStudentEmailTemplateConverter getFreeTrialStudentEmailTemplateConverter(){
        return this.freeTrialStudentEmailTemplateConverter;
    }
    public void setFreeTrialStudentEmailTemplateConverter(FreeTrialStudentEmailTemplateConverter freeTrialStudentEmailTemplateConverter ){
        this.freeTrialStudentEmailTemplateConverter = freeTrialStudentEmailTemplateConverter;
    }
    public FreeTrialDetailConverter getFreeTrialDetailConverter(){
        return this.freeTrialDetailConverter;
    }
    public void setFreeTrialDetailConverter(FreeTrialDetailConverter freeTrialDetailConverter ){
        this.freeTrialDetailConverter = freeTrialDetailConverter;
    }
    public ProfConverter getProfConverter(){
        return this.profConverter;
    }
    public void setProfConverter(ProfConverter profConverter ){
        this.profConverter = profConverter;
    }
    public NiveauEtudeConverter getNiveauEtudeConverter(){
        return this.niveauEtudeConverter;
    }
    public void setNiveauEtudeConverter(NiveauEtudeConverter niveauEtudeConverter ){
        this.niveauEtudeConverter = niveauEtudeConverter;
    }
    public FreeTrialStudentWhatsTemplateConverter getFreeTrialStudentWhatsTemplateConverter(){
        return this.freeTrialStudentWhatsTemplateConverter;
    }
    public void setFreeTrialStudentWhatsTemplateConverter(FreeTrialStudentWhatsTemplateConverter freeTrialStudentWhatsTemplateConverter ){
        this.freeTrialStudentWhatsTemplateConverter = freeTrialStudentWhatsTemplateConverter;
    }
    public boolean  isProf(){
        return this.prof;
    }
    public void  setProf(boolean prof){
        this.prof = prof;
    }
    public boolean  isNiveauEtude(){
        return this.niveauEtude;
    }
    public void  setNiveauEtude(boolean niveauEtude){
        this.niveauEtude = niveauEtude;
    }
    public boolean  isFreeTrialStudentWhatsTemplate(){
        return this.freeTrialStudentWhatsTemplate;
    }
    public void  setFreeTrialStudentWhatsTemplate(boolean freeTrialStudentWhatsTemplate){
        this.freeTrialStudentWhatsTemplate = freeTrialStudentWhatsTemplate;
    }
    public boolean  isFreeTrialStudentEmailTemplate(){
        return this.freeTrialStudentEmailTemplate;
    }
    public void  setFreeTrialStudentEmailTemplate(boolean freeTrialStudentEmailTemplate){
        this.freeTrialStudentEmailTemplate = freeTrialStudentEmailTemplate;
    }
    public boolean  isFreeTrialTeacherEmailTemplate(){
        return this.freeTrialTeacherEmailTemplate;
    }
    public void  setFreeTrialTeacherEmailTemplate(boolean freeTrialTeacherEmailTemplate){
        this.freeTrialTeacherEmailTemplate = freeTrialTeacherEmailTemplate;
    }
    public boolean  isFreeTrialTeacherWhatsTemplate(){
        return this.freeTrialTeacherWhatsTemplate;
    }
    public void  setFreeTrialTeacherWhatsTemplate(boolean freeTrialTeacherWhatsTemplate){
        this.freeTrialTeacherWhatsTemplate = freeTrialTeacherWhatsTemplate;
    }
    public boolean  isFreeTrialConfiguration(){
        return this.freeTrialConfiguration;
    }
    public void  setFreeTrialConfiguration(boolean freeTrialConfiguration){
        this.freeTrialConfiguration = freeTrialConfiguration;
    }
    public boolean  isStatutFreeTrial(){
        return this.statutFreeTrial;
    }
    public void  setStatutFreeTrial(boolean statutFreeTrial){
        this.statutFreeTrial = statutFreeTrial;
    }
    public boolean  isFreeTrialDetails(){
        return this.freeTrialDetails ;
    }
    public void  setFreeTrialDetails(boolean freeTrialDetails ){
        this.freeTrialDetails  = freeTrialDetails ;
    }
}
