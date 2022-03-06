package Fruta;

public class FrutaUnidade extends Fruta{
    private int quantidade;

    public FrutaUnidade(String nome, double preco, int quantidade) {
        super(nome, preco);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public double pagar() {
        return quantidade*getPreco();
    }

}
