package com.alialsubhi.jaspercronmailing.Repository;

import com.alialsubhi.jaspercronmailing.Models.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark,Long> {
}
