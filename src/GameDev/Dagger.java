package GameDev;

import java.util.ArrayList;
import java.util.Random;

public class Dagger extends Weapon
{
    public Dagger(String name_, int wpnPower_) {
        super(name_, wpnPower_);
        this.strName = name_;
        this.intWpnPower = wpnPower_;
        this.arrAttacks = new ArrayList<String>();
        //Ensuring the arraylist has the attacks!
        arrAttacks.add("Having no desire to cut yourself like you have before in the kitchen, you jab \n" +
                "forward with the pointy end while your other arm flails to the side, stabbing \n" +
                "(poking?) the monster for a bit of damage.");
        arrAttacks.add("A rake of the blade across the other’s chest and arms! You managed to pull off\n" +
                "a half-decent maneuver for some damage to the monster.");
        arrAttacks.add("A jab of the blade pokes the enemy for a little damage, but you nearly cut yourself!\n"  +
                "Yow! Better be careful with that blade.");
    }

    public Dagger() {
        this("Fragile Dagger", 2);
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
