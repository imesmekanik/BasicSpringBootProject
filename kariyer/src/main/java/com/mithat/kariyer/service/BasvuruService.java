package com.mithat.kariyer.service;

import com.mithat.kariyer.repository.IBasvuruRepository;
import com.mithat.kariyer.repository.entity.Basvuru;
import com.mithat.kariyer.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BasvuruService extends ServiceManager<Basvuru,Long> {

    private final IBasvuruRepository basvuruRepository;

    public BasvuruService(IBasvuruRepository basvuruRepository){
        super(basvuruRepository);
        this.basvuruRepository=basvuruRepository;
    }

    public Optional<List<Basvuru>> icindeJavaGecenOzgecmisler(){
        return basvuruRepository.icindeJavaGecenOzgecmisler();
    }
    public Optional<List<Basvuru>> tarihtenOnceFiltreliBasvurular(LocalDate date, String arama){
        return basvuruRepository.findAllOptionalByBasvuruTarihiBeforeAndOzgecmisContaining(date, arama);
    }

}
