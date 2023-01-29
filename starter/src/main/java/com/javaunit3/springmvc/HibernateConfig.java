package com.javaunit3.springmvc;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {
    @Bean
    public SessionFactory sessionFactory() {
//        create session factory
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(MovieEntity.class)
                .buildSessionFactory();

    }
}
