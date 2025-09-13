package com.kong.crudapp;

import com.kong.crudapp.repository.PersonDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
Spring Boot  [FULL COURSE]  KongRuksiam Tutorial   
https://www.youtube.com/watch?v=g7gYh-eryXA
*/
@SpringBootApplication
public class CrudappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudappApplication.class, args);
	}
        @Bean
        public CommandLineRunner commandLineRunner(PersonDAO persondao){
             return runner->{
                    //insertData(persondao);
                    //deleteData(persondao);
                    //getPerson(persondao);
                    //findAllData(persondao);
                    updateData(persondao);
                    
             };   
        }
        public void insertData(PersonDAO persondao){
                  Person p1 = new Person("Fortaelza", "shohomen", "fartocu village romangi road pocatona Island");  
                  persondao.save(p1);
                  System.out.println("Insert Complete : "+p1.toString());
        }
        public void deleteData(PersonDAO persondao){
                  int id = 3;
                  persondao.delete(id);
                  System.out.println("delete Complete  ID = "+id);
        }   
        public void getPerson(PersonDAO persondao){
                  int id = 4;
                  try {
                       Person p1 = persondao.getData(id);
                       System.out.println("getPerson Complete : "+p1.toString());
                  } catch (Exception e) {
                       System.out.println("NODATE : cannot find data -------------");
                  }//end try catch

        }  
        public void findAllData(PersonDAO persondao) {
              List<Person> personList = persondao.findAll();
              for (Person person : personList) {
                   System.out.println(person.toString());  
              }
        }  
        public void updateData(PersonDAO persondao) {
              int id = 4;
              Person p1 = new Person();
                  try {
                       p1 = persondao.getData(id);
                       System.out.println("getPerson Complete : "+p1.toString());
                  } catch (Exception e) {
                       System.out.println("NODATE : cannot find data -------------");
                  }//end try catch         
                  
               p1.setFirstname("William");
               p1.setLastname("Rockyfine");
               persondao.update(p1);
               System.out.println("Update success ==================== ");
        }
}



/*
        @Bean
        public CommandLineRunner commandLineRunner(String[] args){
             return runner->{
                  System.out.println("Hello World :: Spring Boot!! ==== CRUD App");    
                  Person p1 = new Person("Hibiki", "Renahadachi", "45 Goku.rd ponghewa Nord-krai");
                  System.out.println(p1.toString());
                    insertData(persondao);
             };   
        }
*/