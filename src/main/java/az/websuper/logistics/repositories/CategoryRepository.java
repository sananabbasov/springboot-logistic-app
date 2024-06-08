package az.websuper.logistics.repositories;

import az.websuper.logistics.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
