package words ;

public class FixeWordRepository extends WordRepository {

    public static final String MOT_PREDEFINI = "avion" ; 
  
    public FixeWordRepository() throws Exception {
    }
    
    public Word getWord() {
        Word mot_secret = new Word( MOT_PREDEFINI ) ; 
        return mot_secret ; 
    }

}
