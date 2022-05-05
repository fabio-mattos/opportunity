package com.fabiomattos.opportunity.controller;

import com.fabiomattos.opportunity.model.Robot;
import com.fabiomattos.opportunity.service.MarsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MarsControllerTest {

    @Autowired
    private MarsController marsController;

    @MockBean
    private MarsService marsService;

    @Test
    public void shouldCallServiceWhenCalculatePosition() throws Exception {
        var expectedRobot = new Robot(1,4, "S");
        var commands = "MRMMRMLMMM";
        when(marsService.calculatePosition(commands)).thenReturn(expectedRobot);

        var response = marsController.calculatePosition(commands);

        verify(marsService, times(1)).calculatePosition(commands);
        assertThat(response.getBody()).isEqualTo(expectedRobot);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
