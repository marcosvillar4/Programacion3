package Ejercicios;

import java.util.Arrays;
import java.util.Collections;

public class IntSequence {
    public static int[] intSeq(int[] data){

        Integer[] size = new Integer[data.length];
        Integer[] indices = new Integer[data.length];

        Arrays.fill(size, 1);
        Arrays.fill(indices, -1);

        for (int i = 1; i < data.length; i++) {

            for (int j = 0; j < i; j++) {
                if (data[j] <= data[i] && size[j] + 1 >= size[i]){
                    size[i] = size[j] + 1;
                    indices[i] = j;
                }
            }
        }

        int arraySize = Collections.max(Arrays.asList(size));
        System.out.println(arraySize);
        int lastIndex = Collections.max(Arrays.asList(indices)) + 1;
        int[] resp = new int[arraySize];
        resp[resp.length-1] = data[lastIndex];

        for (int i = resp.length - 2; i >= 0; i--) {
            resp[i] = data[indices[lastIndex]];
            lastIndex = indices[lastIndex];
        }

        System.out.println(Arrays.toString(resp));

        return resp;

    }

}
