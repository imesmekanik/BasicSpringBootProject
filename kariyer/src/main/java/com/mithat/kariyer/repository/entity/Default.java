package com.mithat.kariyer.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Default {
    boolean isactive;
    Long createdate;
    Long updatedate;
}