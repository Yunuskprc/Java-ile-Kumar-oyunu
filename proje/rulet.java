import java.util.Scanner;

public class rulet extends tutarClass {
    protected int[] ruletDger = new int[38];
    protected int cevap;
    protected int rnd;
    protected String cevapS;

    
    Ana nesneAna = new Ana();

    public static final String ANSI_KIRMIZI = "\u001B[31m";
    public static final String ANSI_YEŞİL = "\u001B[32m";
    public static final String ANSI_MAVI = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    Scanner scann = new Scanner(System.in);

    public rulet()
    {
        System.out.println("Rulete Hoşgeldiniz");
    }

    public void diziDegerAtama() {
        int i;
        for (i = 0; i < 37; i++) {
            ruletDger[i] = i;
        }
        ruletDger[37] = 0;
    }


    public void sekil() {
        int i, j;
        for (i = 1; i < 4; i++) {
            switch (i) {
                case 1:
                    System.out.print("     ");
                    for (j = 1; j < 13; j++) {
                        if (j == 10 || j == 11 || j == 12) {
                            if (j % 2 == 0)
                                System.out.print(ANSI_MAVI + "|" + ruletDger[j] + "| ");
                            else
                                System.out.print(ANSI_KIRMIZI + "|" + ruletDger[j] + "| ");
                        } else {
                            if (j % 2 == 0)
                                System.out.print(ANSI_MAVI + "| " + ruletDger[j] + "| ");
                            else
                                System.out.print(ANSI_KIRMIZI + "| " + ruletDger[j] + "| ");
                        }
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.print(ANSI_YEŞİL + " |0| ");
                    for (j = 13; j < 25; j++) {
                        if (j % 2 == 0)
                            System.out.print(ANSI_MAVI + "|" + ruletDger[j] + "| ");
                        else
                            System.out.print(ANSI_KIRMIZI + "|" + ruletDger[j] + "| ");
                    }
                    System.out.print(ANSI_YEŞİL + " |0| ");
                    System.out.println();
                    break;
                case 3:
                    System.out.print("     ");
                    for (j = 25; j < 37; j++) {
                        if (j % 2 == 0)
                            System.out.print(ANSI_MAVI + "|" + ruletDger[j] + "| ");
                        else
                            System.out.print(ANSI_KIRMIZI + "|" + ruletDger[j] + "| ");
                    }
                    System.out.println();
                    break;

            }
        }
        System.out.println(ANSI_RESET + "");
    }

    public void oyunOyna() {
        diziDegerAtama();
        System.out.println();
        sekil();
        
        System.out.println("\n\t\t\t\t\t\t\tİddia Seçenekleri \n");
        System.out.print("1-)Renkler (*2,*2,*18)\t\t");
        System.out.print("2-)Aralık (*3)\t\t");
        System.out.print("3-)Tek-Çift (*2)\t\t");
        System.out.print("4-)Belirli Bir Sayıya Oynama (*36)\t\t\n");

        System.out.println("\nHangi bahise oynamak istiyorsunuz ?\t\t");
        cevap = scann.nextInt();
        // case 1 de sorun var tüm rndleri ruletdeger[rnd]ye çevir
        switch (cevap) {
            case 1:
                System.out.println("Hangi renge oynamak istiyorsunuz (yesil/kirmizi/mavi)?");
                cevapS = scann.next();
                if (cevapS.equals("yesil")) 
                {
                    topDondur();
                    if (ruletDger[rnd] == 0) 
                    {
                        System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|0|" + ANSI_RESET);
                        nesneAna.cip += tutar * 18;
                        System.out.println("Tebrikler " + (tutar * 18) + " çip kazandınız.");
                    } 
                    else
                    {
                        if (ruletDger[rnd] % 2 == 0) 
                        {
                            System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                            System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                        } 
                        else 
                        {
                            System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                            System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                        }
                    }
                } 
                else if (cevapS.equals("kirmizi"))
                {
                    topDondur();
                    if (ruletDger[rnd] % 2 == 0  &&  ruletDger[rnd]!=0) 
                    {
                        System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                        System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                    }
                    else if(ruletDger[rnd] == 0)
                    {
                        System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|" + rnd + "|" + ANSI_RESET);
                        System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                    } 
                    else 
                    {
                        nesneAna.cip += tutar * 2;
                        System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                        System.out.println("Tebrikler " + (tutar * 2) + " çip kazandınız.");
                    }

                } 
                else if (cevapS.equals("mavi")) 
                {
                    topDondur();
                    if (ruletDger[rnd] % 2 == 0  &&  ruletDger[rnd]!=0) 
                    {
                        nesneAna.cip += tutar * 2;
                        System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                        System.out.println("Tebrikler " + (tutar * 2) + " çip kazandınız.");
                    }
                    else if(ruletDger[rnd] == 0)
                    {
                        System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|" + rnd + "|" + ANSI_RESET);
                        System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                    } 
                    else 
                    {
                        System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                        System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                    }
                }

                break;

            case 2:
                System.out.println("Hangi aralığa oynamak istiyorsunuz (1-12, 13-24, 25-36)");
                cevap = scann.nextInt();
                switch (cevap) {
                    case 1:
                        topDondur();
                        if (ruletDger[rnd] >= 1 && ruletDger[rnd] <= 12) 
                        {
                            if (ruletDger[rnd] % 2 == 0  &&  ruletDger[rnd]!=0) 
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                            }
                            else if(ruletDger[rnd] == 0)
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                            } 
                            else 
                            {
                                nesneAna.cip += tutar * 2;
                                System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Tebrikler " + (tutar * 2) + " çip kazandınız.");
                            }
                        } 
                        else 
                        {
                            if (ruletDger[rnd] % 2 == 0  &&  ruletDger[rnd]!=0) 
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                            }
                            else if(ruletDger[rnd] == 0)
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                            } 
                            else 
                            {
                                nesneAna.cip += tutar * 2;
                                System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Tebrikler " + (tutar * 2) + " çip kazandınız.");
                            }
                        }
                        break;

                    case 2:
                        topDondur();
                        if (rnd >= 13 && rnd <= 24)
                        {
                            if (ruletDger[rnd] % 2 == 0  &&  ruletDger[rnd]!=0) 
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                            }
                            else if(ruletDger[rnd] == 0)
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                            } 
                            else 
                            {
                                nesneAna.cip += tutar * 2;
                                System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Tebrikler " + (tutar * 2) + " çip kazandınız.");
                            }
                        } 
                        else 
                        {
                            if (ruletDger[rnd] % 2 == 0  &&  ruletDger[rnd]!=0) 
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                            }
                            else if(ruletDger[rnd] == 0)
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                            } 
                            else 
                            {
                                nesneAna.cip += tutar * 2;
                                System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Tebrikler " + (tutar * 2) + " çip kazandınız.");
                            }
                        }
                        break;

                    case 3:
                        topDondur();
                        if (rnd >= 25 && rnd <= 36)
                        {
                            if (ruletDger[rnd] % 2 == 0  &&  ruletDger[rnd]!=0) 
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                            }
                            else if(ruletDger[rnd] == 0)
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                            } 
                            else 
                            {
                                nesneAna.cip += tutar * 2;
                                System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Tebrikler " + (tutar * 2) + " çip kazandınız.");
                            }
                        } 
                        else 
                        {
                            if (ruletDger[rnd] % 2 == 0  &&  ruletDger[rnd]!=0) 
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                            }
                            else if(ruletDger[rnd] == 0)
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa Kazandı " + (tutar) + " çip kaybettiniz.");
                            } 
                            else 
                            {
                                nesneAna.cip += tutar * 2;
                                System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Tebrikler " + (tutar * 2) + " çip kazandınız.");
                            }
                        }
                        break;
                }
                break;

            case 3:
                System.out.println("Tek mi Çift mi? (Tek için 1, Çift için 2)");
                cevap = scann.nextInt();
                topDondur();
                switch (cevap) 
                {
                    case 1:
                        if (ruletDger[rnd] % 2 == 1) 
                        {
                            nesneAna.cip += tutar * 2;
                            System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                            System.out.println("Tebrikler " + (tutar * 2) + " çip kazandınız.");
                        } else 
                        {
                            if (ruletDger[rnd] != 0) 
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa kazandı " + (tutar) + " çip kaybettiniz.");
                            } 
                            else 
                            {
                                System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Kasa kazandı " + (tutar) + " çip kaybettiniz.");
                            }

                        }
                        break;

                    case 2:
                        if (ruletDger[rnd] % 2 == 0) 
                        {
                            if (ruletDger[rnd] != 0) 
                            {
                                nesneAna.cip += tutar * 2;
                                System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Tebrikler " + (tutar * 2) + " çip kazandınız.");
                            } 
                            else 
                            {
                                nesneAna.cip += tutar * 2;
                                System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|" + rnd + "|" + ANSI_RESET);
                                System.out.println("Tebrikler " + (tutar * 2) + " çip kazandınız.");
                            }
                        } 
                        else 
                        {
                            System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                            System.out.println("Kasa kazandı  " + (tutar) + " çip kaybettiniz.");
                        }
                        break;
                }
                break;
            case 4:
                System.out.print("Hangi sayıya oynamak istiyorsunuz:");
                cevap = scann.nextInt();
                topDondur();
                if(cevap==ruletDger[rnd])
                {
                    if(ruletDger[rnd]%2==0)
                    {
                        if(ruletDger[rnd]==0)
                        {
                            nesneAna.cip+=tutar*38;
                            System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|" + rnd + "|" + ANSI_RESET);
                            System.out.println("Tebrikler " + (tutar * 38) + " çip kazandınız.");
                        }
                        else
                        {
                            nesneAna.cip+=tutar*38;
                            System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                            System.out.println("Tebrikler " + (tutar * 38) + " çip kazandınız.");
                        }
                    }
                    else
                    {
                        nesneAna.cip+=tutar*38;
                        System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                        System.out.println("Tebrikler " + (tutar * 38) + " çip kazandınız.");
                    }
                }
                else
                {
                    if(ruletDger[rnd]%2==0)
                    {
                        if(ruletDger[rnd]==0)
                        {
                            System.out.println("Kazanan Sayı: " + ANSI_YEŞİL + "|" + rnd + "|" + ANSI_RESET);
                            System.out.println("Kasa kazandı  " + (tutar) + " çip kaybettiniz.");
                        }
                        else
                        {
                            System.out.println("Kazanan Sayı: " + ANSI_MAVI + "|" + rnd + "|" + ANSI_RESET);
                            System.out.println("Kasa kazandı " + (tutar) + " çip kaybettiniz.");
                        }
                    }
                    else
                    {
                        System.out.println("Kazanan Sayı: " + ANSI_KIRMIZI + "|" + rnd + "|" + ANSI_RESET);
                        System.out.println("Kasa kazandı " + (tutar) + " çip kaybettiniz.");
                    }
                }
                break;
        }

    }

    public void topDondur() {
        System.out.println("\nTop Döndürülüyor\n");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        rnd = (int) (Math.random() * 38);
    }
}