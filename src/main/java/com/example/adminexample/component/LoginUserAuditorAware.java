package com.example.adminexample.component;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@EnableJpaAuditing  // JPA Auditing 활성화 --> 이게 없어서 계속 에러가 났었음
public class LoginUserAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("AdminServer");
        // 무언갈 생성하거나 업데이트 할 떄 어떤 사용자가 생성했는지에 대한 정보를 넣어줘야 하는데,
        // 현재는 임시로 AdminServer라는 문자열을 넣어줌

    }
}

