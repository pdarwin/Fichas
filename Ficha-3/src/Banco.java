import java.util.ArrayList;

public class Banco {
    ArrayList<ContaBancaria> contas;
    ArrayList<Casa> casas;
    String name;

    public Banco(String name) {
        contas = new ArrayList<>(100);
        casas = new ArrayList<>();
        this.name = name;
    }

    public void criarConta(ContaBancaria conta){
        contas.add(conta);
    }

    public ContaBancaria getConta(String titular){

        for (ContaBancaria conta: contas) {
            if (conta.getTitular().equals(titular)){
                return conta;
            }
        }
        return null;
    }

    public void adicionaCasa(Casa casa){
        casas.add(casa);
    }

    public void removeCasa(String morada){
        for(Casa casaAux : casas){
            if(casaAux.getMorada().equals(morada)){

                casas.remove(casaAux);
            }
        }


    }


}
