package ee.qrental.transaction.application.service;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.driver.application.port.out.DriverLoadPort;
import ee.qrental.transaction.application.port.in.mapper.FirmResponseMapper;
import ee.qrental.transaction.application.port.in.mapper.TransactionResponseMapper;
import ee.qrental.transaction.application.port.in.mapper.TransactionTypeResponseMapper;
import ee.qrental.transaction.application.port.in.request.firm.FirmUpdateRequest;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionTypeUpdateRequest;
import ee.qrental.transaction.application.port.in.request.transactiontype.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.response.firm.FirmResponse;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import ee.qrental.transaction.application.port.in.response.transactiontype.TransactionTypeResponse;
import ee.qrental.transaction.application.port.out.*;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.domain.Firm;
import ee.qrental.transaction.domain.Transaction;
import ee.qrental.transaction.domain.TransactionType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionApplicationConfig {

    @Bean
    public TransactionUseCaseService getTransactionService(
            final TransactionAddPort transactionAddPort,
            final TransactionUpdatePort transactionUpdatePort,
            final TransactionLoadPort transactionLoadPort,
            final TransactionDeletePort transactionDeletePort,
            final TransactionTypeLoadPort transactionTypeLoadPort,
            final DriverLoadPort driverLoadPort) {
        return new TransactionUseCaseService(
                transactionAddPort,
                transactionUpdatePort,
                transactionLoadPort,
                transactionDeletePort,
                transactionTypeLoadPort,
                driverLoadPort);
    }

    @Bean
    public TransactionTypeUseCaseService getTransactionTypeService(
            final TransactionTypeAddPort transactionTypeAddPort,
            final TransactionTypeUpdatePort transactionTypeUpdatePort,
            final TransactionTypeLoadPort transactionTypeLoadPort,
            final TransactionTypeDeletePort transactionTypeDeletePort) {
        return new TransactionTypeUseCaseService(transactionTypeAddPort,
                transactionTypeUpdatePort,
                transactionTypeLoadPort,
                transactionTypeDeletePort);
    }

    @Bean ConstantService getConstantService (
            final ConstantAddPort constantAddPort,
            final ConstantUpdatePort constantUpdatePort,
            final ConstantLoadPort constantLoadPort,
            final  ConstantDeletePort constantDeletePort) {
     return  new ConstantService( constantAddPort,
             constantUpdatePort,
             constantLoadPort,
             constantDeletePort);
    }


    @Bean FirmUseCaseService getFirmService (
            final FirmAddPort firmAddPort,
            final FirmUpdatePort firmUpdatePort,
            final FirmLoadPort firmLoadPort,
            final FirmDeletePort firmDeletePort) {
        return new FirmUseCaseService( firmAddPort,
                firmUpdatePort,
                firmLoadPort,
                firmDeletePort);
    }




    @Bean
    public ResponseMapper<TransactionUpdateRequest, TransactionResponse, Transaction> getTransactionResponseMapper(
            DriverLoadPort driverLoadPort){
        return new TransactionResponseMapper(driverLoadPort);
    }

    @Bean
    public TransactionQueryService getTransactionQueryService(
            TransactionLoadPort transactionLoadPort,
            ResponseMapper<TransactionUpdateRequest, TransactionResponse, Transaction> mapper){
        return new TransactionQueryService(transactionLoadPort, mapper);
    }

    @Bean
    public ResponseMapper<TransactionTypeUpdateRequest, TransactionTypeResponse, TransactionType> getTransactionTypeResponseMapper(){
        return new TransactionTypeResponseMapper();
    }

    @Bean
    public TransactionTypeQueryService getTransactionTypeQueryService(
            TransactionTypeLoadPort transactionTypeLoadPort,
            ResponseMapper<TransactionTypeUpdateRequest, TransactionTypeResponse, TransactionType> mapper){
        return new TransactionTypeQueryService(transactionTypeLoadPort, mapper);
    }

    @Bean
    public ResponseMapper<FirmUpdateRequest, FirmResponse, Firm> getFirmResponseMapper(){
        return new FirmResponseMapper();
    }

    @Bean
    public FirmQueryService getFirmQueryService(
            FirmLoadPort firmLoadPort,
            ResponseMapper<FirmUpdateRequest, FirmResponse, Firm> mapper){
        return new FirmQueryService(firmLoadPort, mapper);
    }




}
