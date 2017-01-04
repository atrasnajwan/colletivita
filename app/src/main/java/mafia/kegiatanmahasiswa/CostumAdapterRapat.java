package mafia.kegiatanmahasiswa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import mafia.kegiatanmahasiswa.Model.PostList;
import mafia.kegiatanmahasiswa.Model.RapatList;

public class CostumAdapterRapat extends ArrayAdapter<RapatList> {
        
public CostumAdapterRapat(Context context, List<RapatList> rapat) {
        super(context, R.layout.rapat_list_item,rapat);
        }

@Override
public View getView(int position , View convertView , ViewGroup parent)
        {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View costumView = inflater.inflate(R.layout.rapat_list_item, parent, false);

        RapatList rapat = getItem(position);

        TextView indexrapat = (TextView) costumView.findViewById(R.id.txt_rapat);
        TextView tanggal = (TextView) costumView.findViewById(R.id.txt_tanggal);
       

        tanggal.setText(rapat.getTanggal());


        return costumView;
        }

}