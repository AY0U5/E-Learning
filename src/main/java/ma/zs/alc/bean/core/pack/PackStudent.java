package ma.zs.alc.bean.core.pack;

import java.util.Objects;





import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.bean.core.price.Price;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "pack_student")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PackStudent   extends AuditBusinessObject     {

    private Long id;

    private Integer nombreCours = 0;
    @Column(columnDefinition = "boolean default false")
    private Boolean forGroupe = false;
    @Column(length = 500)
    private String code;
    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String description;
    @Column(length = 500)
    private String preRequisites;
    @Column(length = 500)
    private String whyTakeThisCourse;
    @Column(length = 500)
    private String expectations;
    @Column(length = 500)
    private String imgUrl;
    private Integer totalStudents = 0;
    @Column(length = 500)
    private String rating;
    @Column(length = 500)
    private String oldPrice;

    private Parcours parcours ;
    private Price price ;


    public PackStudent(){
        super();
    }

    public PackStudent(Long id){
        this.id = id;
    }

    public PackStudent(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }
    public PackStudent(String libelle){
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
    public Integer getNombreCours(){
        return this.nombreCours;
    }
    public void setNombreCours(Integer nombreCours){
        this.nombreCours = nombreCours;
    }
    public Boolean  getForGroupe(){
        return this.forGroupe;
    }
    public void setForGroupe(Boolean forGroupe){
        this.forGroupe = forGroupe;
    }
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getPreRequisites(){
        return this.preRequisites;
    }
    public void setPreRequisites(String preRequisites){
        this.preRequisites = preRequisites;
    }
    public String getWhyTakeThisCourse(){
        return this.whyTakeThisCourse;
    }
    public void setWhyTakeThisCourse(String whyTakeThisCourse){
        this.whyTakeThisCourse = whyTakeThisCourse;
    }
    public String getExpectations(){
        return this.expectations;
    }
    public void setExpectations(String expectations){
        this.expectations = expectations;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parcours")
    public Parcours getParcours(){
        return this.parcours;
    }
    public void setParcours(Parcours parcours){
        this.parcours = parcours;
    }
    public String getImgUrl(){
        return this.imgUrl;
    }
    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "price")
    public Price getPrice(){
        return this.price;
    }
    public void setPrice(Price price){
        this.price = price;
    }
    public Integer getTotalStudents(){
        return this.totalStudents;
    }
    public void setTotalStudents(Integer totalStudents){
        this.totalStudents = totalStudents;
    }
    public String getRating(){
        return this.rating;
    }
    public void setRating(String rating){
        this.rating = rating;
    }
    public String getOldPrice(){
        return this.oldPrice;
    }
    public void setOldPrice(String oldPrice){
        this.oldPrice = oldPrice;
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
        PackStudent packStudent = (PackStudent) o;
        return id != null && id.equals(packStudent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

