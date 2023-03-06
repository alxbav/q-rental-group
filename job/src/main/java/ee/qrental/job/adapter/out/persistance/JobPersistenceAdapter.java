package ee.qrental.job.adapter.out.persistance;

import ee.qrental.job.adapter.out.persistance.mapper.JobMapper;
import ee.qrental.job.adapter.out.persistance.repository.SpringDataJobRepository;
import ee.qrental.job.application.port.out.JobAddPort;
import ee.qrental.job.application.port.out.JobDeletePort;
import ee.qrental.job.application.port.out.JobLoadPort;
import ee.qrental.job.application.port.out.JobUpdatePort;
import ee.qrental.job.domain.Job;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@AllArgsConstructor
public class JobPersistenceAdapter
        implements JobLoadPort,
        JobAddPort,
        JobUpdatePort,
        JobDeletePort {

    private final SpringDataJobRepository springDataJobRepository;
    private final JobMapper linkMapper;

    @Override
    public List<Job> loadAll() {
        return springDataJobRepository.findAll()
                .stream()
                .map(linkMapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public Job loadById(Long id) {
        return linkMapper.mapToDomain(
                springDataJobRepository.getReferenceById(id));
    }

    @Override
    public Job add(final Job domain) {
        return linkMapper.mapToDomain(
                springDataJobRepository.save(
                        linkMapper.mapToEntity(domain)
                ));
    }

    @Override
    public Job update(final Job domain) {
        return linkMapper.mapToDomain(
                springDataJobRepository.save(
                        linkMapper.mapToEntity(domain)
                ));
    }

    @Override
    public void delete(Long id) {
        springDataJobRepository.deleteById(id);
    }
}