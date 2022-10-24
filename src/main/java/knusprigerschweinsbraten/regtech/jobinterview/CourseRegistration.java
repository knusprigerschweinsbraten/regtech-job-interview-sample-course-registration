package knusprigerschweinsbraten.regtech.jobinterview;

import java.time.LocalDate;

/**
 * Plain vanilla Java object holding the status of a registration.
 *
 * @author juergen.windhaber
 * @author stefan.pachler
 * @since 0.0.1
 */
public class CourseRegistration {
    private final String courseParticipant;
    private final RegistrationStatus registrationStatus;
    private final LocalDate registrationDate;

    private CourseRegistration(String courseParticipant, RegistrationStatus registrationStatus, LocalDate RegistrationDate) {
        this.courseParticipant = courseParticipant;
        this.registrationStatus = registrationStatus;
        this.registrationDate = RegistrationDate;
    }

    public String getCourseParticipant() {
        return courseParticipant;
    }

    public boolean isEnrolled() {
        return RegistrationStatus.ENROLLED == registrationStatus;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public String toString() {
        return "CourseRegistration{" +
                "courseParticipant='" + courseParticipant + '\'' +
                ", registrationStatus=" + registrationStatus +
                ", registrationDate=" + registrationDate +
                '}';
    }

    /**
     * Enumeration containing the possible options a participant has in order to register for a course.
     *
     * @author juergen.windhaber
     * @author stefan.pachler
     * @since 0.0.1
     */
    private enum RegistrationStatus {
        ENROLLED, DISENROLLED
    }

    /**
     * Plain vanilla Java object used for declaring that a person will participate in a course.
     *
     * @author stefan.pachler
     * @since 0.0.2
     */
    static class Enrollment extends CourseRegistration {
        Enrollment(String courseParticipant, String registrationDate) {
            super(courseParticipant, RegistrationStatus.ENROLLED, LocalDate.parse(registrationDate));
        }
    }

    /**
     * Plain vanilla Java object used for declaring that a person will not participate in a course.
     *
     * @author stefan.pachler
     * @since 0.0.2
     */
    static class Disenrollment extends CourseRegistration {
        Disenrollment(String courseParticipant, String registrationDate) {
            super(courseParticipant, RegistrationStatus.DISENROLLED, LocalDate.parse(registrationDate));
        }
    }
}
