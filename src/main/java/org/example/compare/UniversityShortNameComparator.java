package org.example.compare;

import org.apache.commons.lang3.StringUtils;
import org.example.universitymanagement.University;

public class UniversityShortNameComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        return StringUtils.compare(o1.getShortName(), o2.getShortName());
    }
}
