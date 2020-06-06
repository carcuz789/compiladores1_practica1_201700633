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
 * terminado comentario uniliea solo 
 */
public class Lexico {
       public static ArrayList<String> tipo=null;
       public static ArrayList<String> tokens=null;
       public static ArrayList<String> error=null;
    public static ArrayList<String> lex1(String texto){
        int con=0;
        String conca="";
        
        char[] letras=texto.toCharArray();
        do {
            //si es letra
            if (Character.isLetter(letras[con])) {  // ids o letras
                 conca+=letras[con];
                 con++;
                 do {
                    
                } while (true);
                
            }
            else if (Character.isDigit(letras[con])) {  // numeros
                
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
                    } while (estado==true);
                    
                }else{
                    error(conca);
                }
                
            }
        } while (con<letras.length);
        
        return tokens;
                
    }
    public static void error(String Lex){
        error.add(Lex);
        //y parar la ejecucion 
        
    }
}
