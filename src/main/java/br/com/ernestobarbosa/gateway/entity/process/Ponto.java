package br.com.ernestobarbosa.gateway.entity.process;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Ponto implements Serializable {

    private String ponto;

    private Long x;

    private Long y;

    private Long acc;

}
