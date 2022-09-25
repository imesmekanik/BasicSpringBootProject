package com.mithat.kariyer.controller;

import com.mithat.kariyer.repository.entity.Is;
import com.mithat.kariyer.service.IsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import static com.mithat.kariyer.utility.Constants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(IS)
public class IsController {

    private final IsService isService;


    @GetMapping(FINDALL)
    public List<Is> findAll(){
        return isService.findAll();
    }

    @GetMapping(SAVE)
    public String save(String ad, String isDetayi, Double maas, String sonBasvuruTarihi){
        Is is = Is.builder()
                .ad(ad)
                .isDetayi(isDetayi)
                .maas(maas)
                .sonBasvuruTarihi(LocalDate.parse(sonBasvuruTarihi))
                .build();
        isService.save(is);
        return "Is Kaydedildi.";
    }
    //http://localhost:9090/is/maasiGirilendenYuksekIsler?maas=19500
    @GetMapping(MAASIGIRILENDENYUKSEKISLER)
    public ResponseEntity<List<Is>> maasiGirilendenYuksekIsler(Integer maas){
        return ResponseEntity.ok(isService.maasiGirilendenYuksekIsler(maas.doubleValue()).get());
    }

}