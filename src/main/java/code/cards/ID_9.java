import code.cards.AbstractEasyCard;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_9 extends AbstractEasyCard {
    public final static String ID = makeID("ID_9");
    // intellij stuff SKILL, PLAYER, COMMON, 0, 0, 4, 2, 1, 1

    public ID_9() {
        super(ID, 0,  CardType. ATTACK, CardRarity. SPECIAL, CardTarget.  ENEMY);
        baseDamage = 0;        baseBlock = 4;        baseMagicNumber = magicNumber = 1;    }

    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    public void upp() {
    upgradeDamage(0);
    upgradeBlock(2);
    upgradeMagicNumber(1);
 upgradeBaseCost(0);
    }
}