package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_20 extends AbstractEasyCard {
    public final static String ID = makeID("ID_20");
    // intellij stuff attack, enemy, common, 11, 4, 0, 0, 0, 0

    public ID_20() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        exhaust = true;
        baseDamage = 11;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }
    @Override
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.NONE);
        applyToSelf(new EnergizedPower(p,magicNumber));
    }

    public void upp() {
        upgradeDamage(4);
        upgradeBlock(0);
        upgradeMagicNumber(1);
        upgradeBaseCost(2);
    }
}