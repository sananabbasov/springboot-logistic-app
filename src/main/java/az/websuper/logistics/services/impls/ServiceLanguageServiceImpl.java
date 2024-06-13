package az.websuper.logistics.services.impls;

import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.service.ServiceLanguageCreateDto;
import az.websuper.logistics.dtos.service.ServiceLanguageUpdateDto;
import az.websuper.logistics.dtos.service.ServiceListHomeDto;
import az.websuper.logistics.models.BannerLanguage;
import az.websuper.logistics.models.ServiceLanguage;
import az.websuper.logistics.repositories.ServiceLanguageRepository;
import az.websuper.logistics.services.ServiceLanguageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceLanguageServiceImpl  implements ServiceLanguageService {

    @Autowired
    private ServiceLanguageRepository serviceLanguageRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void createServiceLanguage(List<ServiceLanguageCreateDto> serviceLanguage, az.websuper.logistics.models.Service service) {
        try {
            List<ServiceLanguage> result = serviceLanguage
                    .stream().map(bl -> modelMapper.map(bl, ServiceLanguage.class))
                    .collect(Collectors.toList());
            result.forEach(bl -> bl.setService(service));
            serviceLanguageRepository.saveAll(result);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ServiceListHomeDto getServiceByIdAndLangCode(String langCode) {
        return null;
    }

    @Override
    public List<ServiceListHomeDto> getServicesByLang(String langCode) {

        List<ServiceListHomeDto> banners = serviceLanguageRepository
                .findAll().stream()
                .filter(x -> x.getLangCode().equals(langCode))
                .map(x-> new ServiceListHomeDto(x.getId(),x.getTitle(),x.getDescription(),x.getLangCode(),x.getService().getId())).collect(Collectors.toList());
        return banners;
    }

    @Override
    public void updateServicesLanguage(Long id, ServiceLanguageUpdateDto serviceLanguage) {
        ServiceLanguage findServiceLanguage = serviceLanguageRepository.findById(id).orElseThrow();
        findServiceLanguage.setTitle(serviceLanguage.getTitle());
        findServiceLanguage.setDescription(serviceLanguage.getDescription());
        serviceLanguageRepository.save(findServiceLanguage);
    }
}
