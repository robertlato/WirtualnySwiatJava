package wirtualny.swiat;

import java.util.Scanner;

public class App {

    public static void main(String[] args)
    {
        new MyFrame();
        WirtualnySwiat pierwszySwiat = new WirtualnySwiat(20, 20);
        pierwszySwiat.rysujSwiat();
        char operacja = 0;
        Scanner scanner = new Scanner(System.in);
//        rysujMenu();
        System.out.print("Witualny swiat\n1. Wykonaj ture\n2. Zakoncz program\n\n\n");
        while (operacja != '2')
        {
            // cin >> operacja;
            operacja = scanner.next().charAt(0);
            switch (operacja)
            {
                case '1':
                    //system("clear"); // czyszczenie okna w clion nie dziala
                    System.out.print("Wykonuje ture numer: " + (pierwszySwiat.getTura() + 1) + "\n");
                    pierwszySwiat.wykonajTure();
                    pierwszySwiat.rysujSwiat();
//                    rysujMenu();
                    System.out.print("Witualny swiat\n1. Wykonaj ture\n2. Zakoncz program\n\n\n");

                    break;

                case'2':
                    // koncze program
                    break;

//                case'3':
//                    while(pierwszySwiat.getTura() < 1500) pierwszySwiat.wykonajTure();
//
                default:
                    System.out.print("Zly input, sprobuj ponownie\n");
                    System.out.print("operacja = " + operacja + "\n" );
                    break;
            }
        }

//        pierwszySwiat.wykonajTure();
//        pierwszySwiat.rysujSwiat();
    }
}
