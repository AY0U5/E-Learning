package ma.zs.alc.bean.core.grpe;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;


import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.bean.core.quiz.Quiz;
import ma.zs.alc.bean.core.inscriptionref.Skill;
import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant;
import ma.zs.alc.bean.core.inscriptionref.Fonction;
import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.inscriptionref.EtatInscription;
import ma.zs.alc.bean.core.grpe.GroupeType;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial;
import ma.zs.alc.bean.core.pack.PackStudent;
import ma.zs.alc.bean.core.grpe.GroupeEtude;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "inscription")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Inscription   extends AuditBusinessObject     {

    private Long id;

    private Integer numeroInscription = 0;
    private BigDecimal noteQuizNiveau = BigDecimal.ZERO;
    @Column(columnDefinition = "boolean default false")
    private Boolean quizFinished = false;
    @Column(length = 500)
    private String dateRegistration;
    private LocalDateTime datedebutinscription ;
    private LocalDateTime datefininscription ;
    @Column(length = 500)
    private String skype;

    private Etudiant etudiant ;
    private EtatInscription etatInscription ;
    private Parcours parcours ;
    private GroupeEtude groupeEtude ;
    private GroupeType groupeType ;
    private StatutSocial statutSocial ;
    private InteretEtudiant interetEtudiant ;
    private NiveauEtude niveauEtude ;
    private Fonction fonction ;
    private Quiz quiz ;
    private PackStudent packStudent ;
    private Skill skill ;


    public Inscription(){
        super();
    }

    public Inscription(Long id){
        this.id = id;
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
    public Integer getNumeroInscription(){
        return this.numeroInscription;
    }
    public void setNumeroInscription(Integer numeroInscription){
        this.numeroInscription = numeroInscription;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant")
    public Etudiant getEtudiant(){
        return this.etudiant;
    }
    public void setEtudiant(Etudiant etudiant){
        this.etudiant = etudiant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_inscription")
    public EtatInscription getEtatInscription(){
        return this.etatInscription;
    }
    public void setEtatInscription(EtatInscription etatInscription){
        this.etatInscription = etatInscription;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parcours")
    public Parcours getParcours(){
        return this.parcours;
    }
    public void setParcours(Parcours parcours){
        this.parcours = parcours;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupe_etude")
    public GroupeEtude getGroupeEtude(){
        return this.groupeEtude;
    }
    public void setGroupeEtude(GroupeEtude groupeEtude){
        this.groupeEtude = groupeEtude;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupe_type")
    public GroupeType getGroupeType(){
        return this.groupeType;
    }
    public void setGroupeType(GroupeType groupeType){
        this.groupeType = groupeType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "statut_social")
    public StatutSocial getStatutSocial(){
        return this.statutSocial;
    }
    public void setStatutSocial(StatutSocial statutSocial){
        this.statutSocial = statutSocial;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interet_etudiant")
    public InteretEtudiant getInteretEtudiant(){
        return this.interetEtudiant;
    }
    public void setInteretEtudiant(InteretEtudiant interetEtudiant){
        this.interetEtudiant = interetEtudiant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "niveau_etude")
    public NiveauEtude getNiveauEtude(){
        return this.niveauEtude;
    }
    public void setNiveauEtude(NiveauEtude niveauEtude){
        this.niveauEtude = niveauEtude;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fonction")
    public Fonction getFonction(){
        return this.fonction;
    }
    public void setFonction(Fonction fonction){
        this.fonction = fonction;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz")
    public Quiz getQuiz(){
        return this.quiz;
    }
    public void setQuiz(Quiz quiz){
        this.quiz = quiz;
    }
    public BigDecimal getNoteQuizNiveau(){
        return this.noteQuizNiveau;
    }
    public void setNoteQuizNiveau(BigDecimal noteQuizNiveau){
        this.noteQuizNiveau = noteQuizNiveau;
    }
    public Boolean  getQuizFinished(){
        return this.quizFinished;
    }
    public void setQuizFinished(Boolean quizFinished){
        this.quizFinished = quizFinished;
    }
    public String getDateRegistration(){
        return this.dateRegistration;
    }
    public void setDateRegistration(String dateRegistration){
        this.dateRegistration = dateRegistration;
    }
    public LocalDateTime getDatedebutinscription(){
        return this.datedebutinscription;
    }
    public void setDatedebutinscription(LocalDateTime datedebutinscription){
        this.datedebutinscription = datedebutinscription;
    }
    public LocalDateTime getDatefininscription(){
        return this.datefininscription;
    }
    public void setDatefininscription(LocalDateTime datefininscription){
        this.datefininscription = datefininscription;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pack_student")
    public PackStudent getPackStudent(){
        return this.packStudent;
    }
    public void setPackStudent(PackStudent packStudent){
        this.packStudent = packStudent;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill")
    public Skill getSkill(){
        return this.skill;
    }
    public void setSkill(Skill skill){
        this.skill = skill;
    }
    public String getSkype(){
        return this.skype;
    }
    public void setSkype(String skype){
        this.skype = skype;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscription inscription = (Inscription) o;
        return id != null && id.equals(inscription.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

