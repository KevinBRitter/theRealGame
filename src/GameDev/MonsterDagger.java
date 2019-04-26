package GameDev;

import java.util.ArrayList;
import java.util.Random;

public class MonsterDagger extends Weapon
{
    public MonsterDagger(String name_, int wpnPower_) {
        super(name_, wpnPower_);
        this.strName = name_;
        this.intWpnPower = wpnPower_;
        this.arrAttacks = new ArrayList<String>();
        //Ensuring the arraylist has the attacks!
        arrAttacks.add("Despite the precarious state of the knife, the monster wields it relentlessly! \n" +
                "Some cuts are acquired!");
        arrAttacks.add("Deadly and dangerous, the ragged knife's blade did not hit you so much as the \n" +
                "splinters shaken free from the rough handle, speckling your arms with tiny wounds!");
        arrAttacks.add("The creature holding the dagger darts forward, dragging the blade across one of\n" +
                "your sides for a bit of damage.");
    }

    public MonsterDagger() {
        this("Splintery Knife", 2);
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
