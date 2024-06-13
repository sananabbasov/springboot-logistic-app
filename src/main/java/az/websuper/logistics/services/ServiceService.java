package az.websuper.logistics.services;

import az.websuper.logistics.dtos.banner.BannerCreateDto;
import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.banner.BannerUpdateDto;
import az.websuper.logistics.dtos.category.CategoryUpdateDto;
import az.websuper.logistics.dtos.service.ServiceCreateDto;
import az.websuper.logistics.dtos.service.ServiceListHomeDto;
import az.websuper.logistics.dtos.service.ServiceUpdateDto;

import java.util.List;

public interface ServiceService {
    ServiceCreateDto createService(ServiceCreateDto serviceCreate);
    ServiceListHomeDto getServiceByLang(String langCode, Long categoryId);
    List<ServiceListHomeDto> getServicesByLang(String langCode);
    ServiceUpdateDto getUpdate(Long id);
    ServiceUpdateDto getUpdateData(Long id, ServiceUpdateDto serviceUpdate);
}
