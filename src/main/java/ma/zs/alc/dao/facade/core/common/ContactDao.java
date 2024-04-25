package ma.zs.alc.dao.facade.core.common;

import ma.zs.alc.zynerator.repository.AbstractRepository;
import ma.zs.alc.bean.core.common.Contact;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ContactDao extends AbstractRepository<Contact,Long>  {



}
