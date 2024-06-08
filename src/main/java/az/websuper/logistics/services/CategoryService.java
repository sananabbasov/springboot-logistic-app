package az.websuper.logistics.services;

import az.websuper.logistics.dtos.banner.BannerCreateDto;
import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.banner.BannerUpdateDto;
import az.websuper.logistics.dtos.category.CategoryAddDto;
import az.websuper.logistics.dtos.category.CategoryDto;
import az.websuper.logistics.dtos.category.CategoryUpdateDto;

import java.util.List;

public interface CategoryService {
    CategoryAddDto categoryCreate (CategoryAddDto categoryAddDto);
    CategoryDto getCategoryById(String langCode, Long id);
    List<CategoryDto> getCategories(String langCode);
    CategoryUpdateDto getUpdate(Long id);
    CategoryUpdateDto getUpdateData(Long id, CategoryUpdateDto categoryUpdateDto);
}
