package az.websuper.logistics.repositories;

import az.websuper.logistics.models.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
