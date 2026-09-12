package words ;

public class Word {
  
  private String mot_tentative ;
  
  
  public Word (String mot_tentative) {
    this.mot_tentative = mot_tentative ; 
  }
  
  public String getMot_tentative(){
    return this.mot_tentative;  
  }
  
  public boolean isGoodLength() {
   return ( this.mot_tentative.length()==5 ) ;
  }
  
  public boolean isAlphabetiques() {
    return this.mot_tentative.matches("[a-zA-Z]+") ; 
  }  
  
  public boolean isNoRedundance(){
  
    int taille=this.mot_tentative.length();
    
    for(int j=0;j<taille;j++){
      for(int i=0;i<taille;i++){
        if(this.mot_tentative.charAt(i) == this.mot_tentative.charAt(j) && i!=j){
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean isAllGood(){
    return (this.isGoodLength() && this.isAlphabetiques() && this.isNoRedundance() ) ; 
  }

  public String [] AnalyseWithSecretWord ( Word mot_secret ){
    
    int taille = this.mot_tentative.length() ;
    String [] res = new String [ taille ] ;
    
    for ( int i=0 ; i < taille ; i++ ) {
      
      char lettre_t = this.mot_tentative.charAt(i) ; 
      String lettre_m = mot_secret.getMot_tentative() ; 
      
      if ( lettre_t == lettre_m.charAt(i) ) {
        res[i]="OK";
      }
      
      else {
        
        boolean trouver = false ;
        for ( int j=0 ; j < taille ; j++ ) {
          if ( lettre_t == lettre_m.charAt(j) ) { 
            trouver=true;
          }
        }
        
        if(trouver){
          res[i]="PRESENT";
        }
        else {
          res[i]="ABSENT";
        }  
      } 
    }
    return res;
  }

}
