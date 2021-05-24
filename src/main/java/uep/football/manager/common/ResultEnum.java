package uep.football.manager.common;

public enum ResultEnum {

    WIN("Win"),DEFEAT("Defeat"),DRAW("Draw");

    ResultEnum(String value) {
        this.value = value;
    }

    private final String value;

    public String value()
    {
        return value;
    }

}
