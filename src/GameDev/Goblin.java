package GameDev;

import java.util.Random;

public class Goblin extends Monster
{
    public Goblin(String name_, int level_) {
        super(name_);
        randNum = new Random();
        this.strName = name_;
        this.intCurrentHealth = 20*level_;
        this.intMaxHealth = 20*level_;
        addArmour();
        addAttackPwr();
        rollForKey();
        rollForWeapon();
        this.intLevel = level_;
        this.intEXP = 100*level_;

    }
    public Goblin()
    {
        this("Goblin",1);
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
        return this.intAttackPower;
    }
    int GetLevel()
    {
        // Abstract method returns current level
        return this.intLevel;
    }
    void SetLevel(int level_)
    {
        // Abstract method sets current level
        this.intLevel = level_;
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
        // Abstract method player only, for mobs does nothing
    }
    void UpdateLvl()
    {
        // Abstract method player only, for mobs does nothing
    }
    private void addArmour()
    {
        // Armour defaults to zero
        int tempNum = 0;
        if(this.intLevel > 20)
        {
            // If GameDev.Goblin level is greater than 20
            // Pick a random number between 11 and 20
            tempNum = randNum.nextInt(10) + 11;
        }
        else if(this.intLevel > 10)
        {
            // Else if GameDev.Goblin level is between 10 and 20
            // Pick a random number between 1 and 10
            tempNum = randNum.nextInt(10) + 1;
        }
        // Else use default value
        // Update armour with new value
        this.intArmor = tempNum;
    }
    private void addAttackPwr()
    {
        // Attack defaults to five
        int tempNum = 5;
        if(this.intLevel > 20)
        {
            // If GameDev.Goblin level is greater than 20
            // Pick a random number between 11 and 20
            tempNum = randNum.nextInt(10) + 11;
        }
        else if(this.intLevel > 10)
        {
            // Else if GameDev.Goblin level is between 10 and 20
            // Pick a random number between 1 and 10
            tempNum = randNum.nextInt(10) + 1;
        }
        // Else use default value
        // Update armour with new value
        this.intAttackPower = tempNum;
    }
    private void rollForKey()
    {
        // Roll to determine if the goblin is to have one of the keys
        int tempNum = randNum.nextInt(3);
        // Set hasKey boolean
        if( tempNum == 0 ) { this.hasKey = true; }
        else { this.hasKey = false; }
    }
    boolean CheckKey()
    {
        // Returns whether the mob has a key
        return this.hasKey;
    }

    private void rollForWeapon()
    {
        int tempNum = randNum.nextInt(2);
        if (tempNum == 0) {this.mobWeapon = new MonsterClaws();}
        else if (tempNum == 1) {this.mobWeapon = new MonsterDagger();}
    }

    void Equip(Weapon nonexistantweapon)
    {
    }

    boolean getDead()
    {
        return isDead;
    }

}
