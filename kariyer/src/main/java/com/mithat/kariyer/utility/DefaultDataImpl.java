package com.mithat.kariyer.utility;

import com.mithat.kariyer.repository.IKullaniciRepository;
import com.mithat.kariyer.repository.IIsRepository;
import com.mithat.kariyer.repository.IBasvuruRepository;
import com.mithat.kariyer.repository.entity.Basvuru;
import com.mithat.kariyer.repository.entity.Is;
import com.mithat.kariyer.repository.entity.Kullanici;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Uygulama ayağa kalarken veritabanına default verileri eklemek için kullanılır.
 * ancak bu sınıfın otomatik çalışması gerekecek.
 */
@RequiredArgsConstructor
@Component
public class DefaultDataImpl {

    private final IIsRepository isRepository;
    private final IKullaniciRepository kullaniciRepository;
    private final IBasvuruRepository basvuruRepository;
    @PostConstruct
    private void create(){
        saveKullanici();
        saveIs();
        saveBasvuru();
    }

    private void saveKullanici(){
        Kullanici kullanici1 = Kullanici.builder()
                .ad("Mithat")
                .soyad("Orhan")
                .email("miteorhan@gmail.com")
                .telefon("05555555555")
                .sifre("mito1234")
                .build();

        Kullanici kullanici2 = Kullanici.builder()
                .ad("Zehra")
                .soyad("Orhan")
                .email("zehra@yahoo.com")
                .telefon("05325454545")
                .sifre("zehraa1")
                .build();

        kullaniciRepository.saveAll(Arrays.asList(kullanici1, kullanici2));
    }

    private void saveIs(){

        Is is1 = Is.builder()
                .ad("yazilim gelistirici")
                .isDetayi("Java backend tecrubeli")
                .maas(20000.0)
                .sonBasvuruTarihi(LocalDate.parse("2022-10-10"))
                .build();

        Is is2 = Is.builder()
                .ad("on yuz gelistiric")
                .isDetayi("React frontend tecrubeli")
                .maas(19000.0)
                .sonBasvuruTarihi(LocalDate.parse("2022-11-10"))
                .build();

        isRepository.saveAll(Arrays.asList(is1,is2));
    }

    private void saveBasvuru(){

        Basvuru basvuru1 = Basvuru.builder()
                .basvuruMektubu("ise al, ise al ise al beni, yaninda calismak istiiyoorumm")
                .ozgecmis("Sertifikalar: Oracle OCP, Is tecrubesi: a firmasi, Yetenekler: Java, Egitimler: a universitesi, b lisesi")
                .basvuruTarihi(LocalDate.parse("2022-06-06"))
                .isId(1L)
                .kullaniciId(1L)
                .build();

        Basvuru basvuru2 = Basvuru.builder()
                .basvuruMektubu("aradiginiz kisi benim, saygilar")
                .ozgecmis("Sertifikalar: yok, Is tecrubesi: yeni mezun, Yetenekler: React, Egitimler: c universitesi, d lisesi, udemy x kursu")
                .basvuruTarihi(LocalDate.parse("2022-09-06"))
                .isId(2L)
                .kullaniciId(2L)
                .build();

        basvuruRepository.saveAll(Arrays.asList(basvuru1,basvuru2));
    }

}