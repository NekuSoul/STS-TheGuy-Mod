package code.cards;

import code.actions.EasyXCostAction;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class
ID_62 extends AbstractEasyCard {
    public final static String ID = makeID("ID_62");
    // intellij stuff skill, self, uncommon, 0, 0, 0, 0, 0, 1

    public ID_62() {
        super(ID, -1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new EasyXCostAction(this, this::action));
    }

    public boolean action(int amount, int[] params)
    {
        AbstractPlayer p = AbstractDungeon.player;
        if(this.upgraded)
            this.addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, amount+1), amount+1));
        else {
            if(amount == 0)
                return true;
            this.addToBot(new ApplyPowerAction(p, p, new StrengthPower(p, amount), amount));
        }
        return true;
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        upgradeMagicNumber(1);
        //upgradeBaseCost(-1);
    }
}