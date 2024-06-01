package az.websuper.logistics.dtos.banner;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerLanguageUpdateDto {
    private Long id;
    private String title;
    private String subtitle;
    private String langCode;
}
