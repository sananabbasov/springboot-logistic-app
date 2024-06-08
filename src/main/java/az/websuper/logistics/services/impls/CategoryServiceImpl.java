package az.websuper.logistics.services.impls;

import az.websuper.logistics.dtos.banner.BannerUpdateDto;
import az.websuper.logistics.dtos.category.CategoryAddDto;
import az.websuper.logistics.dtos.category.CategoryDto;
import az.websuper.logistics.dtos.category.CategoryUpdateDto;
import az.websuper.logistics.models.Banner;
import az.websuper.logistics.models.Category;
import az.websuper.logistics.repositories.CategoryRepository;
import az.websuper.logistics.services.CategoryLanguageService;
import az.websuper.logistics.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private CategoryLanguageService categoryLanguageService;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryAddDto categoryCreate(CategoryAddDto categoryAddDto) {
        Category category = modelMapper.map(categoryAddDto, Category.class);
        categoryRepository.save(category);
        categoryLanguageService.createCategoryLanguage(categoryAddDto.getCategoryLanguages(),category);
        return categoryAddDto;
    }

    @Override
    public CategoryDto getCategoryById(String langCode, Long id) {
        return null;
    }

    @Override
    public List<CategoryDto> getCategories(String langCode) {
        return null;
    }

    @Override
    public CategoryUpdateDto getUpdate(Long id) {
        Category findCategory = categoryRepository.findById(id).orElseThrow();
        CategoryUpdateDto result = modelMapper.map(findCategory, CategoryUpdateDto.class);
        return result;
    }

    @Override
    public CategoryUpdateDto getUpdateData(Long id, CategoryUpdateDto categoryUpdateDto) {
        Category findCategory = categoryRepository.findById(id).orElseThrow();
        for (var categoryLanguage: categoryUpdateDto.getCategoryLanguages()) {
            categoryLanguageService.updateCategoriesLanguage(categoryLanguage.getId(),categoryLanguage);
        }
        categoryRepository.save(findCategory);
        return categoryUpdateDto;
    }
}
