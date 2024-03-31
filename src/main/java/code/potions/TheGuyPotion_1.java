package code.potions;

import basemod.BaseMod;
import code.CharacterFile;
import code.ModFile;
import code.cards.ID_80;
import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class TheGuyPotion_1 extends AbstractEasyPotion {
    public static String ID = makeID("TheGuyPotion_1");

    public TheGuyPotion_1() {
        super(ID, PotionRarity.UNCOMMON, PotionSize.SPHERE, Color.FIREBRICK, Color.BLACK, null, CharacterFile.Enums.THE_GUY, ModFile.characterColor);
    }

    public int getPotency(int ascensionlevel) {
        return 3;
    }

    public void use(AbstractCreature creature) {
        atb(new MakeTempCardInHandAction(new ID_80(),potency));
    }

    public String getDescription() {
        return strings.DESCRIPTIONS[0] + potency + strings.DESCRIPTIONS[1];
    }

    public void addAdditionalTips() {
        tips.add(new PowerTip(BaseMod.getKeywordTitle(makeID("todo")), BaseMod.getKeywordDescription(makeID("todo"))));
    }
}