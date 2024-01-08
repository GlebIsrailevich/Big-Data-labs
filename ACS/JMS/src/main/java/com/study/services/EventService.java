package com.study.services;

import com.study.models.Event;
import com.study.models.EventType;
import com.study.repos.DormitoryRepository;
import com.study.repos.EventRepository;
import com.study.repos.RoomRepository;
import com.study.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    EventRepository eventRepository;

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    DormitoryRepository dormitoryRepository;
    @Autowired
    StudentRepository studentRepository;
    private Integer getIdFromEntity(Event event){
        return Integer.valueOf(event.getEntity().substring(event.getEntity().indexOf("=") + 1,
                event.getEntity().indexOf(",")));
    }

    private Event getExistingEvent(Event event){
        var events = eventRepository.findAll();
        var id = getIdFromEntity(event);

        var object = switch (event.getModel()) {
            case Room -> roomRepository.findById(id);
            case Dormitories -> dormitoryRepository.findById(id);
            case Student -> studentRepository.findById(id);
        };

        for (var event_ : events) {
            if (getIdFromEntity(event_).equals(id)) {
                event_.setEntity(object.toString());
                event_.setEventType(event.getEventType());
                return event_;
            }
        }
        return null;
    }
    public void save(Event event) {
        System.out.println(event);
        var event_ = getExistingEvent(event);
        System.out.println(event_);
        if (event_ == null){
            eventRepository.save(event);
            return;
        }

        eventRepository.save(event_);
    }
}