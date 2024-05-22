package ru.ntrubkin.multi.datasources.demo.first.module;

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
        entityManagerFactoryRef = "firstEntityManagerFactory",
        transactionManagerRef = "firstTransactionManager"
)
public class FirstConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.first")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource firstDataSource() {
        return firstDataSourceProperties()
                .initializeDataSourceBuilder()
                .build();
    }

    @Bean
    public EntityManagerFactoryBuilder firstEntityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(
                new HibernateJpaVendorAdapter(),
                Map.of("hibernate.hbm2ddl.auto", "create"),
                null
        );
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(
            @Qualifier("firstDataSource") DataSource dataSource,
            @Qualifier("firstEntityManagerFactoryBuilder") EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(dataSource)
                .packages("ru.ntrubkin.multi.datasources.demo.first.module")
                .build();
    }

    @Bean
    public PlatformTransactionManager firstTransactionManager(
            @Qualifier("firstEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactory.getObject()));
    }
}
