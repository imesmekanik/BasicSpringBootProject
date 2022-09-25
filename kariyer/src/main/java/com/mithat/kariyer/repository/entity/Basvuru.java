package com.mithat.kariyer.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "tbl_basvuru")
@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Basvuru extends Default {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500)
    private  String basvuruMektubu;

    @Column(length = 1000)
    private String ozgecmis;

    private LocalDate basvuruTarihi;
    private Long isId;
    private Long kullaniciId;


}