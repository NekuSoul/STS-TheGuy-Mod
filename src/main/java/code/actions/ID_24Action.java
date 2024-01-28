package code.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.ShuffleAction;
import com.megacrit.cardcrawl.actions.defect.ShuffleAllAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.Iterator;

public class ID_24Action extends AbstractGameAction {
    public ID_24Action() {
        this.duration = DURATION;
    }
    private static final float DURATION;
    public void update() {
        AbstractPlayer p = AbstractDungeon.player;
        if (this.duration == DURATION) {
            if (AbstractDungeon.getMonsters().areMonstersBasicallyDead() || p.hand.size()<2) {
                this.isDone = true;
                return;
            }
            AbstractDungeon.handCardSelectScreen.open("TEXT[0]", 2, false, false);
            tickDuration();
            return;
        }

        if (!AbstractDungeon.handCardSelectScreen.wereCardsRetrieved) {
            Iterator var4 = AbstractDungeon.handCardSelectScreen.selectedCards.group.iterator();

            if(!var4.hasNext())
            {
                this.isDone = true;
                return;
            }
            AbstractCard card1 = (AbstractCard)var4.next();
            if(!var4.hasNext())
            {
                this.isDone = true;
                return;
            }
            AbstractCard card2 = (AbstractCard)var4.next();
            int BaseDmg = card1.baseDamage;
            int BaseBlock = card1.baseBlock;
            int BaseMagicNr = card1.baseMagicNumber;
            int cost = card1.cost;
            int costForTurn = card1.costForTurn;

            card1.baseDamage = card2.baseDamage;
            card1.baseBlock = card2.baseBlock;
            card1.baseMagicNumber = card2.baseMagicNumber;
            card1.cost = card2.cost;
            card1.costForTurn = card2.costForTurn;
            card1.isCostModified = true;

            card2.baseDamage = BaseDmg;
            card2.baseBlock = BaseBlock;
            card2.baseMagicNumber = BaseMagicNr;
            card2.cost = cost;
            card2.costForTurn = costForTurn;
            card2.isCostModified = true;

            p.hand.addToHand(card1);
            p.hand.addToHand(card2);

            AbstractDungeon.handCardSelectScreen.selectedCards.clear();

            AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
            this.isDone = true;
        }


        this.isDone = true;
    }

    static {
        DURATION = Settings.ACTION_DUR_XFAST;
    }

}