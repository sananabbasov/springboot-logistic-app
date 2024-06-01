package az.websuper.logistics.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String photoUrl;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "service")
    private List<ServiceLanguage> serviceLanguages = new ArrayList<>();
}
