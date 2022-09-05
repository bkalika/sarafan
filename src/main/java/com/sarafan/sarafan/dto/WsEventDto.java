package com.sarafan.sarafan.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.sarafan.sarafan.domain.Views;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author @bkalika
 * Created on 12.08.2022 9:01 AM
 */

@Data
@JsonView(Views.Id.class)
public class WsEventDto {
    private ObjectType objectType;
    private EventType eventType;

    @JsonRawValue
    private String body;

    public WsEventDto(ObjectType objectType, EventType eventType, String body) {
        this.objectType = objectType;
        this.eventType = eventType;
        this.body = body;
    }

}
