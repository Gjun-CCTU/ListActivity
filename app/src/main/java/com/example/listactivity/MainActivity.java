package com.example.listactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.SearchRecentSuggestionsProvider;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        Resources resources =  getResources();
        String data[] = resources.getStringArray(R.array.course);
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(MainActivity.this,R.layout.item , data);
        setListAdapter(adapter);
        ListView LV =  getListView();
        LV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String msg =  ((TextView)view).getText().toString();
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        LV.setTextFilterEnabled(true);
    }
}
