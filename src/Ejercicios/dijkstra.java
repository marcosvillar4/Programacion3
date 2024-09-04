package Ejercicios;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class dijkstra {



    public Graph buscar(Graph g, int v){
        LinkedList<Integer> visitados = new LinkedList<>();
        LinkedList<Integer> candidatos = new LinkedList<>();

        visitados.add(v);

        for (Integer i : g.adjacentList.keySet()) {
            if(!visitados.contains(i)){
                candidatos.add(i);
            }
        }

        //System.out.println("visitados: " + visitados);
        //System.out.println("Candidatos: " + candidatos);


        Graph solucion = new Graph();

        for (Integer i : g.adjacentList.keySet()) {
            solucion.addNode(i);
        }


        for (Map.Entry<Integer, Set<Integer>> entry : g.adjacentList.entrySet()) {
            int one = entry.getKey();

            for (Integer i : entry.getValue()) {
                solucion.addEdge(one, i, g.weights.get(one).get(i));
            }
        }

        while (!candidatos.isEmpty()) {
            double min = 1000000000;

            int w = -1;
            for (Integer candidato : candidatos) {
                if (solucion.existeArista(v, candidato) && solucion.peso(v, candidato) < min) {
                    min = solucion.peso(v, candidato);
                    w = candidato;
                }
            }
            if (w != -1) {
                visitados.add(w);
                candidatos.removeFirstOccurrence(w);
            }
            if (w == -1 && candidatos.size() == 1) {
                w = candidatos.poll();
                visitados.add(w);
            }

            LinkedList<Integer> auxcandidatos = new LinkedList<>(candidatos);
            System.out.println("Candidatos: " + candidatos);
            System.out.println("visitados: " + visitados);
            while (!auxcandidatos.isEmpty()){
                int p = auxcandidatos.poll();

                System.out.println(auxcandidatos + " | " + w + " | " + p);

                if (w != -1){
                    if (g.existeArista(w, p)){
                        if (solucion.existeArista(v, p)){
                            if (solucion.peso(v,w) + g.peso(w,p) < solucion.peso(v,p)){
                                solucion.addEdge(v,p,solucion.peso(v,w) + g.peso(w,p));
                            }

                        }
                    }
                }
            }
        }



        g.showConnections();

        System.out.println("______________________________");
        return solucion;

    }
}
