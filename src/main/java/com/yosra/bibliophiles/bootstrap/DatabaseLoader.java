package com.yosra.bibliophiles.bootstrap;
import com.yosra.bibliophiles.Repository.CommentRepository;
import com.yosra.bibliophiles.Repository.LinkRepository;
import com.yosra.bibliophiles.Repository.RoleRepository;
import com.yosra.bibliophiles.Repository.UserRepository;
import com.yosra.bibliophiles.domain.Link;
import com.yosra.bibliophiles.domain.Role;
import com.yosra.bibliophiles.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private LinkRepository linkRepository;
    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;


    public DatabaseLoader(LinkRepository linkRepository, CommentRepository commentRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.linkRepository = linkRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {

//
//        Map<String, List<Link>> links = new HashMap<>();
//
//        List<Link> link = new ArrayList<>();
//        link.add(new Link("Alchimiste", "Philosophie", "Paulo Coelho", "https://www.jeejava.com/file-download-example-using-spring-rest-controller/"));
//        link.add(new Link("java", "computer science", "Yosra Riabi", "https://www.jeejava.com/file-download-example-using-spring-rest-controller/"));
//        links.put("string", link);
//
//        System.out.println("******************");
//        System.out.println(links);
//
//
//        links.forEach((k,Link) -> {
//            linkRepository.save(new Link());
//// we will do something with comments later
//        });
//        long linkCount = linkRepository.count();
//        System.out.println("Number of links in the database: " + linkCount );
//                }

      //  add users & roles
        addUsersAndRoles();
        Link l = new Link("l Alchimiste", "Philosophie", "Paulo Coelho", "https://www.jeejava.com/file-download-example-using-spring-rest-controller/");
        linkRepository.save(l);


        long linkCount = linkRepository.count();
        System.out.println("Number of links in the database: " + linkCount);
    }

    private void addUsersAndRoles() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String secret = "{bcrypt}" + encoder.encode("password");
        Role userRole = new Role("ROLE_USER");
        roleRepository.save(userRole);
        Role adminRole = new Role("ROLE_ADMIN");
        roleRepository.save(adminRole);
        User user = new User("user@gmail.com",secret,true);
        user.addRole(userRole);
        userRepository.save(user);
        User admin = new User("admin@gmail.com",secret,true);
        admin.addRole(adminRole);
        userRepository.save(admin);
        User master = new User("super@gmail.com",secret,true);
        master.addRoles(new HashSet<>(Arrays.asList(userRole,adminRole)));
        userRepository.save(master);
        System.out.println("users");
    }

}






