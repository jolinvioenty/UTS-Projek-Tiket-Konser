import java.util.ArrayList;

public class Buyer {

    // Menyimpan data buyer
    private String kodeBuyer;
    private String nama;
    private String noHp;
    private ArrayList<TiketKonser> listTiket;

    // Constructor untuk membuat object Buyer
    public Buyer(String kodeBuyer, String nama, String noHp) {

        this.kodeBuyer = kodeBuyer;
        this.nama = nama;
        this.noHp = noHp;

        // Membuat list untuk menyimpan tiket buyer
        this.listTiket = new ArrayList<TiketKonser>();
    }

    // Menambahkan tiket ke list tiket buyer
    public void addTiket(TiketKonser tiket) {

        listTiket.add(tiket);

    }

    // Mengambil daftar tiket yang dimiliki buyer
    public ArrayList<TiketKonser> getListTiket() {

        return listTiket;

    }

    // Mengambil nama buyer
    public String getNama() {

        return nama;

    }

    // Mengambil nomor HP buyer
    public String getNoHp() {

        return noHp;

    }

}