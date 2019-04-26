package GameDev;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class MobWrangler {

    public static void main(String[] args)
    {
        //TODO initialize private Clip variable - clip;
        // try catch - AudioInputStream variable = AudioSystem.getAudioInputStream(this.getClass().getResource("filename")
        // clip = AudioSystem.getClip(); clip.open(audioInputStream);
        // look up FloatControl for volume
        // clip.loop(big number here);
        // clip.start() [clip.stop() to kill it]
        // end catch;

        // Initialize variables
        Introduction gameStart = new Introduction();
        PathDecisions stupidPath = new PathDecisions();
        Encounter rumble = new Encounter();

        Goblin goblin;
        Monster mob;
        Human player, human;
        player = new Human("Carl");
        Random random = new Random();
        Scanner decision = new Scanner(System.in);

        // Initialize variables
        ArrayList<Integer> roomList;
        ArrayList<Monster> monsterList;
        int intPlayerRoomChoice = 4, intCurrentRoom = 4, intPreviousRoom = 7, intMonsterCount = 2, intMobChoice;
        boolean keepFighting, exitOpen = false, playerDead = false;


//        gameStart.intro(); // temp blocker on intro for trouble shooting code
        //TODO clear block before delivering final game

        // Game loop that runs until the player opens the locked door.
        // This trigger requires the finding of at least 3 keys looted from mobs slain
        do {
            if (player.getDead())
            {
                //TODO Go to end game credits
                System.out.println("All the bad stuff.");
                playerDead = true;
            }
            else
                {
                    // If player is not dead
                    // Choose a new random monster type
                    if(player.intLevel == 1)
                    {
                        intMobChoice = 0;
                    }
                    else {
                        intMobChoice = random.nextInt(intMonsterCount);
                    }
                    if(intCurrentRoom != 6)
                    {
                        // If player is not in the sword room create a new monster as mob
                        if (intMobChoice == 0) {
                            goblin = new Goblin();
                            mob = goblin;
                        } else {
                            human = new Human();
                            mob = human;
                        }

                        // Display the intro to the current room
                        stupidPath.roomIntro(intCurrentRoom);

                        // Display the conflict start
                        System.out.println("\nA " + mob.strName + " is attacking you.");
                        System.out.println("You lunge forward and attack the " + mob.strName + ".");

                        // Count variable keeps track of combat turns
//                        int count = 0;
                        // Attack, defend loop here
                        do {
                            try {
                                sleep(1000);
                            }catch(Exception e){  } // Do nothing, for time
//                            System.out.println("Count " + count);
                            // Calculate for each attack round
                            rumble.Attack(player, mob);
                            //TODO comment the fight for player via weapon class

                            if(!mob.getDead())
                            {
                                // If monster yet lives
                                rumble.Attack(mob, player);
                                // TODO comment the fight for the mob via weapon class
                            }
                            // Check if they are both still standing
                            keepFighting = rumble.CheckHealth(player, mob);


//                            count++;
                        }while(keepFighting);
                        if(mob.getDead())
                        {
                            // Monster died
                            System.out.println("\nThe " + mob.strName + " has fallen before your relentless attack.\n");
                            player.RaiseEXP(mob.GetEXP());
                            player.UpdateLvl();
                            if(mob.CheckKey())
                            {
                                player.addKey();
                            }
                        }
                        else if(player.getDead())
                        {
                            System.out.println("Uh oh.  Looks like you're dead.  Tough Break.");
                            // If player died, jump out of the loop
                            break;
                        }
                    }
                    else
                    {
                        // Display the intro to the sword room
                        stupidPath.roomIntro(intCurrentRoom);
                        // You are entering the sword room.  You feel healthier.
                        player.healPlayer();
                        System.out.println("\nHey, didn't you have cuts and broken stuff before?");
                        System.out.println("You feel... better... Health = " + player.intCurrentHealth);
                    }
                    intPlayerRoomChoice = stupidPath.choosePath(intPreviousRoom, intCurrentRoom);
                    if(intPlayerRoomChoice == 9)
                    {
                        // Player is trying the exit door
                        if(player.getKeyCount()>=3)
                        {
                            exitOpen = true;
                        }
                        else
                        {
                            System.out.println("You don't have enough keys.  In fact you have " +
                                    player.getKeyCount() + " keys.  The door needs three.");
                            intPlayerRoomChoice = stupidPath.choosePath(intPreviousRoom, intCurrentRoom);
                            intPreviousRoom = intCurrentRoom;
                            intCurrentRoom = intPlayerRoomChoice;

                        }
                    }
                    else {
                        intPreviousRoom = intCurrentRoom;
                        intCurrentRoom = intPlayerRoomChoice;
                    }
                }
            }
            while(!exitOpen && !playerDead);
            if(exitOpen) {
                System.out.println("You found the keys!");
                System.out.println("Congrats, you are free of this dungeon!");
            }
            else
            {
                System.out.println("Game over man... GAME OVER!");
            }
//        System.out.println("Working code!");

//        System.out.println("Rinse and repeat!");
    }
}
