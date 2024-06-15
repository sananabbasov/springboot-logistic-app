package az.websuper.logistics.controller;


import az.websuper.logistics.dtos.banner.BannerCreateDto;
import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.banner.BannerUpdateDto;
import az.websuper.logistics.dtos.category.CategoryAddDto;
import az.websuper.logistics.dtos.category.CategoryDto;
import az.websuper.logistics.dtos.category.CategoryUpdateDto;
import az.websuper.logistics.services.CategoryLanguageService;
import az.websuper.logistics.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @Autowired
    private CategoryLanguageService categoryLanguageService;

    @PostMapping("/create")
    public ResponseEntity<CategoryAddDto> createCategory(@RequestBody CategoryAddDto category)
    {
        CategoryAddDto result = categoryService.categoryCreate(category);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/get/{langCode}")
    public  ResponseEntity<CategoryDto> get(@PathVariable String langCode)
    {
        CategoryDto result = categoryLanguageService.getCategoryByIdAndLangCode(langCode);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/getAll/{langCode}")
    public  ResponseEntity<List<CategoryDto>> getAll(@PathVariable String langCode)
    {
        List<CategoryDto> result = categoryLanguageService.getCategoriesByLang(langCode);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/get/id/{id}")
    public  ResponseEntity<CategoryUpdateDto> getUpdateCategory(@PathVariable Long id)
    {
        CategoryUpdateDto result = categoryService.getUpdate(id);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PutMapping("/update/id/{id}")
    public  ResponseEntity<CategoryUpdateDto> getUpdateBanner(@PathVariable Long id, @RequestBody CategoryUpdateDto category)
    {
        CategoryUpdateDto result = categoryService.getUpdateData(id,category);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }
}


// Mecid@123Sebuhi
