package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_71 extends AbstractEasyCard {
    public final static String ID = makeID("ID_71");
    // intellij stuff skill, self, uncommon, 0, 0, 0, 0, 1, 0

    public ID_71() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new LambdaPower(makeID("ID_71_Power"), AbstractPower.PowerType.BUFF, false, p, magicNumber) {

            @Override
            public void onManualDiscard(){

                if(amount > 0) {
                    amount--;
                    AbstractCard card = p.discardPile.getTopCard();
                    p.discardPile.removeCard(card);
                    p.discardPile.moveToHand(card);
                }
                if(amount == 0)
                    this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, makeID("ID_71_Power")));
            }

            public void atEndOfTurn(boolean isPlayer)
            {
                if(!isPlayer) return;
                this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, makeID("ID_71_Power")));
            }
        });
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        upgradeMagicNumber(1);
        //upgradeBaseCost(0);
    }
}