package GameDev;

import java.util.ArrayList;
import java.util.Random;

public class Fisticuffs extends Weapon
{
    public Fisticuffs(String name_, int wpnPower_) {
        super(name_, wpnPower_);
        this.strName = name_;
        this.intWpnPower = wpnPower_;
        this.arrAttacks = new ArrayList<String>();
        //Ensuring the arraylist has the attacks!
        arrAttacks.add("Balling your hands into fists, you bring out the ol’ one-two combo! A jab to \n" +
                "the gut to deal to deal some damage!");
        arrAttacks.add("Imitating the gentlemen of British yore, you decide to engage in fisticuffs, \n" +
                "bringing both hands up before your face before jabbing towards the creature's \n" +
                "face for a bit of damage.");
        arrAttacks.add("Your fists swing from the right to the left and back again, trying to strike \n" +
                "and strike and strike the ugly mug of the enemy for some serious (maybe) damage.");
    }

    public Fisticuffs() {
        this("Poor Hands", 1);
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
