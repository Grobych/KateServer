package server;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class MyController{

    @Autowired
    private QuestionnaireRepository repository;

    private final AtomicLong atomicLong = new AtomicLong();
    private final Random random = new Random();

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public void save(@RequestParam(value="json", defaultValue="") String json) {
        System.out.println("Saving... "+json);
        Questionnaire in = new Questionnaire(json);
        repository.save(in);
        System.out.println(in.getQuestion1());

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Questionnaire get(@RequestParam(value = "name", defaultValue = "test") String name){
        return repository.findByQuestion1(name);
    }

    @RequestMapping(value = "/promo", method = RequestMethod.GET)
    public @ResponseBody PromoCode promo(){
        return new PromoCode(atomicLong.incrementAndGet(),random.nextInt(1000000));
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody List<Questionnaire> getAllQuestionnaire(){
        System.out.println("Get all command...");
        List<Questionnaire> list = repository.findAll();
        System.out.println(list.size());
        return list;
    }

//    @RequestMapping("/")
//    public String index(){
//        System.out.println("Looking in the index controller.........");
//        return "index";
//    }

}