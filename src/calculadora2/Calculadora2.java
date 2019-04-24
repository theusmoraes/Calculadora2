package calculadora2;
import java.util.Scanner;
public class Calculadora2 {
    public static String verifyComma(String numero){
        /*Método que recebe um dos Strings de números, transforma em um array de caracteres, 
        verifica se existe alguma vírgula nele, se existir ele troca por um ponto, evitando o
        erro "java.lang.NumberFormatException" e retornando a string correta do número*/
        char todouble[] = numero.toCharArray(); 
            for (int i = 0; i < todouble.length; i++) {
                if(todouble[i] == ','){
                    todouble[i] = '.';
                }
            }
            numero = String.valueOf(todouble);
            return numero;
    }
    public static boolean verifyCharacters(String caracter){
        /*Método que recebe um dos Strings de números, trata os dados contidos nela
        lendo posição por posição e verificando se o UNICODE retornado pela posição
        é um número, se não for ele retorna false e o main retorna a mensagem de "apenas
        números. O UNICODE funciona de forma a atribuir um número, aqui em decimal, para cada
        símbolo, os números de 0 a 9 tem o unicode entre 48 e 57, tudo que não for isso não entra na calculadora*/
        for (int i = 0; i < caracter.length(); i++) {
            if(caracter.codePointAt(i) != 46 && caracter.codePointAt(i) < 48 || caracter.codePointAt(i) > 57){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Soma soma = new Soma();
        Scanner input = new Scanner(System.in);
        Multiplicacao mult = new Multiplicacao();
        Divisao div = new Divisao();
        Sub sub = new Sub();
        String x, y, oper;
        System.out.println("Instruções\nBem vindo à calculadora!\n"
        + "Escreva com espaço entre os valores:\n<número> <operador> <número> Enter!"
        + "\nLog: <base> L <logaritmando>\n Exponencial: <base> ^ <Expoente>\n2Insira 0 a qualquer momento para sair");
        do{
            System.out.println("\nCALCULADORA\n");
            x = input.next();
            x = verifyComma(x);
            if(x.equals("0")){
                break;//Calculadora break o do-while se receber 0
            }
            oper = input.next();
            oper = oper.toLowerCase();
            if ("v".equals(oper)){
                if(!verifyCharacters(x)){
                    System.out.println("Apenas números são permitidos neste campo!");
                }else{
                    System.out.println(x + " " + oper + " = " + Raiz.sqrt(Double.parseDouble(x)));
                }
                continue;//crie uma nova interação do loop
            }
            y = input.next();
            y = verifyComma(y);
            if(!verifyCharacters(x) || !verifyCharacters(y)){
                System.out.println("Apenas números são permitidos neste campo!");
                continue;//crie uma nova interação do loop
            }
            if(y.equals("0")){
                break;//Calculadora break o do-while se receber 0
            }
            switch (oper){
                case "+":
                    System.out.println(x + " " + oper + " " + y + " = " + soma.soma(Double.parseDouble(x), Double.parseDouble(y)));
                break;
                case "-":
                    System.out.println(x + " " + oper + " " + y + " = " + sub.subtraindo(Double.parseDouble(x), Double.parseDouble(y)));
                break;
                case "*":
                    System.out.println(x + " " + oper + " " + y + " = " + mult.mult(Double.parseDouble(x), Double.parseDouble(y)));
                break;
                case "/":
                    System.out.println(x + " " + oper + " " + y + " = " + div.div(Double.parseDouble(x), Double.parseDouble(y)));
                break;
                case "l":
                    System.out.println("Log - Base(" +x+ ") Valor(" +y+ ") = " +Log.log(Double.parseDouble(x), Double.parseDouble(y)));
                    break;
                case "^":
                    System.out.println(x + " " + oper + " " + y + " = " + Exponencial.Pow(Double.parseDouble(x), Double.parseDouble(y)));
                    break;
                default:
                    System.out.println("Operador não reconhecido!");
                break;
            }
        }while(!x.equals("0"));
    }
}