package az.websuper.logistics.dtos.banner;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerCreateDto {
    private String photoUrl;
    private List<BannerLanguageCreateDto> bannerLanguages;
}
