package calculadora2;
import java.util.Scanner;
public class Calculadora2 {
    public static void main(String[] args){
        Soma soma = new Soma();
        Scanner input = new Scanner(System.in);
        Multiplicacao mult = new Multiplicacao();
        Divisao div = new Divisao();
        String x, y, oper;
        System.out.println("10 + 5 Enter!    Insira 0 a qualquer momento para sair");
        do{
            System.out.println("\nCALCULADORA\n");
            x = input.next();
            if(x.equals("0")){
                break;//Calculadora para se recebe 0
            }
            oper = input.next();
            y = input.next();
            if(y.equals("0")){
                break;//Calculadora para se recebe 0
            }
            switch (oper){
                case "+":
                    System.out.println(x + " " + oper + " " + y + " = " + soma.soma(Integer.parseInt(x), Integer.parseInt(y)));

                break;
                case "-":
                break;
                case "*":
                    System.out.println(x + " " + oper + " " + y + " = " + mult.mult(Integer.parseInt(x), Integer.parseInt(y)));
                break;
                case "/":
                    System.out.println(x + " " + oper + " " + y + " = " + div.div(Double.parseDouble(x), Double.parseDouble(y)));
                break;
                default:
                break;
            }
         }while(!x.equals("0"));
    }
}
