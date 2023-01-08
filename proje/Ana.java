import java.util.Scanner;

public class Ana {
    static public int cip;
    //rulet 2.oyun 5 2.aralıkta

    public static void main(String[] args) {
        UyeGirisi nUyeGirisi2 = new UyeGirisi("Kullanıcı Adınızı giriniz");
        int secim;
        String cevap;
        String cipS = "";
        Boolean kontrol = true;
        int i, j;
        Scanner scann = new Scanner(System.in);

        while (true)// exception kullandı.
        {
            System.out.print("Satın Almak İstediğiniz çip miktarını girin: ");
            cipS = scann.next();

            for (j = 0; j < cipS.length(); j++) {
                if (cipS.charAt(j) == '0' || cipS.charAt(j) == '1' || cipS.charAt(j) == '2' || cipS.charAt(j) == '3'
                        || cipS.charAt(j) == '4' || cipS.charAt(j) == '5' || cipS.charAt(j) == '6'
                        || cipS.charAt(j) == '7'
                        || cipS.charAt(j) == '8' || cipS.charAt(j) == '9') {
                    kontrol = true;
                } else {
                    kontrol = false;
                    break;
                }
            }

            if (kontrol == true) {
                cip = Integer.parseInt(cipS);
                break;
            } else {
                Exception sayiKontrol = new Exception("Kural dışı durum:Sayi girilmedi!!!");
                System.out.println(sayiKontrol.getMessage() + "\n");
            }
        }

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        System.out.println("İşlem Başaralı!\n\n Güncel bakiye: " + cip);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        do {
            System.out.println("\n\n\t\tOyunlar");
            System.out.println("\n1-)Blackjack\t2-)Rulet\t3-)Slot\t\t4-)Tombala");
            System.out.println("Hangi oyunu oynamak istiyorsunuz ?");
            secim = scann.nextInt();
            System.out.println("\n");

            switch (secim) {
                case 1:
                    blackjack nesneBJ = new blackjack();
                    nesneBJ.tutar();
                    do {
                        blackjack nesneBJ1 = new blackjack(1);
                        nesneBJ.OyunOyna();
                        System.out.println("\n");
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                        System.out.println("Güncel Bakiye: " + cip);
                        System.out.println("\nTekrar Oynamak ister misiniz?(evet/hayir)");
                        cevap = scann.next();
                        if (cevap.equals("evet")) {
                            nesneBJ.tutar();
                            System.out.println("\nOyun Başlıyor\n");
                        } else if (cevap.equals("hayir")) {
                            System.out.println("\nİyi günler");
                            break;
                        }

                        cevap = "";

                    } while (true);

                    System.out.println("\ngüncel çip:" + cip);
                    break;

                case 2:
                    rulet nesneRulet = new rulet();
                    nesneRulet.tutar();
                    do {
                        nesneRulet.oyunOyna();
                        System.out.println("\n");
                        System.out.println("Güncel Bakiye: " + cip);
                        System.out.println("\nTekrar Oynamak ister misiniz?(evet/hayir)");
                        cevap = scann.next();
                        if (cevap.equals("evet")) {
                            nesneRulet.tutar();
                            System.out.println("Oyun Başlıyor\n");
                        } else if (cevap.equals("hayir")) {
                            System.out.println("İyi günler");
                            break;
                        }
                        cevap = "";
                    } while (true);
                    System.out.println("güncel çip:" + cip);
                    break;

                case 3:
                    slot nesneSlot = new slot();
                    nesneSlot.tutar();
                    do {
                        nesneSlot.oyunOyna();
                        System.out.println("\n");
                        System.out.println("Tekrar Oynamak ister misiniz?(evet/hayir)");
                        cevap = scann.next();
                        if (cevap.equals("evet")) {
                            nesneSlot.tutar();
                            System.out.println("Oyun Başlıyor\n");
                        } else if (cevap.equals("hayir")) {
                            System.out.println("\nİyi günler\n");
                            break;
                        }
                        cevap = "";
                    } while (true);
                    System.out.println("\ngüncel çip:" + cip + "\n");

                    break;

                case 4:
                    tombala1 nesneTombala = new tombala1();
                    nesneTombala.tutar();
                    do {
                        nesneTombala.oyunOyna();
                        System.out.println("\n");
                        System.out.println("Tekrar Oynamak ister misiniz?(evet/hayir)");
                        cevap = scann.next();
                        if (cevap.equals("evet")) {
                            nesneTombala.tutar();
                            System.out.println("Oyun Başlıyor\n");
                        } else if (cevap.equals("hayir")) {
                            System.out.println("\nİyi günler\n");
                            break;
                        }
                        cevap = "";
                    } while (true);
                    System.out.println("\ngüncel çip:" + cip + "\n");
                    break;

            }

            System.out.println("Başka bir oyun oynamak istiyor musunuz ?");
            cevap = scann.next();
            if (cevap.equals("evet")) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            } else {
                System.out.println("\nİyi Günler");
                break;
            }
        } while (cip > 0);
    }
}
