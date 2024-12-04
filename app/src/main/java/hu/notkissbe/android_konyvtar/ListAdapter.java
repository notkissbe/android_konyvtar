package hu.notkissbe.android_konyvtar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    private List<Item> items;
    private Context context;

    public ListAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void addItems(Item item){
        this.items.add(item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.listviewitem,parent,false);
        TextView cimText = convertView.findViewById(R.id.cimText);
        TextView szerzoText = convertView.findViewById(R.id.szerzoText);
        TextView oldalszamtext = convertView.findViewById(R.id.oldalszamText);
        cimText.setText(items.get(position).cim);
        szerzoText.setText(items.get(position).szerzo);
        oldalszamtext.setText(items.get(position).oldalszam);
        Button torles =  convertView.findViewById(R.id.torlesGomb);

        torles.setOnClickListener((v)-> {
            items.remove(this);
        } );



        return convertView;

    }
}
