package dankook.play.studentcouncilhomepage.domain.user.entity.enumulation;

public enum Department {
    TEST("테스트"),
    COMPUTER_ENGINEERING("컴퓨터공학과");

    private final String name;

    Department(String name) {
        this.name = name;
    }

    public static Department of(String department) {
        return TEST;
    }

    public String getName() {
        return name;
    }    
}
