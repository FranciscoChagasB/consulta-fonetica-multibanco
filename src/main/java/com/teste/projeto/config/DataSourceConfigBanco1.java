package com.teste.projeto.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.teste.projeto.repository.banco1",  // Pacote do repositório da escola
        entityManagerFactoryRef = "escolaEntityManagerFactory",  // Referência ao EntityManagerFactory da escola
        transactionManagerRef = "escolaTransactionManager"  // Referência ao TransactionManager da escola
)
public class DataSourceConfigBanco1 {

    @Bean(name = "escolaDataSource")
    @Primary
    public DataSource escolaDataSource(@Value("${spring.datasource.escola.url}") String url,
                                       @Value("${spring.datasource.escola.username}") String username,
                                       @Value("${spring.datasource.escola.password}") String password) {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Bean(name = "escolaEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean escolaEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("escolaDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.teste.projeto.model.banco1")  // Pacote onde as entidades da escola estão
                .persistenceUnit("escola")
                .build();
    }

    @Bean(name = "escolaTransactionManager")
    @Primary
    public JpaTransactionManager escolaTransactionManager(
            @Qualifier("academiaEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
