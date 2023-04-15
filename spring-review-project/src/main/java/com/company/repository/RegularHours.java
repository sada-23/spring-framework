package com.company.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@Qualifier("RH")
public class RegularHours implements HoursRepository{
    @Override
    public int getHours() {
        return 40;
    }
}
