package spring.francisco.auth.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {


    @GetMapping
    public ResponseEntity<String> getDemo() {
        return ResponseEntity.ok("Hello World");
    }
}
