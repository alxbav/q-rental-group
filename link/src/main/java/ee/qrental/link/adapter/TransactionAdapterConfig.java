package ee.qrental.link.adapter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ee.qrental.link.adapter.out.persistance.LinkMapper;

@ComponentScan(basePackages = "ee.qrental.link.adapter")
@EnableJpaRepositories("ee.qrental.link.adapter.out.persistance")
@EntityScan("ee.qrental.transaction.adapter.out.persistance")
public class TransactionAdapterConfig {

    @Bean
    public LinkMapper getTransactionMapper(){
        return new LinkMapper();
    }

}
