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

public class ID_28Action extends AbstractGameAction {

    private static final UIStrings uiStrings = null;
    public static final String[] TEXT = new String[1];
    private AbstractPlayer p;
    public static int numDiscarded;
    private static final float DURATION = 0.1f;

    public ID_28Action(AbstractCreature target, AbstractCreature source, int amount) {
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
                AbstractCard tmpCard = p.hand.getBottomCard();

                int cnt;
                if(tmpCard.cost == -1)
                    cnt = EnergyPanel.getCurrentEnergy();
                else
                    cnt = tmpCard.costForTurn;
                p.hand.moveToDiscardPile(tmpCard);
                tmpCard.triggerOnManualDiscard();


                Iterator var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

                AbstractMonster mo;
                while(var3.hasNext()) {
                    mo = (AbstractMonster)var3.next();
                    this.addToBot(new ApplyPowerAction(mo, p, new StrengthPower(mo, -amount*cnt), -amount*cnt, true, AttackEffect.NONE));
                }

                var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

                while(var3.hasNext()) {
                    mo = (AbstractMonster)var3.next();
                    if (!mo.hasPower("Artifact")) {
                        this.addToBot(new ApplyPowerAction(mo, p, new GainStrengthPower(mo, amount*cnt), amount*cnt, true, AttackEffect.NONE));
                    }
                }
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
                else
                    cnt = tmpCard.costForTurn;
                p.hand.moveToDiscardPile(tmpCard);
                tmpCard.triggerOnManualDiscard();

                Iterator var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

                AbstractMonster mo;
                while(var3.hasNext()) {
                    mo = (AbstractMonster)var3.next();
                    this.addToBot(new ApplyPowerAction(mo, p, new StrengthPower(mo, -amount*cnt), -amount*cnt, true, AttackEffect.NONE));
                }

                var3 = AbstractDungeon.getCurrRoom().monsters.monsters.iterator();

                while(var3.hasNext()) {
                    mo = (AbstractMonster)var3.next();
                    if (!mo.hasPower("Artifact")) {
                        this.addToBot(new ApplyPowerAction(mo, p, new GainStrengthPower(mo, amount*cnt), amount*cnt, true, AttackEffect.NONE));
                    }
                }

                AbstractDungeon.handCardSelectScreen.selectedCards.clear();
                AbstractDungeon.handCardSelectScreen.wereCardsRetrieved = true;
            }

            this.tickDuration();
        }
    }


}