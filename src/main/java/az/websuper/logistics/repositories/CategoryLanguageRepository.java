package az.websuper.logistics.repositories;

import az.websuper.logistics.models.BannerLanguage;
import az.websuper.logistics.models.CategoryLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryLanguageRepository extends JpaRepository<CategoryLanguage, Long> {
    CategoryLanguage findFirstByLangCode(String langCode);
}
