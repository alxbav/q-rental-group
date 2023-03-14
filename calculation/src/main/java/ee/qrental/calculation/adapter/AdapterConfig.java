package ee.qrental.calculation.adapter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "ee.qrental.calculation.adapter.*")
@EnableJpaRepositories("ee.qrental.calculation.adapter.out.persistance")
@EntityScan("ee.qrental.calculation.adapter.out.persistance.jpaentity")
public class AdapterConfig {
}
