package  ma.zs.alc.ws.converter.grpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.alc.ws.converter.course.ParcoursConverter;
import ma.zs.alc.ws.converter.quiz.QuizConverter;
import ma.zs.alc.ws.converter.inscriptionref.SkillConverter;
import ma.zs.alc.ws.converter.inscriptionref.InteretEtudiantConverter;
import ma.zs.alc.ws.converter.inscriptionref.FonctionConverter;
import ma.zs.alc.ws.converter.inscription.EtudiantConverter;
import ma.zs.alc.ws.converter.inscriptionref.EtatInscriptionConverter;
import ma.zs.alc.ws.converter.grpe.GroupeTypeConverter;
import ma.zs.alc.ws.converter.inscriptionref.StatutSocialConverter;
import ma.zs.alc.ws.converter.pack.PackStudentConverter;
import ma.zs.alc.ws.converter.grpe.GroupeEtudeConverter;
import ma.zs.alc.ws.converter.inscriptionref.NiveauEtudeConverter;

import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.bean.core.quiz.Quiz;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.grpe.Inscription;
import ma.zs.alc.ws.dto.grpe.InscriptionDto;

@Component
public class InscriptionConverter extends AbstractConverter<Inscription, InscriptionDto> {

    @Autowired
    private ParcoursConverter parcoursConverter ;
    @Autowired
    private QuizConverter quizConverter ;
    @Autowired
    private SkillConverter skillConverter ;
    @Autowired
    private InteretEtudiantConverter interetEtudiantConverter ;
    @Autowired
    private FonctionConverter fonctionConverter ;
    @Autowired
    private EtudiantConverter etudiantConverter ;
    @Autowired
    private EtatInscriptionConverter etatInscriptionConverter ;
    @Autowired
    private GroupeTypeConverter groupeTypeConverter ;
    @Autowired
    private StatutSocialConverter statutSocialConverter ;
    @Autowired
    private PackStudentConverter packStudentConverter ;
    @Autowired
    private GroupeEtudeConverter groupeEtudeConverter ;
    @Autowired
    private NiveauEtudeConverter niveauEtudeConverter ;
    private boolean etudiant;
    private boolean etatInscription;
    private boolean parcours;
    private boolean groupeEtude;
    private boolean groupeType;
    private boolean statutSocial;
    private boolean interetEtudiant;
    private boolean niveauEtude;
    private boolean fonction;
    private boolean quiz;
    private boolean packStudent;
    private boolean skill;

    public  InscriptionConverter() {
        super(Inscription.class, InscriptionDto.class);
        init(true);
    }

    @Override
    public Inscription toItem(InscriptionDto dto) {
        if (dto == null) {
            return null;
        } else {
        Inscription item = new Inscription();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getNumeroInscription()))
                item.setNumeroInscription(dto.getNumeroInscription());
            if(StringUtil.isNotEmpty(dto.getNoteQuizNiveau()))
                item.setNoteQuizNiveau(dto.getNoteQuizNiveau());
            if(dto.getQuizFinished() != null)
                item.setQuizFinished(dto.getQuizFinished());
            if(StringUtil.isNotEmpty(dto.getDateRegistration()))
                item.setDateRegistration(dto.getDateRegistration());
            if(StringUtil.isNotEmpty(dto.getDatedebutinscription()))
                item.setDatedebutinscription(DateUtil.stringEnToDate(dto.getDatedebutinscription()));
            if(StringUtil.isNotEmpty(dto.getDatefininscription()))
                item.setDatefininscription(DateUtil.stringEnToDate(dto.getDatefininscription()));
            if(StringUtil.isNotEmpty(dto.getSkype()))
                item.setSkype(dto.getSkype());
            if(dto.getEtudiant() != null && dto.getEtudiant().getId() != null){
                item.setEtudiant(new Etudiant());
                item.getEtudiant().setId(dto.getEtudiant().getId());
                item.getEtudiant().setRef(dto.getEtudiant().getRef());
            }

            if(this.etatInscription && dto.getEtatInscription()!=null)
                item.setEtatInscription(etatInscriptionConverter.toItem(dto.getEtatInscription())) ;

            if(dto.getParcours() != null && dto.getParcours().getId() != null){
                item.setParcours(new Parcours());
                item.getParcours().setId(dto.getParcours().getId());
                item.getParcours().setLibelle(dto.getParcours().getLibelle());
            }

            if(this.groupeEtude && dto.getGroupeEtude()!=null)
                item.setGroupeEtude(groupeEtudeConverter.toItem(dto.getGroupeEtude())) ;

            if(this.groupeType && dto.getGroupeType()!=null)
                item.setGroupeType(groupeTypeConverter.toItem(dto.getGroupeType())) ;

            if(this.statutSocial && dto.getStatutSocial()!=null)
                item.setStatutSocial(statutSocialConverter.toItem(dto.getStatutSocial())) ;

            if(this.interetEtudiant && dto.getInteretEtudiant()!=null)
                item.setInteretEtudiant(interetEtudiantConverter.toItem(dto.getInteretEtudiant())) ;

            if(this.niveauEtude && dto.getNiveauEtude()!=null)
                item.setNiveauEtude(niveauEtudeConverter.toItem(dto.getNiveauEtude())) ;

            if(this.fonction && dto.getFonction()!=null)
                item.setFonction(fonctionConverter.toItem(dto.getFonction())) ;

            if(dto.getQuiz() != null && dto.getQuiz().getId() != null){
                item.setQuiz(new Quiz());
                item.getQuiz().setId(dto.getQuiz().getId());
                item.getQuiz().setLib(dto.getQuiz().getLib());
            }

            if(this.packStudent && dto.getPackStudent()!=null)
                item.setPackStudent(packStudentConverter.toItem(dto.getPackStudent())) ;

            if(this.skill && dto.getSkill()!=null)
                item.setSkill(skillConverter.toItem(dto.getSkill())) ;




        return item;
        }
    }

    @Override
    public InscriptionDto toDto(Inscription item) {
        if (item == null) {
            return null;
        } else {
            InscriptionDto dto = new InscriptionDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getNumeroInscription()))
                dto.setNumeroInscription(item.getNumeroInscription());
            if(StringUtil.isNotEmpty(item.getNoteQuizNiveau()))
                dto.setNoteQuizNiveau(item.getNoteQuizNiveau());
                dto.setQuizFinished(item.getQuizFinished());
            if(StringUtil.isNotEmpty(item.getDateRegistration()))
                dto.setDateRegistration(item.getDateRegistration());
            if(item.getDatedebutinscription()!=null)
                dto.setDatedebutinscription(DateUtil.dateTimeToString(item.getDatedebutinscription()));
            if(item.getDatefininscription()!=null)
                dto.setDatefininscription(DateUtil.dateTimeToString(item.getDatefininscription()));
            if(StringUtil.isNotEmpty(item.getSkype()))
                dto.setSkype(item.getSkype());
            if(this.etudiant && item.getEtudiant()!=null) {
                dto.setEtudiant(etudiantConverter.toDto(item.getEtudiant())) ;

            }
            if(this.etatInscription && item.getEtatInscription()!=null) {
                dto.setEtatInscription(etatInscriptionConverter.toDto(item.getEtatInscription())) ;

            }
            if(this.parcours && item.getParcours()!=null) {
                dto.setParcours(parcoursConverter.toDto(item.getParcours())) ;

            }
            if(this.groupeEtude && item.getGroupeEtude()!=null) {
                dto.setGroupeEtude(groupeEtudeConverter.toDto(item.getGroupeEtude())) ;

            }
            if(this.groupeType && item.getGroupeType()!=null) {
                dto.setGroupeType(groupeTypeConverter.toDto(item.getGroupeType())) ;

            }
            if(this.statutSocial && item.getStatutSocial()!=null) {
                dto.setStatutSocial(statutSocialConverter.toDto(item.getStatutSocial())) ;

            }
            if(this.interetEtudiant && item.getInteretEtudiant()!=null) {
                dto.setInteretEtudiant(interetEtudiantConverter.toDto(item.getInteretEtudiant())) ;

            }
            if(this.niveauEtude && item.getNiveauEtude()!=null) {
                dto.setNiveauEtude(niveauEtudeConverter.toDto(item.getNiveauEtude())) ;

            }
            if(this.fonction && item.getFonction()!=null) {
                dto.setFonction(fonctionConverter.toDto(item.getFonction())) ;

            }
            if(this.quiz && item.getQuiz()!=null) {
                dto.setQuiz(quizConverter.toDto(item.getQuiz())) ;

            }
            if(this.packStudent && item.getPackStudent()!=null) {
                dto.setPackStudent(packStudentConverter.toDto(item.getPackStudent())) ;

            }
            if(this.skill && item.getSkill()!=null) {
                dto.setSkill(skillConverter.toDto(item.getSkill())) ;

            }


        return dto;
        }
    }

    public void copy(InscriptionDto dto, Inscription t) {
    super.copy(dto, t);
    if (dto.getEtudiant() != null)
        etudiantConverter.copy(dto.getEtudiant(), t.getEtudiant());
    if (dto.getEtatInscription() != null)
        etatInscriptionConverter.copy(dto.getEtatInscription(), t.getEtatInscription());
    if (dto.getParcours() != null)
        parcoursConverter.copy(dto.getParcours(), t.getParcours());
    if (dto.getGroupeEtude() != null)
        groupeEtudeConverter.copy(dto.getGroupeEtude(), t.getGroupeEtude());
    if (dto.getGroupeType() != null)
        groupeTypeConverter.copy(dto.getGroupeType(), t.getGroupeType());
    if (dto.getStatutSocial() != null)
        statutSocialConverter.copy(dto.getStatutSocial(), t.getStatutSocial());
    if (dto.getInteretEtudiant() != null)
        interetEtudiantConverter.copy(dto.getInteretEtudiant(), t.getInteretEtudiant());
    if (dto.getNiveauEtude() != null)
        niveauEtudeConverter.copy(dto.getNiveauEtude(), t.getNiveauEtude());
    if (dto.getFonction() != null)
        fonctionConverter.copy(dto.getFonction(), t.getFonction());
    if (dto.getQuiz() != null)
        quizConverter.copy(dto.getQuiz(), t.getQuiz());
    if (dto.getPackStudent() != null)
        packStudentConverter.copy(dto.getPackStudent(), t.getPackStudent());
    if (dto.getSkill() != null)
        skillConverter.copy(dto.getSkill(), t.getSkill());
    }



    public void initObject(boolean value) {
        this.etudiant = value;
        this.etatInscription = value;
        this.parcours = value;
        this.groupeEtude = value;
        this.groupeType = value;
        this.statutSocial = value;
        this.interetEtudiant = value;
        this.niveauEtude = value;
        this.fonction = value;
        this.quiz = value;
        this.packStudent = value;
        this.skill = value;
    }


    public ParcoursConverter getParcoursConverter(){
        return this.parcoursConverter;
    }
    public void setParcoursConverter(ParcoursConverter parcoursConverter ){
        this.parcoursConverter = parcoursConverter;
    }
    public QuizConverter getQuizConverter(){
        return this.quizConverter;
    }
    public void setQuizConverter(QuizConverter quizConverter ){
        this.quizConverter = quizConverter;
    }
    public SkillConverter getSkillConverter(){
        return this.skillConverter;
    }
    public void setSkillConverter(SkillConverter skillConverter ){
        this.skillConverter = skillConverter;
    }
    public InteretEtudiantConverter getInteretEtudiantConverter(){
        return this.interetEtudiantConverter;
    }
    public void setInteretEtudiantConverter(InteretEtudiantConverter interetEtudiantConverter ){
        this.interetEtudiantConverter = interetEtudiantConverter;
    }
    public FonctionConverter getFonctionConverter(){
        return this.fonctionConverter;
    }
    public void setFonctionConverter(FonctionConverter fonctionConverter ){
        this.fonctionConverter = fonctionConverter;
    }
    public EtudiantConverter getEtudiantConverter(){
        return this.etudiantConverter;
    }
    public void setEtudiantConverter(EtudiantConverter etudiantConverter ){
        this.etudiantConverter = etudiantConverter;
    }
    public EtatInscriptionConverter getEtatInscriptionConverter(){
        return this.etatInscriptionConverter;
    }
    public void setEtatInscriptionConverter(EtatInscriptionConverter etatInscriptionConverter ){
        this.etatInscriptionConverter = etatInscriptionConverter;
    }
    public GroupeTypeConverter getGroupeTypeConverter(){
        return this.groupeTypeConverter;
    }
    public void setGroupeTypeConverter(GroupeTypeConverter groupeTypeConverter ){
        this.groupeTypeConverter = groupeTypeConverter;
    }
    public StatutSocialConverter getStatutSocialConverter(){
        return this.statutSocialConverter;
    }
    public void setStatutSocialConverter(StatutSocialConverter statutSocialConverter ){
        this.statutSocialConverter = statutSocialConverter;
    }
    public PackStudentConverter getPackStudentConverter(){
        return this.packStudentConverter;
    }
    public void setPackStudentConverter(PackStudentConverter packStudentConverter ){
        this.packStudentConverter = packStudentConverter;
    }
    public GroupeEtudeConverter getGroupeEtudeConverter(){
        return this.groupeEtudeConverter;
    }
    public void setGroupeEtudeConverter(GroupeEtudeConverter groupeEtudeConverter ){
        this.groupeEtudeConverter = groupeEtudeConverter;
    }
    public NiveauEtudeConverter getNiveauEtudeConverter(){
        return this.niveauEtudeConverter;
    }
    public void setNiveauEtudeConverter(NiveauEtudeConverter niveauEtudeConverter ){
        this.niveauEtudeConverter = niveauEtudeConverter;
    }
    public boolean  isEtudiant(){
        return this.etudiant;
    }
    public void  setEtudiant(boolean etudiant){
        this.etudiant = etudiant;
    }
    public boolean  isEtatInscription(){
        return this.etatInscription;
    }
    public void  setEtatInscription(boolean etatInscription){
        this.etatInscription = etatInscription;
    }
    public boolean  isParcours(){
        return this.parcours;
    }
    public void  setParcours(boolean parcours){
        this.parcours = parcours;
    }
    public boolean  isGroupeEtude(){
        return this.groupeEtude;
    }
    public void  setGroupeEtude(boolean groupeEtude){
        this.groupeEtude = groupeEtude;
    }
    public boolean  isGroupeType(){
        return this.groupeType;
    }
    public void  setGroupeType(boolean groupeType){
        this.groupeType = groupeType;
    }
    public boolean  isStatutSocial(){
        return this.statutSocial;
    }
    public void  setStatutSocial(boolean statutSocial){
        this.statutSocial = statutSocial;
    }
    public boolean  isInteretEtudiant(){
        return this.interetEtudiant;
    }
    public void  setInteretEtudiant(boolean interetEtudiant){
        this.interetEtudiant = interetEtudiant;
    }
    public boolean  isNiveauEtude(){
        return this.niveauEtude;
    }
    public void  setNiveauEtude(boolean niveauEtude){
        this.niveauEtude = niveauEtude;
    }
    public boolean  isFonction(){
        return this.fonction;
    }
    public void  setFonction(boolean fonction){
        this.fonction = fonction;
    }
    public boolean  isQuiz(){
        return this.quiz;
    }
    public void  setQuiz(boolean quiz){
        this.quiz = quiz;
    }
    public boolean  isPackStudent(){
        return this.packStudent;
    }
    public void  setPackStudent(boolean packStudent){
        this.packStudent = packStudent;
    }
    public boolean  isSkill(){
        return this.skill;
    }
    public void  setSkill(boolean skill){
        this.skill = skill;
    }
}
