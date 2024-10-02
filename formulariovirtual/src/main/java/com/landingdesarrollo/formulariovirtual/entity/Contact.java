package com.landingdesarrollo.formulariovirtual.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String nit;
    @NonNull
    private String namePunto;
    @NonNull
    private String ciudad;
    @NonNull
    private String promotor;
    @NonNull
    private String rtc;
    @NonNull
    private Boolean tratamientoDatos;
    @NonNull
    private LocalDateTime createdAt;
}
