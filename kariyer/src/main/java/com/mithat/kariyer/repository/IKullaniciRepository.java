package com.mithat.kariyer.repository;



import com.mithat.kariyer.repository.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IKullaniciRepository extends JpaRepository<Kullanici,Long> {

    Optional<Kullanici> findAllByEmailAndSifre(String email, String sifre);
}