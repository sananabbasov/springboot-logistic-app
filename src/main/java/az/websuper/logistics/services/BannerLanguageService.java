package az.websuper.logistics.services;

import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.banner.BannerLanguageCreateDto;
import az.websuper.logistics.dtos.banner.BannerLanguageUpdateDto;
import az.websuper.logistics.dtos.banner.BannerUpdateDto;
import az.websuper.logistics.models.Banner;
import az.websuper.logistics.models.BannerLanguage;

import java.util.List;

public interface BannerLanguageService {

    void createBannerLanguage(List<BannerLanguageCreateDto> bannerLanguages, Banner banner);
    BannerDto getBannerByIdAndLangCode(String langCode);
   List<BannerDto> getBannersByLang(String langCode);

    void updateBannerLanguage(Long id, BannerLanguageUpdateDto bannerLanguage);
}
