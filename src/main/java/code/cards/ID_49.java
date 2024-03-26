package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.PlayTopCardAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_49 extends AbstractEasyCard {
    public final static String ID = makeID("ID_49");
    // intellij stuff Power, Self, Rare, 0, 0, 0, 0, 0, 1

    public ID_49() {
        super(ID, 1, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        applyToSelf(new LambdaPower(makeID("ID_49_Power"), AbstractPower.PowerType.BUFF, true, p, magicNumber) {

            @Override
            public void onManualDiscard()
            {
                AbstractCard card = p.discardPile.getTopCard();
                card.modifyCostForCombat(-amount);
            }
        });
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        //upgradeMagicNumber(1);
        upgradeBaseCost(0);
    }
}