package com.example.makeMyTrip;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Places,String> {
    @Query(value = "select * from Places where source=?1 and destination=?2",nativeQuery = true)
    Places findBySourceAndDestination(String source, String destination);
}
