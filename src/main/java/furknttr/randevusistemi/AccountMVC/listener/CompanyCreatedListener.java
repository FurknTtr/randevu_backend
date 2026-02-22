package furknttr.randevusistemi.AccountMVC.listener;

import furknttr.randevusistemi.AccountMVC.model.entity.Member;
import furknttr.randevusistemi.AccountMVC.repository.MemberRepository;
import furknttr.randevusistemi.Contracts.CompanyEvents.CompanyCreatedEvent;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompanyCreatedListener {

    final MemberRepository memberRepository;

    @EventListener
    public void handleCompanyCreated(CompanyCreatedEvent event){
        Member member = memberRepository.findById(event.ownerMemberId())
                .orElseThrow(() -> new EntityNotFoundException("Üye bulunamadı"));

        member.setHasCompany(true);
        memberRepository.save(member);
    };
}
