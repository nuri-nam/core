package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemeberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //@Bean memberService -> new MemoryMemeberRepository()
    //@Bean orderService -> new MemoryMemeberRepository()  싱글톤이 깨지는 것...?

   @Bean    //spring container에 등록
   public MemberService memberService(){                    //MemberService 역할
       return new MemberServiceImpl(memberRepository());    //구현 클래스
   }

   @Bean
   public MemberRepository memberRepository() {    //MemberRepository 역할
        return new MemoryMemeberRepository();        //구현 클래스
    }

   @Bean
   public OrderService orderService() {                                    //OrderService 역할
       return new OrderServiceImpl(memberRepository(), discountPolicy());   //구현 클래스
   }

   @Bean
   public DiscountPolicy discountPolicy() {    //DiscountPolicy 역할
//       return new FixDiscountPolicy();          //구현 클래스
       return new RateDiscountPolicy();
   }
}
