package ee.qrental.callsignlink.adapter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages = "ee.qrental.callsignlink.adapter.*")
@EnableJpaRepositories("ee.qrental.callsignlink.adapter.out.persistance.repository")
@EntityScan("ee.qrental.callsignlink.adapter.out.persistance.jpaentity")
public class AdapterConfig {
}
