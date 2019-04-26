package GameDev;

public class Encounter
{
    public Encounter()
    {
        // Create a new Encounter instance
    }

    public void Attack(Monster attacker, Monster defender)
    {
        // Attack method takes two entities and evaluates a single
        // attack / defence aggression
        System.out.printf("\n%s attacks %s for %d damage." ,  attacker.strName , defender.strName , attacker.AttackPower() );
        defender.TakeDamage(attacker.AttackPower());

    }

    public boolean CheckHealth(Monster one, Monster two)
    {
        // Return false if either combatant has died
        // Otherwise return true, as in "good to continue"
        if(one.isDead || two.isDead)
        {
            return false;
        }
        else
            return true;
    }
    public void UpdateStatus(Monster player, Monster mob)
    {
        UpdateEXP(player, mob);
        UpdateLvl(player);
    }
    private void UpdateEXP(Monster player, Monster mob)
    {
        // Raises the player experience by the monster's experience value
        player.RaiseEXP(mob.GetEXP());
    }
    private void UpdateLvl(Monster player)
    {
        // Checks if a level update is warranted and implements it
        player.UpdateLvl();
    }

    private void WeaponCheck(Monster player, Monster mob)
    {
        if(mob.mobWeapon.intWpnPower > player.mobWeapon.intWpnPower)
        {
            if (mob.mobWeapon.strName.contains("Knife"))
            {
                Dagger dagger = new Dagger();
                player.Equip(dagger);
            }
            else if (mob.mobWeapon.strName.contains("Sword"))
            {
                Sword sword = new Sword();
                player.Equip(sword);
            }
        }
    }

}
