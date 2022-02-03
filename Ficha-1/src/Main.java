public class Main {
    public static void main(String [] args){
        //Primeiro print
        System.out.println("Hello World");

        //Teste funçoes
        System.out.println(multiplicacao(5,5));
        System.out.println(soma(5,5));
        System.out.println(subtracao(5,5));

        // Teste operaçao complexa
        System.out.println(operacaoComplexa(1,2));
        System.out.println(operacaoComplexa2(1,2));
    }

    public static float multiplicacao(float num1, float num2){
        return num1*num2;
    }

    public static float soma(float num1, float num2){
        return num1 +num2;
    }

    public static float subtracao(float num1, float num2){
        return num1-num2;
    }

    public static float operacaoComplexa(float num1, float num2){
        return soma(multiplicacao(num1, num2),subtracao(num1,num2));
    }

    //Trocar para operaçãoComplexa
    public  static  float operacaoComplexa2(float num1, float num2){
        return multiplicacao(soma(num1,num2),subtracao(num1, num2));
    }


}
