package GameDev;
import java.util.Random;
import java.util.ArrayList;

public abstract class Weapon {
    String strName;
    Random randNum;
    int intWpnPower;
    ArrayList<String> arrAttacks;

    public Weapon(String name_, int atkBuff_)
    {
        this.strName = name_;
        this.intWpnPower = atkBuff_;
        this.arrAttacks = new ArrayList<String>();
    }

    abstract String WpnName();
    abstract int WpnDamage();
    abstract void WpnAttack();
    abstract void Unequip();

}
