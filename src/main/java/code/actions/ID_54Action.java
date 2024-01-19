package code.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class ID_54Action extends AbstractGameAction {

    int amount;
    AbstractCard c;
    public ID_54Action(AbstractCard c, int amount) {
        this.duration = Settings.ACTION_DUR_FAST;
        this.amount = amount;
        this.c = c;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            c.modifyCostForCombat(amount);
        }

        this.tickDuration();
    }
}
