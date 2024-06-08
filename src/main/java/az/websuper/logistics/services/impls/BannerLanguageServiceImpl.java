package az.websuper.logistics.services.impls;

import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.banner.BannerLanguageCreateDto;
import az.websuper.logistics.dtos.banner.BannerLanguageUpdateDto;
import az.websuper.logistics.models.Banner;
import az.websuper.logistics.models.BannerLanguage;
import az.websuper.logistics.repositories.BannerLanguageRepository;
import az.websuper.logistics.services.BannerLanguageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class BannerLanguageServiceImpl  implements BannerLanguageService {

    @Autowired
    private BannerLanguageRepository bannerLanguageRepository;

    @Autowired
    private ModelMapper modelMapper;



    @Override
    public void createBannerLanguage(List<BannerLanguageCreateDto> bannerLanguages, Banner banner) {
        List<BannerLanguage> result = bannerLanguages
                .stream().map(bl -> modelMapper.map(bl, BannerLanguage.class))
                .collect(Collectors.toList());
        result.forEach(bl -> bl.setBanner(banner));
        bannerLanguageRepository.saveAll(result);
    }

    @Override
    public BannerDto getBannerByIdAndLangCode(String langCode) {
        BannerDto bannerDto = new BannerDto();
        BannerLanguage findBanner = bannerLanguageRepository.findFirstByLangCode(langCode);
        bannerDto.setTitle(findBanner.getTitle());
        bannerDto.setId(findBanner.getBanner().getId());
        bannerDto.setPhotoUrl(findBanner.getBanner().getPhotoUrl());
        bannerDto.setSubtitle(findBanner.getSubtitle());
        return bannerDto;
    }

    @Override
    public List<BannerDto> getBannersByLang(String langCode) {

        List<BannerDto> banners = bannerLanguageRepository
                .findAll().stream()
                .filter(x -> x.getLangCode().equals(langCode))
                .map(x-> new BannerDto(x.getId(),x.getBanner().getPhotoUrl(),x.getTitle(),x.getSubtitle())).collect(Collectors.toList());
        return banners;
    }


    @Override
    public void updateBannerLanguage(Long id, BannerLanguageUpdateDto bannerLanguage) {
        BannerLanguage findBannerLanguage = bannerLanguageRepository.findById(id).orElseThrow();
        findBannerLanguage.setTitle(bannerLanguage.getTitle());
        findBannerLanguage.setSubtitle(bannerLanguage.getSubtitle());
        bannerLanguageRepository.save(findBannerLanguage);
    }
}
