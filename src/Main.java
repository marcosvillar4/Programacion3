import Ejercicios.*;

import java.util.LinkedList;
public class Main {

    public static void main(String[] args){


    //probvuelto();
    moch();
    }

    static void probvuelto(){
        LinkedList<Float> monedas = new LinkedList<>();

        monedas.add(50F);
        monedas.add(20F);
        monedas.add(10F);
        monedas.add(5F);
        monedas.add(1F);
        monedas.add(0.5F);

        Float[] wrapper = monedas.toArray(new Float[0]);
        vuelto func = new vuelto(wrapper);

        System.out.println(func.calcWrap(155.3F));
    }

    static void moch(){

        LinkedList<objItem> list = new LinkedList<>();

        list.add(new objItem(10, 20, 1, "1"));
        list.add(new objItem(5, 15, 2, "2"));
        list.add(new objItem(50F,25F, 0.5F, "3"));

        mochila func = new mochila();

        ;
        System.out.println(func.calcMochila(40, list));



    }
}
