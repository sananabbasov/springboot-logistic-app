package az.websuper.logistics.dtos.banner;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerUpdateDto {
    private String photoUrl;
    private List<BannerLanguageUpdateDto> bannerLanguages;
}
