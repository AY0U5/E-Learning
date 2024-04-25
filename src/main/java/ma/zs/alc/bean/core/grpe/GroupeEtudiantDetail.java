package ma.zs.alc.bean.core.grpe;

import java.util.Objects;





import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.grpe.GroupeEtudiant;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "groupe_etudiant_detail")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class GroupeEtudiantDetail   extends AuditBusinessObject     {

    private Long id;


    private GroupeEtudiant groupeEtudiant ;
    private Etudiant etudiant ;


    public GroupeEtudiantDetail(){
        super();
    }

    public GroupeEtudiantDetail(Long id){
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
    @JoinColumn(name = "groupe_etudiant")
    public GroupeEtudiant getGroupeEtudiant(){
        return this.groupeEtudiant;
    }
    public void setGroupeEtudiant(GroupeEtudiant groupeEtudiant){
        this.groupeEtudiant = groupeEtudiant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant")
    public Etudiant getEtudiant(){
        return this.etudiant;
    }
    public void setEtudiant(Etudiant etudiant){
        this.etudiant = etudiant;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupeEtudiantDetail groupeEtudiantDetail = (GroupeEtudiantDetail) o;
        return id != null && id.equals(groupeEtudiantDetail.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

