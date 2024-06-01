package az.websuper.logistics.controller;

import az.websuper.logistics.dtos.article.ArticleCreateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
public class ArticleController {


    @PostMapping("/create")
    public ResponseEntity<ArticleCreateDto> create()
    {
        return new ResponseEntity<>(null);
    }
}
