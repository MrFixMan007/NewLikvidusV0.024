package com.example.newlikvidus.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.newlikvidus.R;
import com.example.newlikvidus.SaveAdapter;
import com.example.newlikvidus.data.AppDatabase;
import com.example.newlikvidus.data.dao.SaveDao;
import com.example.newlikvidus.data.dao.ValueDao;
import com.example.newlikvidus.data.entities.Save;

import java.util.ArrayList;
import java.util.List;

public class LikvidSaves extends AppCompatActivity {

    private AppDatabase db;
    private List<Save> saves;
    private SaveDao saveDao;
    private List<Float> values;
    private ValueDao valueDao;
    public boolean ready = false;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likvid_saves);

        db = AppDatabase.getInstance(this);
        context = this;

        new Thread(new Runnable() {
            @Override
            public void run() {
                saveDao = db.saveDao();
                valueDao = db.valueDao();

                saves = saveDao.getByType_id(1);
                values = new ArrayList<>();
                for (int i = 0; i < saves.size(); i++) {
                    values.add(valueDao.getByCharacter_idAndSave_id(1, saves.get(i).getSave_id()).getValue()); //добавляю в values нужный результат по id результат (1) и id сейва
                    Log.e("VALUE", values.get(i).toString());
                }
                ready = true;

                RecyclerView recyclerView = findViewById(R.id.list);
                // создаем адаптер
                SaveAdapter adapter = new SaveAdapter(getContext(), saves, values);
                // устанавливаем для списка адаптер
                recyclerView.setAdapter(adapter);
            }
        }).start();
    }

    private static Context getContext(){
        return LikvidSaves.context;
    }
}