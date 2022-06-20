package dankook.play.studentcouncilhomepage.domain.auth;

import dankook.play.studentcouncilhomepage.domain.auth.infra.UserInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class AuthenticationPrincipalConfig implements WebMvcConfigurer {

    private final JwtService jwtService;
    private final TokenProvider tokenProvider;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(createJwtAuthArgumentResolver());
    }

    @Bean
    public JwtAuthArgumentResolver createJwtAuthArgumentResolver() {
        return new JwtAuthArgumentResolver(jwtService);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor(tokenProvider))
                .addPathPatterns("/users/**");
    }
}
