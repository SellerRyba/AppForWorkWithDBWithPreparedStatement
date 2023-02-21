package com.appforworkwithdbwithprst.feature.database;

import com.appforworkwithdbwithprst.feature.prefs.Prefs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DatabasePopulateService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        new DatabaseQueryService().findMaxProjectsClient();
        database.close();


    }
    public void addToDb(Database database){
        try {
            String addToDb = new Prefs().getString(Prefs.POPULATE_DB_SQL_FILE_PATH);

            String sql = String.join("\n",
                    Files.readAllLines(Paths.get(addToDb))
            );
            database.executeUpdate(sql);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

