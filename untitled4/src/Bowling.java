import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Bowling {
    public static void main(String[] args) throws IOException {
        boolean repetareJoc = true;         //folosit pentru a da user-ului posibilitatea sa controleze repetarea sau oprirea jocului
        int multiplayer = 0;                //folosit pentru a da posibilitatea user-ului sa joace singur sau cu prietenii.
        Scanner input = new Scanner(System.in);
        int decizieJoc = 0;                 //folosit pentru a controla meniul jocului.
        System.out.println("Salutare!Iti multumesc ca ai ales jocul creat de mine pentru a-ti petrece timpul." +
                "Te rog sa alegi din optiunile de mai jos introducand cifra care corespunde cu obtiunea dorita.");
        meniuPrincipal();
        while (repetareJoc) {               //1 2 3 sau 4 sunt butoanele meniului, functia meniuPrincipal e mai jos.
            decizieJoc = Integer.parseInt(input.nextLine());
            switch (decizieJoc) {
                case 1:
                    multiplayer = 1;
                    break;
                case 2:
                    multiplayer = 2;
                    break;
                case 3:
                    System.out.println("Te rog intra pe site-ul http://codingdojo.org/kata/Bowling/ pentru a afla cum se joaca");
                    meniuPrincipal();
                    break;
                case 4:
                    System.out.println("Ai parasit jocul. La revedere!");
                    repetareJoc = false;
                    break;
                default:
                    System.out.println("Comanda eronata! Solicitarea nu a putut fi preluata! Va rugam incercati!");
                    decizieJoc = Integer.parseInt(input.nextLine());
            }

            if (multiplayer == 2) {           //daca user-ul alege multiplayer e vor crea 2 obiecte
                Joc.nrPlayer = 0;
                Joc jucator = new Joc();
                Joc jucator2 = new Joc();

                Joc[] listaPlayeri = new Joc[2];   //se stocheaza numele si scorul playerilor
                listaPlayeri[0] = jucator;         //se leaga un obiect de pozitia in array.
                listaPlayeri[1] = jucator2;

                System.out.println("RUNDA LUI " + jucator.nume.toUpperCase());  //corpul jocului. runda player 1
                jucator.runda();
                System.out.println("");

                System.out.println("RUNDA LUI " + jucator2.nume.toUpperCase()); //runda player 2
                jucator2.runda();
                System.out.println("");

                System.out.println(listaPlayeri[0].nume.toUpperCase() + " A OBTINUT " + jucator.finalTotal + " PUNCTE."); //afisare
                System.out.println(listaPlayeri[1].nume.toUpperCase() + " A OBTINUT " + jucator2.finalTotal + " PUNCTE.");//rezultate
                System.out.println("");

                if((int)listaPlayeri[0].finalTotal > (int)listaPlayeri[1].finalTotal) {   //afisare obiectul/playerul castigator
                    System.out.println(listaPlayeri[0].nume.toUpperCase() + " a castigat jocul. Felicitari!!!");
                } else {
                    System.out.println(listaPlayeri[1].nume.toUpperCase() + " a castigat jocul. Felicitari!!!");
                }

                bazaDeDate(listaPlayeri[0].finalTotal);
                bazaDeDate(listaPlayeri[1].finalTotal);

                System.out.println("Mai joci? Introdu 1 pentru a porni un nou joc!");  //aici user-ul controleaza jocul
                int maiJoci = Integer.parseInt(input.nextLine());
                if (maiJoci == 1) {
                    meniuPrincipal();
                } else {
                    repetareJoc = false;
                    System.out.println("Nu ai selectat 1 si ai inchis jocul. La revedere!");
                }

            } else if (multiplayer == 1) {                                             //aici jucatorul e singur. Se antreneaza.
                Joc.nrPlayer = 0;
                Joc jucator = new Joc();
                jucator.runda();
                System.out.println(jucator.nume.toUpperCase() + " A OBTINUT " + jucator.finalTotal + " PUNCTE.");

            bazaDeDate(jucator.finalTotal);

            System.out.println("Mai joci? Introdu 1 pentru a porni un nou joc!");
            int maiJoci = Integer.parseInt(input.nextLine());
            if (maiJoci == 1) {
                meniuPrincipal();
            } else {
                repetareJoc = false;
                System.out.println("Nu ai selectat 1 si ai inchis jocul. La revedere!");
            }
            }
        }
    }

    public static void meniuPrincipal() {                                           //afisare meniu.
        System.out.println("========================================================================");
        System.out.println("MENIU PRINCIPAL:\n1.Joc singleplayer\n2.Joc multiplayer\n3.Instructiuni\n4.Parasire Joc");
        System.out.println("========================================================================");
    }

    public static void bazaDeDate(int x) throws IOException {
        FileWriter retinere = new FileWriter("clasament.txt", true);  //se retine ultimul clasament.
        retinere.write(x + "\n");
        retinere.close();
    }

}
