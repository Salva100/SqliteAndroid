package com.example.salvador.agendaejemplo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by salvador on 18/03/2016.
 */
public class Buscar extends AppCompatActivity {
    EditText inputSearch;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buscar);

        AdminSQLiteOpenHelper dbHandler;
        dbHandler = new AdminSQLiteOpenHelper(this, null, null, 1);
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        Cursor cursor = dbHandler.listarpersonas();

        ListView lvlitems = (ListView) findViewById(R.id.lvlitems);
        lvlitems.setTextFilterEnabled(true);
        final TodoCursorAdapter todoAdapter = new TodoCursorAdapter(this, cursor);
        lvlitems.setAdapter(todoAdapter);

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
}
