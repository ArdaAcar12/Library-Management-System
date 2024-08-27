import java.util.ArrayList;
import java.util.Scanner;

  public class Kitap {
    private String ISBN;
    private String Baslik;
    private String Tur;
    public KitapDurumu durum  ;

    public String getTur() {
        return Tur;
    }
    public void setTur(String tur) {
        Tur = tur;
    }
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBaslik() {
        return Baslik;
    }

    public void setBaslik(String baslik) {
        Baslik = baslik;
    }

    public KitapDurumu getDurum() { return durum; }
    public void setDurum(KitapDurumu durum) { this.durum = durum; }

    public Kitap(String ISBN, String baslik, String tur,KitapDurumu durum) {
        this.ISBN=ISBN;
        this.Baslik = baslik;
        this.Tur = tur;
        this.durum = KitapDurumu.MEVCUT;
    }

      public String toString() {
          return "ISBN: " + ISBN + ", Ad: " + Baslik + ", Tur: " +Tur;
      }
    public static Kitap kitapAlma(ArrayList<Kitap> kitapListesi) {
        Scanner bilgi = new Scanner(System.in);

        System.out.print("kitap ISBN giriniz: ");
        String ISBN = bilgi.nextLine();
        System.out.print("kitap turunu giriniz: ");
        String Tur = bilgi.nextLine();

        Kitap kitapBulunan = null;
        for (Kitap kitap : kitapListesi) {
            if (kitap.getISBN().equals(ISBN) && kitap.getTur().equalsIgnoreCase(Tur)) {
                kitapBulunan = kitap;
                break;
            }
        }
        if (kitapBulunan != null && kitapBulunan.durum == KitapDurumu.MEVCUT) {
            kitapBulunan.setDurum(KitapDurumu.ODUNC_VERILDI);
            System.out.println("Kitap başarıyla ödünç verildi: " + kitapBulunan.getISBN()+ (" ") +  kitapBulunan.getBaslik() + (" ")+kitapBulunan.getTur());
            return kitapBulunan;
        }
        else if (kitapBulunan != null && kitapBulunan.durum == KitapDurumu.ODUNC_VERILDI) {
            System.out.println("Bu kitap zaten ödünç verilmiş.");
        }
        else {
            System.out.println("Kitap bulunamadı.");
        }
        return null;
    }


      public static void iadeEtme(ArrayList<Uye> uyeListesi, ArrayList<Kitap> kitapListesi) {
          Scanner bilgi = new Scanner(System.in);
          System.out.print("İade edilecek kitabın ISBN giriniz: ");
          String ISBN = bilgi.nextLine();
          System.out.print("İade edilecek kitabın türünü giriniz: ");
          String Tur = bilgi.nextLine();
          System.out.print("İade edilecek kitabın Başlığını giriniz: ");
          String Baslik = bilgi.nextLine();

          Kitap iadeEdilecekKitap = null;

          for (Kitap kitap : kitapListesi) {
              if (kitap.getISBN().equals(ISBN) && kitap.getTur().equalsIgnoreCase(Tur) && kitap.getBaslik().equalsIgnoreCase(Baslik)) {
                  iadeEdilecekKitap = kitap;
                  break;
              }
          }

          if (iadeEdilecekKitap != null && iadeEdilecekKitap.getDurum() == KitapDurumu.ODUNC_VERILDI) {

              Uye kitapAlanUye = null;
                  for (Uye uye : uyeListesi) {
                      if (uye.getAldigiKitaplar().contains(iadeEdilecekKitap)) {
                          kitapAlanUye = uye;
                          break;
                      }
                  }

                      if (kitapAlanUye != null) {
                          kitapAlanUye.getAldigiKitaplar().remove(iadeEdilecekKitap);
                          iadeEdilecekKitap.setDurum(KitapDurumu.MEVCUT);
                          System.out.println("Kitap iade edildi ve mevcut duruma getirildi. Kitap, " + kitapAlanUye.getAd() + " " + kitapAlanUye.getSoyAd() + "  " + " isimli üyenin listesinden silindi.");
                      }
                      else {
                          System.out.println("Kitap listede bulunamadı.");
                      }
                  }
          else if (iadeEdilecekKitap != null && iadeEdilecekKitap.getDurum() == KitapDurumu.MEVCUT) {
                  System.out.println("Kitap zaten mevcut durumda.");
              }
          else {
                  System.out.println("Kitap bulunamadı.");
              }
      }

}

