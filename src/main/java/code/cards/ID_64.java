package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_64 extends AbstractEasyCard {
    public final static String ID = makeID("ID_64");
    // intellij stuff attack, enemy, common, 9, 4, 0, 0, 1, 0

    public ID_64() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseDamage = 0;
        baseBlock = 6;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new MakeTempCardInHandAction(new ID_80()));
        blck();
    }

    public void upp() {
        //upgradeDamage(4);
        upgradeBlock(3);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(1);
    }
}