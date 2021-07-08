package knusprigerschweinsbraten.regtech.jobinterview;

import knusprigerschweinsbraten.regtech.jobinterview.CourseRegistration.Disenrollment;
import knusprigerschweinsbraten.regtech.jobinterview.CourseRegistration.Enrolment;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseRegistrationEvaluatorImplTest {
    private final CourseRegistrationEvaluator classUnderTest = new CourseRegistrationEvaluatorImpl();

    @Test
    void tryingToFindAllParticipants() {
        final List<CourseRegistration> registrations = Arrays.asList(
                new Enrolment("Stefan", "2018-01-01"),
                new Enrolment("Isabella", "2018-02-03"),
                new Enrolment("Martin", "2017-01-02"),
                new Disenrollment("Stefan", "2016-12-13"),
                new Disenrollment("Isabella", "2018-02-04"));

        final List<String> result = classUnderTest.findAllParticipants(registrations);

        assertTrue(result.containsAll(Arrays.asList("Martin", "Stefan")));
    }
}
