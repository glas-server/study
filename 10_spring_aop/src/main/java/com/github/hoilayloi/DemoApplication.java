package com.github.hoilayloi;

import com.github.hoilayloi.domain.User;
import com.github.hoilayloi.filter.CollectionFilter;
import com.github.hoilayloi.filter.StringFilter;
import com.github.hoilayloi.filter.UserFilter;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/*
 *
 * @author halab
 */
@AllArgsConstructor
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private final UserFilter userFilter;
    private final StringFilter stringFilter;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        Collection<String> usernames = Arrays.asList("halab", "huongntt", "sonltt", "truongbb");
        Collection<User> users = Arrays.asList(
                new User("halab", 20),
                new User("huongntt", 27),
                new User("sonltt", 23),
                new User("truongbb", 24)
        );
//        System.out.println("\n\n\nBEGIN");
//        userFilter.filter(users);
//        System.out.println("FINISH\n\n\n");

//        System.out.println("\n\n\nBEGIN");
//        userFilter.filter(null);
//        System.out.println("FINISH\n\n\n");


        System.out.println("\n\n\nBEGIN");
        userFilter.filter(users, user -> user.getAge() > 22);
        stringFilter.filter(usernames);
        stringFilter.filter(usernames, "halab"::equals);
        System.out.println("FINISH\n\n\n");
    }
}
