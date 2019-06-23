package me.yujun.demospringmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

//    @RequestMapping(value = "/events", method = RequestMethod.GET)

    @Autowired
    EventService eventService;


    @GetMapping("/events")
    public String events(Model model) {
//        model.addAttribute("events", eventService.getEvents());
        return "events";
    }
}
