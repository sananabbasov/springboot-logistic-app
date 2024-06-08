package az.websuper.logistics.dtos.category;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryAddDto {
    private List<CategoryLanguageCreateDto> categoryLanguages = new ArrayList<>();
}
