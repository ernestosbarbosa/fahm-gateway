package br.com.ernestobarbosa.gateway.entity.process;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Pessoa implements Serializable {

    private Integer idPessoa;

    private Ponto[] pontos;

}
