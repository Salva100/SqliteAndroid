package com.example.salvador.agendaejemplo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by salvador on 18/03/2016.
 */
public class TodoCursorAdapter extends CursorAdapter {
    public TodoCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.buscar, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView idtxt = (TextView) view.findViewById(R.id.id_txt);
        TextView nombretxt = (TextView) view.findViewById(R.id.nombre_txt);
        TextView empresatxt = (TextView) view.findViewById(R.id.empresa_txt);

        // Extraccion de las propiedades del cursor


        int txtid = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
        String txtnombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
        String txtempresa = cursor.getString(cursor.getColumnIndexOrThrow("empresa"));


        idtxt.setText(String.valueOf(txtid));
        nombretxt.setText(txtnombre);
        empresatxt.setText(txtempresa);

    }
}
