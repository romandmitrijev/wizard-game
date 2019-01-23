package com.wizard;

/**
 * Validate name
 * Validate surname
 */

public class CharacterCreation {
    public boolean validateName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            System.out.println("First name is not suitable you didn't enter any name");
            return false;
        }
        if (firstName.contains(" ")) {
            System.out.println("First name must not contain any space");
        }
        String filteredName = eraseNonLetter(firstName);
        if (!filteredName.equalsIgnoreCase(filteredName)) {
            System.out.println("First name is not suitable. Only letters allowed");
            return false;
        }
        return true;
    }

    public boolean validateSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            System.out.println("First name is not suitable you didn't enter any name");
            return false;
        }
        String filteredName = eraseNonLetter(surname);
        if (!filteredName.equalsIgnoreCase(filteredName)) {
            System.out.println("First name is not suitable. Only letters allowed");
            return false;
        }
        return true;

    }

    private String eraseNonLetter(String word) {
        String result = word.replaceAll("\\d", "");
        result = result.replaceAll("\\p{Punct}", "");
        return result;
    }

}
