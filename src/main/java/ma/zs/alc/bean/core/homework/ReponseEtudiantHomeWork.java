package ma.zs.alc.bean.core.homework;

import java.util.Objects;





import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import ma.zs.alc.bean.core.homework.HomeWorkEtudiant;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "reponse_etudiant_home_work")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ReponseEtudiantHomeWork   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String answer;
    @Column(length = 500)
    private String profNote;
    private BigDecimal note = BigDecimal.ZERO;

    private HoweWorkQSTReponse howeWorkQSTReponse ;
    private HomeWorkEtudiant homeWorkEtudiant ;
    private HomeWorkQuestion homeWorkQuestion ;


    public ReponseEtudiantHomeWork(){
        super();
    }

    public ReponseEtudiantHomeWork(Long id){
        this.id = id;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "howe_work_q_s_t_reponse")
    public HoweWorkQSTReponse getHoweWorkQSTReponse(){
        return this.howeWorkQSTReponse;
    }
    public void setHoweWorkQSTReponse(HoweWorkQSTReponse howeWorkQSTReponse){
        this.howeWorkQSTReponse = howeWorkQSTReponse;
    }
    public String getAnswer(){
        return this.answer;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_work_etudiant")
    public HomeWorkEtudiant getHomeWorkEtudiant(){
        return this.homeWorkEtudiant;
    }
    public void setHomeWorkEtudiant(HomeWorkEtudiant homeWorkEtudiant){
        this.homeWorkEtudiant = homeWorkEtudiant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_work_question")
    public HomeWorkQuestion getHomeWorkQuestion(){
        return this.homeWorkQuestion;
    }
    public void setHomeWorkQuestion(HomeWorkQuestion homeWorkQuestion){
        this.homeWorkQuestion = homeWorkQuestion;
    }
    public String getProfNote(){
        return this.profNote;
    }
    public void setProfNote(String profNote){
        this.profNote = profNote;
    }
    public BigDecimal getNote(){
        return this.note;
    }
    public void setNote(BigDecimal note){
        this.note = note;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReponseEtudiantHomeWork reponseEtudiantHomeWork = (ReponseEtudiantHomeWork) o;
        return id != null && id.equals(reponseEtudiantHomeWork.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

