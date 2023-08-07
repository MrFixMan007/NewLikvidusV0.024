package com.example.newlikvidus.data;

import android.util.Log;

import com.example.newlikvidus.data.dao.CharacterDao;
import com.example.newlikvidus.data.dao.TypeDao;
import com.example.newlikvidus.data.entities.Character;
import com.example.newlikvidus.data.entities.Type;

public abstract class SetterDefaultArgs {
    private static Type[] types = new Type[]{
            new Type("Температура заливки фасонного литья и слитков"),
            new Type("Литниково-питающая система (Простой)"),
            new Type("Литниково-питающая система (Расширенный)"),
            new Type("Классическая прибыль 1"),
            new Type("Классическая прибыль 2"),
            new Type("Классическая прибыль 3"),
            new Type("Экзотермическая прибыль"),
            new Type("Боковая прибыль"),
            new Type("Масса груза"),
            new Type("Время выдержки отливки в форме"),
            new Type("Шихта")};

    private static Character[] characters = new Character[]{
            new Character(1, "W", 0f, 100f, "Вольфрам", "%", 0, 1),
            new Character(1, "Cr", 0f, 100f, "Хром", "%", 0, 1.5f),
            new Character(1, "Co", 0f, 100f, "Кобальт", "%", 0, 1.5f),
            new Character(1, "Mo", 0f, 100f, "Молибден", "%", 0, 2),
            new Character(1, "V", 0f, 100f, "Ванадий", "%", 0, 2),
            new Character(1, "Al", 0f, 100f, "Алюминий", "%", 0, 3),
            new Character(1, "Ni", 0f, 100f, "Никель", "%", 0, 4),
            new Character(1, "Mn", 0f, 100f, "Марганец", "%", 0, 5),
            new Character(1, "Cu", 0f, 100f, "Медь", "%", 0, 5),
            new Character(1, "Si", 0f, 100f, "Кремний", "%", 0, 8),
            new Character(1, "Ti", 0f, 100f, "Титан", "%", 0, 20),
            new Character(1, "S", 0f, 100f, "Сера", "%", 0, 25),
            new Character(1, "P", 0f, 100f, "Фосфор", "%", 0, 30),
            new Character(1, "C", 0f, 100f, "Углерод", "%", 0, 88),
    };

    public static void addDefCoefs(AppDatabase db){
        Log.i("TAG", "ФУНКЦИЯ ЗАПУСТИЛАСЬ");
        TypeDao typeDao = db.typeDao();
        CharacterDao characterDao = db.characterDao();

        if(typeDao.getCountOfTypes() == 0) {
            typeDao.insertSome(types);
        }

        if(characterDao.getCountOfCharacters() == 0) {
            characterDao.insertSome(characters);
        }
        Log.i("TAG", "ФУНКЦИЯ ЗАВЕРШИЛАСЬ");
    }
}
