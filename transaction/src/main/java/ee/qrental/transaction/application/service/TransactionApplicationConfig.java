package ee.qrental.transaction.application.service;

import ee.qrental.transaction.application.port.out.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionApplicationConfig {

    @Bean
    public TransactionService getTransactionService(
            final TransactionAddPort transactionAddPort,
            final TransactionUpdatePort transactionUpdatePort,
            final TransactionLoadPort transactionLoadPort,
            final TransactionDeletePort transactionDeletePort,
            final TransactionTypeLoadPort transactionTypeLoadPort) {
        return new TransactionService(
                transactionAddPort,
                transactionUpdatePort,
                transactionLoadPort,
                transactionDeletePort,
                transactionTypeLoadPort);
    }

    @Bean
    public TransactionTypeService getTransactionTypeService(
            final TransactionTypeAddPort transactionTypeAddPort,
            final TransactionTypeUpdatePort transactionTypeUpdatePort,
            final TransactionTypeLoadPort transactionTypeLoadPort,
            final TransactionTypeDeletePort transactionTypeDeletePort) {
        return new TransactionTypeService(transactionTypeAddPort,
                transactionTypeUpdatePort,
                transactionTypeLoadPort,
                transactionTypeDeletePort);
    }
}
