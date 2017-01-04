package mafia.kegiatanmahasiswa.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 11/22/2015.
 */
public class Post {
    @SerializedName("post")
    @Expose
    public List<PostList> post = new ArrayList<PostList>();

    public List<PostList> getPost() {
        return post;
    }

    public void setPost(List<PostList> post) {
        this.post = post;
    }
}
