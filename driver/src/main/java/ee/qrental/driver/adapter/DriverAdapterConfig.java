package ee.qrental.driver.adapter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "ee.qrental.driver.adapter.*")
@EnableJpaRepositories
@EntityScan("ee.qrental.driver.adapter.out.persistance.jpaentity")
public class DriverAdapterConfig {
}
