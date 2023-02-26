package ee.qrental.transaction.application.service;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.transaction.application.port.in.query.GetTransactionQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionFilterRequest;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionUpdateRequest;
import ee.qrental.transaction.application.port.in.response.transaction.TransactionResponse;
import ee.qrental.transaction.application.port.out.TransactionLoadPort;
import ee.qrental.transaction.domain.Transaction;
import lombok.AllArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.Month.JUNE;
import static java.time.temporal.IsoFields.WEEK_OF_WEEK_BASED_YEAR;
import static java.time.temporal.TemporalAdjusters.*;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
class TransactionQueryService implements GetTransactionQuery {

    private final TransactionLoadPort transactionLoadPort;
    private final ResponseMapper<TransactionUpdateRequest, TransactionResponse, Transaction> mapper;

    @Override
    public List<TransactionResponse> getAll() {
        return mapToTransactionResponseList(transactionLoadPort.loadAll());
    }

    @Override
    public TransactionResponse getById(final Long id) {
        return mapper.toResponse(transactionLoadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(final Long id) {
        return mapper.toObjectInfo(transactionLoadPort.loadById(id));
    }

    @Override
    public List<TransactionResponse> getAllByDriverId(final Long driverId) {
        return mapToTransactionResponseList(
                transactionLoadPort.loadAllByDriverId(driverId));
    }

    @Override
    public List<TransactionResponse> getAllByFilterRequest(
            final TransactionFilterRequest request) {
        final var startDay = getStartDate(request);
        final var endDay = getEndDate(request);
        final var driverId = request.getDriverId();
        if (driverId == null) {
            return mapToTransactionResponseList(
                    transactionLoadPort.loadAllBetweenDays(startDay, endDay));
        }
        return mapToTransactionResponseList(
                transactionLoadPort.loadAllByDriverIdAndBetweenDays(driverId, startDay, endDay));
    }


    private LocalDate getStartDate(TransactionFilterRequest request) {
        final var year = request.getYear();
        final var weekNumber = request.getWeek().getNumber();
        if (weekNumber == 0) {
            return getFirstDayInYear(year);
        }

        return getDayByYearAndWeekNumberAndDayOfWeek(year, weekNumber, MONDAY);
    }

    private LocalDate getEndDate(TransactionFilterRequest request) {
        final var year = request.getYear();
        final var weekNumber = request.getWeek().getNumber();
        if (weekNumber == 0) {
            return getLastDayInYear(year);
        }

        return getDayByYearAndWeekNumberAndDayOfWeek(year, weekNumber, SUNDAY);
    }


    @Override
    public TransactionUpdateRequest getUpdateRequestById(Long id) {
        return mapper.toUpdateRequest(transactionLoadPort.loadById(id));
    }

    private LocalDate getFirstDayInYear(final Integer year) {
        return LocalDate.of(year, 1, 1).with(firstDayOfYear());
    }

    private LocalDate getLastDayInYear(final Integer year) {
        return LocalDate.of(year, 1, 1).with(lastDayOfYear());
    }

    private LocalDate getDayByYearAndWeekNumberAndDayOfWeek(
            final Integer year,
            final Integer weekNumber,
            final DayOfWeek dayOfWeek) {
        return LocalDate.of(year, JUNE, 1)
                .with(previousOrSame(dayOfWeek))
                .with(WEEK_OF_WEEK_BASED_YEAR, weekNumber);
    }

    private List<TransactionResponse> mapToTransactionResponseList(final List<Transaction> transactions) {
        return transactions.stream()
                .map(mapper::toResponse)
                .sorted(comparing(TransactionResponse::getDate))
                .collect(toList());
    }
}
