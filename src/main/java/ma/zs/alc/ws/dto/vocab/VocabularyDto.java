package  ma.zs.alc.ws.dto.vocab;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



import ma.zs.alc.ws.dto.course.SectionDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class VocabularyDto  extends AuditBaseDto {

    private String ref  ;
    private Long numero  ;
    private String word  ;
    private String libelle  ;
    private String result  ;
    private String explication  ;
    private String exemple  ;
    private String image  ;

    private SectionDto section ;
    private VocabularyQuizDto vocabularyQuiz ;



    public VocabularyDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    public Long getNumero(){
        return this.numero;
    }
    public void setNumero(Long numero){
        this.numero = numero;
    }

    @Log
    public String getWord(){
        return this.word;
    }
    public void setWord(String word){
        this.word = word;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getResult(){
        return this.result;
    }
    public void setResult(String result){
        this.result = result;
    }

    @Log
    public String getExplication(){
        return this.explication;
    }
    public void setExplication(String explication){
        this.explication = explication;
    }

    @Log
    public String getExemple(){
        return this.exemple;
    }
    public void setExemple(String exemple){
        this.exemple = exemple;
    }

    @Log
    public String getImage(){
        return this.image;
    }
    public void setImage(String image){
        this.image = image;
    }


    public SectionDto getSection(){
        return this.section;
    }

    public void setSection(SectionDto section){
        this.section = section;
    }
    public VocabularyQuizDto getVocabularyQuiz(){
        return this.vocabularyQuiz;
    }

    public void setVocabularyQuiz(VocabularyQuizDto vocabularyQuiz){
        this.vocabularyQuiz = vocabularyQuiz;
    }






}
