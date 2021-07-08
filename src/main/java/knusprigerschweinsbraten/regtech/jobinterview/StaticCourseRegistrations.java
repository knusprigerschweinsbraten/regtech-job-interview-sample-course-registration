package knusprigerschweinsbraten.regtech.jobinterview;

import java.util.Arrays;
import java.util.List;

public final class StaticCourseRegistrations {
    public static final List<CourseRegistration> ALL_REGISTRATION_EVENTS = Arrays.asList(
            new CourseRegistration.Enrolment("Stefan", "2018-01-01"),
            new CourseRegistration.Enrolment("Isabella", "2018-02-03"),
            new CourseRegistration.Enrolment("Martin", "2017-01-02"),
            new CourseRegistration.Disenrollment("Stefan", "2016-12-13"),
            new CourseRegistration.Disenrollment("Isabella", "2018-02-04"));

    private StaticCourseRegistrations() {
    }
}
