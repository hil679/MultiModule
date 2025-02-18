package dev.be.moduleapi.service;

import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.repositories.MemberRepository;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {
//    private final CommonDemoService commonDemoService;
    @Value("${profile-name}") // import springframework.beans, not lombok
    private String name;
    private final MemberRepository memberRepository;
    public String save() {
        System.out.println(name);

        // profile 별 분기
        if (name.equals("local")) {
            // local logic
        } else if (name.equals("beta")) {
            // beta logic
        }
        memberRepository.save(Member
                .builder()
                .name(Thread.currentThread().getName())
                .build());
        return "Save";
    }

    public String find() {
        int size = memberRepository.findAll().size();
        System.out.println(size);
        return "find";
    }
}
