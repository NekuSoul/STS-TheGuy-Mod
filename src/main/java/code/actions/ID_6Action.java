package code.actions;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToDiscardEffect;
import com.megacrit.cardcrawl.vfx.cardManip.ShowCardAndAddToHandEffect;

public class ID_6Action extends AbstractGameAction {

    private final AbstractCard cardToAdd;
    private boolean cardsAdded = false;

    public ID_6Action(AbstractCard card, int number) {
        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = Settings.ACTION_DUR_FAST;
        this.amount = number;
        this.cardToAdd = card;
    }

    public void update() {
        if (!this.cardsAdded) {
            while (amount > 0) {
                AbstractCard disCard = cardToAdd.makeCopy();
                if (AbstractDungeon.player.hand.size() < 10) {
                    AbstractDungeon.effectList.add(
                            new ShowCardAndAddToHandEffect(disCard,
                                    (float) Settings.WIDTH /
                                            2.0F,
                                    (float) Settings.HEIGHT /
                                            2.0F));
                } else {
                    AbstractDungeon.effectList.add(
                            new ShowCardAndAddToDiscardEffect(disCard,
                                    (float) Settings.WIDTH /
                                            2.0F,
                                    (float) Settings.HEIGHT /
                                            2.0F));
                }
                disCard.setCostForTurn(0);
                disCard.purgeOnUse = true;
                amount--;
            }
            this.cardsAdded = true;
        }
        this.tickDuration();
    }
}