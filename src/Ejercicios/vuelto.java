package Ejercicios;

import java.util.HashMap;

public class vuelto {

    Float[] listval;
    int index = 0;
    HashMap<Float, Integer> resp;

    public vuelto(Float[] valores){
        listval = valores;
    }

    int cantDiv(float val, float div){
        int count = 0;
        while(val >= div){
            val = val - div;
            count++;
        }
        return count;
    }


    public HashMap<Float, Integer> calcWrap(float valor){
        resp = new HashMap<>();
        index = 0;
        calcVuelto(valor);

        return resp;
    }


    void calcVuelto(float valor){
        System.out.println("Val: " + valor + " div: " + listval[index] + " index: " + index);
        if (valor < listval[index] && (listval.length - 1) == index && valor > 0){
            System.out.println("Queda vuelto imposible: " + valor);
        }
        else if (valor >= listval[index] && valor > 0){
            System.out.println("val >");
            int intDiv = cantDiv(valor, listval[index]);
            resp.put(listval[index], intDiv);
            valor = valor - intDiv * listval[index];
            calcVuelto(valor);
        }
        else if (valor < listval[index] && valor > 0){
            System.out.println("val <");
            index++;
            calcVuelto(valor);
        }



    }





}
