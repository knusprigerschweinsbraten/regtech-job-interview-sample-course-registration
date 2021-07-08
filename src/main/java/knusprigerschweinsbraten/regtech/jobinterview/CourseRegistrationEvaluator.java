package knusprigerschweinsbraten.regtech.jobinterview;

import java.util.List;

/**
 * Evaluates which people are currently participating in a course.
 *
 * As a course participant I can register to a course but I am also allowed to cancel whenever I want.
 * After a cancellation I can also register again, and so on and so forth.
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
