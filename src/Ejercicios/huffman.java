package Ejercicios;

import java.util.*;

public class huffman {

    static class hojaChar {

        public hojaChar(Character c, Double prob, hojaChar hijo1, hojaChar hijo2) {
            this.c = Objects.requireNonNullElse(c, '�');

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


    static HashMap<Character, String> resp;
    static LinkedList<hojaChar> oplist;

    public static HashMap<Character, String> huffmanCodificacion(String palabra){

        resp = new HashMap<>(); // Creamos un HashMap para la respuesta

        TreeMap<Character, Double> cant = probabilidadCaracter(palabra); // Buscamos la probabilidad de aparecer de cada letra

        oplist = new LinkedList<>(); // Creamos una lista que vamos a usar para calcular la codificacion



        for (Character c : cant.keySet()) {
            oplist.add(new hojaChar(c, cant.get(c), null, null));   // Cargamos todos los caracteres a la lista
        }

        Comparator<hojaChar> comp = new comparator();   // Comparador para el sort

        oplist.sort(comp);  // Sorteamos la lista, los menores van al fondo

        while (oplist.size() >= 2){
            hojaChar h1 = oplist.getLast();
            oplist.removeLast();                // Guardamos los ultimos 2 objetos de la lista y los sacamos
            hojaChar h2 = oplist.getLast();
            oplist.removeLast();
            hojaChar raiz = new hojaChar(null, h1.prob + h2.prob, h1, h2);  // Creamos un nuevo nodo con los 2 nodos guardados como padre e hijo
            oplist.addLast(raiz);   // Agregamos el nodo al fondo y ordenamos
            oplist.sort(comp);
        }

        hojaChar raiz = oplist.getLast();   // Finalmente te va a quedar en la lista 1 nodo raiz, este lo usamos con inorder para generar el HashMap respuesta

        for (Character c : cant.keySet()) {
            inorder(raiz, new LinkedList<>(), c);
        }

        System.out.println(resp);
        return resp;
    }

    private static TreeMap<Character, Double> probabilidadCaracter(String palabra){
        TreeMap<Character, Double> cant = new TreeMap<>();
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
        return cant;
    }
    private static void inorder(hojaChar a, LinkedList<Character> valor, Character c){
        if (a != null) {
            if (a.c == c){
                resp.put(c, Arrays.toString(valor.toArray()));
            }
            if (a.c == '�'){
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
