package code.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
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

        int size = p.hand.size();
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

        if(upgraded) {
            size = p.discardPile.size();
            for (int i = 0; i < size; ++i) {
                AbstractCard c = p.discardPile.getTopCard();
                c.triggerOnManualDiscard();
            }
        }



        this.isDone = true;
    }
}
