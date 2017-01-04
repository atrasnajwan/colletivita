package mafia.kegiatanmahasiswa.API;

import mafia.kegiatanmahasiswa.Model.Post;
import mafia.kegiatanmahasiswa.Model.PostPersonal;
import mafia.kegiatanmahasiswa.Model.Rapat;
import mafia.kegiatanmahasiswa.Model.User;
import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Query;
import retrofit.mime.TypedFile;


public interface gitapi {
    @GET("/{user}")
    public void login(@Path("user") String user,@Query("username") String username,@Query("password") String password,Callback<User> response);
    @GET("/{user}")
    public void getPost(@Path("user") String user,Callback<Post> response);
    @GET("/{user}")
    public void getPostPersonal(@Path("user") String user,Callback<PostPersonal> response);
    @GET("/{user}")
    public void getRapat(@Path("user") String user,@Query("id_acara")String id_acara,Callback<Rapat> response);

    @Multipart
    @POST("/{user}")
    public void register(@Path("user") String user,
                         @Part("username") String username,
                         @Part("nama") String nama,
                         @Part("fakultas") String fakultas,
                         @Part("prodi") String prodi,
                         @Part("email") String email,
                         @Part("no_hp") String no_hp,
                         @Part("password") String password,
                         @Part("tipe_user") String tipe_user,
                         @Part("image") TypedFile file,
                         Callback<Response> response);


}
