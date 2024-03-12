package code.relics;

import code.CharacterFile;
import code.cards.ID_80;
import code.util.Wiz;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.curses.CurseOfTheBell;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.localization.LocalizedStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.ToxicEgg2;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Objects;

import static code.ModFile.makeID;
import static code.util.Wiz.applyToSelf;

public class Relic_8 extends AbstractEasyRelic{
    public static final String ID = makeID("Relic_8");

    public Relic_8() {
        super(ID, RelicTier.UNCOMMON, LandingSound.FLAT, CharacterFile.Enums.THE_GUY_COLOR);
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    public boolean cardSelected = false;
    public AbstractCard card = null;

    public void onEquip() {
        if (AbstractDungeon.player.masterDeck.getPurgeableCards().getSkills().size() > 0) {
            this.cardSelected = false;
            if (AbstractDungeon.isScreenUp) {
                AbstractDungeon.dynamicBanner.hide();
                AbstractDungeon.overlayMenu.cancelButton.hide();
                AbstractDungeon.previousScreen = AbstractDungeon.screen;
            }

            AbstractDungeon.getCurrRoom().phase = AbstractRoom.RoomPhase.INCOMPLETE;
            AbstractDungeon.gridSelectScreen.open(AbstractDungeon.player.masterDeck.getPurgeableCards(), 1, "this.DESCRIPTIONS[1] + this.name + LocalizedStrings.PERIOD", false, false, false, false);
        }
    }

    public void update() {
        super.update();
        if (!this.cardSelected && !AbstractDungeon.gridSelectScreen.selectedCards.isEmpty()) {
            this.cardSelected = true;
            this.card = (AbstractCard)AbstractDungeon.gridSelectScreen.selectedCards.get(0);
            this.card.exhaust = true;
            AbstractDungeon.getCurrRoom().phase = AbstractRoom.RoomPhase.COMPLETE;
            AbstractDungeon.gridSelectScreen.selectedCards.clear();
            this.description = "this.DESCRIPTIONS[2] + FontHelper.colorString(this.card.name, ) + this.DESCRIPTIONS[3];";
            this.tips.clear();
            this.tips.add(new PowerTip(this.name, this.description));
            this.initializeTips();
        }

    }


    @Override
    public boolean canSpawn() {
        return true;
    }

    @Override
    public AbstractRelic makeCopy() {
        return new Relic_8();
    }
}