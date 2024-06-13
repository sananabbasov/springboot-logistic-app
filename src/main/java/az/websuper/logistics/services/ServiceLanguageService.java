package az.websuper.logistics.services;

import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.banner.BannerLanguageCreateDto;
import az.websuper.logistics.dtos.banner.BannerLanguageUpdateDto;
import az.websuper.logistics.dtos.service.ServiceLanguageCreateDto;
import az.websuper.logistics.dtos.service.ServiceLanguageUpdateDto;
import az.websuper.logistics.dtos.service.ServiceListHomeDto;
import az.websuper.logistics.models.Banner;
import az.websuper.logistics.models.Service;

import java.util.List;

public interface ServiceLanguageService {

    void createServiceLanguage(List<ServiceLanguageCreateDto> serviceLanguage, Service service);
    ServiceListHomeDto getServiceByIdAndLangCode(String langCode);
    List<ServiceListHomeDto> getServicesByLang(String langCode);

    void updateServicesLanguage(Long id, ServiceLanguageUpdateDto serviceLanguage);
}
