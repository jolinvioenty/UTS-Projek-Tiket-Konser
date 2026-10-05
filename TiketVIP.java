public class TiketVIP extends TiketKonser {

    // Menyimpan benefit tiket VIP
    private String benefit;

    // Constructor untuk membuat object TiketVIP
    public TiketVIP() {

        // Memanggil constructor dari class TiketKonser
        super(
            "TV001",
            "Social Chic Jakarta 2026",
            150000
        );

        // Menentukan benefit tiket VIP
        benefit = "VIP Access";
    }

    // Menghitung harga tiket VIP
    @Override
    public int hitungHarga() {

        return getHarga();

    }

}