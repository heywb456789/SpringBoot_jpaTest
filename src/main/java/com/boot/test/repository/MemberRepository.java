package com.boot.test.repository;

import com.boot.test.vo.MemberVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<MemberVo,Long> {
    //비워져 있어도 작동한다
    //long 이 아니라 Long으로 작성 ex) int -> Integer 같이 primitive 형식 사용못한다.

    //findBy 뒤에 컬럼명을 붙여주면 이를 이요한 검색이 가능

    public List<MemberVo> findById(String id);

    public List<MemberVo> findByName(String name);

    //like 검색도 가능
    public List<MemberVo> findByNameLike(String keyword);
    /**
     * And => findByLastnameAndFirstname (EX. where x.lastname = ?1 and x.firstname = ?2)
     * Or => findByLastnameOrFirstname (EX. where x.lastname = ?1 or x.firstname = ?2)
     * Is, Equals => findByName,findByNameIs,findByNameEquals (EX. where x.name = 1?)
     * Between => findBySalBetween(EX. where x.sal between 1? and ?2)
     *
     */
}
