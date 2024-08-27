import java.util.ArrayList;

public class Kutuphane {

    public void showUye(ArrayList<Uye> uyeListesi) {
        for (Uye list : uyeListesi) {
            System.out.println(list.getAd() + (" ") + list.getSoyAd());
        }
    }

    public void showKitap(ArrayList<Kitap> tumKitaplar) {
        for (Kitap list : tumKitaplar) {
            System.out.println(list.getISBN() + (" ") + list.getBaslik() + (" ") + list.getTur() + (" ") + list.durum);
        }
    }
    public static void show(ArrayList<Uye> uyeListesi) {
        for (Uye uye : uyeListesi) {
            System.out.println("Üye: " + uye.getAd() + " " + uye.getSoyAd());
            System.out.println("Aldığı Kitaplar:");
            for (Kitap kitap : uye.getAldigiKitaplar()) {
                System.out.println(" " + kitap.getISBN() +(" ")+ kitap.getBaslik()+(" ") + kitap.getTur());
            }
            System.out.println();
        }
    }

}