package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_21 extends AbstractEasyCard {
    public final static String ID = makeID("ID_21");
    // intellij stuff SKILL, ENEMY, COMMON, 0, 0, 7, 7, 1, 2

    public ID_21() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 0;
        baseBlock = 7;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        blck();
        this.addToBot(new ApplyPowerAction(m, m, new WeakPower(m, magicNumber, false)));
    }

    public void upp() {
        //upgradeDamage(0);
        upgradeBlock(7);
        upgradeMagicNumber(1);
        //upgradeBaseCost(0);
    }
}