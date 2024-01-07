package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_35 extends AbstractEasyCard {
    public final static String ID = makeID("ID_35");
    // intellij stuff skill, self, uncommon, 0, 0, 0, 0, 0, 0

    public ID_35() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        CardGroup discard = p.discardPile;
        CardGroup temp;

        temp = discard;
        p.discardPile = p.drawPile;
        p.drawPile = temp;
    }

    public void upp() {
        upgradeDamage(0);
        upgradeBlock(0);
        upgradeMagicNumber(0);
        upgradeBaseCost(0);
    }
}