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
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.GainStrengthPower;
import com.megacrit.cardcrawl.powers.NightmarePower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import java.util.Iterator;

public class ID_66Action extends AbstractGameAction {

    private static final UIStrings uiStrings = null;
    public static final String[] TEXT = new String[1];
    private AbstractPlayer p;
    public static int numDiscarded;
    private static final float DURATION = 0.1f;

    public ID_66Action(AbstractCreature target) {
        p = AbstractDungeon.player;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = DURATION;
        this.target = target;
        TEXT[0] = "Exhaust";
    }

    public void update() {
        if (this.duration == DURATION) {
            if (this.p.hand.isEmpty()) {
                this.isDone = true;
            } else if (this.p.hand.size() == 1) {
                AbstractCard tmpCard = p.hand.getBottomCard();

                int cnt;
                if(tmpCard.cost == -1)
                    cnt = EnergyPanel.getCurrentEnergy();
                else if(tmpCard.cost == -2)
                    cnt = 0;
                else
                    cnt = tmpCard.costForTurn;
                this.addToBot(new ApplyPowerAction(target, p, new StrengthPower(target, -cnt), -cnt));
                p.hand.moveToExhaustPile(tmpCard);
                this.isDone = true;
            } else {
                AbstractDungeon.handCardSelectScreen.open(TEXT[0], 1, false, true);
                this.tickDuration();
            }
        } else {
            if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
                if(AbstractDungeon.handCardSelectScreen.selectedCards.isEmpty()) {
                    isDone = true;
                    return;
                }
                AbstractCard tmpCard = AbstractDungeon.handCardSelectScreen.selectedCards.getBottomCard();

                int cnt;
                if(tmpCard.cost == -1)
                    cnt = EnergyPanel.getCurrentEnergy();
                else if(tmpCard.cost == -2)
                    cnt = 0;
                else
                    cnt = tmpCard.costForTurn;

                this.addToBot(new ApplyPowerAction(target, p, new StrengthPower(target, -cnt), -cnt));

                p.hand.moveToExhaustPile(tmpCard);



                AbstractDungeon.handCardSelectScreen.selectedCards.clear();
                AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
            }

            this.tickDuration();
        }
    }


}