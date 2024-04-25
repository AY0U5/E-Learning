package  ma.zs.alc.ws.dto.course;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectionItemDto  extends AuditBaseDto {

    private String imageUrl  ;
    private String response  ;
    private String transcription  ;
    private String translation  ;
    private String explanation  ;
    private String example  ;
    private String synonyms  ;

    private SectionDto section ;



    public SectionItemDto(){
        super();
    }



    @Log
    public String getImageUrl(){
        return this.imageUrl;
    }
    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    @Log
    public String getResponse(){
        return this.response;
    }
    public void setResponse(String response){
        this.response = response;
    }

    @Log
    public String getTranscription(){
        return this.transcription;
    }
    public void setTranscription(String transcription){
        this.transcription = transcription;
    }

    @Log
    public String getTranslation(){
        return this.translation;
    }
    public void setTranslation(String translation){
        this.translation = translation;
    }

    @Log
    public String getExplanation(){
        return this.explanation;
    }
    public void setExplanation(String explanation){
        this.explanation = explanation;
    }

    @Log
    public String getExample(){
        return this.example;
    }
    public void setExample(String example){
        this.example = example;
    }

    @Log
    public String getSynonyms(){
        return this.synonyms;
    }
    public void setSynonyms(String synonyms){
        this.synonyms = synonyms;
    }


    public SectionDto getSection(){
        return this.section;
    }

    public void setSection(SectionDto section){
        this.section = section;
    }






}
