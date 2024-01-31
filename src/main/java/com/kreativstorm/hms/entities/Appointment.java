package com.kreativstorm.hms.entities;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    Integer patientID;
    Integer doctorID;
    LocalDateTime scheduledFor;

}
