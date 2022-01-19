package br.com.musicsuggestions.dto;

import br.com.musicsuggestions.entity.Historic;
import br.com.musicsuggestions.entity.User;

import java.time.LocalDateTime;
import java.util.List;

public class UserDTO {

    private Long id;
    private String fullName;
    private String email;
    private LocalDateTime createdAt;
    private List<Historic> historic;

    public UserDTO() {
    }

    public UserDTO(Long id, String fullName, String email, LocalDateTime createdAt, List<Historic> historic) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
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
