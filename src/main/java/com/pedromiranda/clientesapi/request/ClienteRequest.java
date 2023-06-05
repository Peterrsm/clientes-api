package com.pedromiranda.clientesapi.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ClienteRequest implements Serializable {

    private String cpf;

    private String nome;

    @ElementCollection(targetClass=String.class)
    private List<String> celulares = new ArrayList<>();

    @ElementCollection(targetClass=String.class)
    private List<String> emails = new ArrayList<>();

}
