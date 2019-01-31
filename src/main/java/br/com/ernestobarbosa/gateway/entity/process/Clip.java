package br.com.ernestobarbosa.gateway.entity.process;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Clip implements Serializable {

    private Quadro[] quadros;

}
