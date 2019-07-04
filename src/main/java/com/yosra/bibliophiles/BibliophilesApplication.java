package com.yosra.bibliophiles;

import org.ocpsoft.prettytime.PrettyTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;


@SpringBootApplication
//@EnableJpaAuditing
@EnableTransactionManagement
public class BibliophilesApplication {

    private static final Logger log = LoggerFactory.getLogger(BibliophilesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BibliophilesApplication.class, args);
    }

    @Bean
    PrettyTime prettyTime(){
        return new PrettyTime();
    }


    // TODO * Configuring this bean should not be needed once Spring Boot's Thymeleaf starter includes configuration
// TODO for thymeleaf-extras-springsecurity5 (instead of thymeleaf-extrasspringsecurity4)
    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

}
