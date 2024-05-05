package org.example.University;

public enum StudyProfile {

    MEDICINE("Медицина"),
    IT("Информационные технологии"),
    ENGINEERING("Инженерия");

    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }

}
