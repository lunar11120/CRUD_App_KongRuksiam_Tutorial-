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
                    findAllData(persondao);
                    //updateData(persondao);
                    
             };   
        }
        public void insertData(PersonDAO persondao){
                  Person p1 = new Person("Reiden3333", "Ei33", "Shiroku village 567-25 Inazuma Island");  
                  persondao.save(p1);
                  System.out.println("Insert Complete : "+p1.toString());
        }
        public void deleteData(PersonDAO persondao){
                  int id = 7;
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

              //show data list person
              System.out.println("");
              System.out.println("list person ===========================================");
              for (Person person : personList) {
                   System.out.println(person.toString());  
              }
              System.out.println("");
        }  
        public void updateData(PersonDAO persondao) {
              int id = 8;
              Person p1 = new Person();
                  try {
                       p1 = persondao.getData(id);
                       System.out.println("getPerson Complete : "+p1.toString());
                  } catch (Exception e) {
                       System.out.println("NODATE : cannot find data -------------");
                  }//end try catch         
                  
               p1.setFirstname("Isomu");
               p1.setLastname("maminoya");
               p1.setAddress("DS125 sura city - Bankalatash");
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