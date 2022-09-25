package com.mithat.kariyer.repository;


import com.mithat.kariyer.repository.entity.Is;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IIsRepository extends JpaRepository<Is,Long> {

    Optional<List<Is>> findAllOptionalByMaasGreaterThan(Double maas);

}