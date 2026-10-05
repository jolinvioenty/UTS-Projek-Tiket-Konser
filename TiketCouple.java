public class TiketCouple extends TiketKonser {

    // Menyimpan jumlah tiket couple
    private int jumlah;

    // Constructor untuk membuat object TiketCouple
    public TiketCouple() {

        // Memanggil constructor dari class TiketKonser
        super(
            "TC001",
            "Social Chic Jakarta 2026",
            60000
        );

        // Menentukan jumlah tiket couple
        jumlah = 2;
    }

    // Menghitung harga berdasarkan jumlah tiket
    @Override
    public int hitungHarga() {

        return getHarga() * jumlah;

    }

}