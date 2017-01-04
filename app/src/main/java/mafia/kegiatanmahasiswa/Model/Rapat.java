package mafia.kegiatanmahasiswa.Model;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Rapat {

    @SerializedName("rapat")
    @Expose
    public List<RapatList> rapat = new ArrayList<RapatList>();

    /**
     *
     * @return
     * The rapat
     */
    public List<RapatList> getRapat() {
        return rapat;
    }

    /**
     *
     * @param rapat
     * The rapat
     */
    public void setRapat(List<RapatList> rapat) {
        this.rapat = rapat;
    }

}
