package az.websuper.logistics.dtos.service;


import lombok.Data;

@Data
public class ServiceLanguageUpdateDto {
    private Long id;
    private String title;
    private String langCode;
    private String description;
}
