package  ma.zs.alc.dao.criteria.core.inscription;



import ma.zs.alc.zynerator.criteria.BaseCriteria;
import java.util.List;

public class DictionaryCriteria extends  BaseCriteria  {

    private String word;
    private String wordLike;
    private String definition;
    private String definitionLike;

    private EtudiantCriteria etudiant ;
    private List<EtudiantCriteria> etudiants ;


    public DictionaryCriteria(){}

    public String getWord(){
        return this.word;
    }
    public void setWord(String word){
        this.word = word;
    }
    public String getWordLike(){
        return this.wordLike;
    }
    public void setWordLike(String wordLike){
        this.wordLike = wordLike;
    }

    public String getDefinition(){
        return this.definition;
    }
    public void setDefinition(String definition){
        this.definition = definition;
    }
    public String getDefinitionLike(){
        return this.definitionLike;
    }
    public void setDefinitionLike(String definitionLike){
        this.definitionLike = definitionLike;
    }


    public EtudiantCriteria getEtudiant(){
        return this.etudiant;
    }

    public void setEtudiant(EtudiantCriteria etudiant){
        this.etudiant = etudiant;
    }
    public List<EtudiantCriteria> getEtudiants(){
        return this.etudiants;
    }

    public void setEtudiants(List<EtudiantCriteria> etudiants){
        this.etudiants = etudiants;
    }
}
