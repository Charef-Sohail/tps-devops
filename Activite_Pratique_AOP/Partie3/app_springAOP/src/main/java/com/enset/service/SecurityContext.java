package com.enset.service;

public class SecurityContext {
    private static String username = "";
    private static String password = "";
    private static String[] roles = {};

    public static void authenticate(String u, String p, String[] r) {
        if (u.equals("root") && p.equals("1234")) {
            username = u;
            password = p;
            roles = r;
        } else {
            throw new RuntimeException("Accès refusé ! Mauvais identifiants.");
        }
    }

    public static boolean hasRole(String role) {
        for (String r : roles) {
            if (r.equals(role)) {
                return true;
            }
        }
        return false;
    }
}
