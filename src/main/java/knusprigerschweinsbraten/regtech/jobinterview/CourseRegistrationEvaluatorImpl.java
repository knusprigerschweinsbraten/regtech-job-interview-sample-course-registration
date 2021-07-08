package knusprigerschweinsbraten.regtech.jobinterview;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * @author juergen.windhaber
 * @author stefan.pachler
 * @since 0.0.1
 */
class CourseRegistrationEvaluatorImpl implements CourseRegistrationEvaluator {
    @Override
    public List<String> findAllParticipants(List<CourseRegistration> registrations) {
        // first of all go through all available registrations and take the latest one of each person
        final Collection<CourseRegistration> latestRegistrations = registrations.stream()
                .collect(toMap(CourseRegistration::getCourseParticipant, Function.identity(), maxBy(comparing(CourseRegistration::getRegistrationDate))))
                .values();

        // once we have all the latest registration entries we need to filter based on the status. So
        // everyone who is enrolled will be counted.
        return latestRegistrations.stream()
                .filter(CourseRegistration::isEnrolled)
                .map(CourseRegistration::getCourseParticipant)
                .collect(toList());
    }
}
