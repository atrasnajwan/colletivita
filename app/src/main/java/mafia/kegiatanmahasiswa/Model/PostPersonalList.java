package mafia.kegiatanmahasiswa.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Acer on 12/18/2015.
 */
public class PostPersonalList {
    @SerializedName("Id_Acara_Personal")
    @Expose
    private String id;
    @SerializedName("nama")
    @Expose
    private String nama_user;
    @SerializedName("Nama_Acara_Personal")
    @Expose
    private String nama_acara;
    @SerializedName("Lokasi_Acara_Personal")
    @Expose
    private String lokasi;
    @SerializedName("Tanggal_Acara_Personal")
    @Expose
    private String tanggal;
    @SerializedName("Deskripsi_Acara_Personal")
    @Expose
    private String deskripsi;
    @SerializedName("foto_profil")
    @Expose
    private String fotoprofil;

    public String getId() {
        return id;
    }
    public void setId(String id ) {
        this.id = id;
    }

    public String getNama_user() {
        return nama_user;
    }
    public void setNama_user(String nama_user ) {
        this.nama_user = nama_user;
    }

    public String getNama_acara() {
        return nama_acara;
    }
    public void setNama_acara(String nama ) {
        this.nama_acara = nama_acara;
    }

    public String getLokasi() {
        return lokasi;
    }
    public void setLokasi(String lokasi ) {
        this.lokasi = lokasi;
    }

    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal(String tanggal ) {
        this.tanggal = tanggal;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi ) {
        this.deskripsi = deskripsi;
    }

    public String getFotoprofil() {
        return fotoprofil;
    }
    public void setFotoprofil(String fotoprofil ) {
        this.fotoprofil = fotoprofil;
    }
}
