package silveira.vinicius.sigepol.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PolicialController {

    @PostMapping("/policial")
    public ResponseEntity cadastrar() {
        return null;
    }

}
