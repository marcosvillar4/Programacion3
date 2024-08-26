package Ejercicios;

public class objItem {
    public objItem(int valor, int peso, int cant, String desc){
        this.valor = valor;
        this.peso = peso;
        this.cant = cant;
        this.desc = desc;
    }
    float valor;
    float peso;
    float cant;
    String desc;

    public float getValor() {
        return valor;
    }

    public float getPeso() {
        return peso;
    }

    public float getCant() {
        return cant;
    }

    public String getDesc() {
        return desc;
    }
}
