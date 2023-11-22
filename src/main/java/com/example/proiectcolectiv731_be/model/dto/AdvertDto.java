package com.example.proiectcolectiv731_be.model.dto;

import com.example.proiectcolectiv731_be.model.Photo;
import com.example.proiectcolectiv731_be.model.User;

import java.util.List;

public class AdvertDto {

    private Long id;
    private String name;
    private String description;
    private Float price;
    private List<Photo> photos;
    private Boolean isPromoted;
    private Boolean isBlocked;
    private Boolean isActive;
    private User userId;

    public AdvertDto() {
    }

    public AdvertDto(Long id, String name, String description, Float price, List<Photo> photos, Boolean isPromoted, Boolean isBlocked, Boolean isActive, User userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.photos = photos;
        this.isPromoted = isPromoted;
        this.isBlocked = isBlocked;
        this.isActive = isActive;
        this.userId = userId;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<Photo> getImages() {
        return photos;
    }

    public void setImages(List<Photo> photos) {
        this.photos = photos;
    }

    public Boolean getPromoted() {
        return isPromoted;
    }

    public void setPromoted(Boolean promoted) {
        isPromoted = promoted;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

}
