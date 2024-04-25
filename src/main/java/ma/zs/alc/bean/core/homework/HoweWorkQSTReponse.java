package ma.zs.alc.bean.core.homework;

import java.util.Objects;





import ma.zs.alc.bean.core.homework.HomeWorkQuestion;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "howe_work_q_s_t_reponse")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class HoweWorkQSTReponse   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    @Column(length = 500)
    private String lib;
    @Column(length = 500)
    private String etatReponse;
    private Integer numero = 0;

    private HomeWorkQuestion homeWorkQuestion ;


    public HoweWorkQSTReponse(){
        super();
    }

    public HoweWorkQSTReponse(Long id){
        this.id = id;
    }

    public HoweWorkQSTReponse(Long id,String lib){
        this.id = id;
        this.lib = lib ;
    }
    public HoweWorkQSTReponse(String lib){
        this.lib = lib ;
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
    public String getLib(){
        return this.lib;
    }
    public void setLib(String lib){
        this.lib = lib;
    }
    public String getEtatReponse(){
        return this.etatReponse;
    }
    public void setEtatReponse(String etatReponse){
        this.etatReponse = etatReponse;
    }
    public Integer getNumero(){
        return this.numero;
    }
    public void setNumero(Integer numero){
        this.numero = numero;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_work_question")
    public HomeWorkQuestion getHomeWorkQuestion(){
        return this.homeWorkQuestion;
    }
    public void setHomeWorkQuestion(HomeWorkQuestion homeWorkQuestion){
        this.homeWorkQuestion = homeWorkQuestion;
    }

    @Transient
    public String getLabel() {
        label = lib;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoweWorkQSTReponse howeWorkQSTReponse = (HoweWorkQSTReponse) o;
        return id != null && id.equals(howeWorkQSTReponse.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

