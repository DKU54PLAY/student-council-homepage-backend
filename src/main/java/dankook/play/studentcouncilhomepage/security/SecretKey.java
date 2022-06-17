package dankook.play.studentcouncilhomepage.security;

import lombok.Getter;

@Getter
public class SecretKey {

    private final String jwtSecretKey;
    private final Long jwtValidTime;
    private final Long refreshValidTime;

    public SecretKey(String jwtSecretKey, Long jwtValidTime, Long refreshValidTime) {
        this.jwtSecretKey = jwtSecretKey;
        this.jwtValidTime = jwtValidTime;
        this.refreshValidTime = refreshValidTime;
    }
}
