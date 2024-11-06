package dasturlash.uz.сontroller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/test")
@RestController
public class TestController {

    @RequestMapping(value = "/time",method = RequestMethod.GET)
    public LocalDateTime currentTime(){
        return LocalDateTime.now();
    }

    @RequestMapping("/greating/{nameP}")
    public String greating(@PathVariable("nameP") String name){
        return "Salom "+ name+". Bormisan jgar.";
    }

    @RequestMapping("/detail/{name}/{surname}/{age}")
    public String getDetail(@PathVariable("name") String name,
                            @PathVariable("surname") String surname,
                            @PathVariable("age") Integer age){
        return "Salom. Your Details: name: "+name+", surname: "+surname+", age: "+age;
    }
}
