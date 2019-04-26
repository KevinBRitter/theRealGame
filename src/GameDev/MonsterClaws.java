package GameDev;

import java.util.ArrayList;
import java.util.Random;

public class MonsterClaws extends Weapon
{
    public MonsterClaws(String name_, int wpnPower_) {
        super(name_, wpnPower_);
        this.strName = name_;
        this.intWpnPower = wpnPower_;
        this.arrAttacks = new ArrayList<String>();
        //Ensuring the arraylist has the attacks!
        arrAttacks.add("The goblin snarls angrily as it lunges forward, nasty, gnarled nails at you, \n" +
                "raking across your skin. Hope you don't get an infection!");
        arrAttacks.add("Ragged nails rake rudely 'round your arms, causing pain and vicious scratches!\n" +
                "That rapscallion! \n");
        arrAttacks.add("The goblin howls, spittle splattering spectacularly in front of it... If only \n" +
                "you hadn't been directly in front of it. Despite no actual scratches, you find you've\n" +
                "taken some damage anyways.");
    }

    public MonsterClaws() {
        this("Gnarled Nails", 1);
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
