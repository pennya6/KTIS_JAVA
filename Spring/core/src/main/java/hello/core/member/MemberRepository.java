package hello.core.member;

public interface MemberRepository {
    //저장하기
    void save(Member member);
    //멤버 찾기
    Member findById(Long memberId);
}
