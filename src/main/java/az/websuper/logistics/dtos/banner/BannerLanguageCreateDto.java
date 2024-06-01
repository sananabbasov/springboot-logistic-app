package az.websuper.logistics.dtos.banner;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerLanguageCreateDto {
    private String title;
    private String subtitle;
    private String langCode;
}
