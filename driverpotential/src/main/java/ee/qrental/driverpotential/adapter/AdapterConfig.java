package ee.qrental.driverpotential.adapter;

import ee.qrental.driverpotential.adapter.out.persistance.DriverPotentialMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "ee.qrental.driverpotential.adapter")
@EnableJpaRepositories("ee.qrental.driverpotential.adapter.out.persistance")
@EntityScan("ee.qrental.driverpotential.adapter.out.persistance")
public class AdapterConfig {

    @Bean
    public DriverPotentialMapper getDriverPotentialMapper(){
        return new DriverPotentialMapper();
    }

/*    @Bean
    public LoadDriverPotentialPort getLoadDriverPotentialPort(
            DriverPotentialMapper mapper,
            SpringDataDriverPotentialRepository springDataDriverPotentialRepository
    ){
        return new DriverPotentialPersistenceAdapter(springDataDriverPotentialRepository, mapper);
    }*/



}
