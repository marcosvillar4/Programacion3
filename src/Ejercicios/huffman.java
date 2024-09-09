package Ejercicios;

import java.util.*;

public class huffman {

    static class hojaChar {

        public hojaChar(Character c, Double prob, hojaChar hijo1, hojaChar hijo2) {
            this.c = Objects.requireNonNullElse(c, '*');

            this.prob = prob;
            this.hijo1 = hijo1;
            this.hijo2 = hijo2;
        }

        char c;
        double prob;
        hojaChar hijo1;
        hojaChar hijo2;
    }

    static class comparator implements Comparator<hojaChar> {
        @Override
        public int compare(hojaChar o1, hojaChar o2) {
            return Double.compare(o2.prob, o1.prob);
        }
    }

    TreeMap<Character, Double> cant;
    HashMap<Character, String> resp;
    LinkedList<hojaChar> oplist;

    public HashMap<Character, String> huffmanCodificacion(String palabra){

        resp = new HashMap<>();
        cant = new TreeMap<>();
        oplist = new LinkedList<>();

        for (char c : palabra.toCharArray()) {
            if (!cant.containsKey(c)){
                cant.put(c, 1D);
            }
            else {
                cant.replace(c, cant.get(c) + 1);
            }
        }

        System.out.println(cant);

        cant.replaceAll((c, v) -> v / palabra.length() * 100);

        for (Character c : cant.keySet()) {
            oplist.add(new hojaChar(c, cant.get(c), null, null));
        }

        Comparator<hojaChar> comp = new comparator();

        oplist.sort(comp);

        while (oplist.size() >= 2){
            hojaChar h1 = oplist.getLast();
            oplist.removeLast();
            hojaChar h2 = oplist.getLast();
            oplist.removeLast();

            hojaChar raiz = new hojaChar(null, h1.prob + h2.prob, h1, h2);
            oplist.addLast(raiz);

            oplist.sort(comp);
        }

        hojaChar raiz = oplist.getLast();

        for (Character c : cant.keySet()) {
            inorder(raiz, new LinkedList<>(), c);
        }

        System.out.println(resp);
        return resp;
    }

    void inorder(hojaChar a,LinkedList<Character> valor, Character c){
        if (a != null) {
            if (a.c == c){
                resp.put(c, Arrays.toString(valor.toArray()));
            }
            if (a.c == '*'){
                valor.addLast('1');
                inorder(a.hijo1, valor, c);
                valor.removeLast();
                valor.addLast('0');
                inorder(a.hijo2, valor, c);
                valor.removeLast();
            }
        }
    }



}
