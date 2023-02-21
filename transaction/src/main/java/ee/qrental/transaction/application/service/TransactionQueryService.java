package ee.qrental.transaction.application.service;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.transaction.application.port.in.query.GetTransactionQuery;
import ee.qrental.transaction.application.port.in.request.transaction.TransactionWeekFilterRequest;
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
import static java.time.temporal.TemporalAdjusters.previousOrSame;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
class TransactionQueryService implements GetTransactionQuery {

    private final TransactionLoadPort transactionLoadPort;
    private final ResponseMapper<TransactionUpdateRequest, TransactionResponse, Transaction> mapper;

    @Override
    public List<TransactionResponse> getAll() {
        return transactionLoadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
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
        return transactionLoadPort.loadAllByDriverId(driverId)
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public List<TransactionResponse> getAllByRequest(
            final TransactionWeekFilterRequest request) {
        final var year = request.getYear();
        final var weekNumber = request.getWeek().getNumber();

        final var startWeekDay = getDayByYearAndWeekNumberAndDayOfWeek(year, weekNumber, MONDAY);
        final var endWeekDay = getDayByYearAndWeekNumberAndDayOfWeek(year, weekNumber, SUNDAY);

        return transactionLoadPort.loadAllBetweenDays(startWeekDay, endWeekDay)
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public TransactionUpdateRequest getUpdateRequestById(Long id) {
        return mapper.toUpdateRequest(transactionLoadPort.loadById(id));

    }

    private LocalDate getDayByYearAndWeekNumberAndDayOfWeek(
            final Integer year,
            final Integer weekNumber,
            final DayOfWeek dayOfWeek) {
        return LocalDate.of(year, JUNE, 1)
                .with(previousOrSame(dayOfWeek))
                .with(WEEK_OF_WEEK_BASED_YEAR, weekNumber);
    }
}
