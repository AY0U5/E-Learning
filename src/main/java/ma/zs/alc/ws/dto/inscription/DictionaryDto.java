package  ma.zs.alc.ws.dto.inscription;

import ma.zs.alc.zynerator.audit.Log;
import ma.zs.alc.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;





@JsonInclude(JsonInclude.Include.NON_NULL)
public class DictionaryDto  extends AuditBaseDto {

    private String word  ;
    private String definition  ;

    private EtudiantDto etudiant ;



    public DictionaryDto(){
        super();
    }



    @Log
    public String getWord(){
        return this.word;
    }
    public void setWord(String word){
        this.word = word;
    }

    @Log
    public String getDefinition(){
        return this.definition;
    }
    public void setDefinition(String definition){
        this.definition = definition;
    }


    public EtudiantDto getEtudiant(){
        return this.etudiant;
    }

    public void setEtudiant(EtudiantDto etudiant){
        this.etudiant = etudiant;
    }






}
