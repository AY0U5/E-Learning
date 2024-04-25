package ma.zs.alc.bean.core.quizetudiant;

import java.util.Objects;





import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import ma.zs.alc.bean.core.quiz.Question;
import ma.zs.alc.bean.core.quiz.Reponse;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "reponse_etudiant")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ReponseEtudiant   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String answer;
    private BigDecimal note = BigDecimal.ZERO;

    private Reponse reponse ;
    private QuizEtudiant quizEtudiant ;
    private Question question ;


    public ReponseEtudiant(){
        super();
    }

    public ReponseEtudiant(Long id){
        this.id = id;
    }

    public ReponseEtudiant(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public ReponseEtudiant(String ref){
        this.ref = ref ;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reponse")
    public Reponse getReponse(){
        return this.reponse;
    }
    public void setReponse(Reponse reponse){
        this.reponse = reponse;
    }
    public String getAnswer(){
        return this.answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_etudiant")
    public QuizEtudiant getQuizEtudiant(){
        return this.quizEtudiant;
    }
    public void setQuizEtudiant(QuizEtudiant quizEtudiant){
        this.quizEtudiant = quizEtudiant;
    }
    public BigDecimal getNote(){
        return this.note;
    }
    public void setNote(BigDecimal note){
        this.note = note;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question")
    public Question getQuestion(){
        return this.question;
    }
    public void setQuestion(Question question){
        this.question = question;
    }

    @Transient
    public String getLabel() {
        label = ref;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReponseEtudiant reponseEtudiant = (ReponseEtudiant) o;
        return id != null && id.equals(reponseEtudiant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

