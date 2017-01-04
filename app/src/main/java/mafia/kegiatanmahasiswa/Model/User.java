package mafia.kegiatanmahasiswa.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class User {

    @SerializedName("user")
    @Expose
    public List<UserList> user = new ArrayList<UserList>();

    public List<UserList> getUser() {
        return user;
    }

    public void setUser(List<UserList> user) {
        this.user = user;
    }
}
