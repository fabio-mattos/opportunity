package com.fabiomattos.opportunity.service;

import com.fabiomattos.opportunity.exception.AreaLimitReachedException;
import com.fabiomattos.opportunity.exception.CommandInvalidException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class MarsServiceTest {

    @Autowired
    private MarsService marsService;

    @Test
    public void shouldCalculateWhenPassSimpleCommands() throws Exception {
        var commands = "MRM";

        var robot = marsService.calculatePosition(commands);

        assertThat(robot.getX()).isEqualTo(1);
        assertThat(robot.getY()).isEqualTo(1);
        assertThat(robot.getDirection()).isEqualTo("E");
    }

    @Test
    public void shouldAreaLimitReachedExceptionWhenPassingOnMaxArea() {
        var commands = "MMMMMM";

        AreaLimitReachedException thrown = assertThrows(
                AreaLimitReachedException.class,
                () -> marsService.calculatePosition(commands));

        assertNotNull(thrown);
    }

    @Test
    public void shouldAreaLimitReachedExceptionWhenPassingOnMinArea() {
        var commands = "MLM";

        AreaLimitReachedException thrown = assertThrows(
                AreaLimitReachedException.class,
                () -> marsService.calculatePosition(commands));

        assertNotNull(thrown);
    }

    @Test
    public void shouldCommandInvalidExceptionWhenPassInvalidCommand() {
        var commands = "MMMMAMMMM";

        CommandInvalidException thrown = assertThrows(
                CommandInvalidException.class,
                () -> marsService.calculatePosition(commands));

        assertNotNull(thrown);
    }

    @Test
    public void shouldPositionCenterAreaWhenPassThisCommand() throws Exception {
        var commands = "MMRMM";

        var robot = marsService.calculatePosition(commands);

        assertThat(robot.getX()).isEqualTo(2);
        assertThat(robot.getY()).isEqualTo(2);
        assertThat(robot.getDirection()).isEqualTo("E");
    }

    @Test
    public void shouldWalkBorderAreaWhenPassThisCommand() throws Exception {
        var commands = "MMMMRMMMMRMMMMRMMM";

        var robot = marsService.calculatePosition(commands);

        assertThat(robot.getX()).isEqualTo(1);
        assertThat(robot.getY()).isEqualTo(0);
        assertThat(robot.getDirection()).isEqualTo("W");
    }

}
