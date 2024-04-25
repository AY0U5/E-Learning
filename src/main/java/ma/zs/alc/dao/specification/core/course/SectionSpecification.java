package  ma.zs.alc.dao.specification.core.course;

import ma.zs.alc.dao.criteria.core.course.SectionCriteria;
import ma.zs.alc.bean.core.course.Section;
import ma.zs.alc.zynerator.specification.AbstractSpecification;


public class SectionSpecification extends  AbstractSpecification<SectionCriteria, Section>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("urlImage", criteria.getUrlImage(),criteria.getUrlImageLike());
        addPredicate("urlImage2", criteria.getUrlImage2(),criteria.getUrlImage2Like());
        addPredicate("urlImage3", criteria.getUrlImage3(),criteria.getUrlImage3Like());
        addPredicate("urlVideo", criteria.getUrlVideo(),criteria.getUrlVideoLike());
        addPredicate("contenu", criteria.getContenu(),criteria.getContenuLike());
        addPredicate("questions", criteria.getQuestions(),criteria.getQuestionsLike());
        addPredicate("indicationProf", criteria.getIndicationProf(),criteria.getIndicationProfLike());
        addPredicateInt("numeroOrder", criteria.getNumeroOrder(), criteria.getNumeroOrderMin(), criteria.getNumeroOrderMax());
        addPredicateInt("url", criteria.getUrl(), criteria.getUrlMin(), criteria.getUrlMax());
        addPredicateInt("content", criteria.getContent(), criteria.getContentMin(), criteria.getContentMax());
        addPredicateFk("categorieSection","id", criteria.getCategorieSection()==null?null:criteria.getCategorieSection().getId());
        addPredicateFk("categorieSection","id", criteria.getCategorieSections());
        addPredicateFk("categorieSection","code", criteria.getCategorieSection()==null?null:criteria.getCategorieSection().getCode());
        addPredicateFk("cours","id", criteria.getCours()==null?null:criteria.getCours().getId());
        addPredicateFk("cours","id", criteria.getCourss());
        addPredicateFk("cours","code", criteria.getCours()==null?null:criteria.getCours().getCode());
    }

    public SectionSpecification(SectionCriteria criteria) {
        super(criteria);
    }

    public SectionSpecification(SectionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
