package com.mithat.kariyer.service;

import com.mithat.kariyer.repository.IIsRepository;
import com.mithat.kariyer.repository.entity.Is;
import com.mithat.kariyer.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IsService extends ServiceManager<Is,Long> {

    private final IIsRepository isRepository;

    public IsService(IIsRepository isRepository){
        super(isRepository);
        this.isRepository=isRepository;
    }

    public Optional<List<Is>> maasiGirilendenYuksekIsler(Double maas){
        return isRepository.findAllOptionalByMaasGreaterThan(maas);
    }
}
