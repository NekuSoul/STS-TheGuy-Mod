package code.cards;

import code.actions.EasyXCostAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_13 extends AbstractEasyCard {
    public final static String ID = makeID("ID_13");

    public ID_13() {
        super(ID, -1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 7;
        baseBlock = 4;
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_VERTICAL);
        atb(new EasyXCostAction(this, this::action));
    }

    public boolean action(int amount, int[] params)
    {
        AbstractPlayer p = AbstractDungeon.player;
        for (int i = 0; i < amount; i++)
            blck();

        return true;
    }

    public void upp() {
        upgradeDamage(+1);
        upgradeBlock(+2);
        upgradeMagicNumber(0);
        upgradeBaseCost(-1);
    }
}