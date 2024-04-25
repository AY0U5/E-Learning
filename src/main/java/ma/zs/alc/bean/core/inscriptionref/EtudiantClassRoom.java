package ma.zs.alc.bean.core.inscriptionref;

import java.util.Objects;





import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.bean.core.classroom.ClassRoom;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "etudiant_class_room")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class EtudiantClassRoom   extends AuditBusinessObject     {

    private Long id;


    private ClassRoom classRoom ;
    private Etudiant etudiant ;


    public EtudiantClassRoom(){
        super();
    }

    public EtudiantClassRoom(Long id){
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
    @JoinColumn(name = "class_room")
    public ClassRoom getClassRoom(){
        return this.classRoom;
    }
    public void setClassRoom(ClassRoom classRoom){
        this.classRoom = classRoom;
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
        EtudiantClassRoom etudiantClassRoom = (EtudiantClassRoom) o;
        return id != null && id.equals(etudiantClassRoom.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

