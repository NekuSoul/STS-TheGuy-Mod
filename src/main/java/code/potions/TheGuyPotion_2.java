package code.potions;

import basemod.BaseMod;
import code.CharacterFile;
import code.ModFile;
import code.cards.ID_80;
import code.powers.LambdaPower;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class TheGuyPotion_2 extends AbstractEasyPotion {
    public static String ID = makeID("TheGuyPotion_2");

    public TheGuyPotion_2() {
        super(ID, PotionRarity.COMMON, PotionSize.MOON, new Color(0.2f, 0.4f, 0.9f, 1f), new Color(0.6f, 0.8f, 1.0f, 1f), null, CharacterFile.Enums.THE_GUY, ModFile.characterColor);
    }

    public int getPotency(int ascensionlevel) {
        return 2;
    }

    public void use(AbstractCreature creature) {
        applyToSelf(new LambdaPower(makeID("ID_52_Power"), AbstractPower.PowerType.BUFF, false, AbstractDungeon.player, potency) {

            @Override
            public void onUseCard(AbstractCard card, UseCardAction action)
            {
                if(card.cost != -1) return;
                this.addToBot(new RemoveSpecificPowerAction(this.owner, this.owner, makeID("ID_52_Power")));
            }
        });
    }

    public String getDescription() {
        return strings.DESCRIPTIONS[0] + potency + strings.DESCRIPTIONS[1];
    }

    public void addAdditionalTips() {
        tips.add(new PowerTip(BaseMod.getKeywordTitle(makeID("todo")), BaseMod.getKeywordDescription(makeID("todo"))));
    }
}