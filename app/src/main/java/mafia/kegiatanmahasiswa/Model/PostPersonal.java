package mafia.kegiatanmahasiswa.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 12/18/2015.
 */
public class PostPersonal {

    @SerializedName("postpersonal")
    @Expose
    public List<PostPersonalList> postpersonal = new ArrayList<PostPersonalList>();

    public List<PostPersonalList> getPost() {
        return postpersonal;
    }

    public void setPost(List<PostPersonalList> postpersonal) {
        this.postpersonal = postpersonal;
    }
}
