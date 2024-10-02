package com.landingdesarrollo.formulariovirtual.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
public class ContactDTO {
    private String name;
    private String email;
    private String nit;
    private String namePunto;
    private String ciudad;
    private String promotor;
    private Boolean tratamientoDatos;
    private String rtc;

}
