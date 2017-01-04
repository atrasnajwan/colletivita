package mafia.kegiatanmahasiswa;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import mafia.kegiatanmahasiswa.API.gitapi;
import mafia.kegiatanmahasiswa.Model.PostPersonal;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class PostinganPersonal extends Fragment {

    private static final String TAG = "postinganpersonal";

    private ListView List;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());


        View view = inflater.inflate(R.layout.fragment_postingan_personal, container, false);
        List = (ListView) view.findViewById(R.id.postingan_personal_list);

        String API = "http://colletivita.hol.es/api";
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API).build();
        gitapi git = restAdapter.create(gitapi.class);

        git.getPostPersonal("postingan_personal.php", new Callback<PostPersonal>() {
            @Override
            public void success(PostPersonal postPersonal, Response response) {

                ListAdapter adapter = new CostumAdapterPostinganPersonal(getActivity(), postPersonal.postpersonal);
                List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                    Context context;


                                                }
                                            }
                );
                List.setAdapter(adapter);
            }


            @Override
            public void failure(RetrofitError error) {

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
        return view;
    }



}
