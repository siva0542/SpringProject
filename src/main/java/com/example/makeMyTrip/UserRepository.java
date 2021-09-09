package com.example.makeMyTrip;

import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserDetails,Integer> {
    @Query(value = "select * from User_Details where name=?1 and password=?2",nativeQuery = true)
    UserDetails findByLoginAndPassword(String username, String password);

  //  @Query(value = "select card_number from User_Details where card_number=?1",nativeQuery = true)
   // UserDetails findByCard_number(String card_number);

    @Query(value = "select name from User_Details where name=?1",nativeQuery = true)
    UserDetails findByName(String name);

    @Query(value = "select * from User_Details where card_number=?1",nativeQuery = true)
    UserDetails findByCard_number(String card_number);

    //UserDetails findByLoginAndPassword(String name,String password);

}
