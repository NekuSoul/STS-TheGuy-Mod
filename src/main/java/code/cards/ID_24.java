package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Iterator;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_24 extends AbstractEasyCard {
    public final static String ID = makeID("ID_24");
    // intellij stuff attack, enemey, uncommon, 12, 6, 0, 0, 0, 0

    public ID_24() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 12;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.NONE);

        Iterator<AbstractCard> cardsIterator = p.hand.group.iterator();
        while (cardsIterator.hasNext())
        {
            AbstractCard c = cardsIterator.next();
            if(c.cardID == Strike.ID) {
                atb(new ExhaustSpecificCardAction(c,p.hand));
                return;
            }
        }


    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        Iterator<AbstractCard> cardsIterator = p.hand.group.iterator();
        while (cardsIterator.hasNext())
        {
            if(((AbstractCard) cardsIterator.next()).cardID == Strike.ID)
                return true;
        }

        return false;

    }

    public void upp() {
        upgradeDamage(6);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(1);
    }
}