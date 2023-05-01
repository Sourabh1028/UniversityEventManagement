package com.geekster.UniversityEventManagement.Controller;

import com.geekster.UniversityEventManagement.Model.Event;
import com.geekster.UniversityEventManagement.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping("/date/{date}")
    public Iterable<Event> getByDate(@PathVariable LocalDate date){
        return eventService.getEventsByDate(date);
    }

    @PostMapping("/")
    public String addEvents(@RequestBody List<Event> eventList){
        return eventService.addEvents(eventList);
    }

    @PutMapping("/{id}")
    public void updateEvent(@PathVariable Integer id, @RequestBody Event event){
        eventService.updateEvent(id, event);
    }

    @DeleteMapping("/{id}")
    public void deleteEventById(@PathVariable Integer id){
        eventService.deleteById(id);
    }
}

