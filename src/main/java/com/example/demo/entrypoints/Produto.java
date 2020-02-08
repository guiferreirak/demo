package com.example.demo.entrypoints;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    private String nome;
    private Integer valor;
    private String marca;

}
