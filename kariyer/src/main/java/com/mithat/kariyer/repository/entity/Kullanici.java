package com.mithat.kariyer.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "tbl_kullanici")
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class Kullanici extends Default {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 50)
    private String ad;
    @Column(length = 50)
    private String soyad;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String telefon;
    @Column(length = 32)
    private String sifre;
}
