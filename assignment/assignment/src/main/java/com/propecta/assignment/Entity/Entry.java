package com.propecta.assignment.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
    @Entity
    @Data
    public class Entry  {
        @JsonProperty("API")
        private String Api;
        @Id
        private String Link;
        @JsonProperty("Description")
        private String Description;
        @JsonProperty("Auth")
        private String Auth;
        @JsonProperty("HTTPS")
        private boolean HTTPS;

        @JsonProperty("Cors")
        private String Cors;
        @JsonProperty("Category")
        private String category;

}
