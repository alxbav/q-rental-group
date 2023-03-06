package ee.qrental.job.application.service;

import ee.qrental.job.application.port.in.mapper.JobResponseMapper;
import ee.qrental.job.application.port.in.mapper.JobUpdateRequestMapper;
import ee.qrental.job.application.port.in.query.GetJobQuery;
import ee.qrental.job.application.port.in.request.JobUpdateRequest;
import ee.qrental.job.application.port.in.response.JobResponse;
import ee.qrental.job.application.port.out.JobLoadPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class JobQueryService implements GetJobQuery {

    private JobLoadPort loadPort;
    private JobResponseMapper mapper;

    private JobUpdateRequestMapper updateRequestMapper;

    @Override
    public List<JobResponse> getAll() {
        return loadPort.loadAll()
                .stream()
                .map(mapper::toResponse)
                .collect(toList());
    }

    @Override
    public JobResponse getById(Long id) {
        return mapper.toResponse(loadPort.loadById(id));
    }

    @Override
    public String getObjectInfo(Long id) {
        return mapper.toObjectInfo(loadPort.loadById(id));
    }

    @Override
    public JobUpdateRequest getUpdateRequestById(Long id) {
        return updateRequestMapper.toRequest(loadPort.loadById(id));
    }
}
