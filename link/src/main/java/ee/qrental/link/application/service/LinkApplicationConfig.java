package ee.qrental.link.application.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ee.qrental.link.application.port.out.LinkDeletePort;
import ee.qrental.link.application.port.out.LinkAddPort;
import ee.qrental.link.application.port.out.LinkLoadPort;
import ee.qrental.link.application.port.out.LinkUpdatePort;

@Configuration
public class LinkApplicationConfig {

    @Bean
    public LinkService getLinkService(
            final LinkAddPort linkAddPort,
            final LinkUpdatePort linkUpdatePort,
            final LinkLoadPort linkLoadPort,
            final LinkDeletePort linkDeletePort){
        return new LinkService(linkAddPort,
                linkUpdatePort,
                linkLoadPort,
                linkDeletePort);
    }
}
