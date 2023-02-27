package ee.qrental.link.adapter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "ee.qrental.link.adapter.*")
@EnableJpaRepositories("ee.qrental.link.adapter.out.persistance")
@EntityScan("ee.qrental.link.adapter.out.persistance")
public class LinkAdapterConfig {
}
