package knusprigerschweinsbraten.regtech.jobinterview;

import knusprigerschweinsbraten.regtech.jobinterview.CourseRegistration.Disenrollment;
import knusprigerschweinsbraten.regtech.jobinterview.CourseRegistration.Enrollment;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseRegistrationEvaluatorImplTest {
    private final CourseRegistrationEvaluator classUnderTest = new CourseRegistrationEvaluatorImpl();

    @Test
    void tryingToFindAllParticipants() {
        final List<CourseRegistration> registrations = Arrays.asList(
                new Enrollment("Stefan", "2018-01-01"),
                new Enrollment("Isabella", "2018-02-03"),
                new Enrollment("Martin", "2017-01-02"),
                new Disenrollment("Stefan", "2016-12-13"),
                new Disenrollment("Isabella", "2018-02-04"));

        final List<String> result = classUnderTest.findAllParticipants(registrations);

        assertEquals(result.size(), 2);
        assertTrue(result.containsAll(Arrays.asList("Martin", "Stefan")));
    }
}
