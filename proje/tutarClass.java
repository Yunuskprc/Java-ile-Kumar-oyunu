import java.util.Scanner;

public class tutarClass {
    static int tutar;
    Scanner scann = new Scanner(System.in);
    public String tutarS="";
    public Boolean tutarKontrol=true;
    public int i,j;

    public void tutar() {
        Ana nesneANA = new Ana();
        
        
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
            if (tutar > nesneANA.cip) {
                System.out.println("YETERSİZ BAKİYE");
            } else {
                nesneANA.cip -= tutar;
                break;
            }
            System.out.print("Oynamak istediğiniz tutarı tekrar giriniz:");
            tutar = scann.nextInt();
            System.out.println();
        }
    }

}
