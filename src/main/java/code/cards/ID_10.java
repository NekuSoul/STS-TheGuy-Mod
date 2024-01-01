import code.cards.AbstractEasyCard;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_10 extends AbstractEasyCard {
    public final static String ID = makeID("ID_10");
    // intellij stuff ATTACK, ENEMY, COMMON, 7, 5, 0, 0, 0, 0

    public ID_10() {
        super(ID, 2,  CardType. ATTACK, CardRarity. SPECIAL, CardTarget.  ENEMY);
        baseDamage = 7;        baseBlock = 0;        baseMagicNumber = magicNumber = 0;    }

    public void use(AbstractPlayer p, AbstractMonster m) {

    }

    public void upp() {
    upgradeDamage(5);
    upgradeBlock(0);
    upgradeMagicNumber(0);
 upgradeBaseCost(0);
    }
}