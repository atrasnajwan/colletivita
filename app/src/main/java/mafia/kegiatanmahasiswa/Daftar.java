package mafia.kegiatanmahasiswa;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import mafia.kegiatanmahasiswa.API.gitapi;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.mime.TypedFile;


public class Daftar extends AppCompatActivity {

    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;

    EditText usernametext;
    EditText passwordtext;
    EditText namatext;
    EditText fakultastext;
    EditText proditext;
    EditText nohptext;
    EditText emailtext;
    Spinner tipe_usertext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spinner = (Spinner) findViewById(R.id.spin);

        final String values [] = {"Mahasiswa","Dosen"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.spinnerstyle, values);
        adapter.setDropDownViewResource(R.layout.spinnerdropdown);
        spinner.setAdapter(adapter);

        usernametext = (EditText) findViewById(R.id.txt_daftar_username);
        passwordtext = (EditText) findViewById(R.id.txt_daftar_password);
        namatext = (EditText) findViewById(R.id.txt_nama_lengkap);
        fakultastext = (EditText) findViewById(R.id.txt_fakultas);
        proditext = (EditText) findViewById(R.id.txt_prodi);
        emailtext = (EditText) findViewById(R.id.txt_password);
        nohptext = (EditText) findViewById(R.id.txt_nomerhp);
        tipe_usertext = (Spinner) findViewById(R.id.spin);
    }

    public void hideSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)  getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    public void OnClickUpload (View view)
    {

        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        );
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                ImageView imgView = (ImageView) findViewById(R.id.foto_profil);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }

    public void OnClickDaftar(View view)
    {
        File photo = new File(imgDecodableString);
        TypedFile typedImage = new TypedFile("image/*", photo);

        String API = "http://192.168.43.131/www/api";
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API).build();
        gitapi git = restAdapter.create(gitapi.class);

        git.register(
                "daftar.php",
                usernametext.getText().toString(),
                namatext.getText().toString(),
                fakultastext.getText().toString(),
                proditext.getText().toString(),
                emailtext.getText().toString(),
                nohptext.getText().toString(),
                passwordtext.getText().toString(),
                tipe_usertext.getSelectedItem().toString(),
                typedImage,
                new Callback<Response>() {

                    @Override
                    public void success(Response response, Response response2) {
                        BufferedReader reader = null;

                        //An string to store output from the server
                        String output = "";

                        try {
                            //Initializing buffered reader
                            reader = new BufferedReader(new InputStreamReader(response.getBody().in()));

                            //Reading the output in the string
                            output = reader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        //Displaying the output as a toast
                        Toast.makeText(Daftar.this, output, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(Daftar.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                }
                );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_daftar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
