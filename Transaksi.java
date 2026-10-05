import java.util.ArrayList;

public class Transaksi implements CetakTiket {

    // Menyimpan data transaksi
    private String idTransaksi;
    private String tanggal;
    private int total;
    private Buyer buyer;
    private ArrayList<TiketKonser> listTiket;
    private Pembayaran pembayaran;

    // Constructor untuk membuat object Transaksi
    public Transaksi(
            String idTransaksi,
            String tanggal,
            Buyer buyer,
            Pembayaran pembayaran) {

        this.idTransaksi = idTransaksi;
        this.tanggal = tanggal;
        this.total = 0;
        this.buyer = buyer;
        this.listTiket = new ArrayList<TiketKonser>();
        this.pembayaran = pembayaran;
    }

    // Menambahkan tiket ke transaksi dan buyer
    public void tambahTiket(TiketKonser tiket) {

        listTiket.add(tiket);
        buyer.addTiket(tiket);
    }

    // Menghitung total harga semua tiket
    public int hitungTotal() {

        total = 0;

        for (TiketKonser tiket : listTiket) {

            total += tiket.hitungHarga();

        }

        return total;
    }

    // Memproses transaksi dan pembayaran
    public void prosesTransaksi() {

        total = hitungTotal();
        pembayaran.prosesPembayaran();
    }

    // Mengambil ID transaksi
    public String getIdTransaksi() {

        return idTransaksi;
    }

    // Mengambil tanggal transaksi
    public String getTanggal() {

        return tanggal;
    }

    // Mengambil total transaksi
    public int getTotal() {

        return total;
    }

    // Mencetak e-ticket
    @Override
    public void cetakTiket() {

        String kategori;

        // Menentukan kategori berdasarkan jenis tiket
        if (listTiket.get(0) instanceof TiketDaily) {

            kategori = "Tiket Daily";

        } else if (listTiket.get(0) instanceof TiketCouple) {

            kategori = "Tiket Couple";

        } else if (listTiket.get(0) instanceof TiketVIP) {

            kategori = "Tiket VIP";

        } else {

            kategori = "Tiket Konser";
        }

        // Menampilkan format e-ticket
        System.out.println();

        System.out.println(
            "============================================================"
        );

        System.out.println(
            "                    THIS IS YOUR E-TICKET"
        );

        System.out.println(
            "============================================================"
        );

        System.out.println(
            "                   SOCIAL CHIC JAKARTA 2026"
        );

        System.out.println(
            "                Stadion Madya Gelora Bung Karno"
        );

        System.out.println(
            "                31 July - 12 August 2026"
        );

        System.out.println(
            "------------------------------------------------------------"
        );

        System.out.println(
            "Name        : " + buyer.getNama()
        );

        System.out.println(
            "Invoice     : " + idTransaksi
        );

        System.out.println(
            "Category    : " + kategori
        );

        System.out.println(
            "Basic Price : Rp" + listTiket.get(0).getHarga()
        );

        System.out.println(
            "------------------------------------------------------------"
        );

        System.out.println(
            "Ticket Code : " + listTiket.get(0).getKodeTiket()
        );

        System.out.println(
            "Ticket Name : " + listTiket.get(0).getNamaKonser()
        );

        System.out.println(
            "Total       : Rp" + total
        );

        System.out.println(
            "Payment     : " + pembayaran.getJenispembayaran()
        );

        System.out.println(
            "------------------------------------------------------------"
        );

        System.out.println(
            "Terms & Conditions"
        );

        System.out.println(
            "1. E-Ticket memiliki kode tiket yang unik."
        );

        System.out.println(
            "2. E-Ticket hanya dapat digunakan sesuai ketentuan acara."
        );

        System.out.println(
            "3. Tiket harus disimpan sampai acara selesai."
        );

        System.out.println(
            "4. Akses masuk mengikuti pemeriksaan tiket."
        );

        System.out.println(
            "------------------------------------------------------------"
        );

        System.out.println(
            "              Thank you for your purchase!"
        );

        System.out.println(
            "============================================================"
        );
    }

    // Menampilkan pesan e-receipt
    @Override
    public void eReceipt() {

        System.out.println();

        System.out.println(
            "E-Receipt berhasil dibuat."
        );
    }

}