package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_34 extends AbstractEasyCard {
    public final static String ID = makeID("ID_34");
    // intellij stuff skill, self, uncommon, 0, 0, 15, 23, 2, 0

    public ID_34() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 15;
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        blck();
        atb(new DrawCardAction(magicNumber));
    }

    public void upp() {
        upgradeDamage(0);
        upgradeBlock(23);
        upgradeMagicNumber(0);
        upgradeBaseCost(3);
    }
}