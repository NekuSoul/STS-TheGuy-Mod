package code.cards;

import code.actions.EasyXCostAction;
import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.FadingPower;
import com.megacrit.cardcrawl.vfx.combat.ExplosionSmallEffect;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_74 extends AbstractEasyCard {
    public final static String ID = makeID("ID_74");
    // intellij stuff skill, self, 0, 0, 0, 0, 0, 0, 0

    public ID_74() {
        super(ID, -1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 2;
        exhaust = true;
        isEthereal = true;
    }
    AbstractPlayer p;

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new EasyXCostAction(this, this::action));
        this.p = p;
    }

    public boolean action(int amount, int[] params)
    {
        atb(new GainEnergyAction(amount*magicNumber));
        atb(new DrawCardAction(amount));


        applyToSelf(new LambdaPower(makeID("ID_74_Power"), "cardStrings.EXTENDED_DESCRIPTION[0]", AbstractPower.PowerType.DEBUFF, true, p, amount) {
            @Override
            public void atEndOfTurn(boolean isPlayer)
            {
                if(!isPlayer) return;
                if (this.amount == 1 && !this.owner.isDying) {
                    this.addToBot(new VFXAction(new ExplosionSmallEffect(this.owner.hb.cX, this.owner.hb.cY), 0.1F));
                    this.addToBot(new LoseHPAction(this.owner, this.owner, 69420));
                } else {
                    this.addToBot(new ReducePowerAction(this.owner, this.owner, makeID("ID_74_Power"), 1));
                    this.updateDescription();
                }
            }

            @Override
            public void updateDescription() {
                description = ""; // cardStrings.EXTENDED_DESCRIPTION[1] + amount + cardStrings.EXTENDED_DESCRIPTION[2] + amount + cardStrings.EXTENDED_DESCRIPTION[3];
            }
        });


        return true;
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(-1);
        isEthereal = false;
        selfRetain = true;
    }
}