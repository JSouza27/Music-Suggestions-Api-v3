package br.com.musicsuggestions.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    @NotNull(message = "O campo nome não pode ser nulo ou vazio!")
    @Size(min = 3, max = 32, message = "O campo nome deve ter entre 3 32 caracteres!")
    private String fullName;

    @Column
    @Email(message = "Email inválido!")
    @NotNull(message = "O campo email não pode ser nulo ou vazio!")
    private String email;

    @Column
    @NotNull(message = "O campo senha não pode ser nulo ou vazio!")
    @Size(min = 6, max = 64, message = "O campo senha não pode ser menor que 6 caracteres e maior que 64!")
    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<Historic> historic;

    public User() {
    }

    public User(String fullName, String email, String password, LocalDateTime createdAt, List<Historic> historic) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.historic = historic;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Historic> getHistoric() {
        return historic;
    }

    public void setHistoric(List<Historic> historic) {
        this.historic = historic;
    }
}
