package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_37 extends AbstractEasyCard {
    public final static String ID = makeID("ID_37");
    // intellij stuff skill, self, uncommon, 0, 0, 0, 0, 5, 7

    public ID_37() {
        super(ID, -2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 5;
        exhaust = true;
    }

    @Override
    public void triggerOnManualDiscard()
    {

    }
    public void use(AbstractPlayer p, AbstractMonster m){}


    public void upp() {
        upgradeDamage(0);
        upgradeBlock(0);
        upgradeMagicNumber(7);
        upgradeBaseCost(-2);
    }
}