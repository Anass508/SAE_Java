package words ;
import java.util.Scanner ; 
import java.util.ArrayList ;

public class Game {

  private WordRepository repository ; 
  private Word mot_secret ;  
  private String nom_joueur ; 
  private ArrayList<Word> tentatives ;
  private ArrayList<Long> temps_game ; 
  private static final int NB_TENTATIVES = 6 ;
  
  
  public Game( WordRepository Wordrepo_mode_jeu ) throws Exception {

    Scanner scan = new Scanner( System.in ) ;
    System.out.print("Veuillez entrer votre nom : ") ;

    String nom = scan.nextLine() ;  
    this.nom_joueur = nom ;
    
    this.temps_game = new ArrayList<Long>() ;
    this.tentatives = new ArrayList<Word>() ;
    this.repository = Wordrepo_mode_jeu ; 
    this.mot_secret = this.repository.getWord() ;
     
  }
  
  public void Start() {
  
    System.out.println("\nBonjour " + this.nom_joueur);
    System.out.println("=============================\n");
    
    long somme = 0 ;
    
    for( int i=1 ; i < (this.NB_TENTATIVES+1) ; i++ ) {
      
        long tic = System.currentTimeMillis() ;
      
        Scanner scan = new Scanner( System.in ) ;
        System.out.print("\nTentative " + i + " : ") ;
      
        String mot = scan.nextLine() ;
        Word tentative = new Word( mot ) ; 
      
        while ( !tentative.isAllGood() ) {
      
            System.out.println("Votre tentative est erroné ,veuillez réessayer : ") ;
            System.out.print("Tentative " + i + " : ") ;
          
            mot = scan.nextLine() ;
            tentative = new Word( mot ) ;
        
        }
      
        this.tentatives.add( tentative ) ;
      
        long temps_tour = ( System.currentTimeMillis() - tic ) ;
        System.out.println("\tTemps du tour : "+ temps_tour/1000 +"s\n") ;
        this.temps_game.add( temps_tour ) ;
      
        Affiche_tentative_game() ;
        
        if ( status_game() ) {
        
            System.out.println("Vous avez GAGNE !!!!") ;
      
            for ( long tmp : this.temps_game ) {
              somme = somme + tmp ;  
            }
          
            long temps_final = somme/1000 ;
            System.out.println("Votre temps global de partie est de : " + temps_final + " secondes" ) ;
        
            return ;
        }
      
      }
    
      System.out.println("\tPERDU : Vous avez utilisé tous vos essais") ;
      System.out.println("\tLe Mot secret : " + this.mot_secret.getMot_tentative() ) ;

    
      for ( long tmp : this.temps_game ) {
        somme = somme + tmp ;  
      }
      
      long temps_final = somme/1000 ;
      System.out.println("\tVotre temps global de partie est de : " + temps_final + " secondes" ) ;
      
      return ;
    } 
  

  public void Affiche_tentative_game() { 
  
    for( Word i : tentatives ) {
        String[] res = i.AnalyseWithSecretWord( this.mot_secret ) ;
      
        for( int z=0 ; z < 5 ; z++ ) {
          System.out.print("[ " + i.getMot_tentative().toUpperCase().charAt(z) + " ]" ) ;
        }
        
        System.out.print(" ==>") ;
      
        for( String j : res ) {
          System.out.print(" " + j ) ;
        }
    
        System.out.print("\n") ;
      }
      
      System.out.print(" \n------------------------------- \n") ;
      
  }

  public boolean status_game() {
  
    boolean fini = false ;
    Word dernier_tentative = this.tentatives.get( this.tentatives.size() - 1 ) ; 
    
    if( dernier_tentative.getMot_tentative().equals( this.mot_secret.getMot_tentative() ) ) {
      fini = true ;
    } 
   
    return fini ;
    
  }

}
