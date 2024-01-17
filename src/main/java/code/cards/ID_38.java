package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;

import java.util.Iterator;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_38 extends AbstractEasyCard {
    public final static String ID = makeID("ID_38");
    // intellij stuff skill, self, uncommon, 0, 0, 0, 0, 1, 1

    public ID_38() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        applyToSelf(new LambdaPower(makeID("ID_38_Power"), "cardStrings.EXTENDED_DESCRIPTION[0]", AbstractPower.PowerType.BUFF, false, p, magicNumber) {

            @Override
            public void onAttack(DamageInfo info, int damageAmount, AbstractCreature target)
            {
                if(damageAmount > 1) {
                    Iterator var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

                    while (var3.hasNext()) {
                        AbstractMonster mo = (AbstractMonster) var3.next();
                        this.addToTop(new ApplyPowerAction(mo, p, new VulnerablePower(mo, amount, false), amount, true, AbstractGameAction.AttackEffect.NONE));
                    }
                }
            }

            public void atEndOfTurn(boolean isPlayer)
            {
                if(!isPlayer) return;
                this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, makeID("ID_38_Power")));
            }

            @Override
            public void updateDescription() {
                description = ""; // cardStrings.EXTENDED_DESCRIPTION[1] + amount + cardStrings.EXTENDED_DESCRIPTION[2] + amount + cardStrings.EXTENDED_DESCRIPTION[3];
            }
        });
    }

    public void upp() {
        upgradeDamage(0);
        upgradeBlock(0);
        upgradeMagicNumber(1);
        upgradeBaseCost(1);
    }
}