//person obj DAO -----
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
