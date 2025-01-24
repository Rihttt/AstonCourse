import org.example.myVariants.DemoClass;

import java.util.Scanner;

public class Main {


    public static void main(String[] args)  {

        while (true){
            System.out.println(
                            "1.Демонстрация реализации ArrayList \n"+
                            "2.Демонстрация реализации LinkedList \n"+
                            "3.Демонстрация перестроения бакета в HashMap \n"+
                            "4.Выход");

            Scanner in = new Scanner(System.in);
            System.out.print("Выберите пункт: ");
            int k = in.nextInt();

            switch(k){
                case 1:{
                    DemoClass.demoAList();
                    break;
                }
                case 2:{
                    DemoClass.demoLList();
                    break;
                }
                case 3:{
                    DemoClass.demoHashTreeify();
                    break;
                }
                case 4:{
                    return;
                }
            }
        }
    }

}