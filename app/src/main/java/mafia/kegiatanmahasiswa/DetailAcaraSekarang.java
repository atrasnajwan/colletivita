package mafia.kegiatanmahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailAcaraSekarang extends AppCompatActivity {

    String url="http://colletivita.hol.es/images/postingan_publik/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail_acara_sekarang);
        TextView judul = (TextView) findViewById(R.id.judul_acara);
        TextView lokasi = (TextView) findViewById(R.id.txt_lokasi);
        TextView tanggal = (TextView) findViewById(R.id.txt_tanggal);
        TextView waktu = (TextView) findViewById(R.id.txt_waktu);
        ImageView poster = (ImageView) findViewById(R.id.flyer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent myIntent = getIntent();

        judul.setText(myIntent.getStringExtra("judul_acara"));
        lokasi.setText(myIntent.getStringExtra("lokasi_acara"));
        tanggal.setText(myIntent.getStringExtra("tanggal_acara"));
        waktu.setText(myIntent.getStringExtra("waktu_acara"));
        Picasso.with(this).load(url+myIntent.getStringExtra("poster_acara")).into(poster);

    }

    public void onRapat(View view)
    {
        Intent i = new Intent(this, Rapat.class);
        startActivity(i);
    }

}
