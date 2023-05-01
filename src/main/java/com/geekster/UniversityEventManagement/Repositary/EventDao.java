package com.geekster.UniversityEventManagement.Repositary;

import com.geekster.UniversityEventManagement.Model.Event;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface EventDao extends CrudRepository<Event, Integer> {
    public Iterable<Event> findAllEventByDate(LocalDate date);
}
