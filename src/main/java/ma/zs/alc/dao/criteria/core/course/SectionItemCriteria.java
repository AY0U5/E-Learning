package  ma.zs.alc.dao.criteria.core.course;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SectionItemCriteria extends  BaseCriteria  {

    private String imageUrl;
    private String imageUrlLike;
    private String response;
    private String responseLike;
    private String transcription;
    private String transcriptionLike;
    private String translation;
    private String translationLike;
    private String explanation;
    private String explanationLike;
    private String example;
    private String exampleLike;
    private String synonyms;
    private String synonymsLike;

    private SectionCriteria section ;
    private List<SectionCriteria> sections ;


    public SectionItemCriteria(){}

    public String getImageUrl(){
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public String getImageUrlLike(){
        return this.imageUrlLike;
    }
    public void setImageUrlLike(String imageUrlLike){
        this.imageUrlLike = imageUrlLike;
    }

    public String getResponse(){
        return this.response;
    }
    public void setResponse(String response){
        this.response = response;
    }
    public String getResponseLike(){
        return this.responseLike;
    }
    public void setResponseLike(String responseLike){
        this.responseLike = responseLike;
    }

    public String getTranscription(){
        return this.transcription;
    }
    public void setTranscription(String transcription){
        this.transcription = transcription;
    }
    public String getTranscriptionLike(){
        return this.transcriptionLike;
    }
    public void setTranscriptionLike(String transcriptionLike){
        this.transcriptionLike = transcriptionLike;
    }

    public String getTranslation(){
        return this.translation;
    }
    public void setTranslation(String translation){
        this.translation = translation;
    }
    public String getTranslationLike(){
        return this.translationLike;
    }
    public void setTranslationLike(String translationLike){
        this.translationLike = translationLike;
    }

    public String getExplanation(){
        return this.explanation;
    }
    public void setExplanation(String explanation){
        this.explanation = explanation;
    }
    public String getExplanationLike(){
        return this.explanationLike;
    }
    public void setExplanationLike(String explanationLike){
        this.explanationLike = explanationLike;
    }

    public String getExample(){
        return this.example;
    }
    public void setExample(String example){
        this.example = example;
    }
    public String getExampleLike(){
        return this.exampleLike;
    }
    public void setExampleLike(String exampleLike){
        this.exampleLike = exampleLike;
    }

    public String getSynonyms(){
        return this.synonyms;
    }
    public void setSynonyms(String synonyms){
        this.synonyms = synonyms;
    }
    public String getSynonymsLike(){
        return this.synonymsLike;
    }
    public void setSynonymsLike(String synonymsLike){
        this.synonymsLike = synonymsLike;
    }


    public SectionCriteria getSection(){
        return this.section;
    }

    public void setSection(SectionCriteria section){
        this.section = section;
    }
    public List<SectionCriteria> getSections(){
        return this.sections;
    }

    public void setSections(List<SectionCriteria> sections){
        this.sections = sections;
    }
}
