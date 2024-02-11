
package code.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.Iterator;

public class ID_29Action extends AbstractGameAction
{
    private static final UIStrings uiStrings;
    public static final String[] TEXT;
    int multiplier;
    private static float DURATION = 0.1f;
    private AbstractPlayer p;
    public ID_29Action(int multiplier)
    {
        this.multiplier = multiplier;
        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = DURATION;
        this.p = AbstractDungeon.player;
    }
    @Override
    public void update() {
        AbstractCard c;
        if (this.duration == DURATION) {
            if (p.hand.isEmpty()) {
                this.isDone = true;
                return;
            }
            AbstractDungeon.handCardSelectScreen.open(TEXT[0], 1, false, true);
            tickDuration();
            return;
        }

        if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
            c = AbstractDungeon.handCardSelectScreen.selectedCards.getBottomCard();
            c.baseBlock *= multiplier;
            c.baseDamage *= multiplier;
            c.baseDiscard *= multiplier;
            c.baseDraw *= multiplier;
            c.baseHeal *= multiplier;
            c.baseMagicNumber *= multiplier;
            c.magicNumber *=multiplier;
            if(c.cost > 0) {
                c.cost *= multiplier;
                c.costForTurn = c.cost;
                c.isCostModified = true;
            }
            for (int i = 0; i < multiplier; i+=2) {
                c.name = "Double " + c.name;
            }
            AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
            c.superFlash();
            c.applyPowers();
            this.p.hand.addToTop(c);
            this.isDone = true;
        }
        this.tickDuration();
    }
    static {
        uiStrings = CardCrawlGame.languagePack.getUIString("DiscardAction");
        TEXT = uiStrings.TEXT;
        DURATION = Settings.ACTION_DUR_XFAST;
    }
}
