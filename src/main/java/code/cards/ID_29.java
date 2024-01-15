package code.cards;

import code.actions.ID_29Action;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_29 extends AbstractEasyCard {
    public final static String ID = makeID("ID_29");
    // intellij stuff skill, self, rare, 0, 0, 0, 0, 2, 2

    public ID_29() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new ID_29Action(magicNumber));
    }

    public void upp() {
        upgradeDamage(0);
        upgradeBlock(0);
        upgradeMagicNumber(2);
        upgradeBaseCost(2);
    }
}