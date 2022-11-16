package ro.esolacad.msge.storeservice;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.annotation.PreDestroy;
import javax.sql.DataSource;
import java.io.IOException;
import java.time.Duration;

@Configuration
public class EmbeddedPostgreSQLConfiguration {
    private PostgreSQLContainer postgresqlContainer;
    private DataSource dataSource;

    @Bean(destroyMethod = "stop", name = "postgresProcess")
    public PostgreSQLContainer postgresProcess() throws IOException {
        postgresqlContainer =
                (PostgreSQLContainer) new PostgreSQLContainer("postgres:12")
                        .withDatabaseName("java_spring")
                        .withUsername("postgres")
                        .withPassword("postgres")
                        .withStartupTimeout(Duration.ofSeconds(600));
        postgresqlContainer.start();
        return postgresqlContainer;
    }

    @Bean
    @DependsOn("postgresProcess")
    @Primary
    public DataSource datasource() {
        dataSource = DataSourceBuilder
                .create()
                .username("postgres")
                .password("postgres")
                .url(postgresqlContainer.getJdbcUrl())
                .driverClassName("org.postgresql.Driver")
                .build();

        return dataSource;
    }

    @PreDestroy
    public void preDestroy() {
        postgresqlContainer.stop();
    }
}
