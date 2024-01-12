package code.cards;

import code.actions.EasyXCostAction;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_14 extends AbstractEasyCard {
    public final static String ID = makeID("ID_14");
    // intellij stuff SKILL, SELF, Common, 0, 0, 7, 1, 3, 2

    public ID_14() {
        super(ID, -1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 7;
        baseMagicNumber = magicNumber = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        blck();
        this.addToBot(new EasyXCostAction(this,this::action));
    }

    public boolean action(int amount, int[] params)
    {
        AbstractPlayer p = AbstractDungeon.player;
        for (int a = 0; a < amount; a++)
        {
            this.addToBot(new ApplyPowerAction(p, p, new NextTurnBlockPower(p, (this.block-magicNumber)), (this.block-magicNumber)));
        }
        return true;
    }

    public void upp() {
        //upgradeDamage(0);
        upgradeBlock(1);
        upgradeMagicNumber(-2);
        //upgradeBaseCost(0);
    }
}