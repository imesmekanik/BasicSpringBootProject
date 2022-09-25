package com.mithat.kariyer.controller;

import com.mithat.kariyer.repository.entity.Kullanici;
import com.mithat.kariyer.service.KullaniciService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.mithat.kariyer.utility.Constants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(KULLANICI)
public class KullaniciController {

    private final KullaniciService kullaniciService;

    @GetMapping(FINDALL)
    public List<Kullanici> findAll(){
        return kullaniciService.findAll();
    }

    @GetMapping(SAVE)
    public String save(String ad, String soyad, String email, String telefon, String sifre){
        Kullanici kullanici = Kullanici.builder()

                .ad(ad)
                .soyad(soyad)
                .email(email)
                .telefon(telefon)
                .sifre(sifre)
                .build();
        kullaniciService.save(kullanici);
        return "Kullanici Kaydedildi.";
    }
    //http://localhost:9090/kullanici/emailVeSifreIleKullaniciBul?email=miteorhan@gmail.com&sifre=mito1234
    @GetMapping(EMAILVESIFREILEKULLANICIBUL)
    public ResponseEntity<Kullanici> emailVeSifreIleKullaniciBul(String email, String sifre){
        return ResponseEntity.ok(kullaniciService.emailVeSifreIleKullaniciBul(email,sifre).get());
    }

}