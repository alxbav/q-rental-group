package ee.qrental.transaction.application.service;

import ee.qrental.common.core.api.mapper.ResponseMapper;
import ee.qrental.transaction.application.port.in.query.GetFirmQuery;
import ee.qrental.transaction.application.port.in.request.firm.FirmUpdateRequest;
import ee.qrental.transaction.application.port.in.response.firm.FirmResponse;
import ee.qrental.transaction.application.port.out.FirmLoadPort;
import ee.qrental.transaction.domain.Firm;
import lombok.AllArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;

@AllArgsConstructor
class FirmQueryService implements GetFirmQuery {

    private final FirmLoadPort firmLoadPort;
    private final ResponseMapper<FirmUpdateRequest, FirmResponse, Firm> mapper;

    @Override
    public List<FirmResponse> getAll() {
        return firmLoadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public FirmResponse getById(final Long id) {
        return mapper.toResponse(firmLoadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(Long id) {
        return mapper.toObjectInfo(firmLoadPort.loadById(id));
    }

    @Override
    public FirmUpdateRequest getUpdateRequestById(Long id) {
        return mapper.toUpdateRequest(firmLoadPort.loadById(id));
    }


}