package org.example.book.dao.repository;

import org.example.book.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    @Query(value = "select * from student where active_balance between :minbalance and :maxbalance", nativeQuery = true)
    List<StudentEntity> findByBalanceBetween(@Param("minbalance") Integer minbalance, @Param("maxbalance") Integer maxbalance);
    @Query(value ="select * from student where first_name = :name",nativeQuery = true)
    List<StudentEntity> findByName(@Param ("name") String name);
}
