package com.thoughtworks.tdd.Story2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Test2 {

    @Test
    public void should_return_ticket_when_park_a_car() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.parking(car);
        //then
        Assertions.assertNotNull(ticket);
    }


    @Test
    public void should_return_car_when_submit_a_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.parking(new Car(1));
        Car car = parkingBoy.redeemCar(ticket);

        //then
        Assertions.assertNotNull(car);
    }

    @Test
    public void should_return_carCount_when_park_cars() {
        //given
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        parkingBoy.parking(car1);
        parkingBoy.parking(car2);
        List<Car> carList = parkingLot.getCarList();
        //then
        Assertions.assertEquals(2,carList.size());
    }

    @Test
    public void should_return_correct_car_when_submit_a_ticket() {
        //given
        Car car1 = new Car(100);
        Car car2 = new Car(200);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket=parkingBoy.parking(car1);
        Ticket ticket1 = parkingBoy.parking(car2);
        Car car = parkingBoy.redeemCar(ticket1);

        //then
        Assertions.assertEquals(car2,car);
    }

    @Test
    public void should_return_null_when_do_not_submit_ticket() {
        //given
        Car car1 = new Car(200);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.parking(car1);
        Car car = parkingBoy.redeemCar(null);

        //then
        Assertions.assertNull(car);
    }

    @Test
    public void should_return_null_when_submit_error_ticket() {
        //given
        Car car1 = new Car(200);
        Ticket ticket = new Ticket(23);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket1 = parkingBoy.parking(car1);
        Car car = parkingBoy.redeemCar(ticket);

        //then
        Assertions.assertNull(car);
    }

    @Test
    public void should_return_null_when_ticket_is_invalidity() {
        //given
        Car car1 = new Car(200);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket car1Ticket = parkingBoy.parking(car1);
        Car car = parkingBoy.redeemCar(car1Ticket);
        Car car2 = parkingBoy.redeemCar(car1Ticket);

        //then
        Assertions.assertNull(car2);
    }

    @Test
    public void should_return_null_when_parking_lot_is_full_of_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for(int i=1;i<=10;i++){
            parkingBoy.parking(new Car(i));
        }
        Car car11 = new Car(11);

        //when
        Ticket ticket = parkingBoy.parking(car11);
        //then
        Assertions.assertNull(ticket);
    }

    @Test
    public void should_get_error_msg_when_ticket_is_invalidity() {
        //given
//        Car car1 = new Car(200);
        Ticket ticket = new Ticket(1);
        ticket.setValidity(false);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
//        Ticket car1Ticket = parkingBoy.parking(car1);
        parkingBoy.redeemCar(ticket);

        //then
        Assertions.assertEquals("Unrecognized parking ticket.",parkingBoy.getErrorMsg());
    }

    @Test
    public void should_get_error_msg_when_ticket_is_not_provide() {
        //given
        Car car1 = new Car(200);
        Ticket ticket = new Ticket(1);
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket car1Ticket = parkingBoy.parking(car1);
        parkingBoy.redeemCar(ticket);

        //then
        Assertions.assertEquals("Unrecognized parking ticket.",parkingBoy.getErrorMsg());
    }

    @Test
    public void should_get_error_msg_when_do_not_submit_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        parkingBoy.redeemCar(null);

        //then
        Assertions.assertEquals("Please provide your parking ticket.",parkingBoy.getErrorMsg());
    }

    @Test
    public void should_get_error_msg_when_parking_lot_is_full_of_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        for(int i=1;i<=10;i++){
            parkingBoy.parking(new Car(i));
        }
        Car car11 = new Car(11);

        //when
        parkingBoy.parking(car11);
        //then
        Assertions.assertEquals("Not enough position.",parkingBoy.getErrorMsg());
    }

}
