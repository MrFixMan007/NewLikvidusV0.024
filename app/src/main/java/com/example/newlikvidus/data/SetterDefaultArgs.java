package com.example.newlikvidus.data;

import android.util.Log;

import com.example.newlikvidus.data.dao.CharacterDao;
import com.example.newlikvidus.data.dao.SaveDao;
import com.example.newlikvidus.data.dao.TypeDao;
import com.example.newlikvidus.data.dao.ValueDao;
import com.example.newlikvidus.data.entities.Character;
import com.example.newlikvidus.data.entities.Save;
import com.example.newlikvidus.data.entities.Type;
import com.example.newlikvidus.data.entities.Value;

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
            new Character(1, "RES", 0f, 3000f, "Результат", "Градус", 0, 1),
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

    private static Save[] saves = new Save[]{
            new Save("Тестовый сейв", "описано", 1),
            new Save("Тестовый результат", 1),
            new Save("Тестовый результат абра кадабра", 1),
            new Save("Тестовый результат", "описано надеюсь не слышком длинно", 1),
            new Save("Тестовый результат", "описано надеюсь не слышком длинно", 1),
            new Save("Тестовый результат", "описано надеюсь не слышком длинно", 1),
            new Save("Тестовый результат", "описано надеюсь не слышком длинно", 1),
            new Save("Тестовый результат", "описано надеюсь не слышком длинно", 1),
            new Save("Тестовый результат", "описано надеюсь не слышком длинно", 1),
            new Save("Тестовый результат", "описано надеюсь не слышком длинно", 1),
            new Save("Тестовый результат", "описано надеюсь не слышком длинно", 1),
            new Save("Тестовый результат", "описано надеюсь не слышком длинно", 1),
            new Save("Тестовый результат", "описано надеюсь не слышком длинно", 1),
    };
    private static Value[] values = new Value[]{
            new Value(1,1,1538f),
            new Value(1,2,1600f),
            new Value(1,3,1800f),
            new Value(1,4,2200f),
            new Value(1,5,2200f),
            new Value(1,6,2200f),
            new Value(1,7,2200f),
            new Value(1,8,2200f),
            new Value(1,9,2200f),
            new Value(1,10,2200f),
            new Value(1,11,2200f),
            new Value(1,12,2200f),
            new Value(1,13,2200f),
    };

    public static void addDefCoefs(AppDatabase db){
//        Log.i("TAG", "ФУНКЦИЯ ЗАПУСТИЛАСЬ");
        TypeDao typeDao = db.typeDao();
        CharacterDao characterDao = db.characterDao();

        if(typeDao.getCountOfTypes() == 0) {
            typeDao.insertSome(types);
        }

        if(characterDao.getCountOfCharacters() == 0) {
            characterDao.insertSome(characters);
        }
//        Log.i("TAG", "ФУНКЦИЯ ЗАВЕРШИЛАСЬ");
    }

    public static void addTestSaves(AppDatabase db){
        SaveDao saveDao = db.saveDao();
        ValueDao valueDao = db.valueDao();

        if(saveDao.getCountOfSaves() == 0) {
            saveDao.insertSome(saves);
        }
        if(valueDao.getCountOfCharacters() == 0){
            valueDao.insertSome(values);
        }
    }

    public static Type[] getTypes() {
        return types;
    }

    public static Character[] getCharacters() {
        return characters;
    }
}
