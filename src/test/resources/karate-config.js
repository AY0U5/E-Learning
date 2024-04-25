function fn() {

    
    var config = {};
    
   
    const rootUrlDev = 'http://localhost:8036/';
    const adminCredentialsDev = {"username": "admin","password": "123"};
    const urlDev = 'jdbc:mysql://localhost:3306/budget';

    const usernameDev = 'root';
    const passwordDev = '';
    const driverDev = 'com.mysql.cj.jdbc.Driver';


    const rootUrlInit = 'https://stage-host/';
    const adminCredentialsInit = {"username": "admin","password": "123"};
    const urlInit = 'jdbc:mysql://localhost:8036/peps-order';
    const usernameInit = 'root';
    const passwordInit = '';
    const driverInit = 'com.mysql.cj.jdbc.Driver';
    
    
    const rootUrlE2e = 'https://e2e-host/';
    const adminCredentialsE2e = {"username": "admin","password": "123"};
    const urlE2e = 'jdbc:mysql://localhost:8036/peps-order';
    const usernameE2e = 'root';
    const passwordE2e = '';
    const driverE2e = 'com.mysql.cj.jdbc.Driver';
    
    var env = karate.env; // get java system property 'karate.env'
    if (!env || env=='dev') {
        env = 'dev';
        config.rootUrl = rootUrlDev;
        config.adminCredentials = adminCredentialsDev;
        config.datasource = { username: usernameDev, password: passwordDev, url: urlDev, driverClassName: driverDev }
    }
    if (env == 'int') {
        // over-ride only those that need to be
        config.rootUrl = rootUrlInit;
        config.adminCredentials = adminCredentialsInit;
        config.datasource = { username: usernameInit, password: passwordInit, url: urlInit, driverClassName: driverInit }
    } else if (env == 'e2e') {
        config.rootUrl = rootUrlE2e;
        config.adminCredentials = adminCredentialsE2e;
        config.datasource = { username: usernameE2e, password: passwordE2e, url: urlE2e, driverClassName: driverE2e }
    }

    config.actuatorUri = config.rootUrl + 'actuator/';
    config.adminUri = config.rootUrl + 'api/admin/';

    config.etatCoursUrl = config.adminUri + 'etatCours/';
    config.howeWorkQSTReponseUrl = config.adminUri + 'howeWorkQSTReponse/';
    config.scheduleProfUrl = config.adminUri + 'scheduleProf/';
    config.freeTrialDetailUrl = config.adminUri + 'freeTrialDetail/';
    config.recommendTeacherUrl = config.adminUri + 'recommendTeacher/';
    config.reponseEtudiantUrl = config.adminUri + 'reponseEtudiant/';
    config.fonctionUrl = config.adminUri + 'fonction/';
    config.adminUrl = config.adminUri + 'admin/';
    config.typeDeQuestionUrl = config.adminUri + 'typeDeQuestion/';
    config.classRoomUrl = config.adminUri + 'classRoom/';
    config.sessionCoursUrl = config.adminUri + 'sessionCours/';
    config.homeWorkUrl = config.adminUri + 'homeWork/';
    config.superCategorieSectionUrl = config.adminUri + 'superCategorieSection/';
    config.etatEtudiantScheduleUrl = config.adminUri + 'etatEtudiantSchedule/';
    config.freeTrialConfigurationUrl = config.adminUri + 'freeTrialConfiguration/';
    config.typeReclamationEtudiantUrl = config.adminUri + 'typeReclamationEtudiant/';
    config.packStudentUrl = config.adminUri + 'packStudent/';
    config.reclamationProfUrl = config.adminUri + 'reclamationProf/';
    config.servicesUrl = config.adminUri + 'services/';
    config.trancheHoraireProfUrl = config.adminUri + 'trancheHoraireProf/';
    config.sectionItemUrl = config.adminUri + 'sectionItem/';
    config.statutSocialUrl = config.adminUri + 'statutSocial/';
    config.dictionaryUrl = config.adminUri + 'dictionary/';
    config.faqEtudiantUrl = config.adminUri + 'faqEtudiant/';
    config.workloadBonusUrl = config.adminUri + 'workloadBonus/';
    config.sessionCoursSectionUrl = config.adminUri + 'sessionCoursSection/';
    config.groupeTypeUrl = config.adminUri + 'groupeType/';
    config.groupeEtudiantUrl = config.adminUri + 'groupeEtudiant/';
    config.classAverageBonusProfUrl = config.adminUri + 'classAverageBonusProf/';
    config.categorieSectionUrl = config.adminUri + 'categorieSection/';
    config.profUrl = config.adminUri + 'prof/';
    config.centreUrl = config.adminUri + 'centre/';
    config.teacherLocalityUrl = config.adminUri + 'teacherLocality/';
    config.skillUrl = config.adminUri + 'skill/';
    config.freeTrialStudentWhatsTemplateUrl = config.adminUri + 'freeTrialStudentWhatsTemplate/';
    config.calendrierProfUrl = config.adminUri + 'calendrierProf/';
    config.etudiantUrl = config.adminUri + 'etudiant/';
    config.categorieProfUrl = config.adminUri + 'categorieProf/';
    config.questionUrl = config.adminUri + 'question/';
    config.contactUrl = config.adminUri + 'contact/';
    config.faqProfUrl = config.adminUri + 'faqProf/';
    config.niveauEtudeUrl = config.adminUri + 'niveauEtude/';
    config.etatInscriptionUrl = config.adminUri + 'etatInscription/';
    config.freeTrialformuleUrl = config.adminUri + 'freeTrialformule/';
    config.groupeEtudeUrl = config.adminUri + 'groupeEtude/';
    config.quizUrl = config.adminUri + 'quiz/';
    config.langueUrl = config.adminUri + 'langue/';
    config.workloadBonusProfUrl = config.adminUri + 'workloadBonusProf/';
    config.classAverageBonusUrl = config.adminUri + 'classAverageBonus/';
    config.quizEtudiantUrl = config.adminUri + 'quizEtudiant/';
    config.freeTrialTeacherEmailTemplateUrl = config.adminUri + 'freeTrialTeacherEmailTemplate/';
    config.coursUrl = config.adminUri + 'cours/';
    config.quizClassRoomUrl = config.adminUri + 'quizClassRoom/';
    config.paiementUrl = config.adminUri + 'paiement/';
    config.typeTeacherUrl = config.adminUri + 'typeTeacher/';
    config.homeWorkEtudiantUrl = config.adminUri + 'homeWorkEtudiant/';
    config.reclamationEtudiantUrl = config.adminUri + 'reclamationEtudiant/';
    config.typeHomeWorkUrl = config.adminUri + 'typeHomeWork/';
    config.freeTrialUrl = config.adminUri + 'freeTrial/';
    config.vocabularyQuizUrl = config.adminUri + 'vocabularyQuiz/';
    config.inscriptionUrl = config.adminUri + 'inscription/';
    config.salaryUrl = config.adminUri + 'salary/';
    config.homeWorkQuestionUrl = config.adminUri + 'homeWorkQuestion/';
    config.priceUrl = config.adminUri + 'price/';
    config.etudiantClassRoomUrl = config.adminUri + 'etudiantClassRoom/';
    config.profReviewUrl = config.adminUri + 'profReview/';
    config.faqTypeUrl = config.adminUri + 'faqType/';
    config.confirmationTokenUrl = config.adminUri + 'confirmationToken/';
    config.reponseEtudiantHomeWorkUrl = config.adminUri + 'reponseEtudiantHomeWork/';
    config.newsUrl = config.adminUri + 'news/';
    config.statutFreeTrialUrl = config.adminUri + 'statutFreeTrial/';
    config.groupeEtatUrl = config.adminUri + 'groupeEtat/';
    config.parcoursUrl = config.adminUri + 'parcours/';
    config.groupeEtudiantDetailUrl = config.adminUri + 'groupeEtudiantDetail/';
    config.inviteStudentUrl = config.adminUri + 'inviteStudent/';
    config.etudiantReviewUrl = config.adminUri + 'etudiantReview/';
    config.interetEtudiantUrl = config.adminUri + 'interetEtudiant/';
    config.etudiantCoursUrl = config.adminUri + 'etudiantCours/';
    config.freeTrialStudentEmailTemplateUrl = config.adminUri + 'freeTrialStudentEmailTemplate/';
    config.vocabularyUrl = config.adminUri + 'vocabulary/';
    config.reponseUrl = config.adminUri + 'reponse/';
    config.faqUrl = config.adminUri + 'faq/';
    config.freeTrialTeacherWhatsTemplateUrl = config.adminUri + 'freeTrialTeacherWhatsTemplate/';
    config.levelTestConfigurationUrl = config.adminUri + 'levelTestConfiguration/';
    config.typeReclamationProfUrl = config.adminUri + 'typeReclamationProf/';
    config.sectionUrl = config.adminUri + 'section/';

    common = karate.callSingle('classpath:common.feature', config);
    config.uniqueId = common.uniqueId
    config.db = common.db
    config.adminToken = common.adminToken
    config.env = env;

    karate.log('karate.env =', karate.env);
    karate.log('config =', config);
    // don't waste time waiting for a connection or if servers don't respond within 5 seconds
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    return config;
}
