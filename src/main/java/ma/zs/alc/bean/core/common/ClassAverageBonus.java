package ma.zs.alc.bean.core.common;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "class_average_bonus")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ClassAverageBonus   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    private Integer nombreSession = 0;
    private BigDecimal prix = BigDecimal.ZERO;



    public ClassAverageBonus(){
        super();
    }

    public ClassAverageBonus(Long id){
        this.id = id;
    }

    public ClassAverageBonus(Long id,String code){
        this.id = id;
        this.code = code ;
    }
    public ClassAverageBonus(String code){
        this.code = code ;
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
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public Integer getNombreSession(){
        return this.nombreSession;
    }
    public void setNombreSession(Integer nombreSession){
        this.nombreSession = nombreSession;
    }
    public BigDecimal getPrix(){
        return this.prix;
    }
    public void setPrix(BigDecimal prix){
        this.prix = prix;
    }

    @Transient
    public String getLabel() {
        label = code;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassAverageBonus classAverageBonus = (ClassAverageBonus) o;
        return id != null && id.equals(classAverageBonus.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

