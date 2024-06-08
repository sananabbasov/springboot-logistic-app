package az.websuper.logistics.dtos.category;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class CategoryUpdateDto {
    private Long id;
    private List<CategoryLanguageUpdateDto> categoryLanguages = new ArrayList<>();

}
