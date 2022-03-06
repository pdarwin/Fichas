import Fruta.Fruta;
import Fruta.FrutaPeso;
import Fruta.FrutaUnidade;

public class Main {
    public static void main(String [] args ){
        FrutaPeso aux = new FrutaPeso("Pera", 1,4 );
        FrutaUnidade aux1 = new FrutaUnidade("maca", 1,2);

        /*System.out.println("Valor a pagar pelas pera: " +aux.pagar());
        System.out.println("Valor a pagar pelas maca: " + aux1.pagar());*/

        System.out.println(aux.getId());
        System.out.println(aux1.getId());

        aux.setNome("");



        Cesto c = new Cesto();
        c.insereFruta(aux);
        c.insereFruta(aux1);

        /*System.out.println("Valor Total: " + c.valorTotal());
        System.out.println("Valor Fruta Unidade: " + c.valorTotalDoTipo("FrutaUnidade"));

        aux.setPercentagem(0.1);

        System.out.println("Valor a pagar depois do desconto das peras: " +aux.pagar());
        System.out.println("Valor Total: " + c.valorTotal());*/
    }

}
