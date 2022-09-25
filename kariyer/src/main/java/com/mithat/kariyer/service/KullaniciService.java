package com.mithat.kariyer.service;

import com.mithat.kariyer.repository.IKullaniciRepository;
import com.mithat.kariyer.repository.entity.Kullanici;
import com.mithat.kariyer.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class KullaniciService extends ServiceManager<Kullanici,Long> {

    private final IKullaniciRepository kullaniciRepository;

    public KullaniciService(IKullaniciRepository kullaniciRepository){
        super(kullaniciRepository);
        this.kullaniciRepository=kullaniciRepository;
    }

    public Optional<Kullanici> emailVeSifreIleKullaniciBul(String email,String sifre){
        return kullaniciRepository.findAllByEmailAndSifre(email,sifre);
    }
}
