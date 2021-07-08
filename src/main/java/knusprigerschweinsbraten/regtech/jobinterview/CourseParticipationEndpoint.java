package knusprigerschweinsbraten.regtech.jobinterview;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static knusprigerschweinsbraten.regtech.jobinterview.StaticCourseRegistrations.ALL_REGISTRATION_EVENTS;

@RestController
public class CourseParticipationEndpoint {
    private final CourseRegistrationEvaluator evaluator;

    public CourseParticipationEndpoint(CourseRegistrationEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    @GetMapping(path = "/course-participants")
    public HttpEntity<List<String>> getCourseParticipants() {
        return ResponseEntity.ok().body(this.evaluator.findAllParticipants(ALL_REGISTRATION_EVENTS));
    }
}
