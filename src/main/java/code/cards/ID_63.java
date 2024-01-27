package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_63 extends AbstractEasyCard {
    public final static String ID = makeID("ID_63");
    // intellij stuff skill, self, uncommon, 0, 0, 0, 0, 1, 0

    public ID_63() {
        super(ID, 1, CardType.SKILL, CardRarity.SPECIAL, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        applyToSelf(new LambdaPower(makeID("ID_63_Power"), "cardStrings.EXTENDED_DESCRIPTION[0]", AbstractPower.PowerType.BUFF, false, p, 1) {

            @Override
            public void onManualDiscard(){
                applyToSelf(new DexterityPower(p, amount));
            }

            public void atEndOfTurn(boolean isPlayer)
            {
                if(!isPlayer) return;
                this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, makeID("ID_63_Power")));
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