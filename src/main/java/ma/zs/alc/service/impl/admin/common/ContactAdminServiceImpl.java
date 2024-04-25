package ma.zs.alc.service.impl.admin.common;


import ma.zs.alc.bean.core.common.Contact;
import ma.zs.alc.dao.criteria.core.common.ContactCriteria;
import ma.zs.alc.dao.facade.core.common.ContactDao;
import ma.zs.alc.dao.specification.core.common.ContactSpecification;
import ma.zs.alc.service.facade.admin.common.ContactAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class ContactAdminServiceImpl extends AbstractServiceImpl<Contact, ContactCriteria, ContactDao> implements ContactAdminService {













    public void configure() {
        super.configure(Contact.class, ContactSpecification.class);
    }



    public ContactAdminServiceImpl(ContactDao dao) {
        super(dao);
    }

}
