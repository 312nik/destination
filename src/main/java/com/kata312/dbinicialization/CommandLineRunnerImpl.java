package com.kata312.dbinicialization;

import com.kata312.model.Role;
import com.kata312.model.User;
import com.kata312.repository.RoleRepository;
import com.kata312.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {


    private final DestinationService destinationService;
    @Autowired
    public CommandLineRunnerImpl(DestinationService destinationService) {
        this.destinationService = destinationService;
    }


    @Override
    public void run(String... args) throws Exception {

        Destination vnukovo=new Destination();

        vnukovo.setCity("Moskow");
        vnukovo.setAirportName("Внуково");
        vnukovo.setAirportCode("VKO");
        vnukovo.setTimezone("AA11");
        vnukovo.setCountryName("Russsia");
        vnukovo.setCountryCode("RU");


        Destination domodedovd=new Destination();

        domodedovd.setCity("Moskow");
        domodedovd.setAirportName("Домодедово");
        domodedovd.setAirportCode("VKO");
        domodedovd.setTimezone("AA11");
        domodedovd.setCountryName("Russsia");
        domodedovd.setCountryCode("RU");

        destinationService.saveDestination(domodedovd);
        destinationService.saveDestination(vnukovo);

    }
}

