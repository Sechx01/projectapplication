package com.qa.projectApplication.repository;

import com.qa.projectApplication.model.Database;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBaseRepository extends JpaRepository<Database, Long> {
}
