package br.com.ernestobarbosa.gateway.entity.process;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Quadro implements Serializable {

    private Integer idQuadro;

    private Pessoa[] pessoas;

}
