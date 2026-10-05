import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Membuat Scanner untuk menerima input dari user
        Scanner input = new Scanner(System.in);

        System.out.println("================================================");
        System.out.println("             SISTEM TIKET KONSER");
        System.out.println("================================================");

        // Input data buyer
        System.out.print("Nama Buyer : ");
        String namaBuyer = input.nextLine();

        System.out.print("No HP      : ");
        String noHp = input.nextLine();

        System.out.print("Tanggal    : ");
        String tanggal = input.nextLine();

        // Membuat object Buyer
        String kodeBuyer = "BYR001";

        Buyer buyer = new Buyer(
            kodeBuyer,
            namaBuyer,
            noHp
        );

        // User memilih jenis tiket
        System.out.println();
        System.out.println("Jenis Tiket:");
        System.out.println("1. Daily");
        System.out.println("2. Couple");
        System.out.println("3. VIP");
        System.out.print("Pilihan : ");

        int pilihanTiket =
            Integer.parseInt(input.nextLine());

        TiketKonser tiket;
        String jenisTiket;

        // Membuat object sesuai jenis tiket yang dipilih
        if (pilihanTiket == 1) {

            tiket = new TiketDaily();
            jenisTiket = "Tiket Daily";

        } else if (pilihanTiket == 2) {

            tiket = new TiketCouple();
            jenisTiket = "Tiket Couple";

        } else if (pilihanTiket == 3) {

            tiket = new TiketVIP();
            jenisTiket = "Tiket VIP";

        } else {

            System.out.println(
                "Jenis tiket tidak tersedia."
            );

            input.close();
            return;
        }

        // User memilih metode pembayaran
        System.out.println();
        System.out.println("Metode Pembayaran:");
        System.out.println("1. QRIS");
        System.out.println("2. E-Wallet");
        System.out.print("Pilihan : ");

        int pilihanPembayaran =
            Integer.parseInt(input.nextLine());

        String jenisPembayaran;

        // Menentukan metode pembayaran
        if (pilihanPembayaran == 1) {

            jenisPembayaran = "QRIS";

        } else if (pilihanPembayaran == 2) {

            jenisPembayaran = "E-Wallet";

        } else {

            System.out.println(
                "Metode pembayaran tidak tersedia."
            );

            input.close();
            return;
        }

        // Membuat object Pembayaran
        String idPembayaran = "PAY001";

        Pembayaran pembayaran =
            new Pembayaran(
                idPembayaran,
                tiket.hitungHarga(),
                tanggal,
                jenisPembayaran
            );

        // Membuat object Transaksi
        String idTransaksi = "TRX001";

        Transaksi transaksi =
            new Transaksi(
                idTransaksi,
                tanggal,
                buyer,
                pembayaran
            );

        // Menambahkan tiket ke transaksi
        transaksi.tambahTiket(tiket);

        // Menghitung total dan memproses pembayaran
        transaksi.prosesTransaksi();

        // Menyimpan data transaksi ke file
        simpanData(
            buyer,
            tiket,
            pembayaran,
            transaksi,
            kodeBuyer,
            jenisTiket
        );

        // Menampilkan e-ticket dan e-receipt
        transaksi.cetakTiket();
        transaksi.eReceipt();

        input.close();
    }

    // Method untuk menyimpan data ke file
    public static void simpanData(
            Buyer buyer,
            TiketKonser tiket,
            Pembayaran pembayaran,
            Transaksi transaksi,
            String kodeBuyer,
            String jenisTiket) {

        try {

            // Membuka file untuk menyimpan data
            FileWriter writer =
                new FileWriter(
                    "data.txt",
                    true
                );

            writer.write(
                "================================================"
            );
            writer.write(System.lineSeparator());

            writer.write(
                "DATA TRANSAKSI TIKET KONSER"
            );
            writer.write(System.lineSeparator());

            writer.write(
                "Kode Buyer : " + kodeBuyer
            );
            writer.write(System.lineSeparator());

            writer.write(
                "Nama Buyer : " + buyer.getNama()
            );
            writer.write(System.lineSeparator());

            writer.write(
                "No HP      : " + buyer.getNoHp()
            );
            writer.write(System.lineSeparator());

            writer.write(
                "Tanggal    : " + transaksi.getTanggal()
            );
            writer.write(System.lineSeparator());

            writer.write(
                "ID Transaksi : "
                + transaksi.getIdTransaksi()
            );
            writer.write(System.lineSeparator());

            writer.write(
                "Kode Tiket : "
                + tiket.getKodeTiket()
            );
            writer.write(System.lineSeparator());

            writer.write(
                "Jenis Tiket : "
                + jenisTiket
            );
            writer.write(System.lineSeparator());

            writer.write(
                "Nama Konser : "
                + tiket.getNamaKonser()
            );
            writer.write(System.lineSeparator());

            writer.write(
                "Harga      : "
                + tiket.hitungHarga()
            );
            writer.write(System.lineSeparator());

            writer.write(
                "Pembayaran : "
                + pembayaran.getJenispembayaran()
            );
            writer.write(System.lineSeparator());

            writer.write(
                "Total      : "
                + transaksi.getTotal()
            );
            writer.write(System.lineSeparator());

            writer.write(
                "================================================"
            );
            writer.write(System.lineSeparator());
            writer.write(System.lineSeparator());

            // Menutup file setelah selesai ditulis
            writer.close();

            System.out.println();
            System.out.println(
                "Data berhasil disimpan ke data.txt."
            );

        } catch (IOException e) {

            // Menampilkan pesan jika terjadi error file
            System.out.println(
                "Terjadi kesalahan saat menyimpan file."
            );

            System.out.println(
                e.getMessage()
            );
        }
    }
}

//try digunakan untuk menjalankan proses penyimpanan file,
// sedangkan catch menangani jika terjadi IOException. 
// e.getMessage() digunakan untuk menampilkan detail kesalahan yang terjadi.