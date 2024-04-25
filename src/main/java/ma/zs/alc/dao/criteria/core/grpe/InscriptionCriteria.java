package  ma.zs.alc.dao.criteria.core.grpe;


import ma.zs.alc.dao.criteria.core.course.ParcoursCriteria;
import ma.zs.alc.dao.criteria.core.quiz.QuizCriteria;
import ma.zs.alc.dao.criteria.core.inscriptionref.SkillCriteria;
import ma.zs.alc.dao.criteria.core.inscriptionref.InteretEtudiantCriteria;
import ma.zs.alc.dao.criteria.core.inscriptionref.FonctionCriteria;
import ma.zs.alc.dao.criteria.core.inscription.EtudiantCriteria;
import ma.zs.alc.dao.criteria.core.inscriptionref.EtatInscriptionCriteria;
import ma.zs.alc.dao.criteria.core.inscriptionref.StatutSocialCriteria;
import ma.zs.alc.dao.criteria.core.pack.PackStudentCriteria;
import ma.zs.alc.dao.criteria.core.inscriptionref.NiveauEtudeCriteria;

import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class InscriptionCriteria extends  BaseCriteria  {

    private String numeroInscription;
    private String numeroInscriptionMin;
    private String numeroInscriptionMax;
    private String noteQuizNiveau;
    private String noteQuizNiveauMin;
    private String noteQuizNiveauMax;
    private Boolean quizFinished;
    private String dateRegistration;
    private String dateRegistrationLike;
    private LocalDateTime datedebutinscription;
    private LocalDateTime datedebutinscriptionFrom;
    private LocalDateTime datedebutinscriptionTo;
    private LocalDateTime datefininscription;
    private LocalDateTime datefininscriptionFrom;
    private LocalDateTime datefininscriptionTo;
    private String skype;
    private String skypeLike;

    private EtudiantCriteria etudiant ;
    private List<EtudiantCriteria> etudiants ;
    private EtatInscriptionCriteria etatInscription ;
    private List<EtatInscriptionCriteria> etatInscriptions ;
    private ParcoursCriteria parcours ;
    private List<ParcoursCriteria> parcourss ;
    private GroupeEtudeCriteria groupeEtude ;
    private List<GroupeEtudeCriteria> groupeEtudes ;
    private GroupeTypeCriteria groupeType ;
    private List<GroupeTypeCriteria> groupeTypes ;
    private StatutSocialCriteria statutSocial ;
    private List<StatutSocialCriteria> statutSocials ;
    private InteretEtudiantCriteria interetEtudiant ;
    private List<InteretEtudiantCriteria> interetEtudiants ;
    private NiveauEtudeCriteria niveauEtude ;
    private List<NiveauEtudeCriteria> niveauEtudes ;
    private FonctionCriteria fonction ;
    private List<FonctionCriteria> fonctions ;
    private QuizCriteria quiz ;
    private List<QuizCriteria> quizs ;
    private PackStudentCriteria packStudent ;
    private List<PackStudentCriteria> packStudents ;
    private SkillCriteria skill ;
    private List<SkillCriteria> skills ;


    public InscriptionCriteria(){}

    public String getNumeroInscription(){
        return this.numeroInscription;
    }
    public void setNumeroInscription(String numeroInscription){
        this.numeroInscription = numeroInscription;
    }   
    public String getNumeroInscriptionMin(){
        return this.numeroInscriptionMin;
    }
    public void setNumeroInscriptionMin(String numeroInscriptionMin){
        this.numeroInscriptionMin = numeroInscriptionMin;
    }
    public String getNumeroInscriptionMax(){
        return this.numeroInscriptionMax;
    }
    public void setNumeroInscriptionMax(String numeroInscriptionMax){
        this.numeroInscriptionMax = numeroInscriptionMax;
    }
      
    public String getNoteQuizNiveau(){
        return this.noteQuizNiveau;
    }
    public void setNoteQuizNiveau(String noteQuizNiveau){
        this.noteQuizNiveau = noteQuizNiveau;
    }   
    public String getNoteQuizNiveauMin(){
        return this.noteQuizNiveauMin;
    }
    public void setNoteQuizNiveauMin(String noteQuizNiveauMin){
        this.noteQuizNiveauMin = noteQuizNiveauMin;
    }
    public String getNoteQuizNiveauMax(){
        return this.noteQuizNiveauMax;
    }
    public void setNoteQuizNiveauMax(String noteQuizNiveauMax){
        this.noteQuizNiveauMax = noteQuizNiveauMax;
    }
      
    public Boolean getQuizFinished(){
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
    public String getDateRegistrationLike(){
        return this.dateRegistrationLike;
    }
    public void setDateRegistrationLike(String dateRegistrationLike){
        this.dateRegistrationLike = dateRegistrationLike;
    }

    public LocalDateTime getDatedebutinscription(){
        return this.datedebutinscription;
    }
    public void setDatedebutinscription(LocalDateTime datedebutinscription){
        this.datedebutinscription = datedebutinscription;
    }
    public LocalDateTime getDatedebutinscriptionFrom(){
        return this.datedebutinscriptionFrom;
    }
    public void setDatedebutinscriptionFrom(LocalDateTime datedebutinscriptionFrom){
        this.datedebutinscriptionFrom = datedebutinscriptionFrom;
    }
    public LocalDateTime getDatedebutinscriptionTo(){
        return this.datedebutinscriptionTo;
    }
    public void setDatedebutinscriptionTo(LocalDateTime datedebutinscriptionTo){
        this.datedebutinscriptionTo = datedebutinscriptionTo;
    }
    public LocalDateTime getDatefininscription(){
        return this.datefininscription;
    }
    public void setDatefininscription(LocalDateTime datefininscription){
        this.datefininscription = datefininscription;
    }
    public LocalDateTime getDatefininscriptionFrom(){
        return this.datefininscriptionFrom;
    }
    public void setDatefininscriptionFrom(LocalDateTime datefininscriptionFrom){
        this.datefininscriptionFrom = datefininscriptionFrom;
    }
    public LocalDateTime getDatefininscriptionTo(){
        return this.datefininscriptionTo;
    }
    public void setDatefininscriptionTo(LocalDateTime datefininscriptionTo){
        this.datefininscriptionTo = datefininscriptionTo;
    }
    public String getSkype(){
        return this.skype;
    }
    public void setSkype(String skype){
        this.skype = skype;
    }
    public String getSkypeLike(){
        return this.skypeLike;
    }
    public void setSkypeLike(String skypeLike){
        this.skypeLike = skypeLike;
    }


    public EtudiantCriteria getEtudiant(){
        return this.etudiant;
    }

    public void setEtudiant(EtudiantCriteria etudiant){
        this.etudiant = etudiant;
    }
    public List<EtudiantCriteria> getEtudiants(){
        return this.etudiants;
    }

    public void setEtudiants(List<EtudiantCriteria> etudiants){
        this.etudiants = etudiants;
    }
    public EtatInscriptionCriteria getEtatInscription(){
        return this.etatInscription;
    }

    public void setEtatInscription(EtatInscriptionCriteria etatInscription){
        this.etatInscription = etatInscription;
    }
    public List<EtatInscriptionCriteria> getEtatInscriptions(){
        return this.etatInscriptions;
    }

    public void setEtatInscriptions(List<EtatInscriptionCriteria> etatInscriptions){
        this.etatInscriptions = etatInscriptions;
    }
    public ParcoursCriteria getParcours(){
        return this.parcours;
    }

    public void setParcours(ParcoursCriteria parcours){
        this.parcours = parcours;
    }
    public List<ParcoursCriteria> getParcourss(){
        return this.parcourss;
    }

    public void setParcourss(List<ParcoursCriteria> parcourss){
        this.parcourss = parcourss;
    }
    public GroupeEtudeCriteria getGroupeEtude(){
        return this.groupeEtude;
    }

    public void setGroupeEtude(GroupeEtudeCriteria groupeEtude){
        this.groupeEtude = groupeEtude;
    }
    public List<GroupeEtudeCriteria> getGroupeEtudes(){
        return this.groupeEtudes;
    }

    public void setGroupeEtudes(List<GroupeEtudeCriteria> groupeEtudes){
        this.groupeEtudes = groupeEtudes;
    }
    public GroupeTypeCriteria getGroupeType(){
        return this.groupeType;
    }

    public void setGroupeType(GroupeTypeCriteria groupeType){
        this.groupeType = groupeType;
    }
    public List<GroupeTypeCriteria> getGroupeTypes(){
        return this.groupeTypes;
    }

    public void setGroupeTypes(List<GroupeTypeCriteria> groupeTypes){
        this.groupeTypes = groupeTypes;
    }
    public StatutSocialCriteria getStatutSocial(){
        return this.statutSocial;
    }

    public void setStatutSocial(StatutSocialCriteria statutSocial){
        this.statutSocial = statutSocial;
    }
    public List<StatutSocialCriteria> getStatutSocials(){
        return this.statutSocials;
    }

    public void setStatutSocials(List<StatutSocialCriteria> statutSocials){
        this.statutSocials = statutSocials;
    }
    public InteretEtudiantCriteria getInteretEtudiant(){
        return this.interetEtudiant;
    }

    public void setInteretEtudiant(InteretEtudiantCriteria interetEtudiant){
        this.interetEtudiant = interetEtudiant;
    }
    public List<InteretEtudiantCriteria> getInteretEtudiants(){
        return this.interetEtudiants;
    }

    public void setInteretEtudiants(List<InteretEtudiantCriteria> interetEtudiants){
        this.interetEtudiants = interetEtudiants;
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
    public FonctionCriteria getFonction(){
        return this.fonction;
    }

    public void setFonction(FonctionCriteria fonction){
        this.fonction = fonction;
    }
    public List<FonctionCriteria> getFonctions(){
        return this.fonctions;
    }

    public void setFonctions(List<FonctionCriteria> fonctions){
        this.fonctions = fonctions;
    }
    public QuizCriteria getQuiz(){
        return this.quiz;
    }

    public void setQuiz(QuizCriteria quiz){
        this.quiz = quiz;
    }
    public List<QuizCriteria> getQuizs(){
        return this.quizs;
    }

    public void setQuizs(List<QuizCriteria> quizs){
        this.quizs = quizs;
    }
    public PackStudentCriteria getPackStudent(){
        return this.packStudent;
    }

    public void setPackStudent(PackStudentCriteria packStudent){
        this.packStudent = packStudent;
    }
    public List<PackStudentCriteria> getPackStudents(){
        return this.packStudents;
    }

    public void setPackStudents(List<PackStudentCriteria> packStudents){
        this.packStudents = packStudents;
    }
    public SkillCriteria getSkill(){
        return this.skill;
    }

    public void setSkill(SkillCriteria skill){
        this.skill = skill;
    }
    public List<SkillCriteria> getSkills(){
        return this.skills;
    }

    public void setSkills(List<SkillCriteria> skills){
        this.skills = skills;
    }
}
