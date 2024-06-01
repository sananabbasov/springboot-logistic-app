package az.websuper.logistics.controller;

import az.websuper.logistics.dtos.banner.BannerCreateDto;
import az.websuper.logistics.dtos.banner.BannerDto;
import az.websuper.logistics.dtos.banner.BannerUpdateDto;
import az.websuper.logistics.services.BannerLanguageService;
import az.websuper.logistics.services.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;


    @Autowired
    private BannerLanguageService bannerLanguageService;


    @PostMapping("/create")
    public ResponseEntity<BannerCreateDto> createBanner(@RequestBody BannerCreateDto banner)
    {
        BannerCreateDto result = bannerService.createBanner(banner);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/get/{langCode}")
    public  ResponseEntity<BannerDto> get(@PathVariable String langCode)
    {
        BannerDto result = bannerLanguageService.getBannerByIdAndLangCode(langCode);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping("/getAll/{langCode}")
    public  ResponseEntity<List<BannerDto>> getAll(@PathVariable String langCode)
    {
        List<BannerDto> result = bannerLanguageService.getBannersByLang(langCode);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/get/id/{id}")
    public  ResponseEntity<BannerUpdateDto> getUpdateBanner(@PathVariable Long id)
    {
        BannerUpdateDto result = bannerService.getUpdate(id);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PutMapping("/update/id/{id}")
    public  ResponseEntity<BannerUpdateDto> getUpdateBanner(@PathVariable Long id, @RequestBody BannerUpdateDto banner)
    {
        BannerUpdateDto result = bannerService.getUpdateData(id,banner);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }
}
