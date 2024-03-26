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

public class ID_70 extends AbstractEasyCard {
    public final static String ID = makeID("ID_70");
    // intellij stuff power, self, uncommon, 0, 0, 0, 0, 5, 3

    public ID_70() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 6;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new LambdaPower(makeID("ID_70_Power"), AbstractPower.PowerType.BUFF, false, p, magicNumber) {

            @Override
            public void onUseCard(AbstractCard card, UseCardAction action)
            {
                if(card.cardID.equals(makeID("ID_80")))
                {
                    atb(new DamageAllEnemiesAction(p,amount, DamageInfo.DamageType.THORNS, AbstractGameAction.AttackEffect.FIRE));
                }
            }

        });
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        upgradeMagicNumber(3);
        //upgradeBaseCost(1);
    }
}