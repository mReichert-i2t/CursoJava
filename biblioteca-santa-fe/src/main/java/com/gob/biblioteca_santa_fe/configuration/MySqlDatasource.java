package com.gob.biblioteca_santa_fe.configuration;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//@Configuration
//@EnableTransactionManagement
/*@EnableJpaRepositories(entityManagerFactoryRef = "mySqlEntityManager", transactionManagerRef = "mySqlTransactionManager",
        basePackages = {"com.gob.biblioteca_sata_fe.repository"})*/
public class MySqlDatasource {

    /*@Value("${mysql.jpa.properties.hibernate.dialect}")
    String dialect;

    @Bean(name = "mySqlDatasource")
    @ConfigurationProperties("mysql.datasource") //prefijo del jndi-name en el properties
    public DataSource dataSource() { return DataSourceBuilder.create().build();}

    @Bean(name = "mySqlEntityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            @Qualifier("mySqlDatasource") DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.gob.biblioteca_santa_fe.model");
        HibernateJpaVendorAdapter vendorAdapter= new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setPersistenceUnitName("ps-mysql");
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jpa.dialect", dialect);
        factoryBean.setJpaPropertyMap(properties);
        return factoryBean;
        }

        @Bean(name = "mySqlTransactionManager")
        public org.springframework.transaction.PlatformTransactionManager transactionManager(
                @Qualifier("mySqlEntityManager") EntityManagerFactory entityManagerFactory) {

            return new JpaTransactionManager(entityManagerFactory);
        }

        @Bean(name = "mySqlJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("mySqlDatasource") DataSource dataSource){

        return new NamedParameterJdbcTemplate(dataSource);
    }*/
}
