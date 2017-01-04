package mafia.kegiatanmahasiswa;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

import mafia.kegiatanmahasiswa.API.gitapi;
import mafia.kegiatanmahasiswa.Model.Post;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PostinganPublik.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PostinganPublik#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostinganPublik extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String TAG = "PostinganPublik";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ListView List;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment PostinganPublik.
     */
    // TODO: Rename and change types and number of parameters
    public static PostinganPublik newInstance(String param1) {
        PostinganPublik fragment = new PostinganPublik();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public PostinganPublik() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());


        View view = inflater.inflate(R.layout.fragment_postingan_publik, container, false);
        List = (ListView) view.findViewById(R.id.postingan_publik_list);

        String API = "http://colletivita.hol.es/api";
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API).build();
        gitapi git = restAdapter.create(gitapi.class);

        git.getPost("postingan.php", new Callback<Post>() {
            @Override
            public void success(final Post post, Response response) {

                ListAdapter adapter = new CostumAdapterPostinganPublik(getActivity(), post.post);
                List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                                @Override
                                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                    Context context;

                                                    if (mParam1 == "Sekarang") {
                                                        Intent newActivity = new Intent(getContext(), DetailAcaraSekarang.class);
                                                        newActivity.putExtra("judul_acara", post.post.get(position).getNama_acara());
                                                        newActivity.putExtra("lokasi_acara", post.post.get(position).getLokasi());
                                                        newActivity.putExtra("tanggal_acara", post.post.get(position).getTanggal());
                                                        newActivity.putExtra("waktu_acara", post.post.get(position).getWaktu());
                                                        newActivity.putExtra("poster_acara", post.post.get(position).getPoster());
                                                        startActivity(newActivity);
                                                    } else if (mParam1 == "Segera") {
                                                        Intent newActivity = new Intent(getContext(), DetailAcaraSegera.class);
                                                        newActivity.putExtra("judul_acara", post.post.get(position).getNama_acara());
                                                        newActivity.putExtra("lokasi_acara", post.post.get(position).getLokasi());
                                                        newActivity.putExtra("tanggal_acara", post.post.get(position).getTanggal());
                                                        newActivity.putExtra("waktu_acara", post.post.get(position).getWaktu());
                                                        newActivity.putExtra("poster_acara", post.post.get(position).getPoster());
                                                        startActivity(newActivity);
                                                    } else if (mParam1 == "Terdahulu") {
                                                        Intent newActivity = new Intent(getContext(), DetailAcaraTerdahulu.class);
                                                        newActivity.putExtra("judul_acara", post.post.get(position).getNama_acara());
                                                        newActivity.putExtra("lokasi_acara", post.post.get(position).getLokasi());
                                                        newActivity.putExtra("tanggal_acara", post.post.get(position).getTanggal());
                                                        newActivity.putExtra("waktu_acara", post.post.get(position).getWaktu());
                                                        newActivity.putExtra("poster_acara", post.post.get(position).getPoster());
                                                        startActivity(newActivity);
                                                    }
                                                }
                                            }
                );
                List.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError error) {

                Log.e(TAG,error.getMessage());
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
