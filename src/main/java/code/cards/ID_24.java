package code.cards;

import code.actions.ID_24Action;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Iterator;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_24 extends AbstractEasyCard {
    public final static String ID = makeID("ID_24");
    // intellij stuff attack, enemey, uncommon, 12, 6, 0, 0, 0, 0

    public ID_24() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new ID_24Action());
    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        if(AbstractDungeon.player.hand.size() > 2)
            return true;
        return false;
    }

    public void upp() {
        //upgradeDamage(6);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        upgradeBaseCost(0);
    }
}