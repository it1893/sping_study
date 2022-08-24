package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // 맞는지 검증
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByType2() {
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // 맞는지 검증
        // 역할과 구현에서는 역할에 의존해야 한다.
        // 구현에 의존하는 것은 좋지 않다.
        // MemberServiceImpl에 의존하는 것은 구현에 의존하는 것이기 때문에 좋지 않다.
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX(){
        // ac.getBean("xxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, // 이 예외가 터져야 한다.
                () -> ac.getBean("xxxxx", MemberService.class)); // 이 로직을 실행하면
    }
}
