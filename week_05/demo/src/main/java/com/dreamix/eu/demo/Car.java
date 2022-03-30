package com.dreamix.eu.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
    private RadioStation radioStation;

    @Autowired
    public Car(RadioStation radioStation) {
        this.radioStation = radioStation;
    }

    @Autowired
    @Qualifier("radioStationRock")
    public void setRadioStation(RadioStation radioStation) {
        this.radioStation = radioStation;
    }

    public RadioStation getRadioStation() {
        return radioStation;
    }

    public void listenToRadio() {
        radioStation.playStation();
    }
}
