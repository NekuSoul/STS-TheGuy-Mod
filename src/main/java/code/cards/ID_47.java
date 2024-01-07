package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_47 extends AbstractEasyCard {
    public final static String ID = makeID("ID_47");
    // intellij stuff attack, enemy, uncommon, 16, 9, 0, 0, 0, 0

    public ID_47() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 16;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.NONE);
    }

    public void upp() {
        upgradeDamage(9);
        upgradeBlock(0);
        upgradeMagicNumber(0);
        upgradeBaseCost(2);
    }
}