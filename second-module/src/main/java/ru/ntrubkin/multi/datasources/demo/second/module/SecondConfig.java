package ru.ntrubkin.multi.datasources.demo.second.module;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondEntityManagerFactory",
        transactionManagerRef = "secondTransactionManager"
)
public class SecondConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.second")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource secondDataSource() {
        return secondDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public EntityManagerFactoryBuilder secondEntityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(
                new HibernateJpaVendorAdapter(),
                Map.of("hibernate.hbm2ddl.auto", "create"),
                null
        );

    }

    @Bean
    public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory(
            @Qualifier("secondDataSource") DataSource dataSource,
            @Qualifier("secondEntityManagerFactoryBuilder") EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("ru.ntrubkin.multi.datasources.demo.second.module")
                .build();
    }

    @Bean
    public PlatformTransactionManager secondTransactionManager(
            @Qualifier("secondEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory.getObject()));
    }
}
