import java.util.Scanner;
import java.lang.Thread;

public class slot extends tutarClass{
    public String[] dizi = new String[8];
    public String str1, str2, str3;
    public int sayi1, sayi2, sayi3;
    public int[] uzunluk = new int[8];
    Scanner klavye = new Scanner(System.in);
    Ana nesneAna = new Ana();

    public slot()
    {
        System.out.println("Slot Makinesine Hoşgeldiniz");
    }

    public void diziDegerAtama() {
        dizi[7] = "kavun";
        dizi[6] = "çilek";
        dizi[5] = "armut";
        dizi[4] = "kiraz";
        dizi[3] = "limon";
        dizi[2] = "dolar";
        dizi[1] = "mango";
        dizi[0] = "havuç";
    }


    public void randomAtama() {
        sayi1 = (int) (Math.random() * 8);
        sayi2 = (int) (Math.random() * 8);
        sayi3 = (int) (Math.random() * 8);
    }

    public void oyunOyna() {
        int i, j;
        diziDegerAtama();
        randomAtama();
        System.out.println("Oyun başlıyor...\n");
        System.out.println("Kol Çevriliyor...\n");
        ciktiDegistir();

        System.out.print(dizi[sayi1] + " " + dizi[sayi2] + " " + dizi[sayi3]);
        try {Thread.sleep(300);} catch (Exception e) {e.printStackTrace();}

        for (i = 0; i < 8; i++) {
            for (j = 22; j > 0; j--) {
                System.out.print("\b");
            }
            System.out.print(dizi[(int) (Math.random() * 8)] + " | " + dizi[(int) (Math.random() * 8)] + " | " + dizi[(int) (Math.random() * 8)] + " ");
            try {Thread.sleep(300);} catch (Exception e) {e.printStackTrace();}
        }
        try {Thread.sleep(300);} catch (Exception e) {e.printStackTrace();}

        randomAtama();
        
        for (j = 22; j > 0; j--) {
            System.out.print("\b");
        }
        System.out.println(dizi[sayi1] + " | " + dizi[sayi2] + " | " + dizi[sayi3] + "\n");

        if (sayi1 == sayi2 && sayi2 == sayi3) {
            if (sayi1 == 2) {
                nesneAna.cip += tutar * 20;
                System.out.println((tutar * 20) + " Çip kazandınız.");
                System.out.println("Güncel bakiyeniz:" + nesneAna.cip);
            } else {
                nesneAna.cip += tutar * 10;
                System.out.println((tutar * 10) + " Çip kazandınız.");
                System.out.println("Güncel bakiyeniz:" + nesneAna.cip);
            }
        } else if (sayi1 == sayi2 || sayi1 == sayi3 || sayi2 == sayi3) {
            nesneAna.cip += tutar * 3;
            System.out.println((tutar * 3) + " Çip kazandınız.");
            System.out.println("Güncel bakiyeniz:" + nesneAna.cip);
        } else {
            System.out.println(tutar + " çip kaybettiniz.");
        }
    }

    public void ciktiDegistir() {
        int i;
        for (i = 0; i < 8; i++) {
            uzunluk[i] = dizi[i].length();
        }
    }
}