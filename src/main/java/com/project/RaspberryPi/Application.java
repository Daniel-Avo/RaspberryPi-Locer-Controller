package com.project.RaspberryPi;

import com.pi4j.io.gpio.*;

public class Application {

    private static GpioPinDigitalOutput pin = null;

    public static void main(String[] args) throws InterruptedException {

        greeting();
        light();
    }

    public static String greeting() {
        return "Hello world!";
    }

    public static void light() throws InterruptedException {
        if (pin == null) {
            GpioController gpio = GpioFactory.getInstance();
            pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "LED", PinState.LOW);
        }

        for (;;){
            Thread.sleep(1000);
            pin.toggle();
        }

    }
}

