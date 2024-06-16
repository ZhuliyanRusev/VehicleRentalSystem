Greetings! This is a quick explanation about the task and how I have come to the decision of it.
Firstly, I created 3 classes - Car, Motorcycle and CargoVan that inherit a Vehicle abstract class. 
I also created an Invoice that has  one field - RentalInfo object, and a method "display" that displays the needed invoice for a concrete vehicle
Inside the RentalInfo class is mostly the business logic, for example I get the days between the start of the reservation and the end of the reservation with ChronoUnit enum.
In the main class I create the desired vehicle with polymorphism, then I create a rentalInfo that accepts a vehicle for one of its parameters and through the 
Invoice object I display the results.