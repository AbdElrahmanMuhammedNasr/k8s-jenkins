package com.example.springBootK8s.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@Data
@Entity
@Table(name = "user", schema = "public")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id ;
    @Column(name = "name")
    private String name = RandomStringUtils.randomAlphabetic(10);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
