package knusprigerschweinsbraten.regtech.jobinterview;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;

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
        final Map<String, CourseRegistration> latestRegistrationsPerName = registrations.stream()
                .collect(toMap(CourseRegistration::getCourseParticipant, Function.identity(), new TakeLatestRegistrationMergeFunction()));
        return latestRegistrationsPerName.entrySet().stream()
                .filter(entry -> entry.getValue().isEnrolled())
                .map(Map.Entry::getKey)
                .collect(toList());
    }

    /**
     * @author stefan.pachler
     * @since 0.0.1
     */
    private static class TakeLatestRegistrationMergeFunction implements BinaryOperator<CourseRegistration> {
        @Override
        public CourseRegistration apply(CourseRegistration oldOne, CourseRegistration newOne) {
            if (oldOne.getRegistrationDate().isBefore(newOne.getRegistrationDate())) {
                return newOne;
            }
            return oldOne;
        }
    }
}
