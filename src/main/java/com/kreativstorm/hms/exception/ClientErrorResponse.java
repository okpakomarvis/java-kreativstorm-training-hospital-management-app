package com.kreativstorm.hms.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientErrorResponse {
    private String status;
    private String message;
    private long timestamps;
}
