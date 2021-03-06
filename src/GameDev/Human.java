package GameDev;

import java.util.Random;

public class Human extends Monster {

    // Attribute Declaration
    private int intKeyCount = 0;

    public Human(String name_)
    {
        super(name_);
        this.randNum = new Random();
        this.intLevel = 1;
        this.intEXP = 0;
        this.intCurrentHealth = 20;
        this.intMaxHealth = 30;
        this.intAttackPower = 5;
        rollForWeapon();
        this.hasKey = false;
        this.mobWeapon = new Fisticuffs();
    }
    public Human()
    {
        this("Chump");
    }
    String MonsterName()
    {
        // Abstract method returns name
        return this.strName;
    }
    int MaxHealth()
    {
        // Abstract method returns max health
        return this.intMaxHealth;
    }
    int CurrentHealth()
    {
        // Abstract method returns current health
        return this.intCurrentHealth;
    }
    int AttackPower()
    {
        // Abstract method returns attack power
        int tempTotalPower = this.intAttackPower + this.mobWeapon.WpnDamage();
        return tempTotalPower;
    }
    int GetLevel()
    {
        // Abstract method returns current level
        return this.intLevel;
    }
    void SetLevel(int level_)
    {
        // Abstract method sets current level
        if(level_ == 1)
        {
            this.intLevel = 1;
        }
        else if(level_ < 4)
        {
            int tempLvl = randNum.nextInt(5);
            this.intLevel = 1 + tempLvl;
        }
        else if (level_ < 10)
        {
            int tempLvl = randNum.nextInt(5);
            this.intLevel = 4 + tempLvl;
        }
    }
    void TakeDamage(int damage_)
    {
        // Abstract method reduces health by damage number
        this.intCurrentHealth -= damage_;
        // If health drops to zero then death occurs
        if(this.intCurrentHealth <= 0)
        {
            this.isDead = true;
        }
    }
    int GetEXP()
    {
        // Abstract method returns experience value of monster
        return this.intEXP;
    }
    void RaiseEXP(int mobEXP)
    {
        // Abstract method increases the total experience points
        this.intEXP += mobEXP;
    }
    void UpdateLvl()
    {
        // Abstract method checks total experience and updates player level
        int tempExp = this.intLevel * 100;
        if(this.intEXP >= tempExp)
        {
            // Subtract the experience overage to increase the requirement by 100 for next level
            this.intEXP -= this.intLevel * 100;

            // Raise level by one
            this.intLevel++;
            System.out.println("\nCongratulations, you've leveled up.  You are now level: " + this.intLevel + ".");
            // Update the max health value
            this.intMaxHealth = 30 + this.intLevel*10;
            // Reset the current health to the max health
            this.intCurrentHealth = this.intMaxHealth;
            System.out.println("\nAs your level increases, so does your health capacity.  You now have: " +
                    this.intMaxHealth + " health.  Use it wisely\n");
            this.intAttackPower++;
            System.out.println("\nYou feel stronger.  Attack strength increased to: " + this.intAttackPower);
        }
    }
    boolean CheckKey()
    {
        return this.hasKey;
    }
    public void addKey()
    {
        // Add one to the value of the key count
        this.intKeyCount++;
        // Print messages about finding keys
        if(this.intKeyCount == 1)
        {
            this.hasKey = true;
            System.out.println("\nWhat's this?  You loot the corpse and find a key.  You should find a locked door.\n");
        }
        else if(this.intKeyCount == 2)
        {
            System.out.println("\nHey, you found another key.  Where was that locked door?\n");
        }
        else if(this.intKeyCount == 3)
        {
            System.out.println("\nWell now.  That makes three keys.  Have you found a key ring yet?\n");
        }
        else if(this.intKeyCount >= 4)
        {
            System.out.println("\nThe exit only needs three keys.  Why are you still killing monsters?\n");
        }
    }
    public int getKeyCount()
    {
        // Return the value of the key count
        return this.intKeyCount;
    }
    boolean getDead()
    {
        return isDead;
    } // Return the value of isDead
    public void healPlayer()
    {
        // Heal player to max health
        this.intCurrentHealth = this.intMaxHealth;
    }
    private void rollForWeapon()
    {
        if(strName.equals("Bandit")) {
            int tempNum = this.randNum.nextInt(2);
            if (tempNum == 0) {
                this.mobWeapon = new MonsterDagger();
            } else if (tempNum == 1) {
                this.mobWeapon = new MonsterSword();
            }
        }
    }

    void Equip(Weapon newWeapon)
    {
        this.mobWeapon = newWeapon;
    }

    void Status()
    {
        // Print health status
        System.out.println(MonsterName() + ": " + "Level " + GetLevel() + "/ Current Health: "+ CurrentHealth());
    }
}
