package work.icql.test.component;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    public static void main(String[] args) {
        test(() -> {
        });
    }

    public static void test(TestFunction f){

    }
}
