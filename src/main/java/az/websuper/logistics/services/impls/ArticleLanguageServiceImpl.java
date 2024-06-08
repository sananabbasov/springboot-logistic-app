package az.websuper.logistics.services.impls;

import az.websuper.logistics.dtos.article.ArticleLanguageCreateDto;
import az.websuper.logistics.dtos.article.ArticleLanguageDto;
import az.websuper.logistics.dtos.article.ArticleLanguageUpdateDto;
import az.websuper.logistics.models.Article;
import az.websuper.logistics.models.ArticleLanguage;
import az.websuper.logistics.repositories.ArticleLanguageRepository;
import az.websuper.logistics.services.ArticleLanguageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleLanguageServiceImpl implements ArticleLanguageService {

    @Autowired
    private ArticleLanguageRepository articleLanguageRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createArticleLanguage(List<ArticleLanguageCreateDto> articleLanguages, Article article) {
        List<ArticleLanguage> result = articleLanguages.stream()
                .map(al -> modelMapper.map(al,ArticleLanguage.class) )
                .collect(Collectors.toList());
        result.forEach(res ->res.setArticle(article));
        articleLanguageRepository.saveAll(result);
    }

    @Override
    public void updateArticleLanguage(Long id, ArticleLanguageUpdateDto articleLanguage) {

    }

    @Override
    public List<ArticleLanguageDto> getByLangCode(String langCode) {
        List<ArticleLanguage> res = articleLanguageRepository.getByLangCode(langCode);
        List<ArticleLanguageDto> articleLanguage = res.stream().map(al -> modelMapper.map(al, ArticleLanguageDto.class)).collect(Collectors.toList());
        return articleLanguage;
    }

    @Override
    public ArticleLanguageDto findByLang(String langCode, Long id) {
        List<ArticleLanguage> res = articleLanguageRepository.getByArticleId(id);
        ArticleLanguage articleLanguage = res.stream().filter(c->c.getLangCode().contains(langCode)).findFirst().get();
        ArticleLanguageDto result = modelMapper.map(articleLanguage, ArticleLanguageDto.class);
        return result;
    }
}
