package code.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.defect.ScrapeFollowUpAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.powers.NightmarePower;

public class ID12_Action extends AbstractGameAction {

    private static final UIStrings uiStrings = null;
    public static final String[] TEXT = new String[1];
    private AbstractPlayer p;
    public static int numDiscarded;
    private static final float DURATION = 0.1f;

    public ID12_Action(AbstractCreature target, AbstractCreature source, int amount) {
        this.setValues(target, source, amount);
        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = DURATION;
        this.p = (AbstractPlayer)target;

        TEXT[0] = "Discard";
    }

    public void update() {
        if (this.duration == DURATION) {
            if (this.p.hand.isEmpty()) {
                this.isDone = true;
            } else if (this.p.hand.size() == 1) {
                this.addToBot(new DrawCardAction(amount, new ID_12DrawFollowUpAction(this.p.hand.getBottomCard().type)));
                this.isDone = true;
            } else {
                AbstractDungeon.handCardSelectScreen.open(TEXT[0], 1, false, false);
                this.tickDuration();
            }
        } else {
            if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
                AbstractCard tmpCard = AbstractDungeon.handCardSelectScreen.selectedCards.getBottomCard();
                //this.addToTop(new ApplyPowerAction(this.p, this.p, new NightmarePower(this.p, this.amount, tmpCard)));
                this.addToBot(new DrawCardAction(amount, new ID_12DrawFollowUpAction(tmpCard.type)));
                AbstractDungeon.player.hand.moveToDiscardPile(tmpCard);
                tmpCard.triggerOnManualDiscard();

                AbstractDungeon.handCardSelectScreen.selectedCards.clear();
                AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
            }

            this.tickDuration();
        }
    }


}
