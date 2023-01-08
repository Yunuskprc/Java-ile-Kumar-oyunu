import java.util.Scanner;

public class UyeGirisi {

    public class KayitOl {
        private String kAdi, sifre, sifreT;
        Scanner scann = new Scanner(System.in);

        public void setSifre(String sifre) {
            this.sifre = sifre;
        }

        public void setSifreT(String sifreT) {
            this.sifreT = sifreT;
        }

        public void setkAdi(String kAdi) {
            this.kAdi = kAdi;
        }

        public String getSifre() {
            return sifre;
        }

        public String getSifreT() {
            return sifreT;
        }

        public String getkAdi() {
            return kAdi;
        }

        public KayitOl() {
            System.out.println("\nHosGeldiniz lütfen kayıt olunuz\n");
        }

        public KayitOl(String kadii) {
            System.out.print(kadii);
            kAdi = scann.next();

            do {
                System.out.print("Şifrenizi giriniz: ");
                sifre = scann.next();
                System.out.print("Şifrenizi tekrar giriniz: ");
                sifreT = scann.next();

                if (sifre.equals(sifreT)) {
                    System.out.println("\nKayıt başarılı");
                    break;
                } else {
                    System.out.println("Şifreler farklı Tekrar deneyin");
                }

            } while (true);

        }
    }

    private String kadi, sifre;
    Scanner scann = new Scanner(System.in);

    public void setKadi(String kadi) {
        this.kadi = kadi;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getKadi() {
        return kadi;
    }

    public String getSifre() {
        return sifre;
    }

    public UyeGirisi() {
        System.out.println("Giriş Yapınız\n");
    }

    public UyeGirisi(String kadii) {
        KayitOl nesnKayitOl = new KayitOl();
        KayitOl nesnKayitOl2 = new KayitOl("Kullanıcı Adı: ");
        UyeGirisi nUyeGirisi = new UyeGirisi();
        do {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            System.out.println(kadii);
            kadi = scann.next();
            System.out.println("Şifrenizi giriniz");
            sifre = scann.next();

            if (kadi.equals(nesnKayitOl2.kAdi)) {
                if (sifre.equals(nesnKayitOl2.sifre)) {
                    System.out.println("\nGiriş başarılı İyi eğlenceler");
                    break;
                } else {
                    System.out.println("Şifre hatalı tekrar deneyin");
                }
            } else {
                System.out.println("Kullanıcı adı bulunamadı tekrar deneyin");
            }
        } while (true);
    }
}
