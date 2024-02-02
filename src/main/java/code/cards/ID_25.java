package code.cards;

import code.cards.AbstractEasyCard;
import code.powers.LambdaPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_25 extends AbstractEasyCard {
    public final static String ID = makeID("ID_25");
    // intellij stuff attack, enemy, uncommon, 12, 6, 0, 0, 1, 0

    private boolean upgraded;
    public ID_25() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 12;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
        tags.add(CardTags.STRIKE);
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        upgraded = this.upgraded;
        dmg(m, AbstractGameAction.AttackEffect.NONE);
        applyToSelf(new LambdaPower(makeID("ID_25_Power"), "cardStrings.EXTENDED_DESCRIPTION[0]", AbstractPower.PowerType.DEBUFF, false, p, magicNumber) {

            @Override
            public void atStartOfTurnPostDraw()
            {
                this.flash();
                if(upgraded) {
                    atb(new DiscardAction(p, p, amount, true));
                }
                else {
                    atb(new DiscardAction(p,p,amount,false));
                }
                this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, makeID("ID_25_Power")));

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
        upgradeDamage(6);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(1);
    }
}