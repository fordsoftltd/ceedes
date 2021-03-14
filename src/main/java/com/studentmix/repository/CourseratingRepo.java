/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studentmix.repository;

import com.studentmix.model.Courserating;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author JIDEX
 */
public interface CourseratingRepo extends JpaRepository<Courserating,Integer>{
    @Query("select st from Courserating st where st.questionid.id=?1")
    List<Courserating> findByQuestionId(Integer id);
}
