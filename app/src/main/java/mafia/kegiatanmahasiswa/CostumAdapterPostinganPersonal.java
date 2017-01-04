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

import mafia.kegiatanmahasiswa.Model.PostPersonalList;

public class CostumAdapterPostinganPersonal extends ArrayAdapter<PostPersonalList> {
    String url="http://colletivita.hol.es/images/foto_profil/";
    public CostumAdapterPostinganPersonal(Context context, List<PostPersonalList> postpersonal) {
        super(context, R.layout.postingan_personal_list_item,postpersonal);
    }

    @Override
    public View getView(int position , View convertView , ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View costumView = inflater.inflate(R.layout.postingan_personal_list_item, parent, false);

        PostPersonalList postpersonal = getItem(position);

        TextView namaacara = (TextView) costumView.findViewById(R.id.txt_rapat);
        TextView lokasi = (TextView) costumView.findViewById(R.id.txt_lokasi);
        TextView tanggal = (TextView) costumView.findViewById(R.id.txt_tanggal);
        TextView namauser = (TextView) costumView.findViewById(R.id.txt_nama_user);
        ImageView fotoprofil = (ImageView) costumView.findViewById(R.id.foto_profil);

        namaacara.setText(postpersonal.getNama_acara());
        lokasi.setText(postpersonal.getLokasi());
        tanggal.setText(postpersonal.getTanggal());
        namauser.setText(postpersonal.getNama_user());

        Picasso.with(getContext()).load(url + postpersonal.getFotoprofil()).into(fotoprofil);

        return costumView;
    }
}

