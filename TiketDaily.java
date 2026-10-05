public class TiketDaily extends TiketKonser {

    // Menyimpan hari atau tanggal tiket
    private String hari;

    // Constructor untuk membuat object TiketDaily
    public TiketDaily() {

        // Memanggil constructor dari class TiketKonser
        super(
            "TD001",
            "Social Chic Jakarta 2026",
            60000
        );

        // Menentukan tanggal tiket
        hari = "31 July 2026";
    }

    // Menghitung harga tiket Daily
    @Override
    public int hitungHarga() {

        return getHarga();

    }

}