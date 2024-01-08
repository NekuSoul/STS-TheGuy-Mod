package code.cards;

import code.actions.ID12_Action;
import code.actions.ID_28Action;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_28 extends AbstractEasyCard {
    public final static String ID = makeID("ID_28");
    // intellij stuff skill, all_enemy, uncommon, 0, 0, 0, 0, 2, 1

    public ID_28() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new ID_28Action(p,p,magicNumber));
    }

    public void upp() {
        //upgradeDamage(0);
        //upgradeBlock(0);
        upgradeMagicNumber(1);
        //upgradeBaseCost(1);
    }
}