package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.unique.LoseEnergyAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Miracle;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.watcher.EnergyDownPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_41 extends AbstractEasyCard {
    public final static String ID = makeID("ID_41");
    // intellij stuff skill, self, uncommon, 0, 0, 0, 0, 2, 1

    public ID_41() {
        super(ID, -2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 2;
        exhaust = true;
    }

    @Override
    public void triggerWhenDrawn()
    {
        AbstractPlayer p = AbstractDungeon.player;

        atb(new DrawCardAction(magicNumber));
        this.addToTop(new ExhaustSpecificCardAction(this, AbstractDungeon.player.hand));

        applyToSelf(new LambdaPower(makeID("ID_41_Power"), "cardStrings.EXTENDED_DESCRIPTION[0]", AbstractPower.PowerType.BUFF, false, p, 1) {

            @Override
            public void atStartOfTurn() {
                atb(new LoseEnergyAction(amount));
                this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, makeID("ID_41_Power")));
            }
            @Override
            public void updateDescription() {
                description = ""; // cardStrings.EXTENDED_DESCRIPTION[1] + amount + cardStrings.EXTENDED_DESCRIPTION[2] + amount + cardStrings.EXTENDED_DESCRIPTION[3];
            }
        });
    }
    public void use(AbstractPlayer p, AbstractMonster m)
    {

    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        upgradeMagicNumber(1);
        //upgradeBaseCost(-2);
    }
}