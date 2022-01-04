package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

//import static jdk.internal.org.jline.utils.InfoCmp.Capability.*;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      /*userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
*/
      userService.add(new User("Tirion", "Lannister", "halfman@gmail.com", new Car("Audi", 8)));
      userService.add(new User("John", "Snow", "bastard@gmail.com", new Car("Toyota", 15)));
      userService.add(new User("Sercei", "Lannister", "slut@gmail.com", new Car("Mercedes", 21)));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }




      User new_user = userService.getUserByCar("Audi", 8);
      System.out.println("Id = "+new_user.getId());
      System.out.println("First Name = "+new_user.getFirstName());
      System.out.println("Last Name = "+new_user.getLastName());
      System.out.println("Email = "+new_user.getEmail());
      System.out.println();

      context.close();
   }
}
