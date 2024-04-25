package ma.zs.alc.dao.facade.core.recomrecla;

import org.springframework.data.jpa.repository.Query;
import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.recomrecla.TypeReclamationEtudiant;
import org.springframework.stereotype.Repository;
import ma.zs.alc.bean.core.recomrecla.TypeReclamationEtudiant;
import java.util.List;


@Repository
public interface TypeReclamationEtudiantDao extends AbstractRepository<TypeReclamationEtudiant,Long>  {
    TypeReclamationEtudiant findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW TypeReclamationEtudiant(item.id,item.libelle) FROM TypeReclamationEtudiant item")
    List<TypeReclamationEtudiant> findAllOptimized();

}
