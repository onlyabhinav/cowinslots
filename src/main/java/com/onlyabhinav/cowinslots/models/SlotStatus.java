package com.onlyabhinav.cowinslots.models;


import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreType
public class SlotStatus {

    private Boolean isAvailable = Boolean.FALSE;
    private Root root;
    private Center center;
    private Session session;

}
