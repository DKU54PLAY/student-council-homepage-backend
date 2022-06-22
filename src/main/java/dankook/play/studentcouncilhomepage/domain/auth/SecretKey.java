package dankook.play.studentcouncilhomepage.domain.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SecretKey {

    private final String jwtSecretKey;
    private final Long jwtValidityTime;
    private final Long refreshValidTime;
}
