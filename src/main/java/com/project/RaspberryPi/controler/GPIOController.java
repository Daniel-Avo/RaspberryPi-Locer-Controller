package com.project.RaspberryPi.controler;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;

public class GPIOController {

    private static GpioPinDigitalOutput pin = null;

    @RequestMapping("/")
    public String greeting(){
        return "Hello world!";
    }

    @RequestMapping("/light")
    public String light(){
        if (pin == null){
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "LED", PinState.LOW);
        }

        pin.toggle();

        return "OK";
    }
}
