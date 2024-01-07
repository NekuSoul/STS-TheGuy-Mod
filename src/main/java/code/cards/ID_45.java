package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

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
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        applyToSelf(new LambdaPower(makeID("ID_45_Power"), "cardStrings.EXTENDED_DESCRIPTION[0]", AbstractPower.PowerType.BUFF, true, p, 0) {

            @Override
            public void atStartOfTurn()
            {
                AbstractPower ap = null;
                if(!p.hasPower("PathToVictoryPower")) return;
                Iterator<AbstractPower> var2 = p.powers.iterator();
                do {
                    if (!var2.hasNext()) {
                        break;
                    }
                    ap = (AbstractPower)var2.next();
                } while(!ap.ID.equals("PathToVictoryPower"));
                int cnt = ap.amount;
                if(magicNumber == 0)
                {
                    for (int i = 0; i < cnt; i++)
                    {
                        atb(new DrawCardAction(1));
                        atb(new DiscardAction(p,p,1,true));
                    }
                }
                else
                {
                    for (int i = 0; i < cnt; i++) {
                        atb(new DiscardAction(p, p, 1, true));
                        atb(new DrawCardAction(1));
                    }
                }

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
        upgradeMagicNumber(1);
        upgradeBaseCost(1);
    }
}