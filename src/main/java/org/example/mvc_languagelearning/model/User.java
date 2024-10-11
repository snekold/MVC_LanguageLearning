package org.example.mvc_languagelearning.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

// 1 Entity
// 2 Id
// 3 класс не final
// 4  поля не должны быть final
// 5 пустой конструктор
@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private int point;

}
