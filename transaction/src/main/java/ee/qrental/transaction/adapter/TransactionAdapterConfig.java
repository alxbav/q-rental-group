package ee.qrental.transaction.adapter;

import ee.qrental.transaction.adapter.out.persistance.mapper.TransactionTypeMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ee.qrental.transaction.adapter.out.persistance.mapper.TransactionMapper;

@ComponentScan(basePackages = "ee.qrental.transaction.adapter")
@EnableJpaRepositories
@EntityScan("ee.qrental.transaction.adapter.out.persistance.jpaentity")
public class TransactionAdapterConfig {

    @Bean
    public TransactionMapper getTransactionMapper(){
        return new TransactionMapper();
    }

    @Bean
    public TransactionTypeMapper getTransactionTypeMapper(){
        return new TransactionTypeMapper();
    }

}
