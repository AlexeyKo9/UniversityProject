package org.example.utillites;

import org.example.compare.*;
import org.example.enums.StudentComparatorEnum;
import org.example.enums.UniversityComparatorEnum;

public class ComparatorUtil {

    private ComparatorUtil() {
    }

    public static StudentComparator getStudentComparator(StudentComparatorEnum studentComparatorEnum) {

        switch (studentComparatorEnum) {

            case FULL_NAME:
                return new StudentFullNameComparator();
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case COURSE_NUM:
                return new StudentCourseNumberComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            default:
                return new StudentFullNameComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorEnum universityComparatorEnum) {

        switch (universityComparatorEnum) {

            case ID:
                return new UniversityIdComparator();
            case FULL_NAME:
                //noinspection DuplicateBranchesInSwitch
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case YEAR_FOUNDATION:
                return new UniversityYearComparator();
            case PROFILE:
                return new UniversityProfileComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }
}