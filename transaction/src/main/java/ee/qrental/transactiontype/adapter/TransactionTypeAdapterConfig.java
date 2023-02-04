package ee.qrental.transactiontype.adapter;

import ee.qrental.transactiontype.adapter.out.persistance.TransactionTypeMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "ee.qrental.transactiontype.adapter")
@EnableJpaRepositories("ee.qrental.transactiontype.adapter.out.persistance")
@EntityScan("ee.qrental.transactiontype.adapter.out.persistance")
public class TransactionTypeAdapterConfig {

    @Bean
    public TransactionTypeMapper getTransactionTypeMapper(){
        return new TransactionTypeMapper();
    }

}
