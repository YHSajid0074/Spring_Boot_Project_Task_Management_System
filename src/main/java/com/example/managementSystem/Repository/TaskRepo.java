package com.example.managementSystem.Repository;

import com.example.managementSystem.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {

@Query(nativeQuery = true,value="select * from Task where id%2=0")
    List<Task> SortByid();

}