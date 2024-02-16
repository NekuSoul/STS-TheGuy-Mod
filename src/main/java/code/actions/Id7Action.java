package code.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.actions.defect.ShuffleAllAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.Iterator;

public class Id7Action extends AbstractGameAction {
    private boolean upgraded;

    public Id7Action(boolean upgraded) {
        this.upgraded = upgraded;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        Iterator cards = p.drawPile.group.iterator();
        while(cards.hasNext())
        {
            AbstractCard card = (AbstractCard) cards.next();
            card.triggerOnManualDiscard();
            card.moveToDiscardPile();
        }
        cards = p.discardPile.group.iterator();
        while(cards.hasNext())
        {
            AbstractCard card = (AbstractCard) cards.next();
            card.triggerOnManualDiscard();
        }
        cards = p.hand.group.iterator();
        while(cards.hasNext())
        {
            AbstractCard card = (AbstractCard) cards.next();
            card.triggerOnManualDiscard();
            card.moveToDiscardPile();
        }

        this.isDone = true;
    }
}
