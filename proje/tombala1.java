import java.util.Scanner;

public class tombala1 implements tutarInterface{
    int  tutar;
    protected int[] taslar = new int[90];
    protected int[] taslar1 = new int[90];
    protected int[] taslar2 = new int[90]; // bunu çekilen taşları kaydetmek için kullanıyoruz
    protected int[][] kart1 = new int[3][9];
    protected int[][] kart2 = new int[3][9];
    protected int rdn, sayac1 = 0, sayac2 = 0;
    String cevap;
    Scanner scann = new Scanner(System.in);

    public tombala1() {
        System.out.println("Tombalaya hoşgeldiniz");
    }

    Ana nesneAna = new Ana();
    
    @Override
    public void tutar()
    {    
        String tutarS="";
        Boolean tutarKontrol=true;
        int i,j;

        while(true)// exception kullandı.
        {
            System.out.print("Oynamak istediğiniz tutarı giriniz:");
            tutarS = scann.next();
            System.out.println();
            
            for (j = 0; j < tutarS.length(); j++) {
                if (tutarS.charAt(j) == '0' || tutarS.charAt(j) == '1' || tutarS.charAt(j) == '2' || tutarS.charAt(j) == '3'
                        || tutarS.charAt(j) == '4' || tutarS.charAt(j) == '5' || tutarS.charAt(j) == '6' || tutarS.charAt(j) == '7'
                        || tutarS.charAt(j) == '8' || tutarS.charAt(j) == '9') {
                    tutarKontrol=true;
                } else {
                    tutarKontrol = false;
                    break;
                }
            }
    
            if (tutarKontrol == true) {
                tutar = Integer.parseInt(tutarS);
                break;
            } else {
                Exception sayiKontrol = new Exception("Kural dışı durum:Sayi girilmedi!!!");
                System.out.println(sayiKontrol.getMessage()+"\n");
            }
        }

        while (true) {
            if (tutar > nesneAna.cip) {
                System.out.println("YETERSİZ BAKİYE");
            } else {
                nesneAna.cip -= tutar;
                break;
            }
            System.out.print("Oynamak istediğiniz tutarı tekrar giriniz:");
            tutar = scann.nextInt();
            System.out.println();
        }
    }

    

   
    public void taslaraDegerGir() {
        for (int i = 0; i < 90; i++) {
            taslar[i] = i + 1;
            taslar1[i] = i + 1;
            taslar2[i] = i + 1;
        }
    }

    public void kartOlustur() {
        int i, j;
        taslaraDegerGir();
        // 1.kart için
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 9; j++) {
                switch (i) {
                    case 0:
                        if (j == 1)
                            kart1[i][j] = 0;
                        else if (j == 3)
                            kart1[i][j] = 0;
                        else if (j == 5)
                            kart1[i][j] = 0;
                        else if (j == 8)
                            kart1[i][j] = 0;
                        else {
                            random();
                            while (true) {
                                if (taslar[rdn] == 0)
                                    random();
                                else {
                                    kart1[i][j] = taslar[rdn];
                                    taslar[rdn] = 0;
                                    break;
                                }
                            }
                        }
                        break;

                    case 1:
                        if (j == 0)
                            kart1[i][j] = 0;
                        else if (j == 2)
                            kart1[i][j] = 0;
                        else if (j == 4)
                            kart1[i][j] = 0;
                        else if (j == 6)
                            kart1[i][j] = 0;
                        else {
                            while (true) {
                                random();
                                if (taslar[rdn] == 0)
                                    random();
                                else {
                                    kart1[i][j] = taslar[rdn];
                                    taslar[rdn] = 0;
                                    break;
                                }
                            }
                        }
                        break;

                    case 2:
                        if (j == 1)
                            kart1[i][j] = 0;
                        else if (j == 3)
                            kart1[i][j] = 0;
                        else if (j == 5)
                            kart1[i][j] = 0;
                        else if (j == 7)
                            kart1[i][j] = 0;
                        else {
                            random();
                            while (true) {
                                random();
                                if (taslar[rdn] == 0)
                                    random();
                                else {
                                    kart1[i][j] = taslar[rdn];
                                    taslar[rdn] = 0;
                                    break;
                                }
                            }

                        }
                        break;
                }
            }
        }

        // 2.kart için
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 9; j++) {
                switch (i) {
                    case 0:
                        if (j == 1)
                            kart2[i][j] = 0;
                        else if (j == 3)
                            kart2[i][j] = 0;
                        else if (j == 5)
                            kart2[i][j] = 0;
                        else if (j == 8)
                            kart2[i][j] = 0;
                        else {
                            random();
                            while (true) {
                                if (taslar[rdn] == 0)
                                    random();
                                else {
                                    kart2[i][j] = taslar[rdn];
                                    taslar[rdn] = 0;
                                    break;
                                }
                            }
                        }
                        break;

                    case 1:
                        if (j == 0)
                            kart2[i][j] = 0;
                        else if (j == 2)
                            kart2[i][j] = 0;
                        else if (j == 4)
                            kart2[i][j] = 0;
                        else if (j == 6)
                            kart2[i][j] = 0;
                        else {
                            while (true) {
                                random();
                                if (taslar[rdn] == 0)
                                    random();
                                else {
                                    kart2[i][j] = taslar[rdn];
                                    taslar[rdn] = 0;
                                    break;
                                }
                            }
                        }
                        break;

                    case 2:
                        if (j == 1)
                            kart2[i][j] = 0;
                        else if (j == 3)
                            kart2[i][j] = 0;
                        else if (j == 5)
                            kart2[i][j] = 0;
                        else if (j == 7)
                            kart2[i][j] = 0;
                        else {
                            random();
                            while (true) {
                                random();
                                if (taslar[rdn] == 0)
                                    random();
                                else {
                                    kart2[i][j] = taslar[rdn];
                                    taslar[rdn] = 0;
                                    break;
                                }
                            }

                        }
                        break;
                }
            }
        }
    }

    public void random() {
        rdn = (int) (Math.random() * 90);
    }

    public void kartBastir(int kartSahibi) {
        int i, j;
        kartOlustur();
        switch (kartSahibi) {
            case 1:
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 9; j++) {
                        if (kart1[i][j] == 0) {
                            System.out.print("|  | ");
                        } else {
                            if (kart1[i][j] < 10)
                                System.out.print("| " + kart1[i][j] + "| ");
                            else
                                System.out.print("|" + kart1[i][j] + "| ");
                        }
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (i = 0; i < 3; i++) {
                    for (j = 0; j < 9; j++) {
                        if (kart2[i][j] == 0) {
                            System.out.print("|  | ");
                        } else {
                            if (kart2[i][j] < 10)
                                System.out.print("| " + kart2[i][j] + "| ");
                            else
                                System.out.print("|" + kart2[i][j] + "| ");
                        }
                    }
                    System.out.println();
                }
                break;
        }
    }

    public void oyunOyna() {
        int i, j;
        System.out.println("Kartınız \n");
        kartBastir(1);
        System.out.println("\n");
        System.out.println("Kasa Kart\n");
        kartBastir(2);

        System.out.println("Oyun Başlıyor\n");
        ThreadSleep(1000);

        while (true) {
            if (sayac1 == 27) {
                System.out.println("TOMBALA\n");
                System.out.println("Tebrikler oyunu kazandınız\n" + tutar * 5 + " çip kazandınız");
                nesneAna.cip += tutar * 5;
                break;
            } else if (sayac2 == 27) {
                System.out.println("TOMBALA\n");
                System.out.println("Kasa Kazandı \n" + tutar + " çip kaybettiniz");
                nesneAna.cip -= tutar;
                break;
            }

            random();
            while (true) {
                if (taslar2[rdn] == 0)
                    random();
                else {
                    System.out.println("Çekilen Taş: " + taslar2[rdn]);
                    ThreadSleep(250);
                    for (i = 0; i < 3; i++) {
                        for (j = 0; j < 9; j++) {
                            if (kart1[i][j] == taslar2[rdn]) {
                                System.out.println("\nTaş oyuncuda\n");
                                ThreadSleep(250);
                                sayac1++;
                            } else if (kart2[i][j] == taslar2[rdn]) {
                                System.out.println("\nTaş kasada\n");
                                ThreadSleep(250);
                                sayac2++;
                            }
                        }
                    }

                    break;
                }
            }
        }

    }

    public void ThreadSleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}