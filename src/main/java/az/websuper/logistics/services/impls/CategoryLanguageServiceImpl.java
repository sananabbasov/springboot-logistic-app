package az.websuper.logistics.services.impls;

import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.category.CategoryDto;
import az.websuper.logistics.dtos.category.CategoryLanguageCreateDto;
import az.websuper.logistics.dtos.category.CategoryLanguageUpdateDto;
import az.websuper.logistics.models.BannerLanguage;
import az.websuper.logistics.models.Category;
import az.websuper.logistics.models.CategoryLanguage;
import az.websuper.logistics.repositories.CategoryLanguageRepository;
import az.websuper.logistics.services.CategoryLanguageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryLanguageServiceImpl implements CategoryLanguageService {


    @Autowired
    private CategoryLanguageRepository categoryLanguageRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createCategoryLanguage(List<CategoryLanguageCreateDto> categoryLanguage, Category category) {
        List<CategoryLanguage> result = categoryLanguage
                .stream().map(bl -> modelMapper.map(bl, CategoryLanguage.class))
                .collect(Collectors.toList());
        result.forEach(bl -> bl.setCategory(category));
        categoryLanguageRepository.saveAll(result);
    }

    @Override
    public CategoryDto getCategoryByIdAndLangCode(String langCode) {
        CategoryDto categoryDto = new CategoryDto();
        CategoryLanguage findCategory = categoryLanguageRepository.findFirstByLangCode(langCode);
        categoryDto.setName(findCategory.getName());
        return categoryDto;
    }

    @Override
    public List<CategoryDto> getCategoriesByLang(String langCode) {
        List<CategoryDto> categories = categoryLanguageRepository
                .findAll().stream()
                .filter(x -> x.getLangCode().equals(langCode))
                .map(x-> new CategoryDto(x.getId(),x.getName(),x.getLangCode(),x.getCategory().getId())).collect(Collectors.toList());
        return categories;
    }

    @Override
    public void updateCategoriesLanguage(Long id, CategoryLanguageUpdateDto categoryLanguage) {
        CategoryLanguage findCategoryLanguage = categoryLanguageRepository.findById(id).orElseThrow();
        findCategoryLanguage.setName(categoryLanguage.getName());
        categoryLanguageRepository.save(findCategoryLanguage);
    }
}
