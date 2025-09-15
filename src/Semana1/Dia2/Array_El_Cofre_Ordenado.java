/*
1. Array – El Cofre Ordenado

Pista:
Los elementos están guardados en celdas numeradas que comienzan desde el índice 0.
Para entrar a una celda, usas corchetes [] con el número de índice.

Reto:
Declara un Array de 5 enteros con tus números favoritos.
Accede al primer y al último número.
Cambia el valor de la posición 2 y vuelve a mostrarlo.
 */

package Dia2;

import javax.xml.transform.Source;

public class Array_El_Cofre_Ordenado {
    public static void main(String[] args) {
        //Declaramos un Array de 5 enteros con tus numeros favoritos
        int[] numerosFavoritos = {14, 7, 77, 21, 1};

        // Accedemos al primer y ultimo numero
        System.out.println("Primero numero: " + numerosFavoritos[0]); //Primer numero
        System.out.println("Ultimo numero: " + numerosFavoritos[4]); //Segundo numero

        // Cambiamos el valor de la posicion 2 y vuelvo a mostrarlo
        numerosFavoritos[2] = 43;

        //Mostramos el nuevo valor en la posision 2
        System.out.println("Nuevo valor en la posicion 2: "+ numerosFavoritos[2]);

    }
}
