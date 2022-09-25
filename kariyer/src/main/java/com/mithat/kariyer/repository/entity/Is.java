package com.mithat.kariyer.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "tbl_is")
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Is extends Default {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String ad;
    private String isDetayi;
    private Double maas;
    private LocalDate sonBasvuruTarihi;


}
