package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class Id8Card extends AbstractEasyCard {
    public final static String ID = makeID("Id8Card");
    // intellij stuff SKILL, PLAYER, COMMON, 0, 0, 0, 0, 0, 0

    public Id8Card() {
        super(ID, 1, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot(new DiscardAction(p, p, 3, false));
        addToBot(new DrawCardAction(magicNumber));
    }

    public void upp() {
        upgradeDamage(0);
        upgradeBlock(0);
        upgradeMagicNumber(1);
        upgradeBaseCost(1);
    }
}