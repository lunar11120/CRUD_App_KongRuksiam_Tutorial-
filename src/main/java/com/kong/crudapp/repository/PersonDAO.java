/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kong.crudapp.repository;

import com.kong.crudapp.Person;
import java.util.List;

/**
 *
 * @author Theam
 */
public interface PersonDAO {
    
     void save(Person person);
     void delete(Integer id);
     Person getData(Integer id);
     List<Person> findAll();
     void update(Person person);
     
}
