package ma.zs.alc.dao.facade.core.alc;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.alc.Admin;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface AdminDao extends AbstractRepository<Admin,Long>  {

    Admin findByUsername(String username);


}
