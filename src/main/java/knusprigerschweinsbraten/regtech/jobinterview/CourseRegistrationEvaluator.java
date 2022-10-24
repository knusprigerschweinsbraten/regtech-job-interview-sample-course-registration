package knusprigerschweinsbraten.regtech.jobinterview;

import java.util.List;

/**
 * Evaluates which people are currently participating in a course.
 *
 * As a course participant I can enroll to a course, but I am also allowed to disenroll whenever I want.
 * After a disenrollment I can also enroll again, and so on and so forth.
 *
 * The current registration is the chronologically last registration a course participant sent.
 *
 * A participant is a person who is eventually enrolled for a course.
 *
 * @author stefan.pachler
 * @since 0.0.2
 */
public interface CourseRegistrationEvaluator {
    List<String> findAllParticipants(List<CourseRegistration> registrations);
}
