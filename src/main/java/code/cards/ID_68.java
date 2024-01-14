package code.cards;

import code.actions.ID_68Action;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_68 extends AbstractEasyCard {
    public final static String ID = makeID("ID_68");
    // intellij stuff skill, self, uncommon, 0, 0, 0, 0, 4, -1

    public ID_68() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new ID_68Action(magicNumber));
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        upgradeMagicNumber(-1);
        //upgradeBaseCost(1);
    }
}