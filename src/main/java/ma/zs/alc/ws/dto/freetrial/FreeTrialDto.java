package  ma.zs.alc.ws.dto.freetrial;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.ws.dto.inscription.EtudiantDto;
import ma.zs.alc.ws.dto.prof.ProfDto;
import ma.zs.alc.ws.dto.inscriptionref.NiveauEtudeDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class FreeTrialDto  extends AuditBaseDto {

    private String reference  ;
    private String dateFreeTrial ;
    private String link  ;
    private Boolean emailTeacherSent  ;
    private String emailTeacherSendingDate ;
    private Boolean whatsTeacherSent  ;
    private String whatsTeacherSendingDate ;
    private String dateFreeTrialPremierRappel ;
    private String dateFreeTrialPremierDeuxiemeRappel ;
    private Integer nombreStudentTotal  = 0 ;
    private Integer nombreStudentAbonne  = 0 ;
    private Integer nombreStudentPresent  = 0 ;

    private ProfDto prof ;
    private NiveauEtudeDto niveauEtude ;
    private FreeTrialStudentWhatsTemplateDto freeTrialStudentWhatsTemplate ;
    private FreeTrialStudentEmailTemplateDto freeTrialStudentEmailTemplate ;
    private FreeTrialTeacherEmailTemplateDto freeTrialTeacherEmailTemplate ;
    private FreeTrialTeacherWhatsTemplateDto freeTrialTeacherWhatsTemplate ;
    private FreeTrialConfigurationDto freeTrialConfiguration ;
    private StatutFreeTrialDto statutFreeTrial ;

    private List<FreeTrialDetailDto> freeTrialDetails ;


    public FreeTrialDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFreeTrial(){
        return this.dateFreeTrial;
    }
    public void setDateFreeTrial(String dateFreeTrial){
        this.dateFreeTrial = dateFreeTrial;
    }

    @Log
    public String getLink(){
        return this.link;
    }
    public void setLink(String link){
        this.link = link;
    }

    @Log
    public Boolean getEmailTeacherSent(){
        return this.emailTeacherSent;
    }
    public void setEmailTeacherSent(Boolean emailTeacherSent){
        this.emailTeacherSent = emailTeacherSent;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getEmailTeacherSendingDate(){
        return this.emailTeacherSendingDate;
    }
    public void setEmailTeacherSendingDate(String emailTeacherSendingDate){
        this.emailTeacherSendingDate = emailTeacherSendingDate;
    }

    @Log
    public Boolean getWhatsTeacherSent(){
        return this.whatsTeacherSent;
    }
    public void setWhatsTeacherSent(Boolean whatsTeacherSent){
        this.whatsTeacherSent = whatsTeacherSent;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getWhatsTeacherSendingDate(){
        return this.whatsTeacherSendingDate;
    }
    public void setWhatsTeacherSendingDate(String whatsTeacherSendingDate){
        this.whatsTeacherSendingDate = whatsTeacherSendingDate;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFreeTrialPremierRappel(){
        return this.dateFreeTrialPremierRappel;
    }
    public void setDateFreeTrialPremierRappel(String dateFreeTrialPremierRappel){
        this.dateFreeTrialPremierRappel = dateFreeTrialPremierRappel;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateFreeTrialPremierDeuxiemeRappel(){
        return this.dateFreeTrialPremierDeuxiemeRappel;
    }
    public void setDateFreeTrialPremierDeuxiemeRappel(String dateFreeTrialPremierDeuxiemeRappel){
        this.dateFreeTrialPremierDeuxiemeRappel = dateFreeTrialPremierDeuxiemeRappel;
    }

    @Log
    public Integer getNombreStudentTotal(){
        return this.nombreStudentTotal;
    }
    public void setNombreStudentTotal(Integer nombreStudentTotal){
        this.nombreStudentTotal = nombreStudentTotal;
    }

    @Log
    public Integer getNombreStudentAbonne(){
        return this.nombreStudentAbonne;
    }
    public void setNombreStudentAbonne(Integer nombreStudentAbonne){
        this.nombreStudentAbonne = nombreStudentAbonne;
    }

    @Log
    public Integer getNombreStudentPresent(){
        return this.nombreStudentPresent;
    }
    public void setNombreStudentPresent(Integer nombreStudentPresent){
        this.nombreStudentPresent = nombreStudentPresent;
    }


    public ProfDto getProf(){
        return this.prof;
    }

    public void setProf(ProfDto prof){
        this.prof = prof;
    }
    public NiveauEtudeDto getNiveauEtude(){
        return this.niveauEtude;
    }

    public void setNiveauEtude(NiveauEtudeDto niveauEtude){
        this.niveauEtude = niveauEtude;
    }
    public FreeTrialStudentWhatsTemplateDto getFreeTrialStudentWhatsTemplate(){
        return this.freeTrialStudentWhatsTemplate;
    }

    public void setFreeTrialStudentWhatsTemplate(FreeTrialStudentWhatsTemplateDto freeTrialStudentWhatsTemplate){
        this.freeTrialStudentWhatsTemplate = freeTrialStudentWhatsTemplate;
    }
    public FreeTrialStudentEmailTemplateDto getFreeTrialStudentEmailTemplate(){
        return this.freeTrialStudentEmailTemplate;
    }

    public void setFreeTrialStudentEmailTemplate(FreeTrialStudentEmailTemplateDto freeTrialStudentEmailTemplate){
        this.freeTrialStudentEmailTemplate = freeTrialStudentEmailTemplate;
    }
    public FreeTrialTeacherEmailTemplateDto getFreeTrialTeacherEmailTemplate(){
        return this.freeTrialTeacherEmailTemplate;
    }

    public void setFreeTrialTeacherEmailTemplate(FreeTrialTeacherEmailTemplateDto freeTrialTeacherEmailTemplate){
        this.freeTrialTeacherEmailTemplate = freeTrialTeacherEmailTemplate;
    }
    public FreeTrialTeacherWhatsTemplateDto getFreeTrialTeacherWhatsTemplate(){
        return this.freeTrialTeacherWhatsTemplate;
    }

    public void setFreeTrialTeacherWhatsTemplate(FreeTrialTeacherWhatsTemplateDto freeTrialTeacherWhatsTemplate){
        this.freeTrialTeacherWhatsTemplate = freeTrialTeacherWhatsTemplate;
    }
    public FreeTrialConfigurationDto getFreeTrialConfiguration(){
        return this.freeTrialConfiguration;
    }

    public void setFreeTrialConfiguration(FreeTrialConfigurationDto freeTrialConfiguration){
        this.freeTrialConfiguration = freeTrialConfiguration;
    }
    public StatutFreeTrialDto getStatutFreeTrial(){
        return this.statutFreeTrial;
    }

    public void setStatutFreeTrial(StatutFreeTrialDto statutFreeTrial){
        this.statutFreeTrial = statutFreeTrial;
    }



    public List<FreeTrialDetailDto> getFreeTrialDetails(){
        return this.freeTrialDetails;
    }

    public void setFreeTrialDetails(List<FreeTrialDetailDto> freeTrialDetails){
        this.freeTrialDetails = freeTrialDetails;
    }



}
