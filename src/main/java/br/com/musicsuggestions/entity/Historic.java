package br.com.musicsuggestions.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "reproduction_history")
public class Historic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "play_list")
    @NotNull
    @Size(max = 100)
    private String playList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    private LocalDateTime createdAt;

    public Historic() {
    }

    public Historic(String playList, User user, LocalDateTime createdAt) {
        this.playList = playList;
        this.user = user;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlayList() {
        return playList;
    }

    public void setPlayList(String playList) {
        this.playList = playList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
