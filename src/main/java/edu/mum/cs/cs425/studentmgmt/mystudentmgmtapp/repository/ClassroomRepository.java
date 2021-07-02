package edu.mum.cs.cs425.studentmgmt.mystudentmgmtapp.repository;

import edu.mum.cs.cs425.studentmgmt.mystudentmgmtapp.model.Classroom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends CrudRepository<Classroom, Long> {
	
}
