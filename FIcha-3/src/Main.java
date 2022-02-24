public class Main {
    public static void main(String [] args){
        ContaBancaria aux = new ContaBancaria("David");
        ContaBancaria aux1 = new ContaBancaria("David", 200);

        //System.out.println(aux.getSaldo());
        //System.out.println(aux1.getSaldo());

        System.out.println(aux);

        //ContaBancaria aux = new ContaBancaria("David");
        Casa casa1 = new Casa("Rua João Gomes");
        Casa casa2 = new Casa("Rua João Gomes2");

        Banco banco1 = new Banco("BPI");

        banco1.adicionaCasa(casa1);
        banco1.adicionaCasa(casa2);

        banco1.removeCasa("Rua João Gomes");
        System.out.println(aux.getInformaçãoConta());
    }
}
