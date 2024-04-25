package ma.zs.alc.bean.core.course;

import java.util.Objects;





import ma.zs.alc.bean.core.course.Section;


import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.alc.zynerator.audit.AuditBusinessObject;
import jakarta.persistence.*;
import java.util.Objects;




@Entity
@Table(name = "section_item")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class SectionItem   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String imageUrl;
    @Column(length = 500)
    private String response;
    @Column(length = 500)
    private String transcription;
    @Column(length = 500)
    private String translation;
    @Column(length = 500)
    private String explanation;
    @Column(length = 500)
    private String example;
    @Column(length = 500)
    private String synonyms;

    private Section section ;


    public SectionItem(){
        super();
    }

    public SectionItem(Long id){
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
    public String getImageUrl(){
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public String getResponse(){
        return this.response;
    }
    public void setResponse(String response){
        this.response = response;
    }
    public String getTranscription(){
        return this.transcription;
    }
    public void setTranscription(String transcription){
        this.transcription = transcription;
    }
    public String getTranslation(){
        return this.translation;
    }
    public void setTranslation(String translation){
        this.translation = translation;
    }
    public String getExplanation(){
        return this.explanation;
    }
    public void setExplanation(String explanation){
        this.explanation = explanation;
    }
    public String getExample(){
        return this.example;
    }
    public void setExample(String example){
        this.example = example;
    }
    public String getSynonyms(){
        return this.synonyms;
    }
    public void setSynonyms(String synonyms){
        this.synonyms = synonyms;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section")
    public Section getSection(){
        return this.section;
    }
    public void setSection(Section section){
        this.section = section;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionItem sectionItem = (SectionItem) o;
        return id != null && id.equals(sectionItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

