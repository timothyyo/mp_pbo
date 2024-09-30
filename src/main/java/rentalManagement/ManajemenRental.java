package rentalManagement;

import rental.Kendaraan;
import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenRental {
    private final ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    // Constructor untuk inisialisasi kendaraan
    public ManajemenRental() {
        inisialisasiKendaraan(); // Memanggil method untuk menambahkan beberapa kendaraan
    }

    // Method untuk inisialisasi kendaraan default
    public void inisialisasiKendaraan() {
        daftarKendaraan.add(new Kendaraan("B 1234 CD", "Toyota", "SUV"));
        daftarKendaraan.add(new Kendaraan("D 5678 EF", "Honda", "Sedan"));
        daftarKendaraan.add(new Kendaraan("E 9101 GH", "Suzuki", "Minivan"));
        daftarKendaraan.add(new Kendaraan("F 2345 IJ", "BMW", "Coupe"));
    }

    // Method untuk menambah Kendaraan
    public void tambahKendaraan() {
        System.out.print("Masukkan Nomor Plat: ");
        String nomorPlat = scanner.nextLine();
        System.out.print("Masukkan Merk Kendaraan: ");
        String merk = scanner.nextLine();
        System.out.print("Masukkan Jenis Kendaraan: ");
        String jenis = scanner.nextLine();
        
        Kendaraan kendaraan = new Kendaraan(nomorPlat, merk, jenis);
        daftarKendaraan.add(kendaraan);
        System.out.println("Kendaraan berhasil ditambahkan!");
    }

    // Method lainnya tetap sama...
    
    public void editKendaraan() {
        System.out.print("Masukkan Nomor Plat kendaraan yang ingin diedit: ");
        String nomorPlat = scanner.nextLine();
        
        for (Kendaraan k : daftarKendaraan) {
            if (k.getNomorPlat().equalsIgnoreCase(nomorPlat)) {
                System.out.print("Masukkan Merk Baru: ");
                String merkBaru = scanner.nextLine();
                System.out.print("Masukkan Jenis Baru: ");
                String jenisBaru = scanner.nextLine();

                k.setMerk(merkBaru);
                k.setJenis(jenisBaru);
                System.out.println("Kendaraan berhasil diedit!");
                return;
            }
        }
        System.out.println("Kendaraan dengan nomor plat tersebut tidak ditemukan.");
    }

    public void hapusKendaraan() {
        System.out.print("Masukkan Nomor Plat kendaraan yang ingin dihapus: ");
        String nomorPlat = scanner.nextLine();

        for (Kendaraan k : daftarKendaraan) {
            if (k.getNomorPlat().equalsIgnoreCase(nomorPlat)) {
                daftarKendaraan.remove(k);
                System.out.println("Kendaraan berhasil dihapus!");
                Kendaraan.jumlahKendaraan--;
                return;
            }
        }
        System.out.println("Kendaraan dengan nomor plat tersebut tidak ditemukan.");
    }

    public void tampilkanSemuaKendaraan() {
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Tidak ada kendaraan yang terdaftar.");
        } else {
            for (Kendaraan k : daftarKendaraan) {
                k.tampilkanDetail();
                System.out.println("-------------------------");
            }
        }
    }

    public void tampilkanMenu() {
        while (true) {
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Edit Kendaraan");
            System.out.println("3. Hapus Kendaraan");
            System.out.println("4. Tampilkan Semua Kendaraan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (pilihan) {
                case 1 -> tambahKendaraan();
                case 2 -> editKendaraan();
                case 3 -> hapusKendaraan();
                case 4 -> tampilkanSemuaKendaraan();
                case 5 -> {
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        }
    }
}
