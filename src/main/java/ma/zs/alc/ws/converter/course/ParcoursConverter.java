package ma.zs.alc.ws.converter.course;

import ma.zs.alc.ws.converter.courseref.EtatParcoursConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.zs.alc.zynerator.util.ListUtil;

import ma.zs.alc.ws.converter.quizetudiant.QuizEtudiantConverter;
import ma.zs.alc.ws.converter.inscriptionref.EtatEtudiantScheduleConverter;
import ma.zs.alc.ws.converter.inscriptionref.InteretEtudiantConverter;
import ma.zs.alc.ws.converter.inscription.EtudiantConverter;
import ma.zs.alc.ws.converter.inscriptionref.StatutSocialConverter;
import ma.zs.alc.ws.converter.inscriptionref.LangueConverter;
import ma.zs.alc.ws.converter.grpe.GroupeEtudiantConverter;
import ma.zs.alc.ws.converter.course.SectionConverter;
import ma.zs.alc.ws.converter.courseref.CentreConverter;
import ma.zs.alc.ws.converter.course.CoursConverter;
import ma.zs.alc.ws.converter.grpe.GroupeEtudeConverter;
import ma.zs.alc.ws.converter.homework.HomeWorkConverter;
import ma.zs.alc.ws.converter.inscriptionref.SkillConverter;
import ma.zs.alc.ws.converter.inscriptionref.FonctionConverter;
import ma.zs.alc.ws.converter.pack.PackStudentConverter;
import ma.zs.alc.ws.converter.grpe.GroupeEtudiantDetailConverter;
import ma.zs.alc.ws.converter.inscriptionref.TeacherLocalityConverter;
import ma.zs.alc.ws.converter.inscriptionref.NiveauEtudeConverter;

import ma.zs.alc.bean.core.courseref.Centre;


import ma.zs.alc.zynerator.util.StringUtil;
import ma.zs.alc.zynerator.converter.AbstractConverter;
import ma.zs.alc.zynerator.util.DateUtil;
import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.ws.dto.course.ParcoursDto;

@Component
public class ParcoursConverter extends AbstractConverter<Parcours, ParcoursDto> {

    @Autowired
    private EtatParcoursConverter etatParcoursConverter;
    @Autowired
    private QuizEtudiantConverter quizEtudiantConverter;
    @Autowired
    private EtatEtudiantScheduleConverter etatEtudiantScheduleConverter;
    @Autowired
    private InteretEtudiantConverter interetEtudiantConverter;
    @Autowired
    private EtudiantConverter etudiantConverter;
    @Autowired
    private StatutSocialConverter statutSocialConverter;
    @Autowired
    private LangueConverter langueConverter;
    @Autowired
    private GroupeEtudiantConverter groupeEtudiantConverter;

    @Autowired
    private SectionConverter sectionConverter;
    @Autowired
    private CentreConverter centreConverter;
    @Autowired
    private CoursConverter coursConverter;
    @Autowired
    private GroupeEtudeConverter groupeEtudeConverter;
    @Autowired
    private HomeWorkConverter homeWorkConverter;
    @Autowired
    private SkillConverter skillConverter;
    @Autowired
    private FonctionConverter fonctionConverter;
    @Autowired
    private PackStudentConverter packStudentConverter;
    @Autowired
    private GroupeEtudiantDetailConverter groupeEtudiantDetailConverter;
    @Autowired
    private TeacherLocalityConverter teacherLocalityConverter;
    @Autowired
    private NiveauEtudeConverter niveauEtudeConverter;
    private boolean etatParcours;
    private boolean centre;
    private boolean courss;
    private boolean etudiants;

    public ParcoursConverter() {
        super(Parcours.class, ParcoursDto.class);
        init(true);
    }

    @Override
    public Parcours toItem(ParcoursDto dto) {
        if (dto == null) {
            return null;
        } else {
            Parcours item = new Parcours();
            if (StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if (StringUtil.isNotEmpty(dto.getDatePublication()))
                item.setDatePublication(DateUtil.stringEnToDate(dto.getDatePublication()));
            if (StringUtil.isNotEmpty(dto.getDateCreation()))
                item.setDateCreation(DateUtil.stringEnToDate(dto.getDateCreation()));
            if (StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if (StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if (StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if (StringUtil.isNotEmpty(dto.getNumeroOrder()))
                item.setNumeroOrder(dto.getNumeroOrder());
            if (StringUtil.isNotEmpty(dto.getNombreCours()))
                item.setNombreCours(dto.getNombreCours());
            if (this.etatParcours && dto.getEtatParcours() != null)
                item.setEtatParcours(etatParcoursConverter.toItem(dto.getEtatParcours()));

            if (dto.getCentre() != null && dto.getCentre().getId() != null) {
                item.setCentre(new Centre());
                item.getCentre().setId(dto.getCentre().getId());
                item.getCentre().setRef(dto.getCentre().getRef());
            }


            if (this.courss && ListUtil.isNotEmpty(dto.getCourss()))
                item.setCourss(coursConverter.toItem(dto.getCourss()));
            if (this.etudiants && ListUtil.isNotEmpty(dto.getEtudiants()))
                item.setEtudiants(etudiantConverter.toItem(dto.getEtudiants()));


            return item;
        }
    }

    @Override
    public ParcoursDto toDto(Parcours item) {
        if (item == null) {
            return null;
        } else {
            ParcoursDto dto = new ParcoursDto();
            if (StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if (item.getDatePublication() != null)
                dto.setDatePublication(DateUtil.dateTimeToString(item.getDatePublication()));
            if (item.getDateCreation() != null)
                dto.setDateCreation(DateUtil.dateTimeToString(item.getDateCreation()));
            if (StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if (StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if (StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if (StringUtil.isNotEmpty(item.getNumeroOrder()))
                dto.setNumeroOrder(item.getNumeroOrder());
            if (StringUtil.isNotEmpty(item.getNombreCours()))
                dto.setNombreCours(item.getNombreCours());
            if (this.etatParcours && item.getEtatParcours() != null) {
                dto.setEtatParcours(etatParcoursConverter.toDto(item.getEtatParcours()));
            }
                if (this.centre && item.getCentre() != null) {
                    dto.setCentre(centreConverter.toDto(item.getCentre()));

                }
                if (this.courss && ListUtil.isNotEmpty(item.getCourss())) {
                    coursConverter.init(true);
                    coursConverter.setParcours(false);
                    dto.setCourss(coursConverter.toDto(item.getCourss()));
                    coursConverter.setParcours(true);

                }
                if (this.etudiants && ListUtil.isNotEmpty(item.getEtudiants())) {
                    etudiantConverter.init(true);
                    etudiantConverter.setParcours(false);
                    dto.setEtudiants(etudiantConverter.toDto(item.getEtudiants()));
                    etudiantConverter.setParcours(true);

                }


                return dto;
            }
        }

        public void copy (ParcoursDto dto, Parcours t){
            super.copy(dto, t);

            if (dto.getEtatParcours() != null)
                etatParcoursConverter.copy(dto.getEtatParcours(), t.getEtatParcours());
            if (dto.getCentre() != null)
                centreConverter.copy(dto.getCentre(), t.getCentre());
            if (dto.getCourss() != null)
                t.setCourss(coursConverter.copy(dto.getCourss()));
            if (dto.getEtudiants() != null)
                t.setEtudiants(etudiantConverter.copy(dto.getEtudiants()));
        }


        public void initList ( boolean value){
            this.courss = value;
            this.etudiants = value;
        }

        public void initObject ( boolean value){
            this.etatParcours = value;
            this.centre = value;
        }


        public QuizEtudiantConverter getQuizEtudiantConverter () {
            return this.quizEtudiantConverter;
        }
        public void setQuizEtudiantConverter (QuizEtudiantConverter quizEtudiantConverter ){
            this.quizEtudiantConverter = quizEtudiantConverter;
        }
        public EtatEtudiantScheduleConverter getEtatEtudiantScheduleConverter () {
            return this.etatEtudiantScheduleConverter;
        }
        public void setEtatEtudiantScheduleConverter (EtatEtudiantScheduleConverter etatEtudiantScheduleConverter ){
            this.etatEtudiantScheduleConverter = etatEtudiantScheduleConverter;
        }
        public InteretEtudiantConverter getInteretEtudiantConverter () {
            return this.interetEtudiantConverter;
        }
        public void setInteretEtudiantConverter (InteretEtudiantConverter interetEtudiantConverter ){
            this.interetEtudiantConverter = interetEtudiantConverter;
        }
        public EtudiantConverter getEtudiantConverter () {
            return this.etudiantConverter;
        }
        public void setEtudiantConverter (EtudiantConverter etudiantConverter ){
            this.etudiantConverter = etudiantConverter;
        }
        public StatutSocialConverter getStatutSocialConverter () {
            return this.statutSocialConverter;
        }
        public void setStatutSocialConverter (StatutSocialConverter statutSocialConverter ){
            this.statutSocialConverter = statutSocialConverter;
        }
        public LangueConverter getLangueConverter () {
            return this.langueConverter;
        }
        public void setLangueConverter (LangueConverter langueConverter ){
            this.langueConverter = langueConverter;
        }
        public GroupeEtudiantConverter getGroupeEtudiantConverter () {
            return this.groupeEtudiantConverter;
        }
        public void setGroupeEtudiantConverter (GroupeEtudiantConverter groupeEtudiantConverter ){
            this.groupeEtudiantConverter = groupeEtudiantConverter;
        }
        public EtatParcoursConverter getEtatParcoursConverter () {
            return this.etatParcoursConverter;
        }
        public void setEtatParcoursConverter (EtatParcoursConverter etatParcoursConverter ){
            this.etatParcoursConverter = etatParcoursConverter;
        }
        public SectionConverter getSectionConverter () {
            return this.sectionConverter;
        }
        public void setSectionConverter (SectionConverter sectionConverter ){
            this.sectionConverter = sectionConverter;
        }

        public CentreConverter getCentreConverter () {
            return this.centreConverter;
        }
        public void setCentreConverter (CentreConverter centreConverter ){
            this.centreConverter = centreConverter;
        }
        public CoursConverter getCoursConverter () {
            return this.coursConverter;
        }
        public void setCoursConverter (CoursConverter coursConverter ){
            this.coursConverter = coursConverter;
        }
        public GroupeEtudeConverter getGroupeEtudeConverter () {
            return this.groupeEtudeConverter;
        }
        public void setGroupeEtudeConverter (GroupeEtudeConverter groupeEtudeConverter ){
            this.groupeEtudeConverter = groupeEtudeConverter;
        }
        public HomeWorkConverter getHomeWorkConverter () {
            return this.homeWorkConverter;
        }
        public void setHomeWorkConverter (HomeWorkConverter homeWorkConverter ){
            this.homeWorkConverter = homeWorkConverter;
        }
        public SkillConverter getSkillConverter () {
            return this.skillConverter;
        }
        public void setSkillConverter (SkillConverter skillConverter ){
            this.skillConverter = skillConverter;
        }
        public FonctionConverter getFonctionConverter () {
            return this.fonctionConverter;
        }
        public void setFonctionConverter (FonctionConverter fonctionConverter ){
            this.fonctionConverter = fonctionConverter;
        }
        public PackStudentConverter getPackStudentConverter () {
            return this.packStudentConverter;
        }
        public void setPackStudentConverter (PackStudentConverter packStudentConverter ){
            this.packStudentConverter = packStudentConverter;
        }
        public GroupeEtudiantDetailConverter getGroupeEtudiantDetailConverter () {
            return this.groupeEtudiantDetailConverter;
        }
        public void setGroupeEtudiantDetailConverter (GroupeEtudiantDetailConverter groupeEtudiantDetailConverter ){
            this.groupeEtudiantDetailConverter = groupeEtudiantDetailConverter;
        }
        public TeacherLocalityConverter getTeacherLocalityConverter () {
            return this.teacherLocalityConverter;
        }
        public void setTeacherLocalityConverter (TeacherLocalityConverter teacherLocalityConverter ){
            this.teacherLocalityConverter = teacherLocalityConverter;
        }
        public NiveauEtudeConverter getNiveauEtudeConverter () {
            return this.niveauEtudeConverter;
        }
        public void setNiveauEtudeConverter (NiveauEtudeConverter niveauEtudeConverter ){
            this.niveauEtudeConverter = niveauEtudeConverter;
        }
        public boolean isEtatParcours () {
            return this.etatParcours;
        }
        public void setEtatParcours ( boolean etatParcours){
            this.etatParcours = etatParcours;
        }
        public boolean isCentre () {
            return this.centre;
        }
        public void setCentre ( boolean centre){
            this.centre = centre;
        }
        public boolean isCourss () {
            return this.courss;
        }
        public void setCourss ( boolean courss ){
            this.courss = courss;
        }
        public boolean isEtudiants () {
            return this.etudiants;
        }
        public void setEtudiants ( boolean etudiants ){
            this.etudiants = etudiants;
        }
    }
