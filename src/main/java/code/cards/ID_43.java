package code.cards;

import code.cards.AbstractEasyCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.util.Iterator;

import static code.ModFile.makeID;
import static code.util.Wiz.*;

public class ID_43 extends AbstractEasyCard {
    public final static String ID = makeID("ID_43");
    // intellij stuff attack, enemy, rare, 7, 5, 0, 0, 0, 0

    public ID_43() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = 7;
        baseBlock = 0;
        baseMagicNumber = magicNumber = 0;
    }

    public static int countCards() {
        int count = 0;
        Iterator var1 = AbstractDungeon.player.hand.group.iterator();

        AbstractCard c;
        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            if (c.cost == -1) {
                ++count;
            }
        }

        var1 = AbstractDungeon.player.drawPile.group.iterator();

        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            if (c.cost == -1) {
                ++count;
            }
        }

        var1 = AbstractDungeon.player.discardPile.group.iterator();

        while(var1.hasNext()) {
            c = (AbstractCard)var1.next();
            if (c.cost == -1) {
                ++count;
            }
        }

        return count;
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        for (int i = 0; i < countCards(); i++)
        {
            if(i%2 == 0)
                this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
            else
                this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        }

    }

    public void upp() {
        upgradeDamage(5);
        //upgradeBlock(0);
        //upgradeMagicNumber(0);
        upgradeBaseCost(1);
    }
}