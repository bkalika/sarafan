package com.sarafan.sarafan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author @bkalika
 * Created on 13.08.2022 10:45 PM
 */

@Data
@AllArgsConstructor
public class MetaDto {
    private String title;
    private String description;
    private String cover;

    public MetaDto(String title, String description, String cover) {
        this.title = title;
        this.description = description;
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
