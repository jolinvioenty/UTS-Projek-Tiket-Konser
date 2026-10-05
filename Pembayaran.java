public class Pembayaran {

    // Menyimpan data pembayaran
    private String idpembayaran;
    private int total;
    private String tanggal;
    private String jenispembayaran;

    // Constructor untuk membuat object Pembayaran
    public Pembayaran(
            String idpembayaran,
            int total,
            String tanggal,
            String jenispembayaran) {

        this.idpembayaran = idpembayaran;
        this.total = total;
        this.tanggal = tanggal;
        this.jenispembayaran = jenispembayaran;
    }

    // Memproses pembayaran
    public void prosesPembayaran() {
        System.out.println(
            "Pembayaran melalui "
            + jenispembayaran
            + " berhasil diproses."
        );
    }

    // Mengambil ID pembayaran
    public String getIdpembayaran() {
        return idpembayaran;
    }

    // Mengambil total pembayaran
    public int getTotal() {
        return total;
    }

    // Mengambil tanggal pembayaran
    public String getTanggal() {
        return tanggal;
    }

    // Mengambil jenis pembayaran
    public String getJenispembayaran() {
        return jenispembayaran;
    }

}