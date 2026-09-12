package words ;

public class JsonWordRepository extends WordRepository {
  
    private WordSet wordSet ; 
  
    public JsonWordRepository() throws Exception {
        this.wordSet = new JsonWordSet("data/mots.json");
    }
  
    public Word getWord() {
        Word mot_secret = new Word( this.wordSet.random() ) ; 
        return mot_secret ; 
    }

}
