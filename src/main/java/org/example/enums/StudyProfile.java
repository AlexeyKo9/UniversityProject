package org.example.enums;

public enum StudyProfile {

    MEDICINE("Медицина"),
    IT("Информационные технологии"),
    ENGINEERING("Инженерия"),
    LINGUISTICS("Лингвистика"),
    PHYSICS("Физика"),
    MATHEMATICS("Математика");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
