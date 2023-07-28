package ru.uxair.flight.entity.dto;



import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import javax.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "\n" +
        "This is information about the destination. In our work, we will use IATA codes and Russian classification of the countries" +
        ". Since IATA provides information for money or to members, we will use open WIKI sources",
        externalDocs = @ExternalDocumentation(url="https://en.wikipedia.org/wiki/International_Air_Transport_Association_code", description = "For more information follow the link"))

public class DestinationDto {

    @Positive
    private Long id;

    @Schema(description = "IATA Code. A code of 3 letters of the Latin alphabet that can be assigned to an airport, city, railway station, sea or river port, or other major transport hub.")
    @Pattern(regexp = "[A-Z]{3}", message = "Airport code must have format XXX")
    @Size(min=3,max=3)
    private String airportCode;

    @Schema(description = "Name of the city where the airport is located")
    @NotBlank(message = "Name of city cannot be empty")
    private String city;

    @Schema(description = "IATA Code. 2-letter country codes are used according to the ISO 3166-1 alpha-2 list.")
    @Pattern (regexp = "[A-Z]{2}", message = "Country code should be in the format XX")
    @Size(min=2,max=2)
    private String countryCode;

    @Schema(description = "Uses a short name of country in accordance with the Russian classification of the countries of the world")
    @NotBlank(message = "Country name cannot be empty")
    private String countryName;

    @Schema(description ="Airport name")
    @NotBlank(message = "Airport name cannot be empty")
    private String airportName;

    @Schema(description = "IATA Code. A code of 2-4 characters (letters of the Latin alphabet and numbers), which is assigned to a country or part of a territory within a country in which local time is calculated in a uniform way")
    @Pattern (regexp = "[A-Z]{2}|[A-Z]{2}+[1-9]{2}|[A-Z]{2}+[1-9]{1}+[A-Z]{1}", message = "Timezone code should be in the format XX or XX11 or XX1X")
    @Size(min=2,max=4)
    private String timezone;
}
