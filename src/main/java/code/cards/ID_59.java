package code.cards;

import code.CharacterFile;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_59 extends AbstractEasyCard {
    public final static String ID = makeID("ID_59");
    // intellij stuff skill, self, uncommon, 0, 0, 0, 0, 3, 2

    public ID_59() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 3;
        exhaust = true;
        this.tags.add(CharacterFile.THEGUY_TAGS.Punch_THE_GUY);
        this.tags.add(CardTags.HEALING);
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new GainEnergyAction(2));
        atb(new HealAction(p,p,magicNumber));
    }

    public void upp()
    {
        //upgradeDamage(0);
        //upgradeBlock(0);
        upgradeMagicNumber(2);
        //upgradeBaseCost(1);
        selfRetain = true;

    }
}