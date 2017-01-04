package mafia.kegiatanmahasiswa.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Acer on 11/22/2015.
 */
public class PostList {
    @SerializedName("id_acara_public")
    @Expose
    private String id;
    @SerializedName("nama_acara_public")
    @Expose
    private String nama_acara;
    @SerializedName("lokasi_acara_public")
    @Expose
    private String lokasi;
    @SerializedName("tanggal_acara_public")
    @Expose
    private String tanggal;
    @SerializedName("waktu_acara_public")
    @Expose
    private String waktu;
    @SerializedName("deskripsi_acara_public")
    @Expose
    private String deskripsi;
    @SerializedName("poster_acara")
    @Expose
    private String poster;

    public String getId() {
        return id;
    }
    public void setId(String id ) {
        this.id = id;
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

    public String getWaktu() {
        return waktu;
    }
    public void setWaktu(String waktu ) {
        this.waktu = waktu;
    }

    public String getDeskripsi() {
        return deskripsi;
    }
    public void setDeskripsi(String deskripsi ) {
        this.deskripsi = deskripsi;
    }

    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster ) {
        this.poster = poster;
    }
}
