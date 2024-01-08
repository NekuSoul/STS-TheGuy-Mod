package code.cards;

import code.actions.ID12_Action;
import code.actions.ID_12DrawFollowUpAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;

public class ID_12 extends AbstractEasyCard {
    public final static String ID = makeID("ID_12");
    // intellij stuff SKILL, SELF, COMMON, 0, 0, 0, 0, 4, 2

    public ID_12() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 4;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        addToBot(new ID12_Action(p,p,magicNumber));
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        upgradeMagicNumber(2);
        //upgradeBaseCost(0);
    }
}