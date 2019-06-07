package com.yosra.bibliophiles.bootstrap;
import com.yosra.bibliophiles.Repository.CommentRepository;
import com.yosra.bibliophiles.Repository.LinkRepository;
import com.yosra.bibliophiles.domain.Link;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private LinkRepository linkRepository;
    private CommentRepository commentRepository;


    public DatabaseLoader(LinkRepository linkRepository, CommentRepository commentRepository) {
        this.linkRepository = linkRepository;
        this.commentRepository = commentRepository;
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


//        Link l = new Link("l Alchimiste", "Philosophie", "Paulo Coelho", "https://www.jeejava.com/file-download-example-using-spring-rest-controller/");
//        linkRepository.save(l);
//
//
//        long linkCount = linkRepository.count();
//        System.out.println("Number of links in the database: " + linkCount);
    }

}






