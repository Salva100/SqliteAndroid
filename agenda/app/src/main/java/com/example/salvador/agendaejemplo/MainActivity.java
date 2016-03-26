package com.example.salvador.agendaejemplo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nom,emp,des,cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AdminSQLiteOpenHelper dbHandler;
        dbHandler = new AdminSQLiteOpenHelper(this, null, null, 1);
        SQLiteDatabase db = dbHandler.getWritableDatabase();


        nom=(EditText)findViewById(R.id.edtxtNom);
        emp=(EditText)findViewById(R.id.edtxtEmp);
        des=(EditText)findViewById(R.id.edtxtDesp);
        cont=(EditText)findViewById(R.id.edtxtCont);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void alta(View v) {
        AdminSQLiteOpenHelper dbHandler;
        dbHandler = new AdminSQLiteOpenHelper(this, null, null, 1);
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        dbHandler.addPersona(nom.getText().toString(),emp.getText().toString(),des.getText().toString());
       /* AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 3);
        SQLiteDatabase bd = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("Nombre", nom.getText().toString());
        registro.put("Empresa",  emp.getText().toString());
        registro.put("descripcion",  des.getText().toString());
        registro.put("Contacto",  cont.getText().toString());
        bd.insert("Agenta", null, registro);

        bd.close();*/
        nom.setText("");
        emp.setText("");
        des.setText("");
        cont.setText("");
        Toast.makeText(this, "Se cargaron los datos del artículo",
                Toast.LENGTH_SHORT).show();
    }
    public void consultaporcodigo(View v) {
        Intent i = new Intent(this, Buscar.class);
        startActivity(i);



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
