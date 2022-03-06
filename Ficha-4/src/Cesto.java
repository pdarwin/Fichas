import Fruta.Fruta;

import java.util.ArrayList;

public class Cesto {
    private int total;
    private final int CAP_MAX = 100;
    private ArrayList<Fruta> cesto;

    public Cesto() {
        total = 0;
        cesto =  new ArrayList<Fruta>();
    }

    public void insereFruta(Fruta f){
        if (total < CAP_MAX){
            cesto.add(f);
            total++;
        }
    }

    public double valorTotal(){
        double valor = 0;

        for(Fruta f: cesto){
            valor+= f.pagar();
        }

        return valor;
    }

    public int numTotalDoTipo(String tipoFruta){
        int valor = 0;

        for(Fruta f: cesto){
            if (f.getClass().getSimpleName().equals(tipoFruta)){
                valor+=1;
            }
        }

        return valor;
    }

    public double valorTotalDoTipo(String tipoFruta){
        double valor = 0;

        for(Fruta f: cesto){
            if (f.getClass().getSimpleName().equals(tipoFruta)){
                valor+= f.pagar();
            }
        }

        return valor;
    }


}
