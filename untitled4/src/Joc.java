import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class Joc {
    String nume = "";                         //se stocheaza numele fiecarui player.
    int finalTotal = 0;                       //stocheaza pucntajul fiecarui player.
    static int nrPlayer = 0;                  //se stocheaza playerii.

    public void runda() {
        //declaratie liste si variabile
        Random rand = new Random();
        ArrayList lista = new ArrayList();    //retine toate valorile pentru prima aruncare din fiecare runda
        ArrayList lista2 = new ArrayList();   //retine toate valorile pentru a doua aruncare din fiecare runda
        ArrayList lista3 = new ArrayList();   //retine totalul pentru fiecare runda de joc
        ArrayList lista4 = new ArrayList();   //pe aceasta lista se verfic daca intr-o runda exista Spare/Strike case

        int a = 0;                            //reprezinta prima aruncare
        int b = 0;                            //reprezinta a doua aruncare
        int totalRunda = 0;                   //reprezinta totalul pe fiecare runda(a+b)
        int totalJoc = 0;                     //reprezinta punctajul total per joc, nu se tine cont de Strike/Spare

        //acest for reprezinta fiecare runda, de aceea se repeta de 10 ori
        for (int i = 0; i < 10; i++) {
            a = rand.nextInt(11);      //valoare aleatoare prima aruncare pe runda
            lista.add(a);                     //se retine valoarea
            b = rand.nextInt(11);      //valoare aleatoare a doua arunca pe runda
            while (a + b > 10) {              //se restrictioneaza b pentru a nu lua oricare valoare, ci a+b sa fie maxim 10
                b = rand.nextInt(11);  //se executa pana cand a+b e maxim 10.
            }
            lista2.add(b);                    //cand b ia o valoare corecta se retine
            totalRunda = a + b;               //se calculeaza scorul pe fiecare runda
            totalJoc = totalJoc + totalRunda; //se calculeaza scorul total

            lista3.add(totalRunda);           //se stocheaza scorul fiecarei runde
            lista4.add(totalJoc);             //se stocheaza si scorul total pe joc
            //           System.out.println("Runda " + (i+1) + ":\npopice tintite la prima incercare: " + a + "\npopice tintite la a doua incercare: " + b + "\nPuncte runda " + (i+1) + ": " + x + "\nPunctaj curent: " + total+"\n");
            System.out.println("================================== Runda " + (i + 1) + " =======================================" +
                    "\npopice tintite la prima incercare: " + a + "\t\t" +
                    "popice tintite la a doua incercare: " + b +
                    "|" +
                    "\t\tPuncte runda " + (i + 1) + ": " + totalRunda);
        }

        for (int i = 0; i < 10; i++) {                                                 // Pentru fiecare runda de joc
            int j = i + 1;                                                             //se preia din avans
            if (i == 9) {
                j = 9;
            }
            if (lista.get(i).equals(10)) {                                             //lista1 retine scor pentru prima valoar,e in caz Spare
                finalTotal = finalTotal + (int) lista3.get(i) + (int) lista3.get(j);   //in caz de Strike se preia totalul din runda curenta si runda urmatoare
            } else if (lista3.get(i).equals(10) && !lista.get(i).equals(10)) {
                finalTotal = finalTotal + (int) lista3.get(i) + (int) lista.get(j);    //in caz de Spare se ia din lista3(total) si lista(prima valoare) din urmatoarea runda
            } else {
                finalTotal = finalTotal + (int) lista3.get(i);                         //daca nu e niciun caz se adauga punctajul pur s simplu
            }
        }
    }

    public Joc() throws IOException {              //contructor prin care pot desemna cati playeri sa joace acest joc.
        Scanner input = new Scanner(System.in);
        System.out.println("Bun venit la Bowling. Te rugam sa introduci numele tau:");
        nume = input.nextLine();
        nrPlayer++;
        System.out.println("Salutare, " + nume.toUpperCase());
        if (nrPlayer == 2) {
            System.out.print("Esti jucatorul cu numarul " + nrPlayer + "\n\n");
        }
    }
}

