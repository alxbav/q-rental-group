package ee.qrental.driver.adapter;

import ee.qrental.driver.adapter.out.persistance.DriverMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "ee.qrental.driver.adapter")
@EnableJpaRepositories("ee.qrental.driver.adapter.out.persistance")
@EntityScan("ee.qrental.driver.adapter.out.persistance")
public class AdapterConfig {

    @Bean
    public DriverMapper getDriverMapper(){
        return new DriverMapper();
    }

/*    @Bean
    public LoadDriverPotentialPort getLoadDriverPotentialPort(
            DriverPotentialMapper mapper,
            SpringDataDriverPotentialRepository springDataDriverPotentialRepository
    ){
        return new DriverPotentialPersistenceAdapter(springDataDriverPotentialRepository, mapper);
    }*/



}
