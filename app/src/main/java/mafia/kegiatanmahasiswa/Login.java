package mafia.kegiatanmahasiswa;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import mafia.kegiatanmahasiswa.API.gitapi;
import mafia.kegiatanmahasiswa.Model.User;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Login extends AppCompatActivity {

    String API = "http://colletivita.hol.es/api";
    String username;
    String password;

    EditText usernametext;
    EditText passwordtext;
    SessionManager session;

    AlertDialog.Builder alertDialogBuilder;
    ProgressDialog ringProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        alertDialogBuilder = new AlertDialog.Builder(Login.this);

        ringProgressDialog = new ProgressDialog(this);
        ringProgressDialog.setCancelable(true);
        ringProgressDialog.setMessage("Sedang Masuk...");

        usernametext = (EditText) findViewById(R.id.txt_username);
        passwordtext = (EditText) findViewById(R.id.txt_password);

        session = new SessionManager(getApplicationContext());

    }

    public void onClickDaftar(View view)
    {
        Intent i = new Intent(this, Daftar.class);
        startActivity(i);
    }

    public void onClickLupa(View view)
    {
        Intent i = new Intent(this, LupaPassword.class);
        startActivity(i);
    }

    public void hideSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)  getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    public void onClick(View view)
    {
        username = usernametext.getText().toString();
        password = passwordtext.getText().toString();

        if(!validasi())
        {
            return;
        }
        else {
            ringProgressDialog.show();

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(API).build();
            gitapi git = restAdapter.create(gitapi.class);

            git.login("index.php", username, password, new Callback<User>() {

                @Override
                public void success(User user, Response response) {
                    if (user.user.isEmpty()) {
                        ringProgressDialog.dismiss();

                        alertDialogBuilder
                                .setMessage("Maaf , NIM atau Password Anda Salah")
                                .setCancelable(false)
                                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                    }
                                });
                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();

                    } else {
                        ringProgressDialog.dismiss();

                        session.createLoginSession(
                                user.user.get(0).getUsername(),
                                user.user.get(0).getNama(),
                                user.user.get(0).getTipe_user(),
                                user.user.get(0).getFoto_profil());
                        Intent i = new Intent(Login.this, BerandaUtama.class);
                        startActivity(i);
                        finish();
                    }
                }

                @Override
                public void failure(RetrofitError error) {

                    ringProgressDialog.dismiss();

                    alertDialogBuilder
                            .setMessage(error.getMessage())
                            .setCancelable(false)
                            .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();

                }
            });

        }
    }

    private boolean validasi() {

        boolean valid = true;


        if (username.isEmpty()) {
            usernametext.setError("Masukkan username");
            valid = false;
        }
        if (password.isEmpty()) {
            passwordtext.setError("Masukkan password");
            valid = false;
        }

        return valid;

    }

}
