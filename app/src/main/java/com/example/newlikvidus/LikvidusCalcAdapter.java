package com.example.newlikvidus;

import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlikvidus.data.entities.Save;

import java.util.List;

public class LikvidusCalcAdapter extends RecyclerView.Adapter<LikvidusCalcAdapter.ViewHolder>{
    private LayoutInflater inflater;
    private List<String> characterNameList;
    private List<Float> characterValueList;
    private static Context context;

    public LikvidusCalcAdapter(Context context, List<String> characterNameList, List<Float> characterValueList) {
        this.context = context;
        this.characterNameList = characterNameList;
        this.characterValueList = characterValueList;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public LikvidusCalcAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.likvidus_character_list_item, parent, false);
        return new ViewHolder(view).linkAdapter(this); //вызовет метод, который прикрепит ссылку в одном месте внизу и вернёт её же
    }

    @Override
    public void onBindViewHolder(LikvidusCalcAdapter.ViewHolder holder, int position) {
        String characterName = characterNameList.get(position);
        float characterValue = characterValueList.get(position);
        holder.nameView.setText(characterName);
        holder.value.setText(String.valueOf(characterValue));
    }

    @Override
    public int getItemCount() {
        return characterNameList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        final EditText value;
        private LikvidusCalcAdapter likvidusCalcAdapter;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.LikvidCalcNameOfCharacter);
            value = view.findViewById(R.id.LikvidCalcValueOfCharacter);
        }
        //linkAdapter прикрепляет ссылку на адаптер и возвращает его
        public ViewHolder linkAdapter(LikvidusCalcAdapter likvidusCalcAdapter) {
            this.likvidusCalcAdapter = likvidusCalcAdapter;
            return this;
        }

        private static Context getContext(){
            return LikvidusCalcAdapter.context;
        }
    }
}
