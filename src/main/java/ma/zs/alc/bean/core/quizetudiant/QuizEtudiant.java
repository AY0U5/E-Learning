package ma.zs.alc.bean.core.quizetudiant;

import java.util.Objects;
import java.util.List;





import ma.zs.alc.bean.core.quiz.Quiz;
import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant;
import ma.zs.alc.bean.core.quiz.Question;
import ma.zs.alc.bean.core.quiz.Reponse;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "quiz_etudiant")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class QuizEtudiant   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    private BigDecimal note = BigDecimal.ZERO;
    @Column(length = 500)
    private String resultat;
    private Long questionCurrent ;

    private Etudiant etudiant ;
    private Quiz quiz ;

    private List<ReponseEtudiant> reponseEtudiants ;

    public QuizEtudiant(){
        super();
    }

    public QuizEtudiant(Long id){
        this.id = id;
    }

    public QuizEtudiant(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }
    public QuizEtudiant(String ref){
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
    @JoinColumn(name = "etudiant")
    public Etudiant getEtudiant(){
        return this.etudiant;
    }
    public void setEtudiant(Etudiant etudiant){
        this.etudiant = etudiant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz")
    public Quiz getQuiz(){
        return this.quiz;
    }
    public void setQuiz(Quiz quiz){
        this.quiz = quiz;
    }
    @OneToMany(mappedBy = "quizEtudiant")

    public List<ReponseEtudiant> getReponseEtudiants(){
        return this.reponseEtudiants;
    }
    public void setReponseEtudiants(List<ReponseEtudiant> reponseEtudiants){
        this.reponseEtudiants = reponseEtudiants;
    }
    public BigDecimal getNote(){
        return this.note;
    }
    public void setNote(BigDecimal note){
        this.note = note;
    }
    public String getResultat(){
        return this.resultat;
    }
    public void setResultat(String resultat){
        this.resultat = resultat;
    }
    public Long getQuestionCurrent(){
        return this.questionCurrent;
    }
    public void setQuestionCurrent(Long questionCurrent){
        this.questionCurrent = questionCurrent;
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
        QuizEtudiant quizEtudiant = (QuizEtudiant) o;
        return id != null && id.equals(quizEtudiant.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

