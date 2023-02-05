package ee.qrental.transaction.application.service;

import ee.qrental.transaction.application.port.out.TransactionDeletePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ee.qrental.transaction.application.port.out.TransactionAddPort;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.application.port.out.TransactionUpdatePort;

@Configuration
public class TransactionApplicationConfig {

    @Bean
    public TransactionService getTransactionTypeService(
            final TransactionAddPort transactionTypeAddPort,
            final TransactionUpdatePort transactionTypeUpdatePort,
            final TransactionLoadPort transactionTypeLoadPort,
            final TransactionDeletePort transactionTypeDeletePort){
        return new TransactionService(transactionTypeAddPort,
                transactionTypeUpdatePort,
                transactionTypeLoadPort,
                transactionTypeDeletePort);
    }
}
