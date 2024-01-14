package code.cards;

import code.actions.ID_67Action;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_67 extends AbstractEasyCard {
    public final static String ID = makeID("ID_67");
    // intellij stuff attack, enemy, common, 9, 3, 9, 9, 12, 6

    public ID_67() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 9;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 12;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new ID_67Action(m,new DamageInfo(p,damage),magicNumber));
    }

    public void upp() {
        upgradeDamage(3);
        //upgradeBlock(0);
        upgradeMagicNumber(6);
        //upgradeBaseCost(1);
    }
}