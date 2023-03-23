@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name="destinations")

public  class Destination {


        @Id
        private String airportCode;

        private String city;

        private String countryCode;

        private String countryName;

        private String airportName;

        private String timezone;


}
