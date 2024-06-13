package az.websuper.logistics.services.impls;

import az.websuper.logistics.dtos.banner.BannerUpdateDto;
import az.websuper.logistics.dtos.service.ServiceCreateDto;
import az.websuper.logistics.dtos.service.ServiceListHomeDto;
import az.websuper.logistics.dtos.service.ServiceUpdateDto;
import az.websuper.logistics.models.Banner;
import az.websuper.logistics.models.Category;
import az.websuper.logistics.repositories.ServiceRepository;
import az.websuper.logistics.services.CategoryService;
import az.websuper.logistics.services.ServiceLanguageService;
import az.websuper.logistics.services.ServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceLanguageService serviceLanguageService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ServiceCreateDto createService(ServiceCreateDto serviceCreate) {
        az.websuper.logistics.models.Service service = modelMapper.map(serviceCreate, az.websuper.logistics.models.Service.class);
        Category category = categoryService.findById(serviceCreate.getCategoryId());
        service.setCategory(category);
        serviceRepository.save(service);
        serviceLanguageService.createServiceLanguage(serviceCreate.getServiceLanguages(),service);
        return serviceCreate;
    }

    @Override
    public ServiceListHomeDto getServiceByLang(String langCode, Long categoryId) {
        return null;
    }

    @Override
    public List<ServiceListHomeDto> getServicesByLang(String langCode) {
        return null;
    }

    @Override
    public ServiceUpdateDto getUpdate(Long id) {
        az.websuper.logistics.models.Service findBanner = serviceRepository.findById(id).orElseThrow();
        ServiceUpdateDto result = modelMapper.map(findBanner, ServiceUpdateDto.class);
        return result;
    }

    @Override
    public ServiceUpdateDto getUpdateData(Long id, ServiceUpdateDto serviceUpdate) {
        az.websuper.logistics.models.Service findService = serviceRepository.findById(id).orElseThrow();
        findService.setPhotoUrl(serviceUpdate.getPhotoUrl());
        for (var serviceLanguage: serviceUpdate.getServiceLanguages()) {
            serviceLanguageService.updateServicesLanguage(serviceLanguage.getId(),serviceLanguage);
        }
        serviceRepository.save(findService);
        return serviceUpdate;
    }
}
