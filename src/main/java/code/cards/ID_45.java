package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.watcher.MarkPower;

import java.util.Iterator;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_45 extends AbstractEasyCard {
    public final static String ID = makeID("ID_45");
    // intellij stuff power, self, rare, 0, 0, 0, 0, 0, 0

    public ID_45() {
        super(ID, 1, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        applyToSelf(new LambdaPower(makeID("ID_45_Power"), AbstractPower.PowerType.BUFF, true, p, magicNumber) {

            @Override
            public void atStartOfTurn()
            {
                this.addToTop(new ApplyPowerAction(p, p, new MarkPower(p, amount)));

            }
        });
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        //upgradeMagicNumber(1);
        //upgradeBaseCost(1);
        isInnate = true;
    }
}