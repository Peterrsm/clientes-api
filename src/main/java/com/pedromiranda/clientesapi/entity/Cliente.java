package com.pedromiranda.clientesapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clientes")
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonDeserialize
@JsonSerialize
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String cpf;

    @Column
    private String nome;

    @ElementCollection(targetClass=String.class)
    private List<String> celulares = new ArrayList<>();

    @ElementCollection(targetClass=String.class)
    private List<String> emails = new ArrayList<>();

    @JsonProperty
    public void addCelular(String novo) {
        this.celulares.add(novo);
    }

    @JsonProperty
    public void addEmail(String novo) {
        this.emails.add(novo);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", celulares=" + celulares +
                ", emails=" + emails +
                '}';
    }
}
