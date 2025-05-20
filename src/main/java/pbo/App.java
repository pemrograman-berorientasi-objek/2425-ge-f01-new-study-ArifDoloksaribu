package pbo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;
import pbo.driver.*;

/*
 12S23004 - Poppy Sibuea
 12S23026 - Arif M. Doloksaribu
 */

/**
 * Main class
 *
 */
public class App {

  //assigmnet untuk EntityManajer dan ManajerFactory
  private static EntityManagerFactory factory;
  private static EntityManager entityManager;
  public static void main(String[] args) {
    // your codes
    // code untuk membuat factory dan entityManajer
    factory = Persistence.createEntityManagerFactory("study_plan_pu");
    entityManager = factory.createEntityManager();

    Driver driv = new Driver(entityManager);
    driv.deletetable();

    Scanner sc = new Scanner(System.in);
    while(true){
      String input = sc.nextLine();
      if(input.equals("---")){
        break;
      }
      else{
        String data[] = input.split("#");
        switch (data[0]) {
          case "student-add":
            driv.addStudent(data);
            break;

          case "student-show-all":
            driv.studentall();
            break;

          case "course-add":
            driv.addCourse(data);
            break;

          case "course-show-all":
            driv.courseall();
            break;
          
          case "enroll":
            driv.enroll(data);
            break;

          case "student-show":
            driv.show(data);
            break;
          default:
            break;
        }
      }
    }
    sc.close();
  }
}
