package code.cards;

import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_53 extends AbstractEasyCard {
    public final static String ID = makeID("ID_53");
    // intellij stuff power, self, rare, 0, 0, 0, 0, 0, 0

    public ID_53() {
        super(ID, 1, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        applyToSelf(new LambdaPower(makeID("ID_53_Power"), AbstractPower.PowerType.BUFF, true, p, magicNumber) {

            @Override
            public void atStartOfTurn() {
                this.addToBot(new GainEnergyAction(1));
                this.flash();
            }
            @Override
            public void onInitialApplication() {
                AbstractDungeon.player.gameHandSize -= amount;
            }
            @Override
            public void onRemove() {
                AbstractDungeon.player.gameHandSize += amount;
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