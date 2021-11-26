package com.qa.projectApplication.service;

import com.qa.projectApplication.model.Database;

import java.util.List;

public interface DatabaseService {
    Database saveDatabase(Database database);
    List<Database> getAllDatabase();
    Database getDataBaseById(long id);
    Database updateDataBase(Database database, long id);
    void deleteDataBase(long id);
}
