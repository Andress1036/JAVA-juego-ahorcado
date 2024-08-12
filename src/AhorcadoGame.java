
import java.util.Scanner;

public class AhorcadoGame {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Juego el Ahorcado");

        String palabraSecreta = "camino";
        int cantidadIntentos = 5;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        for(int i = 0; i < letrasAdivinadas.length; i++){
            letrasAdivinadas[i] = '_';
        }

        StringBuilder letrasMalas = new StringBuilder();

        while(!palabraAdivinada && intentos < cantidadIntentos){

            System.out.println("Adivina la palabra: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            
            System.out.println("Introduce una letra: ");
           char letra = Character.toLowerCase(sc.next().charAt(0));
            boolean letraCorrecta = false;
            
            
            for(int i = 0; i < palabraSecreta.length(); i++){

                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }            

            if(!letraCorrecta){
                intentos++;
                letrasMalas.append(letra + " - ");                
                System.out.println("¡Letra incorrecta! te quedan " + (cantidadIntentos - intentos) + " intentos.");
                System.out.println("Letras incorrectas: " + String.valueOf(letrasMalas));
            }

            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("¡Felicidades has adivinado la palabra secreta! = '" + palabraSecreta + "'");
            }

        }

        if(!palabraAdivinada){
            System.out.println("¡Que mal, no tienes más intentos! YOU LOSE");
        }

        sc.close();



    }
}
