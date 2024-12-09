package com.teste.projeto.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(
        basePackages = "com.teste.projeto.repository.banco2",  // Pacote do repositório da escola
        entityManagerFactoryRef = "academiaEntityManagerFactory",  // Referência ao EntityManagerFactory da escola
        transactionManagerRef = "academiaTransactionManager"  // Referência ao TransactionManager da escola
)
public class DataSourceConfigBanco2 {

    @Bean(name = "academiaDataSource")
    public DataSource academiaDataSource(@Value("${spring.datasource.academia.url}") String url,
                                         @Value("${spring.datasource.academia.username}") String username,
                                         @Value("${spring.datasource.academia.password}") String password) {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Bean(name = "academiaEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean academiaEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("academiaDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.teste.projeto.model.banco2")  // Certifique-se de que o pacote está correto
                .persistenceUnit("academia")
                .build();
    }

    @Bean(name = "academiaTransactionManager")
    public PlatformTransactionManager academiaTransactionManager(
            @Qualifier("academiaEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
