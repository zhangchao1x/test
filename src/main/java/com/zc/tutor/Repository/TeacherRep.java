package com.zc.tutor.Repository;

import com.zc.tutor.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRep extends JpaRepository<Teacher,Integer> {
     Teacher findByPhoneAndTid(Integer tid,String phone);
     Teacher findByTid(Integer tid);
     List<Teacher> findAll();
     boolean deleteTeacherByTid (Integer tid);
}
