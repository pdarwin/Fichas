package Fruta;

public class FrutaVolume extends Fruta implements Descontavel{
    private double volume;
    private double percentagem;

    public FrutaVolume(String nome, double preco, double volume) {
        super(nome, preco);
        this.volume = volume;
        this.percentagem = 0;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public double pagar() {
        return volume*getPreco()-descontar();
    }

    @Override
    public double descontar() {
        return volume*getPreco()*percentagem;
    }
}
