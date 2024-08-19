package Ejercicios;

import java.util.*;

public class code {

    public LinkedList<Integer> genListaRandom(int maxItemCount, int maxItemValue){


        Random rand = new Random();
        LinkedList<Integer> ret = new LinkedList<>();
        for (int i = 1; i < rand.nextInt(maxItemCount * 10); i++) {
            ret.addFirst(rand.nextInt(maxItemValue));
        }

        return ret;
    }

    public Object mayor(LinkedList<Integer> l) {

        System.out.println(l);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer o : l) {
            if (!map.containsKey(o)){
                map.put(o, 1);
            }
            else {
                map.replace(o, map.get(o) + 1);
            }
        }

        System.out.println(map);

        for (Integer i : map.keySet()) {
            System.out.println(i);
            if(map.get(i) > (l.size() / 2) + 1){
                return i;
            }
        }

        return null;
    }
}



