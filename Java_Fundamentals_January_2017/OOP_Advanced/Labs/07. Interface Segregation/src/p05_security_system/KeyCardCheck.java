package p05_security_system;

public class KeyCardCheck extends SecurityCheck {

    private KeyCardUI cardUI;

    public KeyCardCheck(SecurityUI securityUI) {
        this.cardUI = securityUI;
    }

    @Override
    public boolean validateUser() {
        String code = cardUI.requestKeyCard();
        if (isValid(code)) {
            return true;
        }

        return false;
    }

    private boolean isValid(String code) {
        return true;
    }
}
