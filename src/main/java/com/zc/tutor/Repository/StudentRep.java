package com.zc.tutor.Repository;

import com.zc.tutor.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRep extends JpaRepository<Student,Integer> {

     Student findByPhoneAndStuId(Integer sId,String phone);

     Student findByStuId(Integer sId);

     Student findByPhone(String phone);

     List<Student> findAll();

   /** @Query("SELECT U.password FROM Student U WHERE U.phone= ?1")
    public String studentFindByPhone(String phone);
*/
}
