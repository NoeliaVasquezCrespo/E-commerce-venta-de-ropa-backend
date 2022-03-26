package ucb.edu.bo.sis.ventaropa.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/example")
public class ExampleApi {
    @GetMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }
}
