package chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID;
        int metCounts = getMetCriteriaCounts(s);

//        boolean lengthEnough = s.length() >= 8;
//        if (lengthEnough) metCounts++;
//        boolean containsNum = meetsContainingNumberCriteria(s);
//        if (containsNum) metCounts++;
//        boolean containsUpp = meetsContainingUppercaseCriteria(s);
//        if (containsUpp) metCounts++;

        if (metCounts <= 1) return PasswordStrength.WEAK;
//        if (lengthEnough && !containsNum && !containsUpp) {
//            return PasswordStrength.WEAK;
//        }
//        if (!lengthEnough && containsNum && !containsUpp) {
//            return PasswordStrength.WEAK;
//        }
//        if (!lengthEnough && !containsNum && containsUpp) {
//            return PasswordStrength.WEAK;
//        }

        if (metCounts == 2) return PasswordStrength.NORMAL;
//        if (!lengthEnough) {
//            return PasswordStrength.NORMAL;
//        }
//        if (!containsNum) return PasswordStrength.NORMAL;
//        if (!containsUpp) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String s) {
        int metCounts = 0;
        if (s.length() >= 8) metCounts++;
        if (meetsContainingNumberCriteria(s)) metCounts++;
        if (meetsContainingUppercaseCriteria(s)) metCounts++;
        return metCounts;
    }

    private boolean meetsContainingNumberCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUppercaseCriteria(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
}
