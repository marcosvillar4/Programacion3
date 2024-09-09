package Ejercicios;

import java.util.Arrays;

public class canoas {

    public static void viaje(int[][] costos, int n){

        int[] costoViaje = new int[n + 1];
        int index = 0;
        while (index < n){
            if (index == 0){
                costoViaje[0] = 0;
            }
            else {
                costoViaje[n] = Math.min(costos[0][n], costoViaje[n-1]);
            }
            index++;
        }

        System.out.println(Arrays.toString(costoViaje));

    }


}
