package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_42 extends AbstractEasyCard {
    public final static String ID = makeID("ID_42");
    // intellij stuff attack, enemy, common, 3, 2, 0, 0, 0, 0

    public ID_42() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = 3;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        int i = AbstractDungeon.player.discardPile.size();
        if( this.upgraded)
            baseDamage = 3 + i;
        else
            baseDamage = 5 + i;
        dmg(m, AbstractGameAction.AttackEffect.NONE);
    }

    public void upp() {
        upgradeDamage(2);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        upgradeBaseCost(1);
    }
}