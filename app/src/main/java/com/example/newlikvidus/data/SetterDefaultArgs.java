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
            new Type("Температура заливки фасонного литья"),
            new Type("Температура заливки слитков"),
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
            new Character(DbIdConstants.ID_TYPE_FASON, "RES", 0f, 3000f, "Результат", "Градус", 0, 1),
            new Character(DbIdConstants.ID_TYPE_FASON, "M1", -1000f, 1000f, "Разница температуры при заливке (низ)", "", 50, 1),
            new Character(DbIdConstants.ID_TYPE_FASON, "M2", -1000f, 1000f, "Разница температуры при заливке (верх)", "", 70, 1),
            new Character(DbIdConstants.ID_TYPE_FASON, "M3", -1000f, 1000f, "Разница температуры в печи (низ)", "", 40, 1),
            new Character(DbIdConstants.ID_TYPE_FASON, "M4", -1000f, 1000f, "Разница температуры в печи (верх)", "", 40, 1),

            new Character(DbIdConstants.ID_TYPE_FASON, "W", 0f, 100f, "Вольфрам", "%", 0, 1),
            new Character(DbIdConstants.ID_TYPE_FASON, "Cr", 0f, 100f, "Хром", "%", 0, 1.5f),
            new Character(DbIdConstants.ID_TYPE_FASON, "Co", 0f, 100f, "Кобальт", "%", 0, 1.5f),
            new Character(DbIdConstants.ID_TYPE_FASON, "Mo", 0f, 100f, "Молибден", "%", 0, 2),
            new Character(DbIdConstants.ID_TYPE_FASON, "V", 0f, 100f, "Ванадий", "%", 0, 2),
            new Character(DbIdConstants.ID_TYPE_FASON, "Al", 0f, 100f, "Алюминий", "%", 0, 3),
            new Character(DbIdConstants.ID_TYPE_FASON, "Ni", 0f, 100f, "Никель", "%", 0, 4),
            new Character(DbIdConstants.ID_TYPE_FASON, "Mn", 0f, 100f, "Марганец", "%", 0, 5),
            new Character(DbIdConstants.ID_TYPE_FASON, "Cu", 0f, 100f, "Медь", "%", 0, 5),
            new Character(DbIdConstants.ID_TYPE_FASON, "Si", 0f, 100f, "Кремний", "%", 0, 8),
            new Character(DbIdConstants.ID_TYPE_FASON, "Ti", 0f, 100f, "Титан", "%", 0, 20),
            new Character(DbIdConstants.ID_TYPE_FASON, "S", 0f, 100f, "Сера", "%", 0, 25),
            new Character(DbIdConstants.ID_TYPE_FASON, "P", 0f, 100f, "Фосфор", "%", 0, 30),
            new Character(DbIdConstants.ID_TYPE_FASON, "C", 0f, 100f, "Углерод", "%", 0, 88),

            new Character(DbIdConstants.ID_TYPE_INGOT, "RES", 0f, 3000f, "Результат", "Градус", 0, 1),
            new Character(DbIdConstants.ID_TYPE_INGOT, "M1", -1000f, 1000f, "Разница температуры при заливке (низ)", "", 100, 1),
            new Character(DbIdConstants.ID_TYPE_INGOT, "M2", -1000f, 1000f, "Разница температуры при заливке (верх)", "", 120, 1),
            new Character(DbIdConstants.ID_TYPE_INGOT, "M3", -1000f, 1000f, "Разница температуры в печи (низ)", "", 40, 1),
            new Character(DbIdConstants.ID_TYPE_INGOT, "M4", -1000f, 1000f, "Разница температуры в печи (верх)", "", 40, 1),

            new Character(DbIdConstants.ID_TYPE_INGOT, "W", 0f, 100f, "Вольфрам", "%", 0, 1),
            new Character(DbIdConstants.ID_TYPE_INGOT, "Cr", 0f, 100f, "Хром", "%", 0, 1.5f),
            new Character(DbIdConstants.ID_TYPE_INGOT, "Co", 0f, 100f, "Кобальт", "%", 0, 1.5f),
            new Character(DbIdConstants.ID_TYPE_INGOT, "Mo", 0f, 100f, "Молибден", "%", 0, 2),
            new Character(DbIdConstants.ID_TYPE_INGOT, "V", 0f, 100f, "Ванадий", "%", 0, 2),
            new Character(DbIdConstants.ID_TYPE_INGOT, "Al", 0f, 100f, "Алюминий", "%", 0, 3),
            new Character(DbIdConstants.ID_TYPE_INGOT, "Ni", 0f, 100f, "Никель", "%", 0, 4),
            new Character(DbIdConstants.ID_TYPE_INGOT, "Mn", 0f, 100f, "Марганец", "%", 0, 5),
            new Character(DbIdConstants.ID_TYPE_INGOT, "Cu", 0f, 100f, "Медь", "%", 0, 5),
            new Character(DbIdConstants.ID_TYPE_INGOT, "Si", 0f, 100f, "Кремний", "%", 0, 8),
            new Character(DbIdConstants.ID_TYPE_INGOT, "C", 0f, 100f, "Углерод", "%", 0, 88),
            new Character(DbIdConstants.ID_TYPE_INGOT, "Ti", 0f, 100f, "Титан", "%", 0, 20),
            new Character(DbIdConstants.ID_TYPE_INGOT, "S", 0f, 100f, "Сера", "%", 0, 25),
            new Character(DbIdConstants.ID_TYPE_INGOT, "P", 0f, 100f, "Фосфор", "%", 0, 30),
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
            new Value(DbIdConstants.ID_RESULT,1,1538f),
            new Value(DbIdConstants.ID_KOEF1,1,50f),
            new Value(DbIdConstants.ID_KOEF2,1,70f),
            new Value(DbIdConstants.ID_KOEF3,1,40f),
            new Value(DbIdConstants.ID_KOEF4,1,40f),

            new Value(6,1,6.5f),
            new Value(7,1,7),
            new Value(8,1,8),
            new Value(9,1,9.6f),
            new Value(10,1,10),
            new Value(11,1,11),
            new Value(12,1,12),
            new Value(13,1,13),
            new Value(14,1,14),
            new Value(15,1,15),
            new Value(16,1,16),
            new Value(17,1,17),
            new Value(18,1,18),
            new Value(19,1,19),



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
