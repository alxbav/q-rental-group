package ee.qrental.link.application.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ee.qrental.link.application.port.out.TransactionDeletePort;
import ee.qrental.link.application.port.out.TransactionAddPort;
import ee.qrental.link.application.port.out.TransactionLoadPort;
import ee.qrental.link.application.port.out.TransactionUpdatePort;

@Configuration
public class TransactionApplicationConfig {

    @Bean
    public TransactionService getTransactionService(
            final TransactionAddPort transactionAddPort,
            final TransactionUpdatePort transactionUpdatePort,
            final TransactionLoadPort transactionLoadPort,
            final TransactionDeletePort transactionDeletePort){
        return new TransactionService(transactionAddPort,
                transactionUpdatePort,
                transactionLoadPort,
                transactionDeletePort);
    }
}
