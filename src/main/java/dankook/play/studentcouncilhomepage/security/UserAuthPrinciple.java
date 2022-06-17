package dankook.play.studentcouncilhomepage.security;

import dankook.play.studentcouncilhomepage.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
public class UserAuthPrinciple implements UserDetails, OAuth2User {

    private final User user;
    private Map<String, Object> attributes;

    public static UserAuthPrinciple create(User user) {
        return new UserAuthPrinciple(user);
    }

    public static UserAuthPrinciple create(User user, Map<String, Object> attributes) {
        UserAuthPrinciple userAuthPrinciple = UserAuthPrinciple.create(user);
        userAuthPrinciple.setAttributes(attributes);
        return userAuthPrinciple;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        TODO: User 권한 목록이 아직 정해지지 않음
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return null;
    }
}
