package ma.zs.alc.bean.core.freetrial;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.bean.core.freetrial.FreeTrialTeacherEmailTemplate;
import ma.zs.alc.bean.core.freetrial.FreeTrialTeacherWhatsTemplate;
import ma.zs.alc.bean.core.freetrial.StatutFreeTrial;
import ma.zs.alc.bean.core.freetrial.FreeTrialConfiguration;
import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.freetrial.FreeTrialStudentEmailTemplate;
import ma.zs.alc.bean.core.freetrial.FreeTrialDetail;
import ma.zs.alc.bean.core.prof.Prof;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude;
import ma.zs.alc.bean.core.freetrial.FreeTrialStudentWhatsTemplate;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "free_trial")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class FreeTrial   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime dateFreeTrial ;
    @Column(length = 500)
    private String link;
    @Column(columnDefinition = "boolean default false")
    private Boolean emailTeacherSent = false;
    private LocalDateTime emailTeacherSendingDate ;
    @Column(columnDefinition = "boolean default false")
    private Boolean whatsTeacherSent = false;
    private LocalDateTime whatsTeacherSendingDate ;
    private LocalDateTime dateFreeTrialPremierRappel ;
    private LocalDateTime dateFreeTrialPremierDeuxiemeRappel ;
    private Integer nombreStudentTotal = 0;
    private Integer nombreStudentAbonne = 0;
    private Integer nombreStudentPresent = 0;

    private Prof prof ;
    private NiveauEtude niveauEtude ;
    private FreeTrialStudentWhatsTemplate freeTrialStudentWhatsTemplate ;
    private FreeTrialStudentEmailTemplate freeTrialStudentEmailTemplate ;
    private FreeTrialTeacherEmailTemplate freeTrialTeacherEmailTemplate ;
    private FreeTrialTeacherWhatsTemplate freeTrialTeacherWhatsTemplate ;
    private FreeTrialConfiguration freeTrialConfiguration ;
    private StatutFreeTrial statutFreeTrial ;

    private List<FreeTrialDetail> freeTrialDetails ;

    public FreeTrial(){
        super();
    }

    public FreeTrial(Long id){
        this.id = id;
    }

    public FreeTrial(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }
    public FreeTrial(String reference){
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prof")
    public Prof getProf(){
        return this.prof;
    }
    public void setProf(Prof prof){
        this.prof = prof;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "niveau_etude")
    public NiveauEtude getNiveauEtude(){
        return this.niveauEtude;
    }
    public void setNiveauEtude(NiveauEtude niveauEtude){
        this.niveauEtude = niveauEtude;
    }
    public LocalDateTime getDateFreeTrial(){
        return this.dateFreeTrial;
    }
    public void setDateFreeTrial(LocalDateTime dateFreeTrial){
        this.dateFreeTrial = dateFreeTrial;
    }
    public String getLink(){
        return this.link;
    }
    public void setLink(String link){
        this.link = link;
    }
    public Boolean  getEmailTeacherSent(){
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
    public Boolean  getWhatsTeacherSent(){
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "free_trial_student_whats_template")
    public FreeTrialStudentWhatsTemplate getFreeTrialStudentWhatsTemplate(){
        return this.freeTrialStudentWhatsTemplate;
    }
    public void setFreeTrialStudentWhatsTemplate(FreeTrialStudentWhatsTemplate freeTrialStudentWhatsTemplate){
        this.freeTrialStudentWhatsTemplate = freeTrialStudentWhatsTemplate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "free_trial_student_email_template")
    public FreeTrialStudentEmailTemplate getFreeTrialStudentEmailTemplate(){
        return this.freeTrialStudentEmailTemplate;
    }
    public void setFreeTrialStudentEmailTemplate(FreeTrialStudentEmailTemplate freeTrialStudentEmailTemplate){
        this.freeTrialStudentEmailTemplate = freeTrialStudentEmailTemplate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "free_trial_teacher_email_template")
    public FreeTrialTeacherEmailTemplate getFreeTrialTeacherEmailTemplate(){
        return this.freeTrialTeacherEmailTemplate;
    }
    public void setFreeTrialTeacherEmailTemplate(FreeTrialTeacherEmailTemplate freeTrialTeacherEmailTemplate){
        this.freeTrialTeacherEmailTemplate = freeTrialTeacherEmailTemplate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "free_trial_teacher_whats_template")
    public FreeTrialTeacherWhatsTemplate getFreeTrialTeacherWhatsTemplate(){
        return this.freeTrialTeacherWhatsTemplate;
    }
    public void setFreeTrialTeacherWhatsTemplate(FreeTrialTeacherWhatsTemplate freeTrialTeacherWhatsTemplate){
        this.freeTrialTeacherWhatsTemplate = freeTrialTeacherWhatsTemplate;
    }
    public LocalDateTime getDateFreeTrialPremierRappel(){
        return this.dateFreeTrialPremierRappel;
    }
    public void setDateFreeTrialPremierRappel(LocalDateTime dateFreeTrialPremierRappel){
        this.dateFreeTrialPremierRappel = dateFreeTrialPremierRappel;
    }
    public LocalDateTime getDateFreeTrialPremierDeuxiemeRappel(){
        return this.dateFreeTrialPremierDeuxiemeRappel;
    }
    public void setDateFreeTrialPremierDeuxiemeRappel(LocalDateTime dateFreeTrialPremierDeuxiemeRappel){
        this.dateFreeTrialPremierDeuxiemeRappel = dateFreeTrialPremierDeuxiemeRappel;
    }
    public Integer getNombreStudentTotal(){
        return this.nombreStudentTotal;
    }
    public void setNombreStudentTotal(Integer nombreStudentTotal){
        this.nombreStudentTotal = nombreStudentTotal;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "free_trial_configuration")
    public FreeTrialConfiguration getFreeTrialConfiguration(){
        return this.freeTrialConfiguration;
    }
    public void setFreeTrialConfiguration(FreeTrialConfiguration freeTrialConfiguration){
        this.freeTrialConfiguration = freeTrialConfiguration;
    }
    public Integer getNombreStudentAbonne(){
        return this.nombreStudentAbonne;
    }
    public void setNombreStudentAbonne(Integer nombreStudentAbonne){
        this.nombreStudentAbonne = nombreStudentAbonne;
    }
    public Integer getNombreStudentPresent(){
        return this.nombreStudentPresent;
    }
    public void setNombreStudentPresent(Integer nombreStudentPresent){
        this.nombreStudentPresent = nombreStudentPresent;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut_free_trial")
    public StatutFreeTrial getStatutFreeTrial(){
        return this.statutFreeTrial;
    }
    public void setStatutFreeTrial(StatutFreeTrial statutFreeTrial){
        this.statutFreeTrial = statutFreeTrial;
    }
    @OneToMany(mappedBy = "freeTrial")

    public List<FreeTrialDetail> getFreeTrialDetails(){
        return this.freeTrialDetails;
    }
    public void setFreeTrialDetails(List<FreeTrialDetail> freeTrialDetails){
        this.freeTrialDetails = freeTrialDetails;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FreeTrial freeTrial = (FreeTrial) o;
        return id != null && id.equals(freeTrial.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

