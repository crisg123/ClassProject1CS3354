package com.example.projecttwo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(DataStructureRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new DataStructure("test1", (float)1.1, (float)5.0, (float)7.3, (float)12.1, (float)2.1, (float)11.0)));
            log.info("Preloading " + repository.save(new DataStructure("test2", (float)1.1, (float)5.0, (float)7.3, (float)12.1, (float)2.1, (float)11.0)));
        };
    }
}