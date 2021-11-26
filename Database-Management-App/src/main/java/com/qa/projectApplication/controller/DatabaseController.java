package com.qa.projectApplication.controller;

import com.qa.projectApplication.model.Database;
import com.qa.projectApplication.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/database")
public class DatabaseController {

    @Autowired
    private DatabaseService databaseService;

    public DatabaseController(DatabaseService databaseService) {
        super();
        this.databaseService = databaseService;
    }

    // build create Database REST API
    @PostMapping
    public ResponseEntity<Database> saveDatabase(@RequestBody Database database){
        return new ResponseEntity<Database>(databaseService.saveDatabase(database), HttpStatus.CREATED);
    }

    // Build get all Database REST API
    @GetMapping
    public List<Database> getAllDatabase(){
        return databaseService.getAllDatabase();
    }

    // Build get Database by ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Database> getDataBaseById(@PathVariable("id") long DataBaseId){
        return new ResponseEntity<Database>(databaseService.getDataBaseById(DataBaseId), HttpStatus.OK);
    }

    // Build Update Database REST API
    @PutMapping("{id}")
    public ResponseEntity<Database> updateDateBase(@PathVariable("id") long id
                                                  ,@RequestBody Database database){
        return new ResponseEntity<Database>(databaseService.updateDataBase(database, id), HttpStatus.OK);
    }

    //Build delete Database REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDataBase(@PathVariable("id") long id){

        // delete data from the Database//
        databaseService.deleteDataBase(id);
        return new ResponseEntity<String>("Database deleted successfully!.", HttpStatus.OK);
    }
}
