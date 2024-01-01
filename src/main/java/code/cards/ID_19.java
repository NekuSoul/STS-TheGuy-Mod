package code.cards;

import code.actions.EasyXCostAction;
import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_19 extends AbstractEasyCard {
    public final static String ID = makeID("ID_19");
    // intellij stuff ATTACK, ENEMY, COMMON, 9, 3, 0, 0, 0, 0

    public ID_19() {
        super(ID, -1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 9;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }
    public void use(AbstractPlayer p, AbstractMonster m)
    {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_VERTICAL);
        atb(new EasyXCostAction(this, this::action));
    }

    public boolean action(int amount, int[] params)
    {
        addToBot(new DrawCardAction(amount));
        return true;
    }


    public void upp() {
        upgradeDamage(3);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        //upgradeBaseCost(0);
    }
}