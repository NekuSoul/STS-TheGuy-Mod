package code.powers;

import code.patches.subscribers.OnManualDiscardSubscriber;
import code.patches.subscribers.OnRefreshHandSubscriber;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import code.ModFile;
import code.util.TexLoader;

public abstract class AbstractEasyPower extends AbstractPower implements OnManualDiscardSubscriber, OnRefreshHandSubscriber {
    private final PowerStrings powerStrings;
    public int amount2 = -1;
    public boolean isTwoAmount = false;
    public static Color redColor2 = Color.RED.cpy();
    public static Color greenColor2 = Color.GREEN.cpy();
    public boolean canGoNegative2 = false;

    public AbstractEasyPower(String ID, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        this.ID = ID;
        this.powerStrings = CardCrawlGame.languagePack.getPowerStrings(this.ID);
        this.isTurnBased = isTurnBased;

        this.name = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;

        this.owner = owner;
        this.amount = amount;
        this.type = powerType;

        Texture normalTexture = TexLoader.getTexture(ModFile.modID + "Resources/images/powers/" + ID.replaceAll(ModFile.modID + ":", "") + "32.png");
        Texture hiDefImage = TexLoader.getTexture(ModFile.modID + "Resources/images/powers/" + ID.replaceAll(ModFile.modID + ":", "") + "84.png");
        if (hiDefImage != null) {
            region128 = new TextureAtlas.AtlasRegion(hiDefImage, 0, 0, hiDefImage.getWidth(), hiDefImage.getHeight());
            if (normalTexture != null)
                region48 = new TextureAtlas.AtlasRegion(normalTexture, 0, 0, normalTexture.getWidth(), normalTexture.getHeight());
        } else if (normalTexture != null) {
            this.img = normalTexture;
            region48 = new TextureAtlas.AtlasRegion(normalTexture, 0, 0, normalTexture.getWidth(), normalTexture.getHeight());
        }

        updateDescription();
    }

    @Override
    public void updateDescription(){
        description=DESCRIPTIONS[0];
    };

    public void renderAmount(SpriteBatch sb, float x, float y, Color c) {
        super.renderAmount(sb, x, y, c);
        if (!isTwoAmount)
            return;
        if (amount2 > 0) {
            if (!isTurnBased) {
                greenColor2.a = c.a;
                c = greenColor2;
            }

            FontHelper.renderFontRightTopAligned(sb, FontHelper.powerAmountFont, Integer.toString(amount2), x, y + 15.0F * Settings.scale, fontScale, c);
        } else if (amount2 < 0 && canGoNegative2) {
            redColor2.a = c.a;
            c = redColor2;
            FontHelper.renderFontRightTopAligned(sb, FontHelper.powerAmountFont, Integer.toString(amount2), x, y + 15.0F * Settings.scale, fontScale, c);
        }
    }
}