package calculadora2;
import java.util.Scanner;
public class Calculadora2 {
    public static void main(String[] args){
        Soma soma = new Soma();
        Scanner input = new Scanner(System.in);
        Multiplicacao mult = new Multiplicacao();
        Divisao div = new Divisao();
        Sub sub = new Sub();
        String x, y, oper;
        System.out.println("Instruções\nBem vindo à calculadora!\n"
        + "Escreva com espaço entre os valores:\n<número> <operador> <número> Enter!"
        + "\nLog: <base> L <logaritmando>\nInsira 0 a qualquer momento para sair");
        do{
            System.out.println("\nCALCULADORA\n");
            x = input.next();
            if(x.equals("0")){
                break;//Calculadora break o do-while se receber 0
            }
            oper = input.next();
            oper = oper.toLowerCase();
            if ("v".equals(oper)){
                System.out.println(x + " " + oper + " = " + Raiz.sqrt(Double.parseDouble(x)));
                
            }
            y = input.next();
            if(y.equals("0")&&!"v".equals(oper)){
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
                default:
                    System.out.println("Operador não reconhecido!");
                break;
            }
         }while(!x.equals("0"));
    }
}