package com.example.salvador.agendaejemplo;


import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Agenda.db";
    public static final String TABLA_PERSONAS = "persona";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_EMPRESA = "empresa";
    public static final String COLUMN_DESCRIP = "descripcion";



    public AdminSQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLA_PERSONAS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE + " TEXT, " +
                COLUMN_EMPRESA + " TEXT, " +
                COLUMN_DESCRIP + " INTEGER" +
                ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PERSONAS);
        onCreate(db);
    }

    //Añade un nuevo Row a la Base de Datos

    public void addPersona(String nombre, String empresa, String descri) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, nombre);
        values.put(COLUMN_EMPRESA, empresa);
        values.put(COLUMN_DESCRIP, descri);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_PERSONAS, null, values);
        db.close();

    }



    // Borrar una persona de la Base de Datos

    public void borrarPersona(int persona_id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLA_PERSONAS + " WHERE " + COLUMN_ID + " = " + persona_id + ";");
        db.close();
    }

    //listar por id

    public Cursor personabyid(int id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLA_PERSONAS + " WHERE " + COLUMN_ID + " = " + id + ";";
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

    //listar a todas las personas
    public Cursor listarpersonas(){
        SQLiteDatabase db = getReadableDatabase();
        String query = ("SELECT * FROM " + TABLA_PERSONAS + ";");
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

}




