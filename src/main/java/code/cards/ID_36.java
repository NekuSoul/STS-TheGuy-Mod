package code.cards;

import code.actions.EasyXCostAction;
import code.actions.ID_72Action;
import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.NewQueueCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_36 extends AbstractEasyCard {
    public final static String ID = makeID("ID_36");
    // intellij stuff skill, self, uncommon, 0, 0, 0, 0, 0, 0

    public ID_36() {
        super(ID, -1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new EasyXCostAction(this, this::action));
    }


    public boolean action(int amount, int[] params)
    {
        AbstractPlayer p = AbstractDungeon.player;
        if(this.upgraded)
            amount++;
        applyToSelf(new LambdaPower(makeID("ID_36_Power"), "cardStrings.EXTENDED_DESCRIPTION[0]", AbstractPower.PowerType.BUFF, false, p, amount) {

            @Override
            public void onManualDiscard()
            {
                if(amount > 0)
                {
                    amount--;
                    AbstractMonster target = AbstractDungeon.getCurrRoom().monsters.getRandomMonster((AbstractMonster)null, true, AbstractDungeon.cardRandomRng);
                    atb(new ID_72Action(target,false));
                }
                if(amount == 0)
                    this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, makeID("ID_36_Power")));
            }
            @Override
            public void updateDescription() {
                if(magicNumber == 0) {
                    description = "1";
                }
                else {
                    description = "2";
                }
            }
        });

        return true;
    }

    public void upp() {
        upgradeDamage(0);
        upgradeBlock(0);
        upgradeMagicNumber(0);
        upgradeBaseCost(-1);
    }
}