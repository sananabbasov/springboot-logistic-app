package az.websuper.logistics.repositories;

import az.websuper.logistics.models.BannerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerLanguageRepository extends JpaRepository<BannerLanguage, Long> {
    BannerLanguage findFirstByLangCode(String langCode);
}
