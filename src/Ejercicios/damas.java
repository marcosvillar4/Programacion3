package Ejercicios;

import java.util.Objects;

public class damas {

    public static boolean damas(Integer[] S, int e){
        boolean ok = false;
        S[e] = 0;
        while (S[e] < S.length && !ok){
            if (damaOk(S, e)){
                if (e == S.length - 1){
                    ok = true;
                } else {
                    ok = damas(S, e + 1);
                }
            }
            S[e] = S[e] + 1;
        }


        return ok;
    }

    static boolean damaOk(Integer[] a, int e){
        for (int i = 0; i <= e-1; i++) {
            if (Objects.equals(a[i], a[e]) || (Math.abs(a[i] - a[e]) == Math.abs(i-e))){
                return false;
            }
        }
        return true;
    }

}
