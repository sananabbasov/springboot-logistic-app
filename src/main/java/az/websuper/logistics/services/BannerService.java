package az.websuper.logistics.services;

import az.websuper.logistics.dtos.banner.BannerCreateDto;
import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.banner.BannerUpdateDto;

import java.util.List;

public interface BannerService {
    BannerCreateDto createBanner(BannerCreateDto bannerCreateDto);
    BannerDto getBannerByLang(String langCode, Long id);
    List<BannerDto> getBannersByLang(String langCode);

    BannerUpdateDto getUpdate(Long id);
    BannerUpdateDto getUpdateData(Long id, BannerUpdateDto bannerUpdateDto);
}
