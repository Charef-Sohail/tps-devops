package com.enset.aspects;

public class SecurityContext {
    private static String currentRole = "GUEST";

    public static void authenticate(String username, String password, String role) {
        if (username.equals("root") && password.equals("1234")) {
            currentRole = role;
        } else {
            throw new RuntimeException("Échec de l'authentification.");
        }
    }

    public static boolean hasRole(String role) {
        return currentRole.equals(role);
    }
}
