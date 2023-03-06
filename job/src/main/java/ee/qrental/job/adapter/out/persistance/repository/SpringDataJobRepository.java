package ee.qrental.job.adapter.out.persistance.repository;

import ee.qrental.job.adapter.out.persistance.jpaentity.JobJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataJobRepository
        extends JpaRepository<JobJpaEntity, Long> {
}