import Ejercicios.code;

import java.util.LinkedList;
public class Main {

    public static void main(String[] args){

        code func = new code();
        //LinkedList a = func.genListaRandom(20, 4);

        LinkedList<Integer> a = new LinkedList<>();

        a.addFirst(1);
        a.addFirst(1);
        a.addFirst(1);
        a.addFirst(1);
        a.addFirst(2);
        a.addFirst(2);
        a.addFirst(1);
        a.addFirst(1);
        a.addFirst(1);
        a.addFirst(2);

        System.out.println(func.mayor(a));
        //System.out.println(a);



        
    }
}
