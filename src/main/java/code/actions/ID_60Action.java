package code.actions;

import code.CharacterFile;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.Iterator;

public class ID_60Action extends AbstractGameAction {

    public ID_60Action() {
        this.duration = Settings.ACTION_DUR_FAST;
    }

    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        if (this.duration == Settings.ACTION_DUR_FAST) {
            Iterator cards = p.hand.group.iterator();
            while (cards.hasNext()) {
                AbstractCard card = (AbstractCard) cards.next();
                if (card.hasTag(CharacterFile.THEGUY_TAGS.Punch_THE_GUY) && card.cost > 0) {
                    if(card.costForTurn > 0)
                        card.costForTurn -= 1;
                    card.isCostModifiedForTurn = true;
                    card.cost -= 1;
                    card.isCostModified = true;
                }
            }
            cards = p.discardPile.group.iterator();
            while (cards.hasNext()) {
                AbstractCard card = (AbstractCard) cards.next();
                if (card.hasTag(CharacterFile.THEGUY_TAGS.Punch_THE_GUY) && card.cost > 0) {
                    if(card.costForTurn > 0)
                        card.costForTurn -= 1;
                    card.isCostModifiedForTurn = true;
                    card.cost -= 1;
                    card.isCostModified = true;
                }
            }
            cards = p.drawPile.group.iterator();
            while (cards.hasNext()) {
                AbstractCard card = (AbstractCard) cards.next();
                if (card.hasTag(CharacterFile.THEGUY_TAGS.Punch_THE_GUY) && card.cost > 0) {
                    if(card.costForTurn > 0)
                        card.costForTurn -= 1;
                    card.isCostModifiedForTurn = true;
                    card.cost -= 1;
                    card.isCostModified = true;
                }
            }
        }
        this.tickDuration();
    }
}