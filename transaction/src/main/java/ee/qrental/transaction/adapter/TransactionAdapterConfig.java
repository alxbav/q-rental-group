package ee.qrental.transaction.adapter;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ee.qrental.transaction.adapter.out.persistance.TransactionMapper;

@ComponentScan(basePackages = "ee.qrental.link.adapter")
@EnableJpaRepositories("ee.qrental.link.adapter.out.persistance")
@EntityScan("ee.qrental.transaction.adapter.out.persistance")
public class TransactionAdapterConfig {

    @Bean
    public TransactionMapper getTransactionMapper(){
        return new TransactionMapper();
    }

}
