package com.kreativstorm.hms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.kreativstorm.hms.utill.Constant.SUCCESS;

@AllArgsConstructor
@Data
public class ResponseRequest {
    private String status;
    private long timestamps;
    private Object response;
    public ResponseRequest(){
        this.status=SUCCESS;
        this.timestamps =System.currentTimeMillis();
    }


}
