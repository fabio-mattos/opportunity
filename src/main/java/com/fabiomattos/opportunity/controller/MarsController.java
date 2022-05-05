package com.fabiomattos.opportunity.controller;

import com.fabiomattos.opportunity.model.Robot;
import com.fabiomattos.opportunity.service.MarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mars")
public class MarsController {

    @Autowired
    private MarsService marsService;

    @PostMapping(path = "/{commands}")
    public ResponseEntity<String> calculatePosition(@PathVariable String commands) throws Exception {
       Robot robot = marsService.calculatePosition(commands);
       return ResponseEntity.ok(robot.toString());
    }
}
