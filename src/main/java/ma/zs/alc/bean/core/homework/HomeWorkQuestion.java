package ma.zs.alc.bean.core.homework;

import java.util.Objects;
import java.util.List;





import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import ma.zs.alc.bean.core.quizref.TypeDeQuestion;
import ma.zs.alc.bean.core.homework.HomeWork;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "home_work_question")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class HomeWorkQuestion   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String libelle;
    private Integer numero = 0;
    private BigDecimal pointReponseJuste = BigDecimal.ZERO;
    private BigDecimal pointReponsefausse = BigDecimal.ZERO;

    private TypeDeQuestion typeDeQuestion ;
    private HomeWork homeWork ;

    private List<HoweWorkQSTReponse> howeWorkQSTReponses ;

    public HomeWorkQuestion(){
        super();
    }

    public HomeWorkQuestion(Long id){
        this.id = id;
    }

    public HomeWorkQuestion(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public HomeWorkQuestion(String libelle){
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public Integer getNumero(){
        return this.numero;
    }
    public void setNumero(Integer numero){
        this.numero = numero;
    }
    public BigDecimal getPointReponseJuste(){
        return this.pointReponseJuste;
    }
    public void setPointReponseJuste(BigDecimal pointReponseJuste){
        this.pointReponseJuste = pointReponseJuste;
    }
    public BigDecimal getPointReponsefausse(){
        return this.pointReponsefausse;
    }
    public void setPointReponsefausse(BigDecimal pointReponsefausse){
        this.pointReponsefausse = pointReponsefausse;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_de_question")
    public TypeDeQuestion getTypeDeQuestion(){
        return this.typeDeQuestion;
    }
    public void setTypeDeQuestion(TypeDeQuestion typeDeQuestion){
        this.typeDeQuestion = typeDeQuestion;
    }
    @OneToMany(mappedBy = "homeWorkQuestion")

    public List<HoweWorkQSTReponse> getHoweWorkQSTReponses(){
        return this.howeWorkQSTReponses;
    }
    public void setHoweWorkQSTReponses(List<HoweWorkQSTReponse> howeWorkQSTReponses){
        this.howeWorkQSTReponses = howeWorkQSTReponses;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_work")
    public HomeWork getHomeWork(){
        return this.homeWork;
    }
    public void setHomeWork(HomeWork homeWork){
        this.homeWork = homeWork;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeWorkQuestion homeWorkQuestion = (HomeWorkQuestion) o;
        return id != null && id.equals(homeWorkQuestion.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

