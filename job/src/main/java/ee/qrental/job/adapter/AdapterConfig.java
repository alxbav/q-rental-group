package ee.qrental.job.adapter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "ee.qrental.job.adapter.*")
@EnableJpaRepositories("ee.qrental.job.adapter.out.persistance")
@EntityScan("ee.qrental.job.adapter.out.persistance")
public class AdapterConfig {
}
