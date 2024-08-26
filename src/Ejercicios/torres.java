package Ejercicios;

import java.util.Queue;
import java.util.Stack;

public class torres {

    Stack<Integer> a;
    Stack<Integer> b;
    Stack<Integer> c;



    public void ini(){
        a = new Stack<>();
        b = new Stack<>();
        c = new Stack<>();
    }

    public void cantDisc(int n){
        for (int i = 0; i < n; i++) {
            a.add(i);
        }
    }


    public void resolverWrapper(){
        resolver(a.size(), a, b, c);
    }

    void move(Stack<Integer> o,Stack<Integer> a, Stack<Integer> d){




        a.add(o.peek());
        o.pop();
        if (!o.empty()) {
            d.add(o.peek());
            o.pop();
        }
        o.add(a.peek());
        a.pop();
    }

    void resolver(int n, Stack<Integer> origen, Stack<Integer> aux, Stack<Integer> dest){


        if (n == 1){
            //System.out.println("Mover de " + origen + " a " + dest);
        }
        else {
            resolver(n-1, origen, dest, aux);
            move(origen, dest, aux);
            //System.out.println("Mover de " + origen + " a " + dest);
            resolver(n-1, aux, origen, dest);
            move(aux, origen, dest);
        }


        System.out.println("Torre A: " + this.a);
        System.out.println("Torre B: " + b);
        System.out.println("Torre C: " + c);
    }
    
}
