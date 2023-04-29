package com.quantori.dto;

import com.quantori.helpers.DateParser;
import lombok.*;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentCard {

    String visitDate;
    String facility;
    String hospitalReadmission;
    String healthcareProgram;
    String comment;

    public static AppointmentCard createCard(Map<String, String> data) {
        DateParser parser = new DateParser();

        String visitDate = parser.getDate(data.get("Date"));
        String facility = data.get("Facility");
        String hospitalReadmission = data.get("Readmission");
        String healthcareProgram = data.get("Program");
        String comment = data.get("Comment");

        return AppointmentCard.builder()
                .visitDate(visitDate)
                .facility(facility)
                .hospitalReadmission(hospitalReadmission)
                .healthcareProgram(healthcareProgram)
                .comment(comment)
                .build();
    }
}
