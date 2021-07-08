package knusprigerschweinsbraten.regtech.jobinterview;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static knusprigerschweinsbraten.regtech.jobinterview.StaticCourseRegistrations.ALL_REGISTRATION_EVENTS;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseRegistrationEvaluatorImplTest {
    private final CourseRegistrationEvaluator classUnderTest = new CourseRegistrationEvaluatorImpl();

    @Test
    void tryingToFindAllParticipants() {
        final List<String> result = classUnderTest.findAllParticipants(ALL_REGISTRATION_EVENTS);
        assertTrue(result.containsAll(Arrays.asList("Martin", "Stefan")));
    }
}
