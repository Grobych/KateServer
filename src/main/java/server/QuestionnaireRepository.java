package server;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionnaireRepository extends MongoRepository<Questionnaire, String> {
    public Questionnaire findByQuestion1(String question1);
}
