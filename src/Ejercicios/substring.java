package Ejercicios;

import java.util.Arrays;

public class substring {
    public static String subsecuencia(String p1, String p2){

        int[][] matriz = new int[p2.length()][p1.length()];

        for (int i = 0; i < p1.length(); i++) {
            for (int j = 0; j < p2.length(); j++) {
                if (i > 0 && j > 0) {
                    if (p1.charAt(i) == p2.charAt(j)){
                        matriz[j][i] = matriz[j-1][i-1] + 1;
                    }
                    else if (matriz[j][i-1] > matriz[j-1][i]) {
                        matriz[j][i] = matriz[j][i-1];
                    } else {
                        matriz[j][i] = matriz[j-1][i];
                    }
                }
            }
        }
        for (int[] ints : matriz) {
            System.out.println(Arrays.toString(ints));
        }

        char[] resp = new char[matriz[p2.length() - 1][p1.length() - 1]];
        int punteroRespuesta = resp.length - 1;
        int i = p1.length() - 1;
        int j = p2.length() - 1;
        while (i > 0 && j > 0){
            if (matriz[j-1][i-1] == matriz[j][i]){
                j--;
            } else if (matriz[j-1][i-1] < matriz[j][i]){
                resp[punteroRespuesta] = p2.charAt(j);
                j--;
                i--;
                punteroRespuesta--;
            }
        }
        return String.copyValueOf(resp);
    }
}
