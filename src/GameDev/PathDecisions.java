package GameDev;

import java.util.Scanner;

public class PathDecisions
{
    // Path Decisions tree class provides a validation system to request and approve user choices
    // for selecting the next door to go through
    // Attributes
    int room1BodyCount = 0, room2BodyCount = 0, room3BodyCount = 0, room4BodyCount = 0,
            room5BodyCount = 0, room7BodyCount = 0, room8BodyCount = 0;
    int swordvisit = 0;
    int intPrevRoomNum, intCurrentRoomNum, intPlayerChoice, intRoomID;
    Scanner choiceIn;
    public PathDecisions()
    {}
    public int choosePath(int prevRoom, int currentRoom)
    {
        this.intPrevRoomNum = prevRoom;
        this.intCurrentRoomNum = currentRoom;
        // room 7 is the start location
        // room 1 has the exit door
        // room 6 has the sword
        // rooms 2 and 8 are dead ends
        if (intPrevRoomNum == 7)
        {

            // You are in room 4, choices of 3, 5, or back to 7
            System.out.println("Ok, the doors.  Should you go right or left?");
            System.out.println("You can go back too, but that's a dead end right?");
            System.out.println(" 1. - Left, 2. Right, 3. Back ");
            intPlayerChoice = verifyChoice(3);
            intRoomID = idSetterRoom4(intPlayerChoice);
        }
        else if (intPrevRoomNum == 4 && intCurrentRoomNum == 3)
        {
            // You are in room 3, choices of 6, 2, 1, or back to 4
            System.out.println("Should you go left, forward, right or back?");
            System.out.println(" 1. - Left, 2. Forward, 3. Right, 4. Back ");
            intPlayerChoice = verifyChoice(4);
            intRoomID = idSetterRoom3(intPlayerChoice);
        }
        else if (intPrevRoomNum == 4 && intCurrentRoomNum == 5)
        {
            // You are in room 5, choices of 1, 8, or back to 4
            System.out.println("Should you go left, right, or back?");
            System.out.println(" 1. - Left, 2. Right, 3. Back ");
            intPlayerChoice = verifyChoice(3);
            intRoomID = idSetterRoom5(intPlayerChoice);
        }
        else if (intCurrentRoomNum == 6)
        {
            // You are in room 6, choices of back to 3
            System.out.println("\n 1. - Back ");
            intPlayerChoice = verifyChoice(1);
            intRoomID = 3;
        }
        else if (intCurrentRoomNum == 2)
        {
            // You are in room 2, choices of back to 3
            System.out.println("A dead end... Better head back.");
            System.out.println(" 1. - Back ");
            intPlayerChoice = verifyChoice(1);
            intRoomID = 3;
        }
        else if (intCurrentRoomNum == 8)
        {
            // You are in room 8, choices of back to 5
            System.out.println("Oh snap.  A dead end... Go back.");
            System.out.println(" 1. - Back ");
            intPlayerChoice = verifyChoice(1);
            intRoomID = 5;
        }
        else if (intPrevRoomNum == 4 && intCurrentRoomNum == 7)
        {
            // You are in room 7, choices of back to 4
            System.out.println("You think you've been here before.  Have you been here before?");
            System.out.println("Yeah, this is where you woke up.  You recognise your sleepy drool.");
            System.out.println(" 1. - Back ");
            intPlayerChoice = verifyChoice(1);
            intRoomID = 4;
        }
        else if (intPrevRoomNum == 5 && intCurrentRoomNum == 4)
        {
            // You are in room 4, choices of 7, 3, or back to 5
            System.out.println("Well obviously you've been here before.\n  Where should you go now?");
            System.out.println(" 1. - Left, 2. Forward, 3. Back ");
            intPlayerChoice = verifyChoice(3);
            intRoomID = idSetterRoom4(intPlayerChoice);
        }
        else if (intPrevRoomNum == 1 && intCurrentRoomNum == 5)
        {
            // You are in room 5, choices of 8, 4, or back to 1
            System.out.println("Ok, there's options.  Should you go forward or right?");
            System.out.println("You can go back too, that's where you found the locked door.");
            System.out.println(" 1. - Forward, 2. Right, 3. Back ");
            intPlayerChoice = verifyChoice(3);
            intRoomID = idSetterRoom5(intPlayerChoice);
        }
        else if (intPrevRoomNum == 3 && intCurrentRoomNum == 4)
        {
            // You are in room 4, choices of 5, 7, or back to 3
            System.out.println("This seems familiar.  The corpses... Your handiwork?");
            System.out.println("Oh look - doors.  Which way?  Forward, right or back?");
            System.out.println(" 1. - Forward, 2. Right, 3. Back ");
            intPlayerChoice = verifyChoice(3);
            intRoomID = idSetterRoom4(intPlayerChoice);
        }
        else if (intPrevRoomNum == 3 && intCurrentRoomNum == 1)
        {
            // You are in room 1, choices of Exit, 5, or back to 3
            System.out.println("Interesting, a door to the left and one in front.");
            System.out.println("You can go back too.");
            System.out.println(" 1. - Left, 2. Forward, 3. Back ");
            intPlayerChoice = verifyChoice(3);
            intRoomID = idSetterRoom1(intPlayerChoice);
        }
        else if (intPrevRoomNum == 2 && intCurrentRoomNum == 3)
        {
            // You are in room 3, choices of 1, 4, 6, or back to 2
            System.out.println("Hmmm, you were literally just here.");
            System.out.println("Left, forward, right, or back to the dead end?");
            System.out.println(" 1. - Left, 2. Forward, 3. Right, 4. Back ");
            intPlayerChoice = verifyChoice(4);
            intRoomID = idSetterRoom3(intPlayerChoice);
        }
        else if (intPrevRoomNum == 6 && intCurrentRoomNum == 3)
        {
            // You are in room 3, choices of 2, 1, 4, or back to 6
            System.out.println("That last room was a bust.  Where to next?");
            System.out.println("Left, forward, right, or back to that dead end.");
            System.out.println(" 1. - Left, 2. Forward, 3. Right, 4. Back ");
            intPlayerChoice = verifyChoice(4);
            intRoomID = idSetterRoom3(intPlayerChoice);
        }
        else if (intPrevRoomNum == 8 && intCurrentRoomNum == 5)
        {
            // You are in room 5, choices of 4, 1, or back to 8
            System.out.println("Where are you now?  Oh yeah, stuck in this dungeon.");
            System.out.println("You can go left, forward, or back, but that's a dead end right?");
            System.out.println("Why would you go there?");
            System.out.println(" 1. - Left, 2. Right, 3. Back ");
            intPlayerChoice = verifyChoice(3);
            intRoomID = idSetterRoom5(intPlayerChoice);
        }
        else if (intPrevRoomNum == 1 && intCurrentRoomNum == 3)
        {
            // You are in room 3, choices of 4, 6, 2, or back to 1
            System.out.println("This is a new room... unless it's not.  You might be in a maze");
            System.out.println("You can go left, forward, right, or back to that room with the locked door.");
            System.out.println(" 1. - Left, 2. Forward, 3. Right, 4. Back ");
            intPlayerChoice = verifyChoice(4);
            intRoomID = idSetterRoom3(intPlayerChoice);
        }
        else if (intPrevRoomNum == 5 && intCurrentRoomNum == 1)
        {
            // You are in room 1, choices of 3, Exit, or back to 5
            System.out.println("Ah ha, this room... smells weird.");
            System.out.println("You should leave.  Go forward, right or back.");
            System.out.println(" 1. - Forward, 2. Right, 3. Back ");
            intPlayerChoice = verifyChoice(3);
            intRoomID = idSetterRoom1(intPlayerChoice);
        }
        return intRoomID;
    }
    private int verifyChoice(int options)
    {
        // options parameter brings in an integer number of choices to test for
        boolean valid = false;
        int choice = 0;
//        System.out.println("options: " + options);
        // Do while to run until a valid choice is made
        // Scan in a new user response
        this.choiceIn  = new Scanner(System.in);
        do {

            // Try catch tries to parse the string in to integer value
            try {
                String tempNum = choiceIn.nextLine();
//                System.out.println(tempNum);
                choice = Integer.parseInt(tempNum);
                // Run the integer against all options
                for (int i = 0; i < options; i++)
                {
//                    System.out.println("Option: " + options + "i: " + i);
                    // If a match is found signal a valid choice and break
                    if( choice == i + 1){ valid = true; }
//                    break;
                }
            } catch (Exception e)
            {
                // No message. Crash prevention.
            }
            if( !valid )
            {
                // If the choice was not valid print error messages
                System.out.println(" Well, you made a choice... but " + choice + " wasn't a valid option.");
                System.out.println("Be sure to try one of the given integers.");
//                choiceIn.close();
            }
        } while( !valid );
        // Send only valid choices back to be used
        return choice - 1;
    }
    private int idSetterRoom1(int PlayerChoice)
    {
        int roomID = 1;
        if(intPrevRoomNum == 5)
        {
            if(PlayerChoice == 0)
            {
                roomID = 3;
            }
            else if(PlayerChoice == 1)
            {
                roomID = 9;
            }
            else
            {
                roomID = 5;
            }
        }
        else if(intPrevRoomNum == 3)
        {
            if(PlayerChoice == 0)
            {
                roomID = 9;
            }
            else if(PlayerChoice == 1)
            {
                roomID = 5;
            }
            else
            {
                roomID = 3;
            }
        }
        return roomID;
    }
    private int idSetterRoom3(int PlayerChoice)
    {
        int roomID = 3;
        if(intPrevRoomNum == 1)
        {
            if(PlayerChoice == 0)
            {
                roomID = 4;
            }
            else if(PlayerChoice == 1)
            {
                roomID = 6;
            }
            else if(PlayerChoice == 2)
            {
                roomID = 2;
            }
            else
            {
                roomID = 1;
            }
        }
        else if(intPrevRoomNum == 2)
        {
            if(PlayerChoice == 0)
            {
                roomID = 1;
            }
            else if(PlayerChoice == 1)
            {
                roomID = 4;
            }
            else if(PlayerChoice == 2)
            {
                roomID = 6;
            }
            else
            {
                roomID = 2;
            }
        }
        else if(intPrevRoomNum == 4)
        {
            if(PlayerChoice == 0)
            {
                roomID = 6;
            }
            else if(PlayerChoice == 1)
            {
                roomID = 2;
            }
            else if(PlayerChoice == 2)
            {
                roomID = 1;
            }
            else
            {
                roomID = 4;
            }
        }
        else if(intPrevRoomNum == 6)
        {
            if(PlayerChoice == 0)
            {
                roomID = 2;
            }
            else if(PlayerChoice == 1)
            {
                roomID = 1;
            }
            else if(PlayerChoice == 2)
            {
                roomID = 4;
            }
            else
            {
                roomID = 6;
            }
        }
        return roomID;
    }
    private int idSetterRoom4(int PlayerChoice)
    {
        int roomID = 4;
        if(intPrevRoomNum == 3)
        {
            if(PlayerChoice == 0)
            {
                roomID = 5;
            }
            else if(PlayerChoice == 1)
            {
                roomID = 7;
            }
            else
            {
                roomID = 3;
            }
        }
        else if(intPrevRoomNum == 5)
        {
            if(PlayerChoice == 0)
            {
                roomID = 7;
            }
            else if(PlayerChoice == 1)
            {
                roomID = 3;
            }
            else
            {
                roomID = 5;
            }
        }
        else if(intPrevRoomNum == 7)
        {
            if(PlayerChoice == 0)
            {
                roomID = 3;
            }
            else if(PlayerChoice == 1)
            {
                roomID = 5;
            }
            else
            {
                roomID = 7;
            }
        }
        return roomID;
    }
    private int idSetterRoom5(int PlayerChoice)
    {
        int roomID = 5;
        if(intPrevRoomNum == 1)
        {
            if(PlayerChoice == 0)
            {
                roomID = 8;
            }
            else if(PlayerChoice == 1)
            {
                roomID = 4;
            }
            else
            {
                roomID = 1;
            }
        }
        else if(intPrevRoomNum == 4)
        {
            if(PlayerChoice == 0)
            {
                roomID = 1;
            }
            else if(PlayerChoice == 1)
            {
                roomID = 8;
            }
            else
            {
                roomID = 4;
            }
        }
        else if(intPrevRoomNum == 8)
        {
            if(PlayerChoice == 0)
            {
                roomID = 4;
            }
            else if(PlayerChoice == 1)
            {
                roomID = 1;
            }
            else
            {
                roomID = 8;
            }
        }
        return roomID;
    }

    public void roomIntro(int currentRoomNum)
    {
        if(currentRoomNum == 1)
        {
            if(room1BodyCount == 0)
            {
                System.out.println("Oh good lord. The exit... or at least, you assume it to be an exit. Unlike the large \n" +
                        " variety of mundane wooden doors that had blocked several entrances before this point, you can see \n" +
                        "that this one has several gleaming locks, each apparently needing to have a key stuffed into them \n" +
                        "before escape is possible. You need to find those keys - three of them.");
            }
            else if(room1BodyCount == 1)
            {
                System.out.println("You nearly stumble across the goblinoid body that lay dead on the floor in front of the door. \n" +
                        "The room's door still gleams mockingly, taunting you with potential freedom.");
            }
            else if(room1BodyCount >= 2)
            {
                System.out.println("Freedom beckons, albeit one tainted by the blood of the countless creatures you've slain");
            }
            room1BodyCount++;
        }
        else if(currentRoomNum == 2)
        {
            if (room2BodyCount == 0) {
                System.out.println("You enter... a dead-end. Just like the other rooms, this one has the same stone floor, \n" +
                        "stone walls, perpetually burning torches. There also seems to be a monster running at you!");
            } else if (room2BodyCount == 1) {
                System.out.println("The room lies unchanged before you - same walls, same torch, same body on the ground.");
            } else if (room2BodyCount >= 2 && room2BodyCount < 6) {
                System.out.println("The room lies unchanged before you - same walls, same torch, same bodies on the ground.");
            } else if (room2BodyCount >= 6) {
                System.out.println("You've been through this room just a time or two before. You can tell from the pile \n" +
                        "of bodies that had already started stinking, you full-fledged psychopath.");
            }
            room2BodyCount++;
        }
        else if(currentRoomNum == 3)
        {
            if (room3BodyCount == 0) {
                System.out.println("You enter another room, just like the other rooms, this one has the same stone floor, \n" +
                        "stone walls, perpetually burning torches. There also seems to be a monster running at you!");
            } else if (room3BodyCount == 1) {
                System.out.println("The room lies unchanged before you - same walls, same torch, same body on the ground.");
            } else if (room3BodyCount >= 2 && room3BodyCount < 6) {
                System.out.println("The room lies unchanged before you - same walls, same torch, same bodies on the ground.");
            } else if (room3BodyCount >= 6) {
                System.out.println("You've been through this room just a time or two before. You can tell from the pile \n" +
                        "of bodies that had already started stinking, you full-fledged psychopath.");
            }
            room3BodyCount++;
        }
        else if(currentRoomNum == 4)
        {
            if(room4BodyCount == 0) {
                System.out.println("Your fingers wrapped around the cold metal of the handle, and you slowly turned it, only \n" +
                        " to then draw out. The loud screech of tormented metal following your tug greeted your ears, \n" +
                        " and you saw with shock that a midget – not just a midget, but a green one with a large nose! \n" +
                        "- stared at you with shock, before jabbering in a high-pitched voice. The little creature even \n" +
                        "hopped up and down, before tugging a knife out that was as well-maintained as the door you’d just \n" +
                        "walked through… that is, not at all. With a gleeful grin, the little mad-cap darted towards you,  \n" +
                        "clearly eager to fight.");
            }
            else if(room4BodyCount == 1)
            {
                System.out.println("The room lies unchanged before you - same walls, same torch, same body on the ground.");
            }
            else if (room4BodyCount >= 2 && room4BodyCount < 6)
            {
                System.out.println("The room lies unchanged before you - same walls, same torch, same bodies on the ground.");
            }
            else if(room4BodyCount >= 6)
            {
                System.out.println("You've been through this room just a time or two before. You can tell from the pile \n" +
                        "of bodies that had already started stinking, you full-fledged psychopath.");
            }
            room4BodyCount++;
        }
        else if(currentRoomNum == 5)
        {
            if (room5BodyCount == 0) {
                System.out.println("You enter another room. Just like the other rooms, this one has the same stone floor, \n" +
                        "stone walls, perpetually burning torches. There also seems to be a monster running at you!");
            } else if (room5BodyCount == 1) {
                System.out.println("The room lies unchanged before you - same walls, same torch, same body on the ground.");
            } else if (room5BodyCount >= 2 && room5BodyCount < 6) {
                System.out.println("The room lies unchanged before you - same walls, same torch, same bodies on the ground.");
            } else if (room5BodyCount >= 6) {
                System.out.println("You've been through this room just a time or two before. You can tell from the pile \n" +
                        "of bodies that had already started stinking, you full-fledged psychopath.");
            }
            room5BodyCount++;
        }
        else if(currentRoomNum == 6)
        {
            if(swordvisit == 0)
            {
                System.out.println("You proceeded down another hallway… and see in the very center of this room, a sword in the stone. \n" +
                        " Stepping forward, your heart fluttered as you read the familiar epithet that was so often spoken of in \n" +
                        "regards to King Arthur: “Who-so-ever removes the sword from the stone, shall be the true king (or queen?) of \n" +
                        "Britain.” Were you the chosen one? One of your hands moved to grip the handle of the blade, and you tugged. \n" +
                        "And tugged again. Third time’s the charm? Another tug, another nope. Guess you’re not meant to be the true ruler \n" +
                        "of Britain. Probably for the best, considering the mess going on with Brexit. You do however find another blade, \n" +
                        "much rustier, on the ground, and pick it up.");

            }
            else if(swordvisit == 1)
            {
                System.out.println("The rusty color that had previously adorned the blade is gone. It looks as though the \n" +
                        "blade had just been polished. Weird.");
            }
            else if(swordvisit == 2)
            {
                System.out.println("Unlike the rest of the castle, this room has a pleasantly warm feel to it. How relaxing. ");
            }
            else if(swordvisit == 3)
            {
                System.out.println("Alright, now you either know you're going crazy, or else something really strange is happening \n" +
                        "here. Water pours from the ceiling like a miniature waterfall, highlighting the blade.");
            }
            else if(swordvisit == 4)
            {
                System.out.println("The waterfall from last time now has a freaking rainbow mocking you now, curved around the sword. \n" +
                        "Whatever magic the sword has clearly enjoys taunting you.");
            }
            else if(swordvisit >= 5)
            {
                System.out.println("The sword now is brilliantly illuminated by what seemed like an invisible spotlight! The rainbow \n" +
                        "persists, brighter than ever");
            }
            swordvisit++;
        }
        else if(currentRoomNum == 7)
        {
            if(room7BodyCount == 0)
            {
                System.out.println("You re-enter the room you originally woke up in. There's a puddle of vomit on the floor \n" +
                        "that you don't *quite* remember leaving, but could absolutely believe came from you. The horrid smell \n" +
                        "that puddle aside, there's another enemy laying in wait for you!");
            }
            else if(room7BodyCount == 1)
            {
                System.out.println("Point Zero: your original bedroom in this place. The goblin you'd killed earlier covers up \n" +
                        "the chunky salsa you'd hurled earlier. Aside from that, just another angry monster charging at you.");
            }
            else if(room7BodyCount > 1)
            {
                System.out.println("The bodies are stacking up in here. The already atrocious smell is getting even worse. \n" +
                        "You really need to get out of it sooner rather than later.");
            }
            room7BodyCount++;
        }
        else if(currentRoomNum == 8)
        {
            if (room8BodyCount == 0) {
                System.out.println("You enter... a dead-end. Just like the other rooms, this one has the same stone floor, \n" +
                        "stone walls, perpetually burning torches. There also seems to be a monster running at you!");
            } else if (room8BodyCount == 1) {
                System.out.println("The room lies unchanged before you - same walls, same torch, same body on the ground.");
            } else if (room8BodyCount >= 2 && room8BodyCount < 6) {
                System.out.println("The room lies unchanged before you - same walls, same torch, same bodies on the ground.");
            } else if (room8BodyCount >= 6) {
                System.out.println("You've been through this room just a time or two before. You can tell from the pile \n" +
                        "of bodies that had already started stinking, you full-fledged psychopath.");
            }
            room8BodyCount++;
        }
    }
}
