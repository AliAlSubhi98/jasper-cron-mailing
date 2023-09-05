package com.alialsubhi.jaspercronmailing.Repository;

import com.alialsubhi.jaspercronmailing.Models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School,Long> {
}
