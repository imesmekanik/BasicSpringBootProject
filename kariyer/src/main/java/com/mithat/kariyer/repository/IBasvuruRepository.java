package com.mithat.kariyer.repository;


import com.mithat.kariyer.repository.entity.Basvuru;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IBasvuruRepository extends JpaRepository<Basvuru,Long> {

    @Query("select b from Basvuru b where b.ozgecmis like ('%Java%')")
    Optional<List<Basvuru>> icindeJavaGecenOzgecmisler();

    Optional<List<Basvuru>> findAllOptionalByBasvuruTarihiBeforeAndOzgecmisContaining(LocalDate date, String arama);

}

