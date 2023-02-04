package ee.qrental.transactiontype.application.service;

import ee.qrental.transactiontype.application.port.out.TransactionTypeAddPort;
import ee.qrental.transactiontype.application.port.out.TransactionTypeDeletePort;
import ee.qrental.transactiontype.application.port.out.TransactionTypeLoadPort;
import ee.qrental.transactiontype.application.port.out.TransactionTypeUpdatePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionTypeApplicationConfig {

    @Bean
    public TransactionTypeService getTransactionTypeService(
            final TransactionTypeAddPort transactionTypeAddPort,
            final TransactionTypeUpdatePort transactionTypeUpdatePort,
            final TransactionTypeLoadPort transactionTypeLoadPort,
            final TransactionTypeDeletePort transactionTypeDeletePort){
        return new TransactionTypeService(transactionTypeAddPort,
                transactionTypeUpdatePort,
                transactionTypeLoadPort,
                transactionTypeDeletePort);
    }
}
