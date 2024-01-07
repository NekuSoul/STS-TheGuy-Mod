package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.WeakPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_44 extends AbstractEasyCard {
    public final static String ID = makeID("ID_44");
    // intellij stuff skill, enemy, uncommon, 0, 0, 15, 3, 1, 1

    public ID_44() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 0;
        baseBlock = 15;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false), this.magicNumber));
        this.addToBot(new GainBlockAction(p, p, this.block));
    }

    public void upp() {
        upgradeDamage(0);
        upgradeBlock(3);
        upgradeMagicNumber(1);
        upgradeBaseCost(2);
    }
}