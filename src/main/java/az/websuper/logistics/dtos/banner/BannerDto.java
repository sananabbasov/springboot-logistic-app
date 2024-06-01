package az.websuper.logistics.dtos.banner;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerDto {
    private Long id;
    private String photoUrl;
    private String title;
    private String subtitle;
}
