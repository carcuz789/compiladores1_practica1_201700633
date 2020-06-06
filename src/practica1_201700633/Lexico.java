/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_201700633;

import java.util.ArrayList;

/**
 *
 * @author carcu
 * terminado comentario uniliea M LETRAS IDS, NUMEROS
 */
public class Lexico {
       public static ArrayList<String> tipo=null;
       public static ArrayList<String> tokens=null;
       public static ArrayList<String> error=null;
    public static void lex1(String texto){
        int con=0;
        String conca="";
        
        char[] letras=texto.toCharArray();
        do {
            //si es letra
            if (Character.isLetter(letras[con])) {  // ids o letras
                 conca+=letras[con];
                 con++;
                 boolean var = false;
                 boolean estadin = true;
                 do {
                    
                     if (letras[con]=='_') {
                         var= true;
                          do {
                             conca+=letras[con];
                             con++;                             
                         } while (letras[con]=='_');
                         
                     }else if (Character.isDigit( letras[con])) {
                         do {
                             var = true;
                             conca+=letras[con];
                             con++;
                         } while (Character.isDigit( letras[con]));                         
                     }else if (Character.isLetter(letras[con])) {
                         do {
                             conca+=letras[con];
                             con++;
                         } while (Character.isLetter(letras[con]));                         
                     }else{
                         estadin =false;
                     }
                } while (estadin==true);
                 //si es una texto se va a un lugar y si es id a otro
                 if (var==false) {
                    tokens.add(conca);
                    tipo.add("TEXTO");
                    conca="";
                }else{
                    tokens.add(conca);
                    tipo.add("TEXTO ID");
                    conca="";
                 }
                
            }
            else if (Character.isDigit(letras[con])) {  // numeros
                do {
                     conca+=letras[con];
                     con++;
                } while (Character.isDigit(letras[con]));
                 tokens.add(conca);
                 tipo.add("NUMERO");
                 conca="";
                
            }
            else if (letras[con]=='\\') { // comentarios de linea
                conca+=letras[con];
                con++;
                if (letras[con]=='\\') {
                    conca+=letras[con];
                    con++;
                    do {
                        conca+=letras[con];
                        con++; 
                  } while (letras[con]!='\n');
                    //si hay salto de linea se chinga 
                    tokens.add(conca);
                    tipo.add("COMENTARIO LINEAL");
                    conca="";
                }else{  //si hay error se va a la verga
                    error(conca);
                }
                
                
            }else if (letras[con]=='<') {
                conca+=letras[con];
                con++;
                if (letras[con]=='!') {
                   boolean estado= true;
                    do {
                        conca+=letras[con];
                        con++;
                        if (letras[con]=='!') {
                            conca+=letras[con];
                            con++;
                            if (letras[con]=='>') {
                                 conca+=letras[con];
                                 con++;
                                 estado =false;
                            }
                        }
                    } while (estado==true);
                    tokens.add(conca);
                    tipo.add("COMENTARIO MULTILINEA");
                    conca="";
                    
                }else{
                    error(conca);//ESTE ERROR ES POR SI VIENE < PERO NO VIENE DESPUES !
                }                
            }else if(letras[con]=='-'){
                conca+=letras[con];
                con++;
                tokens.add(conca);
                tipo.add("GUION");
                //el guion es correcto
            }else if(Character.isWhitespace(letras[con])){
                con++; // si es espacion en blanco 
            }
        } while (con<letras.length);
        
                
    }
    public static void error(String Lex){
        error.add(Lex);
        //y parar la ejecucion 
        
    }
}
