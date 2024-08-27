import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Kutuphane kutuphane = new Kutuphane();
        ArrayList<Roman> roman = new ArrayList<>();
        roman.add(new Roman("1","dfsdf",KitapDurumu.MEVCUT));
        roman.add(new Roman("2","sofgjsd",KitapDurumu.MEVCUT));
        roman.add(new Roman("3","sofgjsogsd",KitapDurumu.MEVCUT));
        roman.add(new Roman("4","sofgjsogfjsd",KitapDurumu.MEVCUT));

        ArrayList<Bilim> bilim = new ArrayList<>();
        bilim.add(new Bilim("1","ahfgh",KitapDurumu.MEVCUT));
        bilim.add(new Bilim("2","aldf",KitapDurumu.MEVCUT));
        bilim.add(new Bilim("3","argpp",KitapDurumu.MEVCUT));

        ArrayList<Tarih> tarih = new ArrayList<>();
        tarih.add(new Tarih("1","zlkmgdk",KitapDurumu.MEVCUT));
        tarih.add(new Tarih("2","hlokfposd",KitapDurumu.MEVCUT));
        tarih.add(new Tarih("3","olkgsldk",KitapDurumu.MEVCUT));
        tarih.add(new Tarih("4","loooool",KitapDurumu.MEVCUT));
        tarih.add(new Tarih("5","rtykjfdk",KitapDurumu.MEVCUT));

        ArrayList<Kitap> tumKitaplar = new ArrayList<>();
        tumKitaplar.addAll(bilim);
        tumKitaplar.addAll(roman);
        tumKitaplar.addAll(tarih);

        ArrayList<Uye> uyeListesi = new ArrayList<>();
        uyeListesi.add(new Uye("arda","acar"));
        uyeListesi.add(new Uye("fahri","bay"));
        uyeListesi.add(new Uye("bora","kızgın"));
        uyeListesi.add(new Uye("ahmet","yılmaz"));

        for (int i = 0; i <5; i++) {

            System.out.println("********************************* üye olma ******************************");
            Uye.uyeEkle(uyeListesi);
            kutuphane.showUye(uyeListesi);
            System.out.println("********************************* kitap alma ******************************");
            Uye.uyeKontrol(uyeListesi, tumKitaplar);
            kutuphane.showKitap(tumKitaplar);
            System.out.println("********************************* kitap iadesi ******************************");
            Kitap.iadeEtme(uyeListesi, tumKitaplar);
            kutuphane.showKitap(tumKitaplar);
            kutuphane.show(uyeListesi);

        }
    }
}
