package code.cards;

import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_26 extends AbstractEasyCard {
    public final static String ID = makeID("ID_26");
    // intellij stuff skill, self, Uncommen, 0, 0, 3, 5, 0, 0

    public ID_26() {
        super(ID, 0, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 1;
        baseMagicNumber = magicNumber = 0;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        applyToSelf(new LambdaPower(makeID("ID_26_Power"), cardStrings.EXTENDED_DESCRIPTION[0], AbstractPower.PowerType.DEBUFF, false, p, 0) {


            public void onDrawOrDiscard()
            {
                this.flash();
                this.addToBot(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, block));
            }

            @Override
            public void atEndOfTurn(boolean isPlayer)
            {
                if(isPlayer)
                    this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, makeID("ID_26_Power")));
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
    }

    public void upp() {
        //upgradeDamage(0);
        upgradeBlock(1);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(0);
    }
}