package az.websuper.logistics.services;

import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.banner.BannerLanguageCreateDto;
import az.websuper.logistics.dtos.banner.BannerLanguageUpdateDto;
import az.websuper.logistics.dtos.category.CategoryDto;
import az.websuper.logistics.dtos.category.CategoryLanguageCreateDto;
import az.websuper.logistics.dtos.category.CategoryLanguageUpdateDto;
import az.websuper.logistics.models.Banner;
import az.websuper.logistics.models.Category;

import java.util.List;

public interface CategoryLanguageService {
    void createCategoryLanguage(List<CategoryLanguageCreateDto> categoryLanguage, Category category);
    CategoryDto getCategoryByIdAndLangCode(String langCode);
    List<CategoryDto> getCategoriesByLang(String langCode);

    void updateCategoriesLanguage(Long id, CategoryLanguageUpdateDto categoryLanguage);
}
