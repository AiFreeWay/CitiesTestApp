package aifree.com.citiestestapp.data.db_store;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import aifree.com.citiestestapp.data.db_store.tables.LikedCitiesTable;
import aifree.com.citiestestapp.data.db_store.tables.SelectedCitiesTable;


public class SqlHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "CitiesDB";
    private static final int DB_VERSION = 1;

    public SqlHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createCitiesTables(sqLiteDatabase);
        createLikedTables(sqLiteDatabase);
    }

    private void createCitiesTables(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ SelectedCitiesTable.TABLE_NAME+" ("
                + SelectedCitiesTable.FIELD_ID+" integer);");
    }

    private void createLikedTables(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ LikedCitiesTable.TABLE_NAME+" ("
                + LikedCitiesTable.FIELD_ID+" integer);");
    }
}
