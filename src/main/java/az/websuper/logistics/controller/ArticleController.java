package az.websuper.logistics.controller;

import az.websuper.logistics.dtos.article.ArticleCreateDto;
import az.websuper.logistics.dtos.article.ArticleLanguageDto;
import az.websuper.logistics.dtos.article.ArticleListDto;
import az.websuper.logistics.enums.CategoryEnum;
import az.websuper.logistics.payloads.PaginationResponse;
import az.websuper.logistics.services.ArticleLanguageService;
import az.websuper.logistics.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;


    @Autowired
    private ArticleLanguageService articleLanguageService;

    @PostMapping("/create")
    public ResponseEntity<ArticleCreateDto> create(@RequestBody ArticleCreateDto articleCreateDto) {
        articleService.createArticle(articleCreateDto);
        return new ResponseEntity<>(articleCreateDto, HttpStatus.CREATED);
    }

    @GetMapping("/related/{categoryEnum}/{size}")
    public ResponseEntity<List<ArticleListDto>> getRelatedArticlesByCategory(@PathVariable CategoryEnum categoryEnum, int size)
    {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/home/news/{langCode}")
    public ResponseEntity<List<ArticleLanguageDto>> getHomeNews(@PathVariable String langCode)
    {
        List<ArticleLanguageDto> res =  articleLanguageService.getByLangCode(langCode);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/home/activities/{langCode}")
    public ResponseEntity<List<ArticleListDto>> getHomeActivities(@PathVariable String langCode)
    {
        List<ArticleListDto> result = articleService.getHomeActivities(langCode);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/home/activities/page/{pageNo}")
    public ResponseEntity<PaginationResponse<ArticleListDto>> getArticlesActivities(@PathVariable int pageNo)
    {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }


    @GetMapping("/home/newsss/{pageNo}")
    public ResponseEntity<PaginationResponse<ArticleListDto>> getArticlesNews(@PathVariable int pageNo)
    {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

}
