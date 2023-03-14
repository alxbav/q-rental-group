package ee.qrental.transaction.adapter.out.persistance;

import ee.qrental.transaction.adapter.out.persistance.mapper.ConstantMapper;
import ee.qrental.transaction.adapter.out.persistance.repostories.SpringDataConstantRepository;
import ee.qrental.transaction.application.port.out.ConstantAddPort;
import ee.qrental.transaction.application.port.out.ConstantDeletePort;
import ee.qrental.transaction.application.port.out.ConstantLoadPort;
import ee.qrental.transaction.application.port.out.ConstantUpdatePort;
import ee.qrental.transaction.domain.Constant;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component

@AllArgsConstructor
public class ConstantPersistenceAdapterLoadAddUpdateDelete
        implements ConstantLoadPort,
        ConstantAddPort,
        ConstantUpdatePort,
        ConstantDeletePort {

    private final SpringDataConstantRepository springDataConstantRepository;
    private final ConstantMapper constantMapper;

    @Override
    public List<Constant> loadAllConstants() {
        return springDataConstantRepository.findAll()
                .stream()
                .map(constantMapper::mapToDomain)
                .collect(toList());
    }

    @Override
    public Constant loadConstantById(Long id) {
        return constantMapper.mapToDomain(
                springDataConstantRepository.getReferenceById(id));
    }

    @Override
    public Constant loadConstantByName(final String name) {
        return constantMapper.mapToDomain(
                springDataConstantRepository.findByName(name));
    }

    @Override
    public Constant addConstant(final Constant constant) {
        return constantMapper.mapToDomain(
                springDataConstantRepository.save(
                        constantMapper.mapToEntity(constant)
                ));
    }

    @Override
    public Constant updateConstant(final Constant constant) {
        return constantMapper.mapToDomain(
                springDataConstantRepository.save(
                        constantMapper.mapToEntity(constant)
                ));
    }

    @Override
    public void deleteConstant(Long id) {
        springDataConstantRepository.deleteById(id);
    }
}
