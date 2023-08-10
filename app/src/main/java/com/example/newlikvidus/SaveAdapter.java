package com.example.newlikvidus;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

import com.example.newlikvidus.activity.LikvidCalcFasonCast;
import com.example.newlikvidus.activity.LikvidSaves;
import com.example.newlikvidus.data.entities.Save;

import java.util.List;

public class SaveAdapter extends RecyclerView.Adapter<SaveAdapter.ViewHolder>{
    private LayoutInflater inflater;
    private List<Save> saves;
    private List<Float> values;
    private static Context context;

    public SaveAdapter(Context context, List<Save> saves, List<Float> values) {
        this.context = context;
        this.saves = saves;
        this.values = values;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public SaveAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.save_list_item, parent, false);
        return new ViewHolder(view).linkAdapter(this); //вызовет метод, который прикрепит ссылку в одном месте внизу и вернёт её же
    }

    @Override
    public void onBindViewHolder(SaveAdapter.ViewHolder holder, int position) {
        Save save = saves.get(position);
        float value = values.get(position);
        holder.nameView.setText(save.getName());
        holder.descriptionView.setText(save.getDescription());
        holder.dateView.setText(save.getDate());
        holder.resultView.setText(String.valueOf(value));
    }

    @Override
    public int getItemCount() {
        return saves.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, descriptionView, dateView, resultView;
        final ImageView moreView;
        private SaveAdapter saveAdapter;
        ViewHolder(View view){
            super(view);
            context = view.getContext();
            nameView = view.findViewById(R.id.name);
            descriptionView = view.findViewById(R.id.description);
            dateView = view.findViewById(R.id.date);
            resultView = view.findViewById(R.id.result);
            moreView = view.findViewById(R.id.more);
            moreView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showPopupMenu(v);
                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, LikvidCalcFasonCast.class);
                    intent.putExtra("save", saveAdapter.saves.get(getAdapterPosition()));
                    context.startActivity(intent);
                }
            });
        }

        //linkAdapter прикрепляет ссылку на адаптер и возвращает его
        public ViewHolder linkAdapter(SaveAdapter saveAdapter) {
            this.saveAdapter = saveAdapter;
            return this;
        }

        //
        public void callRemoveItemWindow(){
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(R.string.remove_item_window);
            builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    removeItem();
                }
            });
            builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
        }
        //
        public void callRemoveDescriptionItemWindow(){
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(R.string.remove_description_of_item_window);
            builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    changeDescription("");
                }
            });
            builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
        }
        //
        public void callRenameItemWindow(){
            Context context = getContext();
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(R.string.rename_item_window);

            final EditText nameInput = new EditText(context);
            nameInput.setInputType(InputType.TYPE_CLASS_TEXT);
            nameInput.setText(saveAdapter.saves.get(getAdapterPosition()).getName());
            builder.setView(nameInput);
            builder.setPositiveButton(R.string.ready, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    renameItem(nameInput.getText().toString());
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
        }
        //
        public void callChangeDescriptionWindow(){
            Context context = getContext();
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(R.string.change_description_item_window);

            final EditText descriptionInput = new EditText(context);
            descriptionInput.setInputType(InputType.TYPE_CLASS_TEXT);
            descriptionInput.setText(saveAdapter.saves.get(getAdapterPosition()).getDescription());
            builder.setView(descriptionInput);
            builder.setPositiveButton(R.string.ready, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    changeDescription(descriptionInput.getText().toString());
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            builder.show();
        }

        //removeItem удаляет сейв и результат по нажатому индексу, а потом уведомляет адаптер,
        //что был удалён элемент по нах-ся индексу (адаптер отрисует изменение)
        public void removeItem(){
            int index = getAdapterPosition();
            saveAdapter.saves.remove(index);
            saveAdapter.values.remove(index);
            saveAdapter.notifyItemRemoved(getAdapterPosition());
        }
        //renameItem переименовывает выбранный элемент и уведомляет адаптер (адаптер отрисует изменение)
        public void renameItem(@NonNull String newName){
            int index = getAdapterPosition();
            saveAdapter.saves.get(index).setName(newName);
            saveAdapter.notifyItemChanged(index);
        }
        //changeDescription изменяет описание выбранного элемента
        //и уведомляет адаптер (адаптер отрисует изменение)
        public void changeDescription(@NonNull String newDescription){
            int index = getAdapterPosition();
            saveAdapter.saves.get(index).setDescription(newDescription);
            saveAdapter.notifyItemChanged(index);
        }

        private void showPopupMenu(View v) {
            PopupMenu popupMenu = new PopupMenu(v.getContext(), v);
            popupMenu.getMenu().add(0, ID_RENAME, Menu.NONE, R.string.rename);
            popupMenu.getMenu().add(0, ID_CHANGE_DESCRIPTION, Menu.NONE, R.string.change_description);
            popupMenu.getMenu().add(0, ID_REMOVE_DESCRIPTION, Menu.NONE, R.string.remove_description);
            popupMenu.getMenu().add(0, ID_REMOVE, Menu.NONE, R.string.remove);
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case ID_RENAME:
                        callRenameItemWindow();
                        break;
                    case ID_CHANGE_DESCRIPTION:
                        callChangeDescriptionWindow();
                        break;
                    case ID_REMOVE:
                        callRemoveItemWindow();
                        break;
                    case ID_REMOVE_DESCRIPTION:
                        callRemoveDescriptionItemWindow();
                        break;
                }
                return true;
            });
            popupMenu.show();
        }

        private static Context getContext(){
            return SaveAdapter.context;
        }
        private static final int ID_RENAME = 1;
        private static final int ID_CHANGE_DESCRIPTION = 2;
        private static final int ID_REMOVE = 3;
        private static final int ID_REMOVE_DESCRIPTION = 4;
    }
}
