package ee.qrental.driver.adapter;

import ee.qrental.driver.adapter.out.persistance.CallSignLinkMapper;
import ee.qrental.driver.adapter.out.persistance.DriverMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "ee.qrental.driver.adapter")
@EnableJpaRepositories("ee.qrental.driver.adapter.out.persistance")
@EntityScan("ee.qrental.driver.adapter.out.persistance")
public class DriverAdapterConfig {

    @Bean
    public DriverMapper getDriverMapper(){
        return new DriverMapper();
    }


    @Bean
    public CallSignLinkMapper getCallSignLinkMapper(){
        return new CallSignLinkMapper();
    }
}
