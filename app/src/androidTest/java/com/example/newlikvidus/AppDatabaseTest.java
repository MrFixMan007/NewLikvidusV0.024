package com.example.newlikvidus;

import android.util.Log;

import com.example.newlikvidus.data.AppDatabase;
import com.example.newlikvidus.data.SetterDefaultArgs;
import com.example.newlikvidus.data.dao.CharacterDao;
import com.example.newlikvidus.data.dao.PossibleValueDao;
import com.example.newlikvidus.data.dao.ValueDao;
import com.example.newlikvidus.data.entities.PossibleValue;
import com.example.newlikvidus.data.entities.Save;
import com.example.newlikvidus.data.entities.Character;
import com.example.newlikvidus.data.dao.SaveDao;
import com.example.newlikvidus.data.entities.Type;
import com.example.newlikvidus.data.dao.TypeDao;
import com.example.newlikvidus.data.entities.Value;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import androidx.room.Room;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class AppDatabaseTest extends TestCase {
    private AppDatabase db;
    private SaveDao saveDao;
    private TypeDao typeDao;
    private CharacterDao characterDao;
    private PossibleValueDao possibleValueDao;
    private ValueDao valueDao;
    private static Save[] saves = new Save[]{new Save("Расчёт температуры ликвидус", "описано", 1)};

    private static Character[] characters = new Character[]{new Character(1, "C", 0f, 100f),
            new Character(1, "S", 0f, 100f, "Сера"),
            new Character(1, "W", 0f, 100f, "Вольфрам"),
            new Character(1, "P", 0f, 100f, "Фосфор"),};
    @Before
    public void createDb() throws Exception{
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getContext(), AppDatabase.class).build();
        SetterDefaultArgs.addDefaultData(db);
        saveDao = db.saveDao();
        typeDao = db.typeDao();
        characterDao = db.characterDao();
        possibleValueDao = db.possibleValueDao();
        valueDao = db.valueDao();
    }

    @Test
    public void getCountOfTypes(){
        assertEquals(11, typeDao.getCountOfTypes());
    }

    @Test
    public void addTypeUnSuccess (){
        assertEquals(printArray(typeDao.getAll()), -1, typeDao.insert(new Type("температура заливки фасонного литья и слитков")));
    }

    @Test
    public void addTypeSuccess (){
        assertEquals(printArray(typeDao.getAll()), typeDao.insert(new Type("Простой тип")), typeDao.getCountOfTypes());
    }

    @Test
    public void addTypeSuccess1 (){
        assertEquals(printArray(typeDao.getAll()), typeDao.insert(new Type("")), typeDao.getCountOfTypes());
    }
    @Test
    public void addSave(){
        assertEquals(1, saveDao.insert(saves[0]));
    }
    @Test
    public void getSave(){
        saves[0].setSave_id(saveDao.insert(saves[0]));
        assertTrue("\nОжидалось:\n"+saves[0]+"\nНо вышло:\n"+
                saveDao.getAll().get(0)+"\n", saveDao.getAll().get(0).equals(saves[0]));
    }
    @Test
    public void getSave1(){
        saves[0].setSave_id(saveDao.insert(saves[0]));
        assertEquals("\nОжидалось:\n"+saves[0]+"\nНо вышло:\n"+saveDao.getAll().get(0)+"\n", saves[0], saveDao.getAll().get(0));
    }

    @Test
    public void getCharacter(){
        try {
            characters[0].setCharacter_id(characterDao.insert(characters[0]));
            testAssertEquals(characters[0], characterDao.getAll().get(characterDao.getCountOfCharacters()-1), characterDao.getAll());
        } catch (Exception e){
            assertFalse(true);
        }
        finally {
            Log.e("SAS", characterDao.getAll().toString());
        }
    }

    @Test
    public void getCharacter1(){
        characters[1].setCharacter_id(characterDao.insert(characters[1]));
        testAssertEquals(characters[1], characterDao.getAll().get(characterDao.getCountOfCharacters()-1), characterDao.getAll());
    }

    @Test
    public void getCharacters(){
        characters[2].setCharacter_id(characterDao.insert(characters[2]));
        characters[3].setCharacter_id(characterDao.insert(characters[3]));
        testAssertEquals(characters[2], characterDao.getAll().get(characterDao.getCountOfCharacters()-2), characterDao.getAll());
        testAssertEquals(characters[3], characterDao.getAll().get(characterDao.getCountOfCharacters()-1), characterDao.getAll());
    }

    @Test
    public void addPossibleValue(){
        characterDao.insert(characters[0]);
        PossibleValue possibleValue = new PossibleValue(2f, 1);
        possibleValue.setPossible_value_id(possibleValueDao.insert(possibleValue));
        testAssertEquals(2f, possibleValueDao.getById(1).getValue(), possibleValueDao.getAll());
    }

    @Test
    public void getCharacter_id_fkOfPossibleValue(){
        characterDao.insert(characters[0]);
        PossibleValue possibleValue = new PossibleValue(2f, 1);
        possibleValue.setPossible_value_id(possibleValueDao.insert(possibleValue));
        testAssertEquals((long)1, possibleValueDao.getById(1).getCharacter_id_fk(), possibleValueDao.getAll());
    }

    @Test
    public void addValue(){
        characterDao.insert(characters[0]);
        saveDao.insert(saves[0]);
        Value value = new Value(1, 1, 10f);
        value.setValue_id(valueDao.insert(value));
        testAssertEquals(10f, valueDao.getById(1).getValue(), valueDao.getAll());
    }

    @After
    public void closeDb() throws Exception{
        db.close();
    }

    public <T, K> void testAssertEquals(T expected, T actual, List<K> array){
        assertEquals(printArray(array), expected, actual);
    }

    public <T> String printArray(List<T> array){
        StringBuilder stringBuilder = new StringBuilder("\n");
        for (int i = 0; i < array.size(); i++){
            stringBuilder.append(array.get(i) + "\n");
        }
        return stringBuilder.toString();
    }
}