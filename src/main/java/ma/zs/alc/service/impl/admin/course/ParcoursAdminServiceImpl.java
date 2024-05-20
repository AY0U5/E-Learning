package ma.zs.alc.service.impl.admin.course;


import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.bean.core.courseref.EtatParcours;
import ma.zs.alc.dao.criteria.core.course.ParcoursCriteria;
import ma.zs.alc.dao.facade.core.course.ParcoursDao;
import ma.zs.alc.dao.specification.core.course.ParcoursSpecification;
import ma.zs.alc.service.facade.admin.course.ParcoursAdminService;
import ma.zs.alc.service.facade.admin.courseref.EtatParcoursAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.zs.alc.service.facade.admin.inscription.EtudiantAdminService;
import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.service.facade.admin.courseref.CentreAdminService;
import ma.zs.alc.service.facade.admin.course.CoursAdminService;
import ma.zs.alc.bean.core.course.Cours;

@Service
public class ParcoursAdminServiceImpl extends AbstractServiceImpl<Parcours, ParcoursCriteria, ParcoursDao> implements ParcoursAdminService {


    public List<Parcours> findByEtatParcoursId(Long id) {
        return dao.findByEtatParcoursId(id);
    }

    public int deleteByEtatParcoursId(Long id) {
        return dao.deleteByEtatParcoursId(id);
    }

    public long countByEtatParcoursCode(String code) {
        return dao.countByEtatParcoursCode(code);
    }

    @Override
    public Parcours findByCode(String code) {
        return parcoursDao.findByCode(code);
    }

    @Override
    public int deleteByCode(String code) {
        return parcoursDao.deleteByCode(code);
    }

    @Override
    public Parcours findByLibelle(String lib) {
        return parcoursDao.findByLibelle(lib);
    }

    @Override
    public int deleteByLibelle(String Lib) {
        return parcoursDao.deleteByLibelle(Lib);
    }

    @Override
    public List<Parcours> findByCentreRef(String CentreRef) {
        return parcoursDao.findByCentreRef(CentreRef);
    }

    @Override
    public int deleteByCentreRef(String CentreRef) {
        return parcoursDao.deleteByCentreRef(CentreRef);
    }

    private @Autowired ParcoursDao parcoursDao;
    private @Autowired CentreAdminService centreAdminService;


    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Parcours create(Parcours t) {
        Parcours saved = super.create(t);
        if (saved != null && t.getCourss() != null) {
            t.getCourss().forEach(element -> {
                element.setParcours(saved);
                coursService.create(element);
            });
        }
        if (saved != null && t.getEtudiants() != null) {
            t.getEtudiants().forEach(element -> {
                element.setParcours(saved);
                etudiantService.create(element);
            });
        }
        return saved;

    }

    @Override
    public Parcours saveparcour(Parcours parcours) {
        if (parcours != null) {
            if (parcoursDao.findByCode(parcours.getCode()) == null) {
                EtatParcours etatParcours = etatParcoursService.findById(1L);
                parcours.setEtatParcours(etatParcours);
                //
//                findOrSaveAssociatedObject(parcours);
                //
                parcoursDao.save(parcours);
                return parcours;
            }
            return null;
        } else {
            return null;
        }
    }
    @Override
    public void updateParcour(Parcours parcours) {
        /*if (parcoursDao.findByCode(parcours.getCode()) != null ){
            parcoursDao.save(parcours);
        }*/
        if (parcoursDao.findById(parcours.getId()) != null ){
            parcoursDao.save(parcours);
        }
    }

    public Parcours findWithAssociatedLists(Long id) {
        Parcours result = dao.findById(id).orElse(null);
        if (result != null && result.getId() != null) {
            result.setCourss(coursService.findByParcoursId(id));
            result.setEtudiants(etudiantService.findByParcoursId(id));
        }
        return result;
    }

    @Transactional
    public void deleteAssociatedLists(Long id) {
        coursService.deleteByParcoursId(id);
        etudiantService.deleteByParcoursId(id);
    }


    public void updateWithAssociatedLists(Parcours parcours) {
        if (parcours != null && parcours.getId() != null) {
            List<List<Cours>> resultCourss = coursService.getToBeSavedAndToBeDeleted(coursService.findByParcoursId(parcours.getId()), parcours.getCourss());
            coursService.delete(resultCourss.get(1));
            ListUtil.emptyIfNull(resultCourss.get(0)).forEach(e -> e.setParcours(parcours));
            coursService.update(resultCourss.get(0), true);
            List<List<Etudiant>> resultEtudiants = etudiantService.getToBeSavedAndToBeDeleted(etudiantService.findByParcoursId(parcours.getId()), parcours.getEtudiants());
            etudiantService.delete(resultEtudiants.get(1));
            ListUtil.emptyIfNull(resultEtudiants.get(0)).forEach(e -> e.setParcours(parcours));
            etudiantService.update(resultEtudiants.get(0), true);
        }
    }


    public Parcours findByReferenceEntity(Parcours t) {
        return t == null ? null : dao.findByCode(t.getCode());
    }

    public void findOrSaveAssociatedObject(Parcours t) {
        if (t != null) {
            t.setEtatParcours(etatParcoursService.findOrSave(t.getEtatParcours()));
            t.setCentre(centreService.findOrSave(t.getCentre()));

        }
    }

    public List<Parcours> findByCentreId(Long id) {
        return dao.findByCentreId(id);
    }

    public int deleteByCentreId(Long id) {
        return dao.deleteByCentreId(id);
    }

    public long countByCentreRef(String ref) {
        return dao.countByCentreRef(ref);
    }

    public List<Parcours> findAllOptimized() {
        return dao.findAllOptimized();
    }


    public void configure() {
        super.configure(Parcours.class, ParcoursSpecification.class);
    }



    @Autowired
    private EtatParcoursAdminService etatParcoursService;
    @Autowired
    private EtudiantAdminService etudiantService;
    @Autowired
    private CentreAdminService centreService;
    @Autowired
    private CoursAdminService coursService;

    public ParcoursAdminServiceImpl(ParcoursDao dao) {
        super(dao);
    }

}
