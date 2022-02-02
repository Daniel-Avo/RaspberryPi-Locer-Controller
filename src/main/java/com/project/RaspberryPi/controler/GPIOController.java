package com.project.RaspberryPi.controler;

import com.pi4j.io.gpio.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GPIOController {

    private static GpioPinDigitalOutput pin = null;

    @RequestMapping("/unlock")
    public String unlock() throws InterruptedException {
        if (pin == null){
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "LED", PinState.LOW);
        }

        pin.toggle();
        Thread.sleep(3000);
        pin.toggle();

        return "unlocked";
    }
}
