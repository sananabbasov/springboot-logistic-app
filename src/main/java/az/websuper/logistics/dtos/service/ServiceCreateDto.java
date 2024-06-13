package az.websuper.logistics.dtos.service;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ServiceCreateDto {
    private Long serviceId;
    private String photoUrl;
    private Long categoryId;
    private List<ServiceLanguageCreateDto> serviceLanguages = new ArrayList<>();
}
