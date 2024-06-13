package az.websuper.logistics.controller;


import az.websuper.logistics.dtos.banner.BannerCreateDto;
import az.websuper.logistics.dtos.banner.BannerUpdateDto;
import az.websuper.logistics.dtos.service.ServiceCreateDto;
import az.websuper.logistics.dtos.service.ServiceUpdateDto;
import az.websuper.logistics.services.ServiceLanguageService;
import az.websuper.logistics.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;


    @Autowired
    private ServiceLanguageService serviceLanguageService;


    @PostMapping("/create")
    public ResponseEntity<ServiceCreateDto> createService(@RequestBody ServiceCreateDto service)
    {
        ServiceCreateDto result = serviceService.createService(service);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/get/id/{id}")
    public  ResponseEntity<ServiceUpdateDto> getUpdateService(@PathVariable Long id)
    {
        ServiceUpdateDto result = serviceService.getUpdate(id);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PutMapping("/update/id/{id}")
    public  ResponseEntity<ServiceUpdateDto> getUpdateService(@PathVariable Long id, @RequestBody ServiceUpdateDto service)
    {
        ServiceUpdateDto result = serviceService.getUpdateData(id,service);
        return  new ResponseEntity<>(result, HttpStatus.OK);
    }

}
