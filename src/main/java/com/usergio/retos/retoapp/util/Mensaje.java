package com.usergio.retos.retoapp.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder// contruir una instancia del objeto
public class Mensaje {

    private int httpCode;
    private String mensaje;
}


