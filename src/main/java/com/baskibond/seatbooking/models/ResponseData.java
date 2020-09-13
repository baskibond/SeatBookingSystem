package com.baskibond.seatbooking.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

@Data
@Builder
@Validated
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseData<T> implements Serializable {

    @JsonProperty("success")
    boolean success;

    @JsonProperty("error_message")
    String errorMessage;

    @JsonProperty("status_code")
    int statusCode;

    @JsonProperty("result")
    T result;

    public ResponseData(T result) {
        this.result = result;
        this.success = true;
    }
    public ResponseData(boolean success,String errorMessage,int statusCode,T result) {
        this.result = result;
        this.success = success;
        this.errorMessage=errorMessage;
        this.statusCode=statusCode;
    }
}
