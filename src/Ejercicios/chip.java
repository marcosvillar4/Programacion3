package Ejercicios;

import java.util.Arrays;

public class chip {

    public chip() {


    }

    public static void ejChip(int cant){

        int[] array = new int[cant];

        func(array,0, cant);

    }

    private static void func(int[] a, int etapa, int cant){
        if (etapa == cant){
            System.out.println(Arrays.toString(a));
        } else {
            for (int i = 0; i < 2; i++) {
                a[etapa] = i;
                func(a, etapa+1,cant);
            }
        }
    }
}
