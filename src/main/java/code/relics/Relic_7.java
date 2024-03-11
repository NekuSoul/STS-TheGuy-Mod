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
import com.megacrit.cardcrawl.monsters.AbstractMonster;
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

public class Relic_7 extends AbstractEasyRelic{
    public static final String ID = makeID("Relic_7");

    public Relic_7() {
        super(ID, RelicTier.UNCOMMON, LandingSound.FLAT, CharacterFile.Enums.THE_GUY_COLOR);
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    public boolean isFirstCard = false;

    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m)
    {
        if(!isFirstCard) return;

        isFirstCard = false;
        c.exhaust = true;
        this.flash();
    }

    @Override
    public void atTurnStart()
    {
        isFirstCard = true;
    }

    @Override
    public boolean canSpawn() {
        return true;
    }

    @Override
    public AbstractRelic makeCopy() {
        return new Relic_7();
    }
}