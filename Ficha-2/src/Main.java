import java.util.HashMap;

public class Main {
    public static void main(String [] args){
        //Chamar aqui para testar

        
    }

    public static float areaTriang(float altura, float base){
        return (altura*base)/2;
    }

    public static float areaRetang(float altura, float comprimento){
        return altura*comprimento;
    }

    //primeira forma
    public static float areaCal(float x, float y, float z){
        if (z==1){
            return areaTriang(x,y);
        }else{
            return areaRetang(x,y);
        }
    }

    //segunda forma
    public static float areaCal2 (float x, float y, String z){
        switch(z) {
            case "1":
                return areaTriang(x,y);
            default:
                return areaRetang(x,y);
        }
    }

    public static int factor(int num){
        int res = 1;
        for (int i = 1; i<=num; i++){
            res=res*i;
        }
        return res;
    }

    public static int factorRec(int num){
        //ter em atenção que factorial de 0! = 1
        if (num == 0){
            return 1;
        }
        return num*factorRec(num-1);
    }

    public static int numTotalVogais(String frase){
        int numVogais = 0;

        for (int i=0 ; i<frase.length(); i++){
            char ch = frase.charAt(i);
            if(ch == 'a'|| ch == 'e'|| ch == 'i' ||ch == 'o' ||ch == 'u'){
                numVogais ++;
            }
        }

        return numVogais;
    }

    //Outra possibilidade
    public static int numTotalVogais2(String frase){
        int numVogais = 0;

        char[] vogais = {'a','e','i', 'o', 'u'};

        for (int i=0 ; i<frase.length(); i++){
            for (char aux: vogais) {
                if (aux == frase.charAt(i)){
                    numVogais++;
                }
            }
        }

        return numVogais;
    }


    public static void numTotalVogaisDicionario(String frase){
        HashMap<String, Integer> dic = new HashMap<>();

        dic.put("a",0);
        dic.put("e",0);
        dic.put("i",0);
        dic.put("o",0);
        dic.put("u",0);

        for (int i=0 ; i<frase.length(); i++){
            char ch = frase.charAt(i);
            if(ch == 'a'){
                dic.put("a", dic.get("a")+1);
            }else if (ch == 'e'){
                dic.put("e", dic.get("e")+1);
            }else if (ch == 'i'){
                dic.put("i", dic.get("i")+1);
            }else if (ch == 'o'){
                dic.put("o", dic.get("o")+1);
            }else if (ch == 'u'){
                dic.put("u", dic.get("u")+1);
            }

        }

        for (String str: dic.keySet() ) {
            System.out.println(str + " " + dic.get(str));
        }
    }

    public static void  numTotalVogaisDicionario2(String frase){
        HashMap<String, Integer> dic = new HashMap<>();

        dic.put("a",0);
        dic.put("e",0);
        dic.put("i",0);
        dic.put("o",0);
        dic.put("u",0);

        for (int i=0 ; i<frase.length(); i++){
            switch (frase.charAt(i)){
                case 'a':
                    dic.put("a", dic.get("a")+1);
                    break;
                case 'e':
                    dic.put("e", dic.get("e")+1);
                    break;
                case 'i':
                    dic.put("i", dic.get("i")+1);
                    break;
                case 'o':
                    dic.put("o", dic.get("o")+1);
                    break;
                case 'u':
                    dic.put("u", dic.get("u")+1);
                    break;
            }
        }

        for (String str: dic.keySet() ) {
            System.out.println(str + " " + dic.get(str));
        }
    }

    public static void convertSeconds(int numSegundos){
        //Dia = 60*60*24 = 86400
        int days = numSegundos / 86400;
        numSegundos = numSegundos % 86400;

        //Hour = 60*60 = 3600
        int hours = numSegundos / 3600;
        numSegundos = numSegundos % 3600;

        //Min = 60
        int minutes = numSegundos / 60;
        numSegundos = numSegundos % 60;

        //Segundos
        int sec = numSegundos;

        System.out.println("Day: " + days + " \nHour: " + hours + " \nMinute: " + minutes + " \nSeconds: " + sec);
    }

}
