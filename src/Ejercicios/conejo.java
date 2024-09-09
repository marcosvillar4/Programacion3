package Ejercicios;

public class conejo {

    public static int[][] solucion(int[][] cant){
        int[][] resp = new int[cant.length][cant.length];
        System.out.println(cant.length);
        int MaxIndex = 0;
        for (int i : cant[0]) {
            resp[0][i] = cant[0][i];
            if (MaxIndex < cant[0][i]){
                MaxIndex = i;
            }
        }

        System.out.println(MaxIndex);
        int index = 1;


        return resp;
    }
}
