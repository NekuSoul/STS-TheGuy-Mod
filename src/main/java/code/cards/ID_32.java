package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.TalkAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ConfusionPower;
import com.megacrit.cardcrawl.vfx.combat.ExplosionSmallEffect;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_32 extends AbstractEasyCard {
    public final static String ID = makeID("ID_32");
    // intellij stuff power, self, rare, 0, 0, 0, 0, 2, 0

    public ID_32() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new SFXAction("VO_CULTIST_1A"));
        this.addToBot(new TalkAction(true, "Birds are not real", 1.0F, 2.0F));


        applyToSelf(new LambdaPower(makeID("ID_32_Power"), "cardStrings.EXTENDED_DESCRIPTION[0]", AbstractPower.PowerType.BUFF, true, p, 2) {

            @Override
            public void onInitialApplication()
            {
                atb(new DrawCardAction(magicNumber));
            }
            @Override
            public void onCardDraw(AbstractCard card) {
                if (card.cost >= 0) {
                    int newCost = AbstractDungeon.cardRandomRng.random(3);
                    if (card.cost != newCost) {
                        card.cost = newCost;
                        card.costForTurn = card.cost;
                        card.isCostModified = true;
                    }

                    card.freeToPlayOnce = false;
                }
            }

            @Override
            public void atEndOfTurn(boolean isPlayer)
            {
                if(!isPlayer) return;
                this.addToBot(new ReducePowerAction(this.owner, this.owner, makeID("ID_32_Power"), 1));
                this.updateDescription();

                if(amount == 0)
                    this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, makeID("ID_32_Power")));
            }

            @Override
            public void updateDescription() {
                description = ""; // cardStrings.EXTENDED_DESCRIPTION[1] + amount + cardStrings.EXTENDED_DESCRIPTION[2] + amount + cardStrings.EXTENDED_DESCRIPTION[3];
            }
        });


    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        upgradeBaseCost(0);
    }
}