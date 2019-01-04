package br.com.ernestobarbosa.gateway.domain.response;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Builder
@ToString
public class Response implements Serializable {
    private final String MESSAGE = "sucesso";
    private String id;
}
