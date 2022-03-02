import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaBancaria {
    private String titular;
    private double saldo;
    private Date dataAbertura;

    public ContaBancaria(String titular) {
        this.titular = titular;
        saldo = 0;
        dataAbertura = new Date();
    }

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        dataAbertura = new Date();
    }


    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public String getInformaçãoConta() {
        DecimalFormat df = new DecimalFormat("0.00");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Titular: " + titular + ", Saldo: " + df.format(saldo) + ", Data Abertura: " + simpleDateFormat.format(dataAbertura);
    }

    public void depositar(float valor){
        saldo = saldo + valor;
    }

    public void levantar (float valor){
        if (valor<=saldo){
            saldo = saldo - valor;
        }
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", dataAbertura=" + dataAbertura +
                '}';
    }
}
