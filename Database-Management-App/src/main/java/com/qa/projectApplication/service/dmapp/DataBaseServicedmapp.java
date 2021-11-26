package com.qa.projectApplication.service.dmapp;

import com.qa.projectApplication.exception.DataNotFoundException;
import com.qa.projectApplication.model.Database;
import com.qa.projectApplication.repository.DataBaseRepository;
import com.qa.projectApplication.service.DatabaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataBaseServicedmapp implements DatabaseService {

    private DataBaseRepository dataBaseRepository;

    public DataBaseServicedmapp(DataBaseRepository dataBaseRepository) {
        super();
        this.dataBaseRepository = dataBaseRepository;
    }

    @Override
    public Database saveDatabase(Database database) {
        return dataBaseRepository.save(database);
    }

    @Override
    public List<Database> getAllDatabase() {
        return dataBaseRepository.findAll();
    }

    @Override
    public Database getDataBaseById(long id) {
        return dataBaseRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Database", "Id", id));
    }

    @Override
    public Database updateDataBase(Database database, long id) {

        // We need to check if the user with given id is exist in the Database or not//
        Database existingDataBase = dataBaseRepository
                .findById(id).orElseThrow(() -> new DataNotFoundException("Database", "Id", id));

        // Update the DatabaseRepository//
        existingDataBase.setUserFirstName(database.getUserFirstName());
        existingDataBase.setUserLastName(database.getUserLastName());
        existingDataBase.setEmailId(database.getEmailId());
        existingDataBase.setPhoneNumber(database.getPhoneNumber());

        // Save existing database to the Database//
        dataBaseRepository.save(existingDataBase);
        return existingDataBase;
    }

    @Override
    public void deleteDataBase(long id) {

        //Check if a data exist on the database
        dataBaseRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Database", "Id", id));
        dataBaseRepository.deleteById(id);
    }
}
