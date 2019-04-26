package GameDev;

import java.util.ArrayList;
import java.util.Random;

public class MonsterSword extends Weapon
{
    public MonsterSword(String name_, int wpnPower_) {
        super(name_, wpnPower_);
        this.strName = name_;
        this.intWpnPower = wpnPower_;
        this.arrAttacks = new ArrayList<String>();
        //Ensuring the arraylist has the attacks!
        arrAttacks.add("The rusty blade jabbed towards you as though the monster wielding it were \n" +
                "using a rapier. Despite your attempts to dodge, you still get cut! Hope you've \n" +
                "kept up on your tetanus shots.");
        arrAttacks.add("The blade gleaming in the torchlight swung at you, rending the air with \n" +
                "a squeal! No, that was you as you attempted to avoid the weapon. You failed and\n" +
                "took some damage anyways.");
        arrAttacks.add("The sword wielded by the monster jabbed at you again and again, and despite \n" +
                "some frantic backpedaling, you were struck a bit anyways!.");
    }

    public MonsterSword() {
        this("Rusty Sword", 3);
    }

    //Returning abstract weapon name.
    String WpnName() {
        return strName;
    }

    //Returning abstract wpn damage to be added to player attack.
    int WpnDamage()
    {
        return intWpnPower;
    }

    //Demonstrating the weapon's attack.
    void WpnAttack()
    {
        randNum = new Random();
        int intWpnChoice = randNum.nextInt(3);
        System.out.println(arrAttacks.get(intWpnChoice));
    }

    void Unequip()
    {
        arrAttacks.clear();
    }
}
