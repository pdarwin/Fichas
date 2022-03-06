package Fruta;

import java.util.UUID;

public abstract class Fruta {
    private String nome;
    private double preco;
    private static int num = 0;
    private int id;

    public Fruta(String nome, double preco) {
        id = num;
        num +=1;
        this.nome = nome;
        this.preco = preco;
    }

    public static int getNum() {
        return num;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public abstract double pagar();

    @Override
    public String toString() {
        return "Fruta.Fruta{" +
                "nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    public void teste(){
        System.out.println("Teste Fruta");
    }
}
