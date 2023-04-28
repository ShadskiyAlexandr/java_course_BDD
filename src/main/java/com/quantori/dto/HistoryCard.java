package com.quantori.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryCard {

    String visitDate;
    String facility;
    String hospitalReadmission;
    String healthcareProgram;
    String comment;
}
