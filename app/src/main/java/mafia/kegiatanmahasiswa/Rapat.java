package mafia.kegiatanmahasiswa;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import mafia.kegiatanmahasiswa.API.gitapi;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Rapat extends AppCompatActivity {

    private ListView List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapat);

        List = (ListView) findViewById(R.id.rapat_list);

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);


        String API = "http://colletivita.hol.es/api";
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API).build();
        gitapi git = restAdapter.create(gitapi.class);

        git.getRapat("rapat.php", "1", new Callback<mafia.kegiatanmahasiswa.Model.Rapat>() {
            @Override
            public void success(mafia.kegiatanmahasiswa.Model.Rapat rapat, Response response) {
                ListAdapter adapter = new CostumAdapterRapat(Rapat.this, rapat.rapat);
                List.setAdapter(adapter);

                List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                    Context context;


                                                }
                                            }
                );
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    
}
