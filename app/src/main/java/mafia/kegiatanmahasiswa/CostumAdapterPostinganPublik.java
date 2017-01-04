package mafia.kegiatanmahasiswa;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import mafia.kegiatanmahasiswa.Model.PostList;

public class CostumAdapterPostinganPublik extends ArrayAdapter<PostList> {
    String url="http://colletivita.hol.es/images/postingan_publik/";
    public CostumAdapterPostinganPublik(Context context, List<PostList> post) {
        super(context, R.layout.postingan_publik_list_item,post);
    }

    @Override
    public View getView(int position , View convertView , ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View costumView = inflater.inflate(R.layout.postingan_publik_list_item, parent, false);

        PostList post = getItem(position);

        TextView judul = (TextView) costumView.findViewById(R.id.txt_rapat);
        TextView lokasi = (TextView) costumView.findViewById(R.id.txt_lokasi);
        TextView tanggal = (TextView) costumView.findViewById(R.id.txt_tanggal);
        ImageView poster = (ImageView) costumView.findViewById(R.id.foto_profil);

        judul.setText(post.getNama_acara());
        lokasi.setText(post.getLokasi());
        tanggal.setText(post.getTanggal());

        Picasso.with(getContext()).load(url + post.getPoster()).into(poster);

        return costumView;
    }
}
