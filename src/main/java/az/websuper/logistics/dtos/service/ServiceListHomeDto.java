package az.websuper.logistics.dtos.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceListHomeDto {
    private Long id;
    private String title;
    private String langCode;
    private String description;
    private Long serviceId;
}
