package Ejercicios;

import java.util.Arrays;
import java.util.LinkedList;

public class chip {

    public static LinkedList<String> ejChip(int cant){

        int[] array = new int[cant];
        LinkedList<String> resp = new LinkedList<>();

        return func(array,0, cant, resp);
    }

    private static LinkedList<String> func(int[] a, int etapa, int cant, LinkedList<String> resp){
        if (etapa == cant){
            if ((a[0] ^ a[2]) == 1) {
                System.out.println(Arrays.toString(a));
                resp.add(Arrays.toString(a));
            }
        } else {
            for (int i = 0; i < 2; i++) {
                a[etapa] = i;
                func(a, etapa+1,cant, resp);
            }
        }
        return resp;
    }
}
