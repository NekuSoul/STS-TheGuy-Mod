package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_30 extends AbstractEasyCard {
    public final static String ID = makeID("ID_30");
    // intellij stuff power, self, rare, 0, 0, 0, 0, 0, 0

    public ID_30() {
        super(ID, 3, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        applyToSelf(new LambdaPower(makeID("ID_30_Power"), AbstractPower.PowerType.BUFF, false, p, magicNumber) {

            public void atStartOfTurn() {
                    applyToSelf(new LambdaPower(makeID("ID_30_Power_Power"), AbstractPower.PowerType.BUFF, false, p, magicNumber) {

                        @Override
                        public void onPlayCard(AbstractCard card, AbstractMonster m)
                        {
                            if(card.cost != -1) return;
                            if(amount < 1) return;
                            card.freeToPlayOnce = true;
                            amount--;
                            if(amount == 0)
                                this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, makeID("ID_30_Power_Power")));

                        }
                        @Override
                        public void atEndOfTurn(boolean isPlayer) {
                            if(isPlayer)
                                this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, makeID("ID_30_Power_Power")));
                        }

                    });
                }

            });
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        upgradeBaseCost(2);
    }
}