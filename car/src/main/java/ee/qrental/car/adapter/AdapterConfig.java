package ee.qrental.car.adapter;

import ee.qrental.car.adapter.out.persistance.mapper.CarMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "ee.qrental.car.adapter")
@EnableJpaRepositories("ee.qrental.car.adapter.out.persistance")
@EntityScan("ee.qrental.car.adapter.out.persistance")
public class AdapterConfig {
}
