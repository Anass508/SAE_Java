package words ;
import java.util.Scanner ;

public class Main {

  public static void main (String[] args) {
    
    System.out.println("=====================================");
    System.out.println("FIND MY WORD - BUT1");
    System.out.println("=====================================");
    System.out.println();
    
    boolean restart_game = true ;
    Scanner restart = new Scanner(System.in) ;
    
    while ( restart_game ) {
      
      try {
      
        boolean ok = false ;
        String mode_jeux ;
        
        
        while ( !ok ) {
        
            System.out.println(" * '1' Jeu Cassique -- 'utilisation d'un mot au hasard' ");
            System.out.println(" * '2' Mode Test -- 'utilisation d'un mot prédéfini -- teste' ");
            System.out.print("\nVeuillez entre votre Mode de jeu : ");
            mode_jeux = restart.nextLine().trim();
        
            if( mode_jeux.equals("2") ) {      
              WordRepository Wordrepo_mode_jeu = new FixeWordRepository() ; 
              Game nouvelle_game = new Game( Wordrepo_mode_jeu );
              nouvelle_game.Start(); 
              ok = true ;
            } 
        
            if( mode_jeux.equals("1") ) {
              WordRepository Wordrepo_mode_jeu = new JsonWordRepository() ; 
              Game nouvelle_game = new Game( Wordrepo_mode_jeu );
              nouvelle_game.Start();
              ok = true ;
            }

        }
          
      }
    
      catch ( Exception e ) {
        System.err.println("Une erreur c'est produite veuillez réessayer : " + e.getMessage()) ;
      }
      
      finally {
      
        System.out.println("\n\nRelancer une Game ? : [ o / n ]") ;
        String rep = restart.nextLine().trim();
        
        if( rep.equals("n") ) {
          System.out.println("BYEEEEE passer une bonne journée ;-) ");
          restart_game = false ;
        }
        else {
          System.out.println("Vous allez rejouer a mon jeu :-) , Merci \n\n\n"); 
        }
        
      }
      
    }
    
    restart.close();
  }
} 
