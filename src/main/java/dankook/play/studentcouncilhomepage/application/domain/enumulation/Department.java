package dankook.play.studentcouncilhomepage.application.domain.enumulation;

public enum Department {
    COMPUTER_ENGINEERING("컴퓨터공학과");

    private final String name;

    Department(String name) {
        this.name = name;
    }

    public static Department of(String department) {
        return COMPUTER_ENGINEERING;
    }

    public String getName() {
        return name;
    }
}
