package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.watcher.MarkPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_9 extends AbstractEasyCard {
    public final static String ID = makeID("ID_9");
    // intellij stuff SKILL, PLAYER, COMMON, 0, 0, 4, 2, 1, 1

    public ID_9() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 0;
        baseBlock = 4;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        blck();
        this.addToBot(new ApplyPowerAction(p, p, new MarkPower(p, magicNumber)));
    }

    public void upp() {
        upgradeDamage(0);
        upgradeBlock(2);
        upgradeMagicNumber(1);
        upgradeBaseCost(0);
    }
}