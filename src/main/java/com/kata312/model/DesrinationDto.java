@Data
@NoArgsConstructor
@AllArgsConstructor

public class DestinationDto {

    @Pattern(regexp = "[A-Z]{3}", message = "Airport code must have format XXX")
    private String airportCode;

    @NotBlank(message = "Name of city cannot be empty")
    private String city;

    @Pattern (regexp = "[A-Z]{2}", message = "Country code should be in the format XX")
    private String countryCode;

    @NotBlank(message = "Country name cannot be empty")
    private String countryName;

    @NotBlank(message = "Airpourt name cannot be empty")
    private String airportName;


    @Pattern (regexp = " [A-Z]{2}|[A-Z]{2}+[1-9]{2}|[A-Z]{2}+[1-9]{1}+[A-Z]{1}", message = "timezone code should be in the format XX or XX11 or XX1X")
    private String timezone;
}
