package GameDev;

import java.util.ArrayList;
import java.util.Random;

public class Sword extends Weapon {
    public Sword(String name_, int wpnPower_) {
        super(name_, wpnPower_);
        this.strName = name_;
        this.intWpnPower = wpnPower_;
        this.arrAttacks = new ArrayList<String>();
        //Ensuring the arraylist has the attacks!
        arrAttacks.add("With all the grace of a black-out drunk trying to walk a straight line, \n" +
                "you swing the sword… like a bat. The flat of the blade strikes the enemy with a \n" +
                "slap of metal on flesh to deal some damage. Oops?");
        arrAttacks.add("You stab with the pointy end! Your footwork could use less of the former, \n" +
                "and more of the latter, as you stagger a bit, but at least you still managed to scrape \n" +
                "the enemy for some damage!");
        arrAttacks.add("You swing, the sharp end slashing across the creature's body, dealing damage. \n" +
                "Keep it up and you might be able to be considered competent as you do your best to \n" +
                "kill another living creature. But hey, nobody's judging you!");
    }

    public Sword() {
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