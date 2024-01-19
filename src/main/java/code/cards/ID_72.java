package code.cards;

import code.actions.ID_72Action;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_72 extends AbstractEasyCard {
    public final static String ID = makeID("ID_72");
    // intellij stuff skill, enemy, rare, 0, 0, 0, 0, 0, 0

    public ID_72() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new ID_72Action(m,false));
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        upgradeBaseCost(0);
    }
}