package az.websuper.logistics.services.impls;

import az.websuper.logistics.dtos.article.ArticleCreateDto;
import az.websuper.logistics.dtos.article.ArticleLanguageDto;
import az.websuper.logistics.dtos.article.ArticleListDto;
import az.websuper.logistics.dtos.article.ArticleUpdateDto;
import az.websuper.logistics.enums.CategoryEnum;
import az.websuper.logistics.models.Article;
import az.websuper.logistics.payloads.PaginationResponse;
import az.websuper.logistics.repositories.ArticleRepository;
import az.websuper.logistics.services.ArticleLanguageService;
import az.websuper.logistics.services.ArticleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleLanguageService articleLanguageService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ArticleCreateDto createArticle(ArticleCreateDto createArticle) {
        Article article = modelMapper.map(createArticle,Article.class);
//        article.getArticleLanguages().forEach(a->a.setArticle(article));
        articleRepository.save(article);
        articleLanguageService.createArticleLanguage(createArticle.getArticleLanguages(),article);
        return null;
    }

    @Override
    public void updateArticle(ArticleUpdateDto updateArticle) {

    }

    @Override
    public List<ArticleListDto> getRelatedArticlesByCategory(CategoryEnum categoryEnum, int size) {
        return null;
    }

    @Override
    public List<ArticleListDto> getHomeNews(String langCode) {
        articleLanguageService.getByLangCode(langCode);
        return null;
    }

    @Override
    public List<ArticleListDto> getHomeActivities(String langCode) {
        List<Article> article = articleRepository.findAll();
        List<ArticleListDto> result = article.stream().map(a -> {
            ArticleListDto list = modelMapper.map(a, ArticleListDto.class);
            list.setTitle(a.getArticleLanguages().stream().filter(x->x.getLangCode().equals(langCode)).findFirst().get().getTitle());
           return list;
        }).collect(Collectors.toList());
        return result;
    }

    @Override
    public PaginationResponse<ArticleListDto> getArticlesActivities(int pageNo) {
        return null;
    }

    @Override
    public PaginationResponse<ArticleListDto> getArticlesNews(int pageNo) {
        return null;
    }
}
