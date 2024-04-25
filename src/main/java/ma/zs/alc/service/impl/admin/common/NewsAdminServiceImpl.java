package ma.zs.alc.service.impl.admin.common;


import ma.zs.alc.bean.core.common.News;
import ma.zs.alc.dao.criteria.core.common.NewsCriteria;
import ma.zs.alc.dao.facade.core.common.NewsDao;
import ma.zs.alc.dao.specification.core.common.NewsSpecification;
import ma.zs.alc.service.facade.admin.common.NewsAdminService;
import ma.zs.alc.zynerator.service.AbstractServiceImpl;
import ma.zs.alc.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
@Service
public class NewsAdminServiceImpl extends AbstractServiceImpl<News, NewsCriteria, NewsDao> implements NewsAdminService {






    public News findByReferenceEntity(News t){
        return t==null? null : dao.findByRef(t.getRef());
    }


    public List<News> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(News.class, NewsSpecification.class);
    }



    public NewsAdminServiceImpl(NewsDao dao) {
        super(dao);
    }

}
