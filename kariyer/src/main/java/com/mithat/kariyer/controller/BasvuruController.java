package com.mithat.kariyer.controller;

import com.mithat.kariyer.repository.entity.Basvuru;
import com.mithat.kariyer.service.BasvuruService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.mithat.kariyer.utility.Constants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(BASVURU)
public class BasvuruController {

    private final BasvuruService basvuruService;

    @GetMapping(FINDALL)
    public ResponseEntity<List<Basvuru>> findAll(){
        return ResponseEntity.ok(basvuruService.findAll());
    }

    @GetMapping(SAVE)
    public ResponseEntity<String> save(String basvuruMektubu, String ozgecmis, String basvuruTarihi, Long isId, Long kullaniciId){
        Basvuru basvuru = Basvuru.builder()
                .basvuruMektubu(basvuruMektubu)
                .ozgecmis(ozgecmis)
                .basvuruTarihi(LocalDate.parse(basvuruTarihi))
                .isId(isId)
                .kullaniciId(kullaniciId)
                .build();
        basvuruService.save(basvuru);
        return ResponseEntity.ok("Basvuru Kaydedildi.");
    }
    //http://localhost:9090/basvuru/icindeJavaGecenOzgecmisler
    @GetMapping(ICINDEJAVAGECENOZGECMISLILER)
    public ResponseEntity<List<Basvuru>> icindeJavaGecenOzgecmisler(){
        return ResponseEntity.ok(basvuruService.icindeJavaGecenOzgecmisler().get());
    }
    //http://localhost:9090/basvuru/tarihtenOnceFiltreliBasvurular?date=2050-11-11&arama=Java
    @GetMapping(TARIHTENONCEFILTRELIBASVURULAR)
    public ResponseEntity<List<Basvuru>> tarihtenOnceFiltreliBasvurular(String date,String arama){
        return ResponseEntity.ok(basvuruService.tarihtenOnceFiltreliBasvurular(LocalDate.parse(date),arama).get());
    }

}