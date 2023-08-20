package seat.code.mowers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seat.code.mowers.service.PlateauService;

@RestController
public class PlateauController {
    @Autowired
    PlateauService plateauService;

    @PostMapping(value = "/plateau/init")
    public String init(@RequestBody String inputMessage) {
        return plateauService.init(inputMessage);
    }
}
