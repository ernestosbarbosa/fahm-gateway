package br.com.ernestobarbosa.gateway.entity.status;


import br.com.ernestobarbosa.gateway.entity.process.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exist implements Serializable {

    private String fileName;

    private boolean exist;

}
