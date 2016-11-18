package aifree.com.citiestestapp.data.db_store;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import aifree.com.citiestestapp.data.db_store.tables.LikedCitiesTable;
import aifree.com.citiestestapp.data.db_store.tables.SelectedCitiesTable;
import aifree.com.citiestestapp.presentation.models.City;
import aifree.com.citiestestapp.presentation.utils.Logger;

public class DBController {

    private SQLiteDatabase mDatabase;

    public DBController(Context context) {
        SqlHelper helper = new SqlHelper(context);
        mDatabase = helper.getWritableDatabase();
    }

    public int addCityToLiked(City city) {
        mDatabase.execSQL("INSERT INTO "+ LikedCitiesTable.TABLE_NAME+" VALUES ("+city.getId()+");");
        return city.getId();
    }

    public int removeCityFromLiked(City city) {
        mDatabase.execSQL("DELETE FROM "+ LikedCitiesTable.TABLE_NAME+" WHERE "+LikedCitiesTable.FIELD_ID+" = "+city.getId()+";");
        return city.getId();
    }

    public int selectSity(City city) {
        mDatabase.execSQL("DELETE FROM "+ SelectedCitiesTable.TABLE_NAME+";");
        mDatabase.execSQL("INSERT INTO "+ SelectedCitiesTable.TABLE_NAME+" VALUES ("+city.getId()+");");
        return city.getId();
    }

    public int getSelectedCity() {
        String query = "SELECT * FROM "+SelectedCitiesTable.TABLE_NAME+";";
        Cursor cursor = mDatabase.rawQuery(query, null);
        cursor.moveToFirst();
        try {
            return cursor.getInt(cursor.getColumnIndex(SelectedCitiesTable.FIELD_ID));
        } catch (Exception e) {
            Logger.logError(e);
            return -1;
        }
    }

    public List<Integer> getLikedCities() {
        String query = "SELECT * FROM "+LikedCitiesTable.TABLE_NAME+";";
        Cursor cursor = mDatabase.rawQuery(query, null);
        List<Integer> selectedCities = new ArrayList<>();
        try {
            cursor.moveToFirst();
            do {
                selectedCities.add(cursor.getInt(cursor.getColumnIndex(LikedCitiesTable.FIELD_ID)));
            } while (cursor.moveToNext());
        } catch (Exception e) {
            Logger.logError(e);
        }
        return selectedCities;
    }
}
