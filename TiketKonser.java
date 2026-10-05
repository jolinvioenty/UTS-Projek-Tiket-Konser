public class TiketKonser {

    // Menyimpan data tiket konser
    private String kodeTiket;
    private String namaKonser;
    private int harga;

    // Constructor untuk membuat object TiketKonser
    public TiketKonser(String kodeTiket, String namaKonser, int harga) {

        this.kodeTiket = kodeTiket;
        this.namaKonser = namaKonser;
        this.harga = harga;
    }

    // Mengambil kode tiket
    public String getKodeTiket() {

        return kodeTiket;
    }

    // Mengambil nama konser
    public String getNamaKonser() {

        return namaKonser;
    }

    // Mengambil jenis tiket
    public String getJenisTiket() {

        return "Tiket Konser";
    }

    // Mengambil harga tiket
    public int getHarga() {

        return harga;
    }

    // Menghitung harga tiket
    public int hitungHarga() {

        return harga;
    }

}