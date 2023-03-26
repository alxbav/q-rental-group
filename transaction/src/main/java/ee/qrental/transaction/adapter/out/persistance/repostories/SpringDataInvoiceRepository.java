package ee.qrental.transaction.adapter.out.persistance.repostories;

import ee.qrental.transaction.adapter.out.persistance.jpaentity.InvoiceJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SpringDataInvoiceRepository
        extends JpaRepository<InvoiceJpaEntity, Long> {

    InvoiceJpaEntity findById(final String id);
}

