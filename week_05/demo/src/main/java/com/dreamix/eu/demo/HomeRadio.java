package com.dreamix.eu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HomeRadio {
    @Autowired
    @Qualifier("radioStationNews")
    private RadioStation radioStation;

    public void listenToMusicAtHome() {
        radioStation.playStation();
    }
}
