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
import com.megacrit.cardcrawl.helpers.input.InputHelper;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.relics.ToxicEgg2;
import com.megacrit.cardcrawl.rewards.RewardItem;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Objects;

import static code.ModFile.makeID;
import static code.util.Wiz.applyToSelf;

public class Relic_6 extends AbstractEasyRelic{
    public static final String ID = makeID("Relic_6");

    public Relic_6() {
        super(ID, RelicTier.UNCOMMON, LandingSound.FLAT, CharacterFile.Enums.THE_GUY_COLOR);
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    private boolean cardsReceived = true;

    public void onEquip() {
        this.cardsReceived = false;
        /*
        CardGroup group = new CardGroup(CardGroup.CardGroupType.UNSPECIFIED);
        AbstractCard bellCurse = new CurseOfTheBell();
        UnlockTracker.markCardAsSeen(bellCurse.cardID);
        group.addToBottom(bellCurse.makeCopy());
        AbstractDungeon.gridSelectScreen.openConfirmationGrid(group, "this is a const on Relic");
         */
    }

    public void update() {
        super.update();
        if (!this.cardsReceived && !AbstractDungeon.isScreenUp) {

            AbstractRelic rndRelic = (AbstractRelic) (Wiz.getRandomItem(AbstractDungeon.player.relics)).makeCopy();

            AbstractDungeon.combatRewardScreen.open();
            AbstractDungeon.combatRewardScreen.rewards.clear();

            AbstractDungeon.combatRewardScreen.rewards.add(new RewardItem(rndRelic));

            AbstractDungeon.combatRewardScreen.positionRewards();
            //AbstractDungeon.overlayMenu.proceedButton.setLabel("this is a const on the Relic");
            this.cardsReceived = true;
            AbstractDungeon.getCurrRoom().rewardPopOutTimer = 0.25F;
        }

    }

    @Override
    public boolean canSpawn() {
        int relicCount = 0;
        for (AbstractRelic abstractRelic : AbstractDungeon.player.relics) {
            relicCount++;
        }

        return Settings.isEndless || relicCount > 4;
    }

    @Override
    public AbstractRelic makeCopy() {
        return new Relic_6();
    }
}