package  ma.zs.alc.dao.criteria.core.freetrial;


import ma.zs.alc.dao.criteria.core.prof.ProfCriteria;
import ma.zs.alc.dao.criteria.core.inscriptionref.NiveauEtudeCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class FreeTrialCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime dateFreeTrial;
    private LocalDateTime dateFreeTrialFrom;
    private LocalDateTime dateFreeTrialTo;
    private String link;
    private String linkLike;
    private Boolean emailTeacherSent;
    private LocalDateTime emailTeacherSendingDate;
    private LocalDateTime emailTeacherSendingDateFrom;
    private LocalDateTime emailTeacherSendingDateTo;
    private Boolean whatsTeacherSent;
    private LocalDateTime whatsTeacherSendingDate;
    private LocalDateTime whatsTeacherSendingDateFrom;
    private LocalDateTime whatsTeacherSendingDateTo;
    private LocalDateTime dateFreeTrialPremierRappel;
    private LocalDateTime dateFreeTrialPremierRappelFrom;
    private LocalDateTime dateFreeTrialPremierRappelTo;
    private LocalDateTime dateFreeTrialPremierDeuxiemeRappel;
    private LocalDateTime dateFreeTrialPremierDeuxiemeRappelFrom;
    private LocalDateTime dateFreeTrialPremierDeuxiemeRappelTo;
    private String nombreStudentTotal;
    private String nombreStudentTotalMin;
    private String nombreStudentTotalMax;
    private String nombreStudentAbonne;
    private String nombreStudentAbonneMin;
    private String nombreStudentAbonneMax;
    private String nombreStudentPresent;
    private String nombreStudentPresentMin;
    private String nombreStudentPresentMax;

    private ProfCriteria prof ;
    private List<ProfCriteria> profs ;
    private NiveauEtudeCriteria niveauEtude ;
    private List<NiveauEtudeCriteria> niveauEtudes ;
    private FreeTrialStudentWhatsTemplateCriteria freeTrialStudentWhatsTemplate ;
    private List<FreeTrialStudentWhatsTemplateCriteria> freeTrialStudentWhatsTemplates ;
    private FreeTrialStudentEmailTemplateCriteria freeTrialStudentEmailTemplate ;
    private List<FreeTrialStudentEmailTemplateCriteria> freeTrialStudentEmailTemplates ;
    private FreeTrialTeacherEmailTemplateCriteria freeTrialTeacherEmailTemplate ;
    private List<FreeTrialTeacherEmailTemplateCriteria> freeTrialTeacherEmailTemplates ;
    private FreeTrialTeacherWhatsTemplateCriteria freeTrialTeacherWhatsTemplate ;
    private List<FreeTrialTeacherWhatsTemplateCriteria> freeTrialTeacherWhatsTemplates ;
    private FreeTrialConfigurationCriteria freeTrialConfiguration ;
    private List<FreeTrialConfigurationCriteria> freeTrialConfigurations ;
    private StatutFreeTrialCriteria statutFreeTrial ;
    private List<StatutFreeTrialCriteria> statutFreeTrials ;


    public FreeTrialCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public LocalDateTime getDateFreeTrial(){
        return this.dateFreeTrial;
    }
    public void setDateFreeTrial(LocalDateTime dateFreeTrial){
        this.dateFreeTrial = dateFreeTrial;
    }
    public LocalDateTime getDateFreeTrialFrom(){
        return this.dateFreeTrialFrom;
    }
    public void setDateFreeTrialFrom(LocalDateTime dateFreeTrialFrom){
        this.dateFreeTrialFrom = dateFreeTrialFrom;
    }
    public LocalDateTime getDateFreeTrialTo(){
        return this.dateFreeTrialTo;
    }
    public void setDateFreeTrialTo(LocalDateTime dateFreeTrialTo){
        this.dateFreeTrialTo = dateFreeTrialTo;
    }
    public String getLink(){
        return this.link;
    }
    public void setLink(String link){
        this.link = link;
    }
    public String getLinkLike(){
        return this.linkLike;
    }
    public void setLinkLike(String linkLike){
        this.linkLike = linkLike;
    }

    public Boolean getEmailTeacherSent(){
        return this.emailTeacherSent;
    }
    public void setEmailTeacherSent(Boolean emailTeacherSent){
        this.emailTeacherSent = emailTeacherSent;
    }
    public LocalDateTime getEmailTeacherSendingDate(){
        return this.emailTeacherSendingDate;
    }
    public void setEmailTeacherSendingDate(LocalDateTime emailTeacherSendingDate){
        this.emailTeacherSendingDate = emailTeacherSendingDate;
    }
    public LocalDateTime getEmailTeacherSendingDateFrom(){
        return this.emailTeacherSendingDateFrom;
    }
    public void setEmailTeacherSendingDateFrom(LocalDateTime emailTeacherSendingDateFrom){
        this.emailTeacherSendingDateFrom = emailTeacherSendingDateFrom;
    }
    public LocalDateTime getEmailTeacherSendingDateTo(){
        return this.emailTeacherSendingDateTo;
    }
    public void setEmailTeacherSendingDateTo(LocalDateTime emailTeacherSendingDateTo){
        this.emailTeacherSendingDateTo = emailTeacherSendingDateTo;
    }
    public Boolean getWhatsTeacherSent(){
        return this.whatsTeacherSent;
    }
    public void setWhatsTeacherSent(Boolean whatsTeacherSent){
        this.whatsTeacherSent = whatsTeacherSent;
    }
    public LocalDateTime getWhatsTeacherSendingDate(){
        return this.whatsTeacherSendingDate;
    }
    public void setWhatsTeacherSendingDate(LocalDateTime whatsTeacherSendingDate){
        this.whatsTeacherSendingDate = whatsTeacherSendingDate;
    }
    public LocalDateTime getWhatsTeacherSendingDateFrom(){
        return this.whatsTeacherSendingDateFrom;
    }
    public void setWhatsTeacherSendingDateFrom(LocalDateTime whatsTeacherSendingDateFrom){
        this.whatsTeacherSendingDateFrom = whatsTeacherSendingDateFrom;
    }
    public LocalDateTime getWhatsTeacherSendingDateTo(){
        return this.whatsTeacherSendingDateTo;
    }
    public void setWhatsTeacherSendingDateTo(LocalDateTime whatsTeacherSendingDateTo){
        this.whatsTeacherSendingDateTo = whatsTeacherSendingDateTo;
    }
    public LocalDateTime getDateFreeTrialPremierRappel(){
        return this.dateFreeTrialPremierRappel;
    }
    public void setDateFreeTrialPremierRappel(LocalDateTime dateFreeTrialPremierRappel){
        this.dateFreeTrialPremierRappel = dateFreeTrialPremierRappel;
    }
    public LocalDateTime getDateFreeTrialPremierRappelFrom(){
        return this.dateFreeTrialPremierRappelFrom;
    }
    public void setDateFreeTrialPremierRappelFrom(LocalDateTime dateFreeTrialPremierRappelFrom){
        this.dateFreeTrialPremierRappelFrom = dateFreeTrialPremierRappelFrom;
    }
    public LocalDateTime getDateFreeTrialPremierRappelTo(){
        return this.dateFreeTrialPremierRappelTo;
    }
    public void setDateFreeTrialPremierRappelTo(LocalDateTime dateFreeTrialPremierRappelTo){
        this.dateFreeTrialPremierRappelTo = dateFreeTrialPremierRappelTo;
    }
    public LocalDateTime getDateFreeTrialPremierDeuxiemeRappel(){
        return this.dateFreeTrialPremierDeuxiemeRappel;
    }
    public void setDateFreeTrialPremierDeuxiemeRappel(LocalDateTime dateFreeTrialPremierDeuxiemeRappel){
        this.dateFreeTrialPremierDeuxiemeRappel = dateFreeTrialPremierDeuxiemeRappel;
    }
    public LocalDateTime getDateFreeTrialPremierDeuxiemeRappelFrom(){
        return this.dateFreeTrialPremierDeuxiemeRappelFrom;
    }
    public void setDateFreeTrialPremierDeuxiemeRappelFrom(LocalDateTime dateFreeTrialPremierDeuxiemeRappelFrom){
        this.dateFreeTrialPremierDeuxiemeRappelFrom = dateFreeTrialPremierDeuxiemeRappelFrom;
    }
    public LocalDateTime getDateFreeTrialPremierDeuxiemeRappelTo(){
        return this.dateFreeTrialPremierDeuxiemeRappelTo;
    }
    public void setDateFreeTrialPremierDeuxiemeRappelTo(LocalDateTime dateFreeTrialPremierDeuxiemeRappelTo){
        this.dateFreeTrialPremierDeuxiemeRappelTo = dateFreeTrialPremierDeuxiemeRappelTo;
    }
    public String getNombreStudentTotal(){
        return this.nombreStudentTotal;
    }
    public void setNombreStudentTotal(String nombreStudentTotal){
        this.nombreStudentTotal = nombreStudentTotal;
    }   
    public String getNombreStudentTotalMin(){
        return this.nombreStudentTotalMin;
    }
    public void setNombreStudentTotalMin(String nombreStudentTotalMin){
        this.nombreStudentTotalMin = nombreStudentTotalMin;
    }
    public String getNombreStudentTotalMax(){
        return this.nombreStudentTotalMax;
    }
    public void setNombreStudentTotalMax(String nombreStudentTotalMax){
        this.nombreStudentTotalMax = nombreStudentTotalMax;
    }
      
    public String getNombreStudentAbonne(){
        return this.nombreStudentAbonne;
    }
    public void setNombreStudentAbonne(String nombreStudentAbonne){
        this.nombreStudentAbonne = nombreStudentAbonne;
    }   
    public String getNombreStudentAbonneMin(){
        return this.nombreStudentAbonneMin;
    }
    public void setNombreStudentAbonneMin(String nombreStudentAbonneMin){
        this.nombreStudentAbonneMin = nombreStudentAbonneMin;
    }
    public String getNombreStudentAbonneMax(){
        return this.nombreStudentAbonneMax;
    }
    public void setNombreStudentAbonneMax(String nombreStudentAbonneMax){
        this.nombreStudentAbonneMax = nombreStudentAbonneMax;
    }
      
    public String getNombreStudentPresent(){
        return this.nombreStudentPresent;
    }
    public void setNombreStudentPresent(String nombreStudentPresent){
        this.nombreStudentPresent = nombreStudentPresent;
    }   
    public String getNombreStudentPresentMin(){
        return this.nombreStudentPresentMin;
    }
    public void setNombreStudentPresentMin(String nombreStudentPresentMin){
        this.nombreStudentPresentMin = nombreStudentPresentMin;
    }
    public String getNombreStudentPresentMax(){
        return this.nombreStudentPresentMax;
    }
    public void setNombreStudentPresentMax(String nombreStudentPresentMax){
        this.nombreStudentPresentMax = nombreStudentPresentMax;
    }
      

    public ProfCriteria getProf(){
        return this.prof;
    }

    public void setProf(ProfCriteria prof){
        this.prof = prof;
    }
    public List<ProfCriteria> getProfs(){
        return this.profs;
    }

    public void setProfs(List<ProfCriteria> profs){
        this.profs = profs;
    }
    public NiveauEtudeCriteria getNiveauEtude(){
        return this.niveauEtude;
    }

    public void setNiveauEtude(NiveauEtudeCriteria niveauEtude){
        this.niveauEtude = niveauEtude;
    }
    public List<NiveauEtudeCriteria> getNiveauEtudes(){
        return this.niveauEtudes;
    }

    public void setNiveauEtudes(List<NiveauEtudeCriteria> niveauEtudes){
        this.niveauEtudes = niveauEtudes;
    }
    public FreeTrialStudentWhatsTemplateCriteria getFreeTrialStudentWhatsTemplate(){
        return this.freeTrialStudentWhatsTemplate;
    }

    public void setFreeTrialStudentWhatsTemplate(FreeTrialStudentWhatsTemplateCriteria freeTrialStudentWhatsTemplate){
        this.freeTrialStudentWhatsTemplate = freeTrialStudentWhatsTemplate;
    }
    public List<FreeTrialStudentWhatsTemplateCriteria> getFreeTrialStudentWhatsTemplates(){
        return this.freeTrialStudentWhatsTemplates;
    }

    public void setFreeTrialStudentWhatsTemplates(List<FreeTrialStudentWhatsTemplateCriteria> freeTrialStudentWhatsTemplates){
        this.freeTrialStudentWhatsTemplates = freeTrialStudentWhatsTemplates;
    }
    public FreeTrialStudentEmailTemplateCriteria getFreeTrialStudentEmailTemplate(){
        return this.freeTrialStudentEmailTemplate;
    }

    public void setFreeTrialStudentEmailTemplate(FreeTrialStudentEmailTemplateCriteria freeTrialStudentEmailTemplate){
        this.freeTrialStudentEmailTemplate = freeTrialStudentEmailTemplate;
    }
    public List<FreeTrialStudentEmailTemplateCriteria> getFreeTrialStudentEmailTemplates(){
        return this.freeTrialStudentEmailTemplates;
    }

    public void setFreeTrialStudentEmailTemplates(List<FreeTrialStudentEmailTemplateCriteria> freeTrialStudentEmailTemplates){
        this.freeTrialStudentEmailTemplates = freeTrialStudentEmailTemplates;
    }
    public FreeTrialTeacherEmailTemplateCriteria getFreeTrialTeacherEmailTemplate(){
        return this.freeTrialTeacherEmailTemplate;
    }

    public void setFreeTrialTeacherEmailTemplate(FreeTrialTeacherEmailTemplateCriteria freeTrialTeacherEmailTemplate){
        this.freeTrialTeacherEmailTemplate = freeTrialTeacherEmailTemplate;
    }
    public List<FreeTrialTeacherEmailTemplateCriteria> getFreeTrialTeacherEmailTemplates(){
        return this.freeTrialTeacherEmailTemplates;
    }

    public void setFreeTrialTeacherEmailTemplates(List<FreeTrialTeacherEmailTemplateCriteria> freeTrialTeacherEmailTemplates){
        this.freeTrialTeacherEmailTemplates = freeTrialTeacherEmailTemplates;
    }
    public FreeTrialTeacherWhatsTemplateCriteria getFreeTrialTeacherWhatsTemplate(){
        return this.freeTrialTeacherWhatsTemplate;
    }

    public void setFreeTrialTeacherWhatsTemplate(FreeTrialTeacherWhatsTemplateCriteria freeTrialTeacherWhatsTemplate){
        this.freeTrialTeacherWhatsTemplate = freeTrialTeacherWhatsTemplate;
    }
    public List<FreeTrialTeacherWhatsTemplateCriteria> getFreeTrialTeacherWhatsTemplates(){
        return this.freeTrialTeacherWhatsTemplates;
    }

    public void setFreeTrialTeacherWhatsTemplates(List<FreeTrialTeacherWhatsTemplateCriteria> freeTrialTeacherWhatsTemplates){
        this.freeTrialTeacherWhatsTemplates = freeTrialTeacherWhatsTemplates;
    }
    public FreeTrialConfigurationCriteria getFreeTrialConfiguration(){
        return this.freeTrialConfiguration;
    }

    public void setFreeTrialConfiguration(FreeTrialConfigurationCriteria freeTrialConfiguration){
        this.freeTrialConfiguration = freeTrialConfiguration;
    }
    public List<FreeTrialConfigurationCriteria> getFreeTrialConfigurations(){
        return this.freeTrialConfigurations;
    }

    public void setFreeTrialConfigurations(List<FreeTrialConfigurationCriteria> freeTrialConfigurations){
        this.freeTrialConfigurations = freeTrialConfigurations;
    }
    public StatutFreeTrialCriteria getStatutFreeTrial(){
        return this.statutFreeTrial;
    }

    public void setStatutFreeTrial(StatutFreeTrialCriteria statutFreeTrial){
        this.statutFreeTrial = statutFreeTrial;
    }
    public List<StatutFreeTrialCriteria> getStatutFreeTrials(){
        return this.statutFreeTrials;
    }

    public void setStatutFreeTrials(List<StatutFreeTrialCriteria> statutFreeTrials){
        this.statutFreeTrials = statutFreeTrials;
    }
}
