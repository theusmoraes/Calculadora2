package calculadora2;
import java.util.Scanner;
public class Calculadora2 {
    public static void main(String[] args){
        Soma soma = new Soma();
        Scanner input = new Scanner(System.in);
        String x, y;
        String oper;
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
                break;
                case "/":
                break;
                default:
                break;
            }
         }while(!x.equals("0"));
    }
}
