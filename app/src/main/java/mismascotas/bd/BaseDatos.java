package mismascotas.bd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.android.miscontactos.R;

import java.util.ArrayList;

import mismascotas.Mascotas;

/**
 * Created by JULIAN on 29/05/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, Cte.DATABASE_NAME, null, Cte.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + Cte.TABLE_MASC + "(" +
                Cte.TABLE_MASC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Cte.TABLE_MASC_NOMBRE + " TEXT, " +
                Cte.TABLE_MASC_RATE + " INTEGER, " +
                Cte.TABLE_MASC_FOTO + " INTEGER" +
                ")";

        db.execSQL(queryCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + Cte.TABLE_MASC);
        onCreate(db);
    }

    public ArrayList<Mascotas> obtenerMascotas() {
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + Cte.TABLE_MASC;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){

            Mascotas mascActual = new Mascotas();

            mascActual.setId(registros.getInt(0));
            mascActual.setNombre(registros.getString(1));
            mascActual.setRate(registros.getInt(2));
            mascActual.setFoto(registros.getInt(3));

            mascotas.add(mascActual);

        }



        return mascotas;
    }
    public ArrayList<Mascotas> obtenerMascotas2() {
        ArrayList<Mascotas> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + Cte.TABLE_MASC + " ORDER BY rate DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){

            Mascotas mascActual = new Mascotas();

            mascActual.setId(registros.getInt(0));
            mascActual.setNombre(registros.getString(1));
            mascActual.setRate(registros.getInt(2));
            mascActual.setFoto(registros.getInt(3));

            mascotas.add(mascActual);

        }



        return mascotas;
    }

    public void insertarMasc(){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.insert(Cte.TABLE_MASC,null, contentValues);
        SQLiteStatement pst = db.compileStatement("INSERT INTO mascota (nombre,rate,foto) VALUES (?,?,?)");
        pst.bindString(1,"KATY");
        pst.bindString(2,"1");
        pst.bindString(3, String.valueOf(R.drawable.caballo));
        pst.execute();

            pst.bindString(1,"QUESO");
        pst.bindString(2,"1");
        pst.bindString(3, String.valueOf(R.drawable.culebra));
        pst.execute();

        pst.bindString(1,"LOLO");
        pst.bindString(2,"1");
        pst.bindString(3, String.valueOf(R.drawable.delfin));
        pst.execute();

        pst.bindString(1,"MAR");
        pst.bindString(2,"1");
        pst.bindString(3, String.valueOf(R.drawable.elefante));
        pst.execute();

        pst.bindString(1,"ESTRELLA");
        pst.bindString(2,"1");
        pst.bindString(3, String.valueOf(R.drawable.gato));
        pst.execute();
    }

    public void actualizaLike(int i, Mascotas mascota){
        SQLiteDatabase db = this.getWritableDatabase();
        String cadena= "UPDATE mascota SET rate='" + i + "' WHERE id='"+mascota.getId()+"'";
        db.execSQL(cadena);
        db.close();
    }


    public int obtenerLikes(Mascotas mascota){
        int likes =0;
        String query = "SELECT rate FROM mascota WHERE id='"+mascota.getId()+"'";

        SQLiteDatabase db2 = this.getWritableDatabase();
        Cursor registros = db2.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

       registros.close();

        return likes;
    }
}
