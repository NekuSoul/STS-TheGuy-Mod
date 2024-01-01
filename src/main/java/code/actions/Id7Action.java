package code.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.actions.defect.ShuffleAllAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class Id7Action extends AbstractGameAction {
    private boolean upgraded;

    public Id7Action(boolean upgraded) {
        this.upgraded = upgraded;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;

        if (upgraded) {
            this.addToBot(new ShuffleAllAction());
            this.addToBot(new ShuffleAction(AbstractDungeon.player.drawPile, false));
        }
        else {
            addToBot(new DiscardAction(p, AbstractDungeon.player, p.hand.size(), false));
        }

        this.isDone = true;
    }
}
