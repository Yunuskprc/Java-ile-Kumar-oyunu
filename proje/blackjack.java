import java.util.Scanner;

public class blackjack extends tutarClass {
    public int diziSec = 0, kartSec = 0; // matrise erişmek için
    public String cevap, sigortaCevap = ""; // sorulara cecavp için
    public int kasaTop = 0, oyuncuTop = 0;
    public int sigortaDeger;
    public String[][] dizi = { { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" },{ "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" }, { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" },{ "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" } };
    public String[] kasaKart = { "*", "*", "*", "*", "*", "*" };
    public String[] oyuncuKart = { "*", "*", "*", "*", "*", "*" };

    Scanner scann = new Scanner(System.in);

    public blackjack()
    {
        System.out.println("Blackjack a hoşgeldiniz");
    }

    public blackjack(int a)
    {
        System.out.println("\n\n\t\t Oyun "+a+" Saniye sonra Başlıyor");
        try {
            Thread.sleep(a*2000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println("\nKartlar Dağıtılıyor");
    }

    Ana nesneAna = new Ana();

    public void OyunOyna() {
        int i = 2, j = 2;
        
        
        KartDagit(0, 1);
        KartDagit(0, 2);
        KartDagit(1, 1);
        KartDagit(1, 2);
        kartDeger(oyuncuKart[0], 1);
        kartDeger(oyuncuKart[1], 1);
        System.out.println("Oyuncu Kart:" + oyuncuKart[0] + " " + oyuncuKart[1] + " Toplam:" + oyuncuTop);
        System.out.println("Kasa kart:* " + kasaKart[1]);
        System.out.println("\n");
        // oyuncu oyun başında blackjack yaparsa
        if (oyuncuTop == 21) {
            System.out.println("Kasa kartlarını açıyor");
            kartDeger(kasaKart[0], 2);
            kartDeger(kasaKart[1], 2);
            System.out.print("Kasa kart: " + kasaKart[0] + " " + kasaKart[1] + " ");

            while (true) {
                if (kasaTop <= 16) {
                    KartDagit(j, 2);
                    kartDeger(kasaKart[j], 2);
                    try {
                        Thread.sleep(400);
                    } catch (Exception e) {
                    }
                    System.out.print(kasaKart[j] + " ");
                } else {
                    break;
                }
                j++;
            }

            if (kasaTop < oyuncuTop) {
                System.out.println("Oyuncu kazandı\n" + tutar * 2 + " çip kazandınız");
                nesneAna.cip += tutar * 2;
                System.exit(0);
            } else if (kasaTop == oyuncuTop) {
                System.out.println("Oyun Beraberer bitti\n" + tutar + " çip kazandınız");
                nesneAna.cip += tutar;
                System.exit(0);
            }
        }

        if (oyuncuTop > 21) {
            System.out.println("Kasa kazandı " + tutar + "çip kaybettiniz");
            System.exit(0);
        }
        // sigorta durumu soruldu
        if (kasaKart[1].equals("1")) {
            if (nesneAna.cip > (tutar + tutar / 2)) {
                System.out.println("Sigorta yapmak ister misiniz ? (evet/hayir)");
                sigortaCevap = scann.next();
                if (sigortaCevap.equals("evet")) {
                    sigortaDeger = tutar / 2;
                    tutar += sigortaDeger;
                    nesneAna.cip = nesneAna.cip - sigortaDeger;
                    System.out.println("Sigorta yapıldı oynanan yeni tutar: " + tutar);
                    kartCekme();
                    System.exit(0);
                } else if (sigortaCevap.equals("hayir")) {
                    System.out.println("Sigorta yapılmadı oyun devam ediyor");
                    kartCekme();
                    System.exit(0);
                } else {
                    System.out.println("Hatalı cevap girişi");
                }
            } else {
                System.out.println("Çip miktarı yetersiz sigorta yapılamıyor oyun devam ediyor");
                kartCekme();
                System.exit(0);
            }
        }

        kartCekme();
        cevap="";
        sigortaCevap="";kasaTop=0;
        oyuncuTop=0;
        sigortaDeger=0;

    }

    public void kartCekme() {
        int i = 2;
        while (true) {
            System.out.println("Kart çekmek ister misiniz ? (evet/hayir)");
            cevap = scann.next();

            if (cevap.equals("evet")) {
                KartDagit(i, 1);
                kartDeger(oyuncuKart[i], 1);
                System.out.println("Çekilen Kart:" + oyuncuKart[i] + "  Toplam:" + oyuncuTop);

                if (oyuncuTop == 21) {
                    System.out.println("Kasa kartlarını açıyor");
                    kartDeger(kasaKart[0], 2);
                    kartDeger(kasaKart[1], 2);
                    System.out.print("Kasa kart: " + kasaKart[0] + " " + kasaKart[1] + " ");

                    while (true) {
                        if (kasaTop <= 16) {
                            KartDagit(i, 2);
                            kartDeger(kasaKart[i], 2);
                            try {
                                Thread.sleep(400);
                            } catch (Exception e) {
                            }
                            System.out.print(kasaKart[i] + " ");
                        } else {
                            break;
                        }
                        i++;
                    }

                    if (kasaTop < oyuncuTop) {
                        System.out.println("Oyuncu kazandı\n" + tutar * 2 + " çip kazandınız");
                        nesneAna.cip += tutar * 2;
                    } else if (kasaTop == oyuncuTop) {
                        System.out.println("Oyun Beraberer bitti\n" + tutar + " çip kazandınız");
                        nesneAna.cip += tutar;
                    }
                    break;
                }

                else if (oyuncuTop > 21) {
                    if (sigortaCevap.equals("evet")) {
                        System.out.println("Kasa kazandı " + sigortaDeger + " çip kaybettiniz");
                    } else
                        System.out.println("Kasa kazandı " + tutar + " çip kaybettiniz");
                    break;
                }
            } else if (cevap.equals("hayir")) {
                System.out.println("Kasa kartlarını açıyor");
                kartDeger(kasaKart[0], 2);
                kartDeger(kasaKart[1], 2);
                System.out.print("Kasa kart: " + kasaKart[0] + " " + kasaKart[1] + " ");

                while (true) {
                    if (kasaTop <= 16) {
                        KartDagit(i, 2);
                        kartDeger(kasaKart[i], 2);
                        try {
                            Thread.sleep(400);
                        } catch (Exception e) {
                        }
                        System.out.print(kasaKart[i] + " ");
                    } else {
                        break;
                    }
                    i++;
                }

                if (kasaTop > 21) {
                    System.out.println("Kasa kaybetti " + tutar * 2 + " çip kazandınız");
                    nesneAna.cip += tutar * 2;
                } else if (kasaTop == 21) {
                    if (oyuncuTop == 21) {
                        System.out.println("Oyun berabere bitti");
                        nesneAna.cip += tutar;
                    } else {
                        System.out.println("Kasa kazandı " + tutar + " çip kaybettiniz");
                    }
                } else {
                    if (kasaTop > oyuncuTop) {
                        if (sigortaCevap.equals("evet")) {
                            System.out.println("Kasa kazandı " + sigortaDeger + " çip kaybettiniz");
                        } else
                            System.out.println("Kasa kazandı\n" + tutar + " çip kaybettiniz");
                    } else if (kasaTop < oyuncuTop) {
                        System.out.println("Oyuncu kazandı\n" + tutar * 2 + " çip kazandınız");
                        nesneAna.cip += tutar * 2;
                    } else {
                        System.out.println("Oyun Beraberer bitti\n" + tutar + " çip kazandınız");
                        nesneAna.cip += tutar;
                    }
                }
                break;
            }
        }
    }

    public void kartDeger(String str, int kartsahibi) // eğer resimli kartlarla 1 gelirse 11 aksi taktirde 1 olarak
                                                      // hesaplanır
    {
        switch (kartsahibi) {
            case 1:
                if (str.equals("K"))
                    oyuncuTop += 10;
                else if (str.equals("Q"))
                    oyuncuTop += 10;
                else if (str.equals("J"))
                    oyuncuTop += 10;
                else if (str.equals("10"))
                    oyuncuTop += 10;
                else if (str.equals("9"))
                    oyuncuTop += 9;
                else if (str.equals("8"))
                    oyuncuTop += 8;
                else if (str.equals("7"))
                    oyuncuTop += 7;
                else if (str.equals("6"))
                    oyuncuTop += 6;
                else if (str.equals("5"))
                    oyuncuTop += 5;
                else if (str.equals("4"))
                    oyuncuTop += 4;
                else if (str.equals("3"))
                    oyuncuTop += 3;
                else if (str.equals("2"))
                    oyuncuTop += 2;
                else if (str.equals("1")) {
                    // for döngüsü ile yaparsak sürekli 1er 1er değer artıyor
                    if (oyuncuKart[0].equals("K") || oyuncuKart[0].equals("Q") || oyuncuKart[0].equals("J")) {
                        oyuncuTop += 11;
                    } else if (oyuncuKart[1].equals("K") || oyuncuKart[1].equals("Q") || oyuncuKart[1].equals("J")) {
                        oyuncuTop += 11;
                    } else if (oyuncuKart[2].equals("K") || oyuncuKart[2].equals("Q") || oyuncuKart[2].equals("J")) {
                        oyuncuTop += 11;
                    } else if (oyuncuKart[3].equals("K") || oyuncuKart[3].equals("Q") || oyuncuKart[3].equals("J")) {
                        oyuncuTop += 11;
                    } else if (oyuncuKart[4].equals("K") || oyuncuKart[4].equals("Q") || oyuncuKart[4].equals("J")) {
                        oyuncuTop += 11;
                    } else if (oyuncuKart[5].equals("K") || oyuncuKart[5].equals("Q") || oyuncuKart[5].equals("J")) {
                        oyuncuTop += 11;
                    } else {
                        oyuncuTop += 1;
                    }
                }
                break;
            case 2:
                if (str.equals("K"))
                    kasaTop += 10;
                else if (str.equals("Q"))
                    kasaTop += 10;
                else if (str.equals("J"))
                    kasaTop += 10;
                else if (str.equals("10"))
                    kasaTop += 10;
                else if (str.equals("9"))
                    kasaTop += 9;
                else if (str.equals("8"))
                    kasaTop += 8;
                else if (str.equals("7"))
                    kasaTop += 7;
                else if (str.equals("6"))
                    kasaTop += 6;
                else if (str.equals("5"))
                    kasaTop += 5;
                else if (str.equals("4"))
                    kasaTop += 4;
                else if (str.equals("3"))
                    kasaTop += 3;
                else if (str.equals("2"))
                    kasaTop += 2;
                else if (str.equals("1")) {
                    if (kasaKart[0].equals("K") || kasaKart[0].equals("Q") || kasaKart[0].equals("J")) {
                        kasaTop += 11;
                    } else if (kasaKart[1].equals("K") || kasaKart[1].equals("Q") || kasaKart[1].equals("J")) {
                        kasaTop += 11;
                    } else if (kasaKart[2].equals("K") || kasaKart[2].equals("Q") || kasaKart[2].equals("J")) {
                        kasaTop += 11;
                    } else if (kasaKart[3].equals("K") || kasaKart[3].equals("Q") || kasaKart[3].equals("J")) {
                        kasaTop += 11;
                    } else if (kasaKart[4].equals("K") || kasaKart[4].equals("Q") || kasaKart[4].equals("J")) {
                        kasaTop += 11;
                    } else if (kasaKart[5].equals("K") || kasaKart[5].equals("Q") || kasaKart[5].equals("J")) {
                        kasaTop += 11;
                    } else {
                        kasaTop += 1;
                    }
                }
                break;
        }
    }

    public void KartDagit(int dagitilanKartSayisi, int KartSahibi)// kartsahibi 1 ise oyuncu 2 ise kasa için kart
                                                                  // dağıtır
    {
        switch (KartSahibi) {
            case 1:
                diziSec = (int) (Math.random() * 4);
                kartSec = (int) (Math.random() * 13);
                if (dizi[diziSec][kartSec].equals("*")) {
                    KartDagit(dagitilanKartSayisi, 1);
                } else {
                    oyuncuKart[dagitilanKartSayisi] = dizi[diziSec][kartSec];
                    dizi[diziSec][kartSec] = "*";
                }
                break;

            case 2:
                diziSec = (int) (Math.random() * 4);
                kartSec = (int) (Math.random() * 13);
                if (dizi[diziSec][kartSec].equals("*")) {
                    KartDagit(dagitilanKartSayisi, 2);
                } else {
                    kasaKart[dagitilanKartSayisi] = dizi[diziSec][kartSec];
                    dizi[diziSec][kartSec] = "*";
                }
                break;
        }
    }
}