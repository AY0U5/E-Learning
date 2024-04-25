package ma.zs.alc.bean.core.quiz;

import java.util.Objects;
import java.util.List;





import ma.zs.alc.bean.core.quiz.Quiz;
import ma.zs.alc.bean.core.quizref.TypeDeQuestion;
import ma.zs.alc.bean.core.quiz.Reponse;
import ma.zs.alc.bean.core.homework.HomeWork;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "question")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Question   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String urlImg;
    @Column(length = 500)
    private String urlVideo;
    private Long numero ;
    private BigDecimal pointReponseJuste = BigDecimal.ZERO;
    private BigDecimal pointReponsefausse = BigDecimal.ZERO;

    private TypeDeQuestion typeDeQuestion ;
    private Quiz quiz ;
    private HomeWork homeWork ;

    private List<Reponse> reponses ;

    public Question(){
        super();
    }

    public Question(Long id){
        this.id = id;
    }

    public Question(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public Question(String libelle){
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
    public String getUrlImg(){
        return this.urlImg;
    }
    public void setUrlImg(String urlImg){
        this.urlImg = urlImg;
    }
    public String getUrlVideo(){
        return this.urlVideo;
    }
    public void setUrlVideo(String urlVideo){
        this.urlVideo = urlVideo;
    }
    public Long getNumero(){
        return this.numero;
    }
    public void setNumero(Long numero){
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
    @OneToMany(mappedBy = "question")

    public List<Reponse> getReponses(){
        return this.reponses;
    }
    public void setReponses(List<Reponse> reponses){
        this.reponses = reponses;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz")
    public Quiz getQuiz(){
        return this.quiz;
    }
    public void setQuiz(Quiz quiz){
        this.quiz = quiz;
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
        Question question = (Question) o;
        return id != null && id.equals(question.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

