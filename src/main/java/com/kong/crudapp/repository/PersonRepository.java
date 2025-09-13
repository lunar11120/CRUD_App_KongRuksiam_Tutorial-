package com.kong.crudapp.repository;
/*
 * @author Theam
 */
import com.kong.crudapp.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonRepository implements PersonDAO{
    
    private EntityManager entitymanager;
    
    @Autowired
    public PersonRepository(EntityManager entitymanager) {
        this.entitymanager = entitymanager;
    }
       
    @Override
    @Transactional
    public void save(Person person) {
        entitymanager.persist(person);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Person person = entitymanager.find(Person.class,id);
        entitymanager.remove(person);
    }

    @Override
    public Person getData(Integer id) {
        return entitymanager.find(Person.class,id);
    }

    @Override
    public List<Person> findAll() {
        //fix when not use select * from person
        String hqlQuery = "SELECT p FROM Person p";
        TypedQuery<Person> query =  entitymanager.createQuery(hqlQuery , Person.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Person person) {
        entitymanager.merge(person);
    }
    
}
