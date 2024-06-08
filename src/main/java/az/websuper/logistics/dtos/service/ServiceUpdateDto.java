package az.websuper.logistics.dtos.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ServiceUpdateDto {
    private String photoUrl;
    private Long categoryId;
    private List<ServiceLanguageUpdateDto> serviceLanguages = new ArrayList<>();
}
