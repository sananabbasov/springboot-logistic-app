package az.websuper.logistics.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "statistics")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String icon;
    private int count;


    @OneToMany(mappedBy = "statistic")
    private List<StatisticLanguage> statisticLanguages = new ArrayList<>();
}
