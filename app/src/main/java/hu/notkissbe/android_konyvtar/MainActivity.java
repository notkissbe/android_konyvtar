package hu.notkissbe.android_konyvtar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText cimEditText;
    EditText szerzoEditText;
    EditText oldalszamEditText;
    Button HozzaadasGomb;
    ArrayList<Item> items = new ArrayList<Item>();
    ListView listView;
    Button torlesGomb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();

        ListAdapter adapter = new ListAdapter(items, this);
        listView.setAdapter(adapter);
        HozzaadasGomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cim = cimEditText.getText().toString();
                String szerzo = szerzoEditText.getText().toString();
                String oldalszam = oldalszamEditText.getText().toString();


                if (!cim.isEmpty() && !szerzo.isEmpty() && !oldalszam.isEmpty()) {
                    Item newItem = new Item(cim, szerzo, oldalszam);
                    items.add(newItem);
                    adapter.notifyDataSetChanged();

                    cimEditText.setText("");
                    szerzoEditText.setText("");
                    oldalszamEditText.setText("");
                }
            }
        });


        listView.setOnItemClickListener((parent,view, position,id) -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("szerzo",items.get(position).cim);
            intent.putExtra("szerzo",items.get(position).szerzo);
            intent.putExtra("szerzo",items.get(position).oldalszam);
            startActivity(intent);
            finish();
        });

    }


    public void init() {
        cimEditText = findViewById(R.id.cimEditText);
        szerzoEditText = findViewById(R.id.szerzoEditText);
        oldalszamEditText = findViewById(R.id.oldalszamEditText);
        HozzaadasGomb = findViewById(R.id.HozzaadasGomb);
        listView = findViewById(R.id.foListView);
        torlesGomb = findViewById(R.id.torlesGomb);
    }

}