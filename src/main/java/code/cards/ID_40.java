package code.cards;

import code.actions.EasyXCostAction;
import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_40 extends AbstractEasyCard {
    public final static String ID = makeID("ID_40");
    // intellij stuff power, self, rare, 0, 0, 0, 0, 0, 0

    public ID_40() {
        super(ID, -1, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new EasyXCostAction(this, this::action));
    }

    public boolean action(int amount, int[] params)
    {
        amount+= magicNumber;

        if(amount < 1) return true;
        AbstractPlayer p = AbstractDungeon.player;

        applyToSelf(new LambdaPower(makeID("ID_40_Power"), AbstractPower.PowerType.BUFF, false, p, amount) {

            @Override
            public void onPlayCard(AbstractCard card, AbstractMonster m)
            {
                if (card.type != CardType.ATTACK) return;

                for (int i = 0; i < amount; i++)
                {
                    AbstractCard newCard = card.makeCopy();
                    if (card.costForTurn >= 0) {
                        newCard.cost = 0;
                        newCard.isCostModified = true;
                    }
                    if (magicNumber == 1)
                        newCard.upgrade();

                    this.addToBot(new MakeTempCardInDiscardAction(newCard, 1));
                }
                card.cost = 0;
            }
        });

        return true;
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        upgradeMagicNumber(1);
        //upgradeBaseCost(-1);
    }
}