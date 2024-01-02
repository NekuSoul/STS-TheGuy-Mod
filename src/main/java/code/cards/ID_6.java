package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_6 extends AbstractEasyCard {
    public final static String ID = makeID("ID_6");
    // intellij stuff Skill, Self, uncommon, 0, 0, 0, 0, 0, 0

    public ID_6() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
        cardsToPreview = new Shiv();
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        makeInHand(new Shiv(),GameActionManager.totalDiscardedThisTurn);
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        upgradeBaseCost(1);
    }
}