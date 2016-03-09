package com.example.english.assignement1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener{

    Button add;
    ListView listview;
    EditText taskInit;

    final ArrayList<ElementListeView> list = new ArrayList<ElementListeView>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);


        add=(Button)findViewById(R.id.add);
        taskInit=(EditText)findViewById(R.id.edittext);



        final CustomArrayAdaptator adapter = new CustomArrayAdaptator(this, list);
        listview.setAdapter(adapter);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                list.remove(position);
                listview.setAdapter(adapter);
                return false;
            }
        });

        add.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == add.getId())
        {
            if (!taskInit.getText().toString().isEmpty()) {
                ElementListeView e = new ElementListeView(taskInit.getText().toString(), 0);
                list.add(e);
                final CustomArrayAdaptator adapter = new CustomArrayAdaptator(this, list);
                listview.setAdapter(adapter);
                taskInit.setText("");
            }
        }


    }
}
