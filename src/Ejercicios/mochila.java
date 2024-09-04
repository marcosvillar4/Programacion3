package Ejercicios;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;

public class mochila {


    LinkedList<objItem> list;
    LinkedList<ratioItem> ratioList;

    int index;

    HashMap<String, Float> resp;

    static class ratioItem{

        ratioItem(objItem item, float ratio){
            this.item = item;
            this.ratio = ratio;
        }
        objItem item;
        float ratio;
    }

    static class comparator implements Comparator<ratioItem>{

        @Override
        public int compare(ratioItem o1, ratioItem o2) {
            return Float.compare(o2.ratio, o1.ratio);
        }
    }

    void calcRatio(){
        ratioList = new LinkedList<>();
        for (objItem objItem : list) {
            ratioList.add(new ratioItem(objItem, objItem.getValor() / objItem.getPeso()));
        }
        comparator comp = new comparator();
        ratioList.sort(comp);
    }

    public HashMap<String, Float> calcMochila(int peso, LinkedList<objItem> listItem){
        resp = new HashMap<>();
        list = listItem;
        index = 0;
        calcRatio();

        calc(peso);

        return resp;
    }


    void calc(float peso){

        if (index <= (ratioList.size() - 1) && peso > 0){
            float calc = Math.min(ratioList.get(index).item.getCant(), (peso / ratioList.get(index).item.getPeso()));
            resp.put(ratioList.get(index).item.getDesc(), calc);
            index++;
            System.out.println("Index: " + (index - 1) + " Peso: " + (peso - calc * ratioList.get(index - 1).item.peso) + " Item ID: " + ratioList.get(index - 1).item.desc);
            calc(peso - (calc * ratioList.get(index - 1).item.peso));
        }
        else {
            System.out.println("Index: " + (index - 1) + " Peso: " + peso + " Last Item: " + ratioList.get(index - 1).item.desc);
            System.out.println("Fin de items/Mochila sin peso");
        }

    }

}
