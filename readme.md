# Challenge 1: Gym Reservation and Event Schedule Simulator

## Features

This program simulates a reservation system at a gym. The program can display a schedule, add events to the schedule, RSVP to events, rent equipment, play sports games with 10 people, and handle memberships. It also includes two sample schedule files, ``Schedule.txt``, the default one, and ``CustomSchedule.txt``, a custom one.

## About the Code

This project was made for Challenge 1 in CSC109 by Group 4. This group consists of Michael Merritt, Alex Santeramo, Rom Wasserman, and Howard Byrd.

## How to Run

Clone this repository, open it in your IDE of choice, and then run ``Driver.java``.

To run the program using only the command line, navigate to the src folder in Challenge-1 and run the following commands:

```
javac Driver.java
java Driver
```

## Expected Output

The program will only use one schedule and handle one task. Here is a sample run of the program.

```
Welcome! Do you have a custom schedule? (yes/no)
> yes
What is the name of the custom schedule file?
> CustomSchedule.txt
Here is the schedule:
Tuesday, March 2
11:00 AM: Basketball at Gym
2:00 PM: Basketball at Gym

Please type the number for the option you would like to do.
1. Schedule reservation
2. RSVP to an event or rent equipment
3. Play a sport
4. Schedule another event
5. Get a membership
> 1
What hour would you like to reserve the Gym for? (1-12)
> 5
Would you like the reservation at 5 AM or 5 PM? (AM/PM)
> PM
What are you scheduling with this reservation? (example: "Basketball")
> Soccer
Thank you for visiting! If you have more concerns, please run the program again.
```

If you want to perform multiple tasks, run the program again and follow the instructions given during runtime for each task.
