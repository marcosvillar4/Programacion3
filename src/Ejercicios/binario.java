package Ejercicios;

import java.util.Arrays;
import java.util.LinkedList;

public class binario {

    public static LinkedList<String> ejBinario(int cant){

        int[] array = new int[cant];
        LinkedList<String> resp = new LinkedList<>();
        func(array,0, cant, resp);
        return resp;
    }

    private static void func(int[] a, int etapa, int cant, LinkedList<String> resp){
        if (etapa == cant){
            if ((a[0] ^ a[2]) == 1) {
                System.out.println(Arrays.toString(a));
                resp.add(Arrays.toString(a));
            }
            //System.out.println(Arrays.toString(a));
        } else {
            for (int i = 0; i < 2; i++) {
                a[etapa] = i;
                func(a, etapa+1,cant, resp);
            }
        }
    }
}
