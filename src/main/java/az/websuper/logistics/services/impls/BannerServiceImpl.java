package az.websuper.logistics.services.impls;

import az.websuper.logistics.dtos.banner.BannerCreateDto;
import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.banner.BannerUpdateDto;
import az.websuper.logistics.exceptions.ResourceNotFoundException;
import az.websuper.logistics.models.Banner;
import az.websuper.logistics.models.BannerLanguage;
import az.websuper.logistics.repositories.BannerLanguageRepository;
import az.websuper.logistics.repositories.BannerRepository;
import az.websuper.logistics.services.BannerLanguageService;
import az.websuper.logistics.services.BannerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private BannerLanguageService bannerLanguageService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BannerCreateDto createBanner(BannerCreateDto bannerCreateDto) {
        Banner banner = modelMapper.map(bannerCreateDto, Banner.class);
        bannerRepository.save(banner);
        bannerLanguageService.createBannerLanguage(bannerCreateDto.getBannerLanguages(),banner);
        return bannerCreateDto;
    }

    @Override
    public BannerDto getBannerByLang(String langCode, Long id) {
        BannerDto bannerDto = new BannerDto();
//        BannerLanguage bannerLanguage = bannerLanguageService.findFirstByLangCode("az");
//        bannerDto.setTitle(bannerLanguage.getTitle());
//        bannerDto.setId(bannerLanguage.getBanner().getId());
//        bannerDto.setPhotoUrl(bannerLanguage.getBanner().getPhotoUrl());
//        bannerDto.setSubtitle(bannerLanguage.getSubtitle());
        return bannerDto;
    }

    @Override
    public List<BannerDto> getBannersByLang(String langCode) {
        return null;
    }

    @Override
    public BannerUpdateDto getUpdate(Long id) {
        Banner findBanner = bannerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Banner","banner id",id));
        BannerUpdateDto result = modelMapper.map(findBanner, BannerUpdateDto.class);
        return result;
    }

    @Override
    public BannerUpdateDto getUpdateData(Long id, BannerUpdateDto bannerUpdateDto) {
        Banner findBanner = bannerRepository.findById(id).orElseThrow();
        findBanner.setPhotoUrl(bannerUpdateDto.getPhotoUrl());
        for (var bannerLanguage: bannerUpdateDto.getBannerLanguages()) {
            bannerLanguageService.updateBannerLanguage(bannerLanguage.getId(),bannerLanguage);
        }
        bannerRepository.save(findBanner);
        return bannerUpdateDto;
    }
}
