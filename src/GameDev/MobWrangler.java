package GameDev;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


import static java.lang.Thread.sleep;

public class MobWrangler {

    public static void main(String[] args)
    {
        // Initialize variables
        Introduction gameStart = new Introduction();
        Outro gameEnd = new Outro();
        PathDecisions stupidPath = new PathDecisions();
        Encounter rumble = new Encounter();

        Goblin goblin;
        Monster mob;
        Human player;
        Bandito bandit;

        //TODO create user input for player name
        Random random = new Random();
        Scanner nameIn = new Scanner(System.in);


        // Initialize variables
        ArrayList<Integer> roomList;
        ArrayList<Monster> monsterList;
        int intPlayerRoomChoice = 4, intCurrentRoom = 4, intPreviousRoom = 7, intMonsterCount = 2, intMobChoice;
        boolean keepFighting, exitOpen = false, playerDead = false, mobDead = false;

        // Create name query
        System.out.println("WELCOME(?) TO MOB WRANGLER.");
        System.out.print("\nEnter a player name: ");
        String name = nameIn.nextLine();
        player = new Human(name);

        System.out.println("\nHello " + name + ", press enter to begin game.\n");
        nameIn.nextLine();

        gameStart.intro(); // temp blocker on intro for trouble shooting code
        //TODO clear block before delivering final game

        // Game loop that runs until the player opens the locked door.
        // This trigger requires the finding of at least 3 keys looted from mobs slain
        do {
            mobDead = false;
            if (player.getDead())
            {
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
                        goblin = new Goblin("Goblin", player.intLevel);
                        mob = goblin;
                    } else {
                        bandit = new Bandito("Bandit", player.intLevel);
                        mob = bandit;
                    }

                    // Display the intro to the current room
                    stupidPath.roomIntro(intCurrentRoom);

                    // Display the conflict start
                    System.out.println("\nA " + mob.strName + " is attacking you.");
                    System.out.println("You lunge forward and attack the " + mob.strName + ".");
                    System.out.println();
                    System.out.println("\nHit enter to continue.\n");
                    nameIn.nextLine();
                    try{
                        sleep(2000);
                    }catch(Exception e){ System.out.println("uh roh raggy sleep failed.\n" + e);}


                    // Count variable keeps track of combat turns
//                        int count = 0;
                    // Attack, defend loop here
                    do {
                        try {
                            sleep(1000);
                        }catch(Exception e){  } // Do nothing, for time
//                            System.out.println("Count " + count);
                        // Calculate for each attack round
//                            player.Status();
//                            mob.Status();
                        rumble.Status(player, mob);
                        System.out.println();

                        player.mobWeapon.WpnAttack();
                        rumble.Attack(player, mob);
                        try{
                            sleep(2000);
                        }catch(Exception e){ System.out.println("uh roh raggy sleep failed.\n" + e);}

                        if(!mob.getDead())
                        {
                            // If monster yet lives
                            mob.mobWeapon.WpnAttack();
                            rumble.Attack(mob, player);
                            System.out.println();
                            try{
                                sleep(2500);
                            }catch(Exception e){ System.out.println("uh roh raggy sleep failed.\n" + e);}
                        }
                        // Check if they are both still standing
                        keepFighting = rumble.CheckHealth(player, mob);

                        mobDead = mob.getDead();
//                            count++;
                    }while(keepFighting);

                    if(mobDead)
                    {
                        // Monster died
                        System.out.println("\nThe " + mob.strName + " has fallen before your relentless attack.\n");
                        rumble.UpdateStatus(player, mob);
                        rumble.WeaponCheck(player, mob);
//                            player.RaiseEXP(mob.GetEXP());
//                            player.UpdateLvl();

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
                intPlayerRoomChoice = stupidPath.choosePath(intPreviousRoom, intCurrentRoom, mobDead);
                if(intPlayerRoomChoice == 9)
                {
                    // Player is trying the exit door
                    if(player.getKeyCount()>=3)
                    {
                        exitOpen = true;
                    }
                    else
                    {
                        do {
                            System.out.println("You don't have enough keys.  In fact you have " +
                                    player.getKeyCount() + " keys.  The door needs three.");
                            intPlayerRoomChoice = stupidPath.choosePath(intPreviousRoom, intCurrentRoom, mobDead);
                        }while(intPlayerRoomChoice == 9);
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
            gameEnd.Victory();
        }
        else
        {
            gameEnd.GameOver();
        }

//        System.out.println("Working code!");
//        System.out.println("Rinse and repeat!");
    }
}
