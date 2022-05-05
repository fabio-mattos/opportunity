package com.fabiomattos.opportunity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Robot {
    int x;
    int y;
    String direction;

    @Override
    public String toString() {
        return String.format("(%S, %S, %S)", x, y, direction);
    }
}
