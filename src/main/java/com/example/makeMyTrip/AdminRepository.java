package com.example.makeMyTrip;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin,Integer> {
    @Query(value = "select * from Admin where username=?1 and password=?2",nativeQuery = true)
    Admin findByLoginAndPassword(String username, String password);
}
