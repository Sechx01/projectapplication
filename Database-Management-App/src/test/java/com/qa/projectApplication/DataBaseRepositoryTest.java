package com.qa.projectApplication;

import com.qa.projectApplication.model.Database;
import com.qa.projectApplication.repository.DataBaseRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DataBaseRepositoryTest {

    @Autowired
    private DataBaseRepository dataBaseRepository;

    // JUnit test for saveDataBase
    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveDataBaseTest(){
        Database database = Database.builder()
                .userFirstName("Kelvin")
                .userLastName("Dorang")
                .EmailId("kdurang@gmail.com")
                .build();

        dataBaseRepository.save(database);

        Assertions.assertThat(database.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getDataBaseTest(){
        Database database = dataBaseRepository.findById(1L).get();

        Assertions.assertThat(database.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    public void getListofDatabaseTest(){

        List<Database> databases = dataBaseRepository.findAll();

        Assertions.assertThat(databases.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateDatabaseTest(){

        Database database = dataBaseRepository.findById(1L).get();

        database.setEmailId("kdurang@gmail.com");

        Database databaseUpdated = dataBaseRepository.save(database);

        Assertions.assertThat(databaseUpdated.getEmailId()).isEqualTo("kdurang@gmail.com");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteDatabaseTest(){

        Database database = dataBaseRepository.findById(1L).get();

        dataBaseRepository.delete(database);

        Database database1 = null;

        Optional<Database> optionalDatabase = dataBaseRepository.findById(database.getId());

        if(optionalDatabase.isPresent()){
            database1 = optionalDatabase.get();
        }

        Assertions.assertThat(database1).isNull();
    }
}
