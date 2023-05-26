package com.example.newlikvidus.data;

import android.util.Log;

import java.util.List;

public abstract class SetterDefCoefsOfArgs {
    static private CoefOfArgs[] coefsOfArgs= {new CoefOfArgs("1stTemp", 1537),
            new CoefOfArgs("summator1", 50), new CoefOfArgs("summator2", 70),
            new CoefOfArgs("summator3", 40), new CoefOfArgs("summator4", 40),
            new CoefOfArgs("C", 88), new CoefOfArgs("Si", 8),
            new CoefOfArgs("Mn", 5),  new CoefOfArgs("P", 30),  new CoefOfArgs("S", 25),
            new CoefOfArgs("Cr", 1.5f), new CoefOfArgs("Ni", 4), new CoefOfArgs("Cu", 5),
            new CoefOfArgs("Al", 3),  new CoefOfArgs("Ti", 20), new CoefOfArgs("V", 2),
            new CoefOfArgs("Mo", 2), new CoefOfArgs("W", 1)};

    public static void addDefCoefs(AppDatabase db){
        //Log.i("TAG", "ФУНКЦИЯ ЗАПУСТИЛАСЬ");
        CoefOfArgsDao coefOfArgsDao = db.coefOfArgsDao();

        if(coefOfArgsDao.getCountOfCoefsOfArgs() == 0) {
            coefOfArgsDao.insertSome(coefsOfArgs);
        }
        //Log.i("TAG", "ФУНКЦИЯ ЗАВЕРШИЛАСЬ");
    }
}
