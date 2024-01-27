package code.cards;

import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;

public class ID_51 extends AbstractEasyCard {
    public final static String ID = makeID("ID_51");
    // intellij stuff skill, self, uncommen, 0, 0, 0, 0, 3, 1

    public ID_51() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 3;
        baseSecondMagic = secondMagic = 3;
        selfRetain = true;
    }
    public void onRetained()
    {
            secondMagic ++;
    }
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.addToBot(new DiscardAction(p,p,magicNumber,false));
        this.addToTop(new DrawCardAction(p, secondMagic));

    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        upgradeBaseCost(0);
    }
}