package mafia.kegiatanmahasiswa.Model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RapatList {

    @SerializedName("id_acara_public")
    @Expose
    private String idAcaraPublic;
    @SerializedName("id_rapat")
    @Expose
    private String idRapat;
    @SerializedName("notulen")
    @Expose
    private String notulen;
    @SerializedName("peserta")
    @Expose
    private String peserta;
    @SerializedName("tanggal")
    @Expose
    private String tanggal;
    @SerializedName("hasil")
    @Expose
    private String hasil;
    @SerializedName("pimpinan")
    @Expose
    private String pimpinan;

    /**
     *
     * @return
     * The idAcaraPublic
     */
    public String getIdAcaraPublic() {
        return idAcaraPublic;
    }

    /**
     *
     * @param idAcaraPublic
     * The id_acara_public
     */
    public void setIdAcaraPublic(String idAcaraPublic) {
        this.idAcaraPublic = idAcaraPublic;
    }

    /**
     *
     * @return
     * The idRapat
     */
    public String getIdRapat() {
        return idRapat;
    }

    /**
     *
     * @param idRapat
     * The id_rapat
     */
    public void setIdRapat(String idRapat) {
        this.idRapat = idRapat;
    }

    /**
     *
     * @return
     * The notulen
     */
    public String getNotulen() {
        return notulen;
    }

    /**
     *
     * @param notulen
     * The notulen
     */
    public void setNotulen(String notulen) {
        this.notulen = notulen;
    }

    /**
     *
     * @return
     * The peserta
     */
    public String getPeserta() {
        return peserta;
    }

    /**
     *
     * @param peserta
     * The peserta
     */
    public void setPeserta(String peserta) {
        this.peserta = peserta;
    }

    /**
     *
     * @return
     * The tanggal
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     *
     * @param tanggal
     * The tanggal
     */
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    /**
     *
     * @return
     * The hasil
     */
    public String getHasil() {
        return hasil;
    }

    /**
     *
     * @param hasil
     * The hasil
     */
    public void setHasil(String hasil) {
        this.hasil = hasil;
    }

    /**
     *
     * @return
     * The pimpinan
     */
    public String getPimpinan() {
        return pimpinan;
    }

    /**
     *
     * @param pimpinan
     * The pimpinan
     */
    public void setPimpinan(String pimpinan) {
        this.pimpinan = pimpinan;
    }

}