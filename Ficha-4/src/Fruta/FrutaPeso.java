package Fruta;

public class FrutaPeso extends Fruta implements Descontavel{
    private double peso;
    private double percentagem;

    public FrutaPeso(String nome, double preco, double peso) {
        super(nome, preco);
        this.peso = peso;
        this.percentagem = 0;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setPercentagem(double percentagem) {
        this.percentagem = percentagem;
    }

    @Override
    public double pagar() {
        return peso*getPreco() - descontar();
    }

    @Override
    public double descontar() {
        return peso*getPreco()*percentagem;
    }

    public void teste(){
        System.out.println("Teste FrutaPeso");
    }
}
