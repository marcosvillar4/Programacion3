package Ejercicios;
import java.util.*;
public final class Graph {

    public Map<Integer, Set<Integer>> adjacentList = new HashMap<>();
    public Map<Integer, Map<Integer, Double>> weights = new HashMap<>();

    public void addNode(int node) {
        adjacentList.computeIfAbsent(node, key -> new TreeSet<>());
    }

    public void addEdge(int one, int two, double weight) {
        addDirectedEdge(one, two, weight);
        addDirectedEdge(two, one, weight);
    }

    private void addDirectedEdge(int one, int two, double weight) {
        addNode(one);
        addNode(two);
        adjacentList.get(one).add(two);
        setWeight(one, two, weight);
    }

    private void setWeight(int one, int two, double weight) {
        weights.computeIfAbsent(one, key -> new HashMap<>());
        weights.get(one).put(two, weight);
    }

    public boolean existeArista(int v, int u){
        return (adjacentList.get(v).contains(u));
    }

    public double peso(int v, int u){
        return weights.get(v).get(u);
    }

    public void showConnections() {
        for (Map.Entry<Integer, Set<Integer>> entry : adjacentList.entrySet()) {
            int one = entry.getKey();

            System.out.print(entry.getKey() + " ---> [");
            boolean comma = false;

            for (int two : entry.getValue()) {
                if (comma)
                    System.out.print(", ");

                comma = true;
                double weight = weights.get(one).get(two);
                System.out.format(Locale.ENGLISH, "%d (weight: %.2f)", two, weight);
            }

            System.out.println(']');
        }
    }
}