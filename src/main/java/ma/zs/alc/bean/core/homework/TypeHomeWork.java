package ma.zs.alc.bean.core.homework;

import java.util.Objects;







import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "type_home_work")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TypeHomeWork   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String lib;



    public TypeHomeWork(){
        super();
    }

    public TypeHomeWork(Long id){
        this.id = id;
    }

    public TypeHomeWork(Long id,String lib){
        this.id = id;
        this.lib = lib ;
    }
    public TypeHomeWork(String lib){
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
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getLib(){
        return this.lib;
    }
    public void setLib(String lib){
        this.lib = lib;
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
        TypeHomeWork typeHomeWork = (TypeHomeWork) o;
        return id != null && id.equals(typeHomeWork.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

