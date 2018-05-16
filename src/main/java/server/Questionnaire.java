package server;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.data.annotation.Id;

public class Questionnaire {
    @Id
    private String id;

    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;
    private String question6;
    private String question7;
    private String question8;
    private String question9;
    private String question10;
    private String question11;
    private String question12;
    private String question13;
    private String question14;
    private String question15;
    private String question16;

    public Questionnaire(){}

    public Questionnaire(String json){
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(json).getAsJsonObject();
        this.question1 = jsonObject.get("question1").getAsString();
        this.question2 = jsonObject.get("question2").getAsString();
        this.question3 = jsonObject.get("question3").getAsString();
        this.question4 = jsonObject.get("question4").getAsString();
        this.question5 = jsonObject.get("question5").getAsString();
        this.question6 = jsonObject.get("question6").getAsString();
        this.question7 = jsonObject.get("question7").getAsString();
        this.question8 = jsonObject.get("question8").getAsString();
        this.question9 = jsonObject.get("question9").getAsString();
        this.question10 = jsonObject.get("question10").getAsString();
        this.question11 = jsonObject.get("question11").getAsString();
        this.question12 = jsonObject.get("question12").getAsString();
        this.question13 = jsonObject.get("question13").getAsString();
        this.question14 = jsonObject.get("question14").getAsString();
        this.question15 = jsonObject.get("question15").getAsString();
        this.question16 = jsonObject.get("question16").getAsString();
    }

    public String getQuestion1() {
        return question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public String getQuestion4() {
        return question4;
    }

    public String getQuestion5() {
        return question5;
    }

    public String getQuestion6() {
        return question6;
    }

    public String getQuestion7() {
        return question7;
    }

    public String getQuestion8() {
        return question8;
    }

    public String getQuestion9() {
        return question9;
    }

    public String getQuestion10() {
        return question10;
    }

    public String getQuestion11() {
        return question11;
    }

    public String getQuestion12() {
        return question12;
    }

    public String getQuestion13() {
        return question13;
    }

    public String getQuestion14() {
        return question14;
    }

    public String getQuestion15() {
        return question15;
    }

    public String getQuestion16() {
        return question16;
    }
}
