package code.cards;

import code.actions.Id7Action;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Iterator;

import static code.ModFile.makeID;

public class ID_7 extends AbstractEasyCard {
    public final static String ID = makeID("ID_7");
    // intellij stuff SKILL, PLAYER, RARE, 0, 0, 0, 0, 0, 0

    public ID_7() {
        super(ID, -1, CardType.SKILL, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {

        int size = p.discardPile.size();
        for(int i = 0; i < size; ++i) {
            AbstractCard c = p.discardPile.getTopCard();
            c.triggerOnManualDiscard();
        }

        size = p.hand.size();
        for(int i = 0; i < size; ++i) {
            AbstractCard c = p.hand.getTopCard();
            p.hand.moveToDiscardPile(c);
            c.triggerOnManualDiscard();
            GameActionManager.incrementDiscard(true);
        }

        size = p.drawPile.size();
        for(int i = 0; i < size; ++i) {
            AbstractCard c = p.drawPile.getTopCard();
            p.drawPile.moveToDiscardPile(c);
            c.triggerOnManualDiscard();
            GameActionManager.incrementDiscard(true);
        }
    }

    public void upp() {
    }
}

