package com.fabiomattos.opportunity.service;

import com.fabiomattos.opportunity.exception.AreaLimitReachedException;
import com.fabiomattos.opportunity.exception.CommandInvalidException;
import com.fabiomattos.opportunity.model.Robot;
import org.springframework.stereotype.Component;

@Component
public class MarsService {
    private static final int LIMIT_AREA_MAX = 4;
    private static final int LIMIT_AREA_MIN = 0;
    public Robot calculatePosition(String commands) throws Exception {
        char[] commandsArray = commands.toCharArray();

        Robot robot = new Robot(0,0,"N");

        for (char command : commandsArray){
            switch(command) {
                case 'M':
                    this.move(robot);
                    break;
                case 'L':
                    this.rotateLeft(robot);
                    break;
                case 'R':
                    this.rotateRight(robot);
                    break;
                default:
                    throw new CommandInvalidException();
            }
        }

        return robot;
    }

    private void move(Robot robot) throws Exception {
        switch (robot.getDirection()) {
            case "N":
                if (robot.getY() == LIMIT_AREA_MAX)
                    throw new AreaLimitReachedException();
                robot.setY(robot.getY() + 1);
                break;
            case "S":
                if (robot.getY() == LIMIT_AREA_MIN)
                    throw new AreaLimitReachedException();
                robot.setY(robot.getY() - 1);
                break;
            case "W":
                if (robot.getX() == LIMIT_AREA_MIN)
                    throw new AreaLimitReachedException();
                robot.setX(robot.getX() - 1);
                break;
            case "E":
                if (robot.getX() == LIMIT_AREA_MAX)
                    throw new AreaLimitReachedException();
                robot.setX(robot.getX() + 1);
                break;
        }
    }

    private void rotateLeft(Robot robot) {
        switch (robot.getDirection()){
            case "N":
                robot.setDirection("W");
                break;
            case "W":
                robot.setDirection("S");
                break;
            case "S":
                robot.setDirection("E");
                break;
            case "E":
                robot.setDirection("N");
                break;
        }
    }

    private void rotateRight(Robot robot) {
        switch (robot.getDirection()){
            case "N":
                robot.setDirection("E");
                break;
            case "E":
                robot.setDirection("S");
                break;
            case "S":
                robot.setDirection("W");
                break;
            case "W":
                robot.setDirection("N");
                break;
        }
    }
}
