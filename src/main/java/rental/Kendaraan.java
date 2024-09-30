package rental;

public class Kendaraan {
    private final String nomorPlat;
    private String merk;
    private String jenis;
    
    // Static property untuk menghitung jumlah kendaraan
    public static int jumlahKendaraan = 0;
    
    // Constructor
    public Kendaraan(String nomorPlat, String merk, String jenis) {
        this.nomorPlat = nomorPlat;
        this.merk = merk;
        this.jenis = jenis;
        jumlahKendaraan++;
    }
    
    // Getter untuk nomor plat
    public String getNomorPlat() {
        return nomorPlat;
    }

    // Getter dan Setter untuk merk
    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    // Getter dan Setter untuk jenis
    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    // Method untuk menampilkan detail kendaraan
    public void tampilkanDetail() {
        System.out.println("Nomor Plat: " + nomorPlat);
        System.out.println("Merk: " + merk);
        System.out.println("Jenis: " + jenis);
    }
}
