package ee.qrental.transaction.adapter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "ee.qrental.transaction.adapter.*")
@EnableJpaRepositories
@EntityScan("ee.qrental.transaction.adapter.out.persistance.jpaentity")
public class AdapterConfig {
}