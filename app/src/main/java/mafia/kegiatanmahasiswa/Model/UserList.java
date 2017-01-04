package mafia.kegiatanmahasiswa.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserList {


    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("fakultas")
    @Expose
    private String fakultas;
    @SerializedName("prodi")
    @Expose
    private String prodi;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("no_hp")
    @Expose
    private String no_hp;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("tipe_user")
    @Expose
    private String tipe_user;
    @SerializedName("foto_profil")
    @Expose
    private String foto_profil;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username ) {
        this.username = username;
    }

    public String getNama() {
        return nama;
    }
    public void setNama(String nama ) {
        this.nama = nama;
    }

    public String getFakultas() {
        return fakultas;
    }
    public void setFakultas(String fakultas ) {
        this.fakultas = fakultas;
    }

    public String getProdi() {
        return prodi;
    }
    public void setProdi(String prodi ) {
        this.prodi = prodi;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email ) {
        this.email = email;
    }

    public String getNohp() {
        return no_hp;
    }
    public void setNohp(String no_hp ) {
        this.no_hp = no_hp;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password ) {
        this.password = password;
    }

    public String getTipe_user() {
        return tipe_user;
    }
    public void setTipe_user(String tipe_user ) {
        this.tipe_user = tipe_user;
    }

    public String getFoto_profil() {
        return foto_profil;
    }
    public void setFoto_profil(String tipe_user ) {
        this.foto_profil = foto_profil;
    }


}
