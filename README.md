# SeatBookingSystem

This Springboot Application is functional demo simulating a Seat Booking System having below features:
1) View of the threatre haing list of booked unbooked, booking in progress
2) Users can book the unbooked seat 

Postman collections for REST call can be found in resources.

Application assumes that there is a Payment system exists which is responsible for the Payemnt of a booking.
Once the payment is completes we update the same in our DB. I have wrttien a cron job which acts as stub for Payment system.

Also the Application lockes the seat for 10 mins after which it will be released. There is a cron job which runs every 10sec to release a locked seat which is not booked within 10 min.
