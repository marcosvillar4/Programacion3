import Ejercicios.*;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args){


        //probvuelto();
        //moch();
        // minDistNode();

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

        list.add(new objItem(10, 20, 1, "Item 1"));
        list.add(new objItem(5, 15, 2, "Item 2"));
        list.add(new objItem(50F,25F, 0.5F, "Item 3"));

        mochila func = new mochila();

        ;
        System.out.println(func.calcMochila(40, list));



    }

    static void huffman(){




    }

    static void minDistNode(){
        Graph grafo1 = new Graph();
        dijkstra dijkstra = new dijkstra();


        grafo1.addNode(1);
        grafo1.addNode(2);
        grafo1.addNode(3);
        grafo1.addNode(4);
        grafo1.addNode(5);

        grafo1.addEdge(1,2,7);
        grafo1.addEdge(1,3,5);
        grafo1.addEdge(1,5,2);
        grafo1.addEdge(3,1,3);
        grafo1.addEdge(2,3,9);
        grafo1.addEdge(2,5,8);
        grafo1.addEdge(2,4,1);
        grafo1.addEdge(5,2,1);
        grafo1.addEdge(3,4,3);
        grafo1.addEdge(4,3,1);

        //System.out.println(grafo1.peso(1,2));

        dijkstra.buscar(grafo1, 1).showConnections();

        //grafo1.showConnections();
    }

    static void kruskal(){
        Graph graph = new Graph();

        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addNode(7);

        graph.addEdge(1,2, 4);
        graph.addEdge(1,6, 5);
        graph.addEdge(1,7,1);
        graph.addEdge(1,3, 7);
        graph.addEdge(2,3, 3);
        graph.addEdge(3,4, 5);
        graph.addEdge(3,7, 3);
        graph.addEdge(4,7,9);
        graph.addEdge(4,5,7);
        graph.addEdge(5, 7,4);
        graph.addEdge(5, 6, 8);
        graph.addEdge(6, 7, 2);


        


    }
}
