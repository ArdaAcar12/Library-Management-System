import java.util.ArrayList;
import java.util.Scanner;

 class Uye implements IUye {
     private String Ad;
     private String SoyAd;
     private ArrayList<Kitap> aldigiKitaplar;

     public String getAd() {
         return Ad;
     }

     public void setAd(String ad) {
         Ad = ad;
     }

     public String getSoyAd() {
         return SoyAd;
     }

     public void setSoyAd(String soyAd) {
         SoyAd = soyAd;
     }

     public Uye(String ad, String soyAd) {
         this.Ad = ad;
         this.SoyAd = soyAd;
         this.aldigiKitaplar = new ArrayList<>();
     }

     public ArrayList<Kitap> getAldigiKitaplar() {
         return aldigiKitaplar;
     }

     public void kitapEkle(Kitap kitap) {
         this.aldigiKitaplar.add(kitap);
     }

     public static void uyeEkle(ArrayList<Uye> uyeListesi) {
         Scanner uye = new Scanner(System.in);
         System.out.print("Üye adı giriniz: ");
         String ad = uye.nextLine();
         System.out.print("Üye soyadı giriniz: ");
         String soyAd = uye.nextLine();

         boolean uyeVarMi = false;
         for (Uye mevcutUye : uyeListesi) {
             if (mevcutUye.getAd().equalsIgnoreCase(ad) &&
                     mevcutUye.getSoyAd().equalsIgnoreCase(soyAd)) {
                 uyeVarMi = true;
                 break;
             }
         }

         if (!uyeVarMi) {
             Uye yeniUye = new Uye(ad, soyAd);
             uyeListesi.add(yeniUye);
             System.out.println("Üye başarıyla eklendi: " + yeniUye.getAd() + " " + yeniUye.getSoyAd());
         } else {
             System.out.println("Bu üye zaten mevcut.");
         }
     }

     public static void uyeKontrol(ArrayList<Uye> uyeListesi, ArrayList<Kitap> tumKitaplar) {
         Scanner kisi = new Scanner(System.in);
         System.out.print("Kitabı alacak kişinin adını giriniz: ");
         String ad = kisi.nextLine().trim();
         System.out.print("Soyadını giriniz: ");
         String soyad = kisi.nextLine().trim();

         boolean uyeBulundu = false;
         for (Uye uye : uyeListesi) {
             if (uye.getAd().equals(ad) && uye.getSoyAd().equals(soyad)) {
                 uyeBulundu = true;

                 Kitap kitapBulunan = Kitap.kitapAlma(tumKitaplar);
                 if (kitapBulunan != null) {
                     uye.kitapEkle(kitapBulunan);
                 }
                 break;
             }
         }
             if (!uyeBulundu) {
                 System.out.println("Uye bu kütüphaneye kayıtlı değil");
             }
         }
     }



